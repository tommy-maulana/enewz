package com.bestweby.enewz.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bestweby.enewz.R;
import com.bestweby.enewz.adapter.recycler.CommentListAdapter;
import com.bestweby.enewz.app.BaseActivity;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.cache.preference.AppPreference;
import com.bestweby.enewz.cache.preference.PrefKey;
import com.bestweby.enewz.databinding.ActivityPostCommentsLayoutBinding;
import com.bestweby.enewz.databinding.DialogPostCommentLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.model.posts.post.Reply;
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
 * Created by Md Sahidul Islam on 11-Jun-19.
 */
public class PostCommentsActivity extends BaseActivity {

    private ActivityPostCommentsLayoutBinding binding;
    private DialogPostCommentLayoutBinding commentLayoutBinding;

    private Dialog commentDialog;
    private CommentListAdapter commentListAdapter;

    private List<Reply> replies;
    private int postId = 0;

    private int pageNumber = AppConstants.PAGE_NUMBER;
    private Boolean isDataLoading = false;
    private Boolean canLoadMore = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initView();
        initListener();
        initRecyclerView();
        loadPostComments(AppConstants.PAGE_NUMBER);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initVars() {
        replies = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.containsKey(AppConstants.BUNDLE_POST_ID))
                postId = bundle.getInt(AppConstants.BUNDLE_POST_ID);
        }
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_comments_layout);

        setToolbar(binding.primaryToolbar.toolbar, binding.primaryToolbar.toolbarTitle, getString(R.string.toolbar_comments));
    }

    private void initListener() {
        binding.fabWriteComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCommentDialog();
            }
        });
    }

    private void initRecyclerView() {
        commentListAdapter = new CommentListAdapter(PostCommentsActivity.this, replies);
        binding.primaryRecycler.setLayoutManager(new LinearLayoutManager(PostCommentsActivity.this));
        binding.primaryRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.primaryRecycler.setNestedScrollingEnabled(false);
        binding.primaryRecycler.setAdapter(commentListAdapter);
        binding.nestedscrollView.setOnScrollChangeListener(onNestedScrollChange());
    }

    private void loadPostComments(int pageNumber) {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            if (pageNumber == AppConstants.PAGE_NUMBER) {
                binding.fabWriteComment.setVisibility(View.GONE);
                binding.primaryRecycler.setVisibility(View.GONE);
                binding.emptyListLayout.setVisibility(View.GONE);
                binding.commentShimmerView.shimmerView.setVisibility(View.VISIBLE);
                replies.clear();
            }

            HashMap<String, String> postCommentsMap = ApiRequests.buildPostComments(postId, pageNumber);
            ApiClient.getInstance().getApiInterface().getPostComments(postCommentsMap).enqueue(new Callback<List<Reply>>() {
                @Override
                public void onResponse(@NonNull Call<List<Reply>> call, @NonNull Response<List<Reply>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().size() > 0) {
                                canLoadMore = true;

                                replies.addAll(response.body());
                                commentListAdapter.notifyDataSetChanged();
                                binding.primaryRecycler.setVisibility(View.VISIBLE);
                                binding.commentShimmerView.shimmerView.setVisibility(View.GONE);
                            } else {
                                if (replies.size() == 0) {
                                    binding.emptyListLayout.removeAllViews();
                                    binding.emptyListLayout.addView(setEmptyLayout(PostCommentsActivity.this, getString(R.string.no_data)));
                                    binding.emptyListLayout.setVisibility(View.VISIBLE);
                                    binding.commentShimmerView.shimmerView.setVisibility(View.GONE);
                                    binding.primaryRecycler.setVisibility(View.GONE);
                                }
                                canLoadMore = false;
                            }
                            isDataLoading = false;
                            binding.progressBar.setVisibility(View.GONE);
                            binding.fabWriteComment.setVisibility(View.VISIBLE);
                        }
                    } else {
                        if (response.code() == AppConstants.EMPTY_RESULT) {
                            canLoadMore = false;
                            binding.progressBar.setVisibility(View.GONE);
                        } else {
                            AppHelper.showShortToast(context, getString(R.string.failed_msg));
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Reply>> call, @NonNull Throwable t) {
                    binding.commentShimmerView.shimmerView.setVisibility(View.GONE);
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
                            binding.progressBar.setVisibility(View.VISIBLE);
                            pageNumber += 1;
                            loadPostComments(pageNumber);
                        }
                    }
                }
            }
        };
    }

    private void loadCommentDialog() {
        commentDialog = new Dialog(this);
        commentDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        commentLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.dialog_post_comment_layout, null, false);
        commentDialog.setContentView(commentLayoutBinding.getRoot());
        commentDialog.setCanceledOnTouchOutside(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(commentDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        commentDialog.getWindow().setAttributes(layoutParams);

        String prefAuthorName = AppPreference.getInstance(getApplicationContext()).getString(PrefKey.KEY_NAME);
        String prefAuthorEmail = AppPreference.getInstance(getApplicationContext()).getString(PrefKey.KEY_EMAIL);

        commentLayoutBinding.authorName.setText(prefAuthorName);
        commentLayoutBinding.authorEmail.setText(prefAuthorEmail);

        commentLayoutBinding.submitComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String authorName = commentLayoutBinding.authorName.getText().toString().trim();
                String authorEmail = commentLayoutBinding.authorEmail.getText().toString().trim();
                String commentContent = commentLayoutBinding.commentContent.getText().toString().trim();

                if (authorName.isEmpty() && authorName.length() == 0) {
                    commentLayoutBinding.authorName.setError(getString(R.string.full_name_empty_msg));
                    commentLayoutBinding.authorName.requestFocus();
                } else if (authorEmail.isEmpty() && authorEmail.length() == 0) {
                    commentLayoutBinding.authorEmail.setError(getString(R.string.email_address_empty_msg));
                    commentLayoutBinding.authorEmail.requestFocus();
                } else if (commentContent.isEmpty() && commentContent.length() == 0) {
                    commentLayoutBinding.commentContent.setError(getString(R.string.comment_content_empty_msg));
                    commentLayoutBinding.commentContent.requestFocus();
                } else {
                    saveComment(authorName, authorEmail, commentContent);

                    AppPreference.getInstance(getApplicationContext()).setString(PrefKey.KEY_NAME, authorName);
                    AppPreference.getInstance(getApplicationContext()).setString(PrefKey.KEY_EMAIL, authorEmail);
                }
            }
        });

        commentLayoutBinding.cancelComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentDialog.dismiss();
            }
        });

        commentDialog.show();
    }

    private void saveComment(String authorName, String authorEmail, String comment) {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            progressDialog.show();
            HashMap<String, String> newCommentMap = ApiRequests.buildCreateComment(postId, authorName, authorEmail, comment);
            ApiClient.getInstance().getApiInterface().createPostComment(newCommentMap).enqueue(new Callback<Reply>() {
                @Override
                public void onResponse(@NonNull Call<Reply> call, @NonNull Response<Reply> response) {
                    if (response.isSuccessful()) {
                        loadPostComments(AppConstants.PAGE_NUMBER);
                        AppHelper.showShortToast(PostCommentsActivity.this, getString(R.string.comment_success_msg));
                    } else {
                        AppHelper.showShortToast(PostCommentsActivity.this, getString(R.string.failed_msg));
                    }
                    progressDialog.dismiss();
                    commentDialog.dismiss();
                }

                @Override
                public void onFailure(@NonNull Call<Reply> call, @NonNull Throwable t) {
                    progressDialog.dismiss();
                    commentDialog.dismiss();
                    AppHelper.showShortToast(PostCommentsActivity.this, getString(R.string.failed_msg));
                }
            });
        }
        AppHelper.noInternetWarning(context, binding.getRoot());
    }
}
