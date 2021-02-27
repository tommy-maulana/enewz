package com.bestweby.enewz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.bestweby.enewz.R;
import com.bestweby.enewz.adapter.recycler.ArticlePostListAdapter;
import com.bestweby.enewz.adapter.recycler.HomeCategoryAdapter;
import com.bestweby.enewz.adapter.viewpager.TemplateSliderAdapter;
import com.bestweby.enewz.app.BaseActivity;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.databinding.ActivityArticleTemplateLayoutBinding;
import com.bestweby.enewz.databinding.NavHeaderLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.listener.ItemClickListener;
import com.bestweby.enewz.listener.ItemViewClickListener;
import com.bestweby.enewz.listener.MenuItemClickListener;
import com.bestweby.enewz.model.Category.CategoryModel;
import com.bestweby.enewz.model.posts.post.PostModel;
import com.bestweby.enewz.network.ApiClient;
import com.bestweby.enewz.network.ApiRequests;
import com.bestweby.enewz.receiver.NetworkChangeReceiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md Sahidul Islam on 04-Jun-19.
 */

public class ArticleTemplateActivity extends BaseActivity {

    private ActivityArticleTemplateLayoutBinding binding;
    private NavHeaderLayoutBinding navHeaderbinding;

    private TemplateSliderAdapter sliderAdapter;
    private HomeCategoryAdapter categoryAdapter;
    private ArticlePostListAdapter postListAdapter;

    private List<PostModel> featuredList, postList;
    private List<CategoryModel> categoryList;

    private int pageNumber = AppConstants.PAGE_NUMBER;
    private Boolean isDataLoading = false;
    private Boolean canLoadMore = false;

    private boolean doubleBackToExitPressedOnce = false;
    private int NUM_PAGES = 0, CURRENT_PAGE = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initView();
        initListener();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateToolbarNotificationCount(binding.homeToolbar.notificationCounter);
        binding.mainNavView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (this.binding.homeDrawerlayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.homeDrawerlayout.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            AppHelper.showShortToast(ArticleTemplateActivity.this, "Please click BACK again to exit");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    private void initVars() {
        featuredList = new ArrayList<>();
        postList = new ArrayList<>();
        categoryList = new ArrayList<>();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_template_layout);

        initDrawerLayout(binding.homeDrawerlayout, binding.mainNavView, binding.homeToolbar.toolbar);
        initializeDrawerHeader();
        initSliderViewPager();
        initRecyclerView();
    }

    private void initListener() {
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        binding.contentView.sliderViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                enableDisableSwipeRefresh(binding.swipeRefresh, state == ViewPager.SCROLL_STATE_IDLE);
            }
        });

        binding.homeToolbar.toolbarMenuNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArticleTemplateActivity.this, NotificationActivity.class));
            }
        });

        binding.homeToolbar.toolbarMenuSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArticleTemplateActivity.this, SearchPostActivity.class));
            }
        });

        categoryAdapter.setItemClickListener(new ItemViewClickListener() {
            @Override
            public void onItemViewClickGetPosition(int position, View view) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, categoryList.get(position).getName());
                bundle.putInt(AppConstants.BUNDLE_CATEGORY_ID, categoryList.get(position).getId());
                bundle.putSerializable(AppConstants.BUNDLE_LAYOUT_TYPE, AppConstants.ListLayoutType.LINEAR);
                startActivity(new Intent(ArticleTemplateActivity.this, CategoryPostsActivity.class).putExtras(bundle));
            }
        });

        postListAdapter.setItemClickListener(new ItemViewClickListener() {
            @Override
            public void onItemViewClickGetPosition(int position, View view) {
                switch (view.getId()) {
                    case R.id.parent_view:
                        Bundle bundle = new Bundle();
                        bundle.putInt(AppConstants.BUNDLE_POST_ID, postList.get(position).getId());
                        bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, postList.get(position).getTitle().getRendered());
                        startActivity(new Intent(ArticleTemplateActivity.this, PostDetailActivity.class).putExtras(bundle));
                        break;
                }
            }
        });

        postListAdapter.setMenuItemClickListener(new MenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_share:
                        sharePost(postList.get(position));
                        break;
                    case R.id.menu_save:
                        checkAndSaveFavourite(postList.get(position));
                        break;
                }
            }
        });

    }

    private void initializeDrawerHeader() {
        navHeaderbinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.nav_header_layout, binding.mainNavView, false);
        binding.mainNavView.addHeaderView(navHeaderbinding.getRoot());
    }

    private void initSliderViewPager() {
        sliderAdapter = new TemplateSliderAdapter(this, featuredList, true);
        binding.contentView.sliderViewpager.setAdapter(sliderAdapter);

        sliderAdapter.setSliderItemClickListerner(new ItemClickListener() {
            @Override
            public void onItemClickGetPosition(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstants.BUNDLE_POST_ID, featuredList.get(position).getId());
                bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, featuredList.get(position).getTitle().getRendered());
                startActivity(new Intent(ArticleTemplateActivity.this, PostDetailActivity.class).putExtras(bundle));
            }
        });
    }

    private void initRecyclerView() {
        categoryAdapter = new HomeCategoryAdapter(ArticleTemplateActivity.this, categoryList);
        binding.contentView.categoryRecycler.setLayoutManager(new LinearLayoutManager(ArticleTemplateActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.contentView.categoryRecycler.setNestedScrollingEnabled(false);
        binding.contentView.categoryRecycler.setAdapter(categoryAdapter);

        postListAdapter = new ArticlePostListAdapter(ArticleTemplateActivity.this, postList);
        binding.contentView.primaryRecycler.setLayoutManager(new LinearLayoutManager(ArticleTemplateActivity.this));
        binding.contentView.primaryRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.contentView.primaryRecycler.setNestedScrollingEnabled(false);
        binding.contentView.primaryRecycler.setAdapter(postListAdapter);
        binding.nestedscrollView.setOnScrollChangeListener(onNestedScrollChange());
    }

    private void showSlider() {
        sliderAdapter.notifyDataSetChanged();
        binding.contentView.sliderShimmerView.shimmerView.setVisibility(View.GONE);
        binding.contentView.sliderViewpager.setVisibility(View.VISIBLE);

        /*Uncomment below codes for auto sliding effect*/
/*        NUM_PAGES = featuredList.size();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(AppConstants.SLIDER_DURATION);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    CURRENT_PAGE = binding.contentView.sliderViewpager.getCurrentItem();
                    if (CURRENT_PAGE == (NUM_PAGES - 1)) {
                        CURRENT_PAGE = 0;
                    } else {
                        CURRENT_PAGE++;
                    }

                    (ArticleTemplateActivity.this).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.contentView.sliderViewpager.setCurrentItem(CURRENT_PAGE, true);
                        }
                    });
                }
            }
        }).start();*/
    }

    private void loadData() {
        loadFeaturedPosts();
        loadCategories();
        loadAllPosts(AppConstants.PAGE_NUMBER);
    }

    private void refreshData() {
        loadFeaturedPosts();
        loadCategories();
        loadAllPosts(AppConstants.PAGE_NUMBER);

        if (binding.swipeRefresh.isRefreshing()) {
            binding.swipeRefresh.setRefreshing(false);
        }
    }

    private void loadFeaturedPosts() {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            binding.contentView.sliderViewpager.setVisibility(View.GONE);
            binding.contentView.sliderShimmerView.shimmerView.setVisibility(View.VISIBLE);

            HashMap<String, String> featuredPostsMap = ApiRequests.buildPostTaxonomy(true, AppConstants.PER_PAGE);
            ApiClient.getInstance().getApiInterface().getPosts(featuredPostsMap).enqueue(new Callback<List<PostModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<PostModel>> call, @NonNull Response<List<PostModel>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            featuredList.clear();
                            featuredList.addAll(response.body());

                            if (featuredList != null && featuredList.size() > 0) {
                                showSlider();
                            }
                            binding.contentView.sliderShimmerView.shimmerView.setVisibility(View.GONE);
                        }
                    } else {
                        AppHelper.showShortToast(context, getString(R.string.failed_msg));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {
                    binding.contentView.sliderShimmerView.shimmerView.setVisibility(View.GONE);
                    AppHelper.showShortToast(context, getString(R.string.failed_msg));
                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }

    private void loadCategories() {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            binding.contentView.categoryCardView.setVisibility(View.GONE);
            binding.contentView.categoryShimmerView.shimmerView.setVisibility(View.VISIBLE);

            HashMap<String, String> categoriesMap = ApiRequests.buildCategory(true, AppConstants.CATEGORY_PER_PAGE);
            ApiClient.getInstance().getApiInterface().getCategories(categoriesMap).enqueue(new Callback<List<CategoryModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<CategoryModel>> call, @NonNull Response<List<CategoryModel>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            categoryList.clear();

                            /* Show only Main/Parent Categories*/
                            for (CategoryModel categoryModel : response.body()) {
                                if (categoryModel.getParent() == 0) {
                                    categoryList.add(categoryModel);
                                }

                            }

                            /* Show All Categories*/
                            // categoryList.addAll(response.body());

                            if (categoryList != null && categoryList.size() > 0) {
                                categoryAdapter.notifyDataSetChanged();

                                binding.contentView.categoryCardView.setVisibility(View.VISIBLE);
                            }

                            binding.contentView.categoryShimmerView.shimmerView.setVisibility(View.GONE);
                        }
                    } else {
                        AppHelper.showShortToast(context, getString(R.string.failed_msg));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<CategoryModel>> call, @NonNull Throwable t) {
                    binding.contentView.categoryShimmerView.shimmerView.setVisibility(View.GONE);
                    AppHelper.showShortToast(context, getString(R.string.failed_msg));
                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }

    private void loadAllPosts(int pageNumber) {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            if (pageNumber == AppConstants.PAGE_NUMBER) {
                binding.contentView.primaryRecycler.setVisibility(View.GONE);
                binding.contentView.emptyListLayout.setVisibility(View.GONE);
                binding.contentView.articleShimmerView.shimmerView.setVisibility(View.VISIBLE);
            }

            HashMap<String, String> allPostsMap = ApiRequests.buildAllPosts(pageNumber);
            ApiClient.getInstance().getApiInterface().getPosts(allPostsMap).enqueue(new Callback<List<PostModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<PostModel>> call, @NonNull Response<List<PostModel>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().size() > 0) {
                                canLoadMore = true;

                                postList.addAll(response.body());
                                postListAdapter.notifyDataSetChanged();
                                binding.contentView.primaryRecycler.setVisibility(View.VISIBLE);
                                binding.contentView.articleShimmerView.shimmerView.setVisibility(View.GONE);
                            } else {
                                if (postList.size() == 0) {
                                    binding.contentView.emptyListLayout.removeAllViews();
                                    binding.contentView.emptyListLayout.addView(setEmptyLayout(ArticleTemplateActivity.this, getString(R.string.no_data)));
                                    binding.contentView.emptyListLayout.setVisibility(View.VISIBLE);
                                    binding.contentView.articleShimmerView.shimmerView.setVisibility(View.GONE);
                                    binding.contentView.primaryRecycler.setVisibility(View.GONE);
                                }
                                canLoadMore = false;
                            }
                            isDataLoading = false;
                            binding.contentView.progressBar.setVisibility(View.GONE);
                        }
                    } else {
                        if (response.code() == AppConstants.EMPTY_RESULT) {
                            canLoadMore = false;
                            binding.contentView.progressBar.setVisibility(View.GONE);
                        } else {
                            AppHelper.showShortToast(context, getString(R.string.failed_msg));
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {
                    binding.contentView.articleShimmerView.shimmerView.setVisibility(View.GONE);
                    AppHelper.showShortToast(context, getString(R.string.failed_msg));


                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }

    private NestedScrollView.OnScrollChangeListener onNestedScrollChange() {
        return new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView scrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > 0) {
                    if (!scrollView.canScrollVertically(NestedScrollView.FOCUS_DOWN)) {
                        if (canLoadMore && !isDataLoading) {
                            isDataLoading = true;
                            binding.contentView.progressBar.setVisibility(View.VISIBLE);
                            pageNumber += 1;
                            loadAllPosts(pageNumber);
                        }
                    }
                }
            }
        };
    }
}
