package com.bestweby.enewz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.bestweby.enewz.R;
import com.bestweby.enewz.adapter.viewpager.FeedTemplatePagerAdapter;
import com.bestweby.enewz.adapter.viewpager.TemplateSliderAdapter;
import com.bestweby.enewz.app.BaseActivity;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.databinding.ActivityFeedTemplateLayoutBinding;
import com.bestweby.enewz.databinding.NavHeaderLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.listener.ItemClickListener;
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
 * Created by Md Sahidul Islam on 07-Jun-19.
 */

public class FeedTemplateActivity extends BaseActivity {

    private ActivityFeedTemplateLayoutBinding binding;
    private NavHeaderLayoutBinding navHeaderbinding;

    private TemplateSliderAdapter sliderAdapter;
    private FeedTemplatePagerAdapter homeFivePageAdapter;

    private List<PostModel> featuredList;
    private List<CategoryModel> categoryList;

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
        binding.mainNavView.getMenu().getItem(4).setChecked(true);
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
            AppHelper.showShortToast(FeedTemplateActivity.this, "Please click BACK again to exit");

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
        categoryList = new ArrayList<>();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_template_layout);

        initDrawerLayout(binding.homeDrawerlayout, binding.mainNavView, binding.homeToolbar.toolbar);
        initializeDrawerHeader();
        initSliderViewPager();
        initTablayout();
    }

    private void initListener() {
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        binding.sliderViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        binding.categoryPostsViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                startActivity(new Intent(FeedTemplateActivity.this, NotificationActivity.class));
            }
        });

        binding.homeToolbar.toolbarMenuSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeedTemplateActivity.this, SearchPostActivity.class));
            }
        });

    }

    private void initializeDrawerHeader() {
        navHeaderbinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.nav_header_layout, binding.mainNavView, false);
        binding.mainNavView.addHeaderView(navHeaderbinding.getRoot());
    }

    private void initSliderViewPager() {
        sliderAdapter = new TemplateSliderAdapter(this, featuredList, true);
        binding.sliderViewpager.setAdapter(sliderAdapter);

        sliderAdapter.setSliderItemClickListerner(new ItemClickListener() {
            @Override
            public void onItemClickGetPosition(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstants.BUNDLE_POST_ID, featuredList.get(position).getId());
                bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, featuredList.get(position).getTitle().getRendered());
                startActivity(new Intent(FeedTemplateActivity.this, PostDetailActivity.class).putExtras(bundle));
            }
        });
    }

    private void initTablayout() {
        homeFivePageAdapter = new FeedTemplatePagerAdapter(getSupportFragmentManager(), (ArrayList<CategoryModel>) categoryList);
        binding.categoryPostsViewpager.setAdapter(homeFivePageAdapter);
        binding.categoryTablayout.setupWithViewPager(binding.categoryPostsViewpager);
    }

    private void showSlider() {
        sliderAdapter.notifyDataSetChanged();
        binding.sliderShimmerView.shimmerView.setVisibility(View.GONE);
        binding.sliderViewpager.setVisibility(View.VISIBLE);

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
                    CURRENT_PAGE = binding.sliderViewpager.getCurrentItem();
                    if (CURRENT_PAGE == (NUM_PAGES - 1)) {
                        CURRENT_PAGE = 0;
                    } else {
                        CURRENT_PAGE++;
                    }

                    (FeedTemplateActivity.this).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.sliderViewpager.setCurrentItem(CURRENT_PAGE, true);
                        }
                    });
                }
            }
        }).start();*/
    }

    private void loadData() {
        loadFeaturedPosts();
        loadCategories();
    }

    private void refreshData() {
        binding.categoryPostsViewpager.setAdapter(null);
        initTablayout();

        loadFeaturedPosts();
        loadCategories();

        if (binding.swipeRefresh.isRefreshing()) {
            binding.swipeRefresh.setRefreshing(false);
        }
    }

    private void loadFeaturedPosts() {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            binding.sliderViewpager.setVisibility(View.GONE);
            binding.sliderShimmerView.shimmerView.setVisibility(View.VISIBLE);

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
                            binding.sliderShimmerView.shimmerView.setVisibility(View.GONE);
                        }
                    } else {
                        AppHelper.showShortToast(context, getString(R.string.failed_msg));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {
                    binding.sliderShimmerView.shimmerView.setVisibility(View.GONE);
                    AppHelper.showShortToast(context, getString(R.string.failed_msg));
                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }

    private void loadCategories() {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            binding.categoryTablayout.setVisibility(View.GONE);
            binding.categoryPostsViewpager.setVisibility(View.GONE);
            binding.feedShimmerView.shimmerView.setVisibility(View.VISIBLE);

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
                                homeFivePageAdapter.notifyDataSetChanged();

                                binding.categoryTablayout.setVisibility(View.VISIBLE);
                                binding.categoryPostsViewpager.setVisibility(View.VISIBLE);
                            }

                            binding.feedShimmerView.shimmerView.setVisibility(View.GONE);
                        }
                    } else {
                        AppHelper.showShortToast(context, getString(R.string.failed_msg));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<CategoryModel>> call, @NonNull Throwable t) {
                    binding.feedShimmerView.shimmerView.setVisibility(View.GONE);
                    AppHelper.showShortToast(context, getString(R.string.failed_msg));
                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }

}
