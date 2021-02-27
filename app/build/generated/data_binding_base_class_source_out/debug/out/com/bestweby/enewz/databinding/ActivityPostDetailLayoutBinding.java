// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.NeoSansProTextView;
import com.bestweby.enewz.customview.RobotoTextView;
import com.google.android.gms.ads.AdView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPostDetailLayoutBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final CollapsingToolbarLayout collapsingToolbar;

  @NonNull
  public final ShimmerPostDetailLayoutBinding detailShimmerLayout;

  @NonNull
  public final DetailsToolbarLayoutBinding detailToolbar;

  @NonNull
  public final FloatingActionButton fabWriteComment;

  @NonNull
  public final AdView footerBannerAdLayout;

  @NonNull
  public final AdView headerBannerAdLayout;

  @NonNull
  public final CircleImageView postAuthorImage;

  @NonNull
  public final LinearLayout postAuthorLayout;

  @NonNull
  public final NeoSansProTextView postAuthorName;

  @NonNull
  public final RobotoTextView postCategory;

  @NonNull
  public final RobotoTextView postDate;

  @NonNull
  public final NestedScrollView postDetailLayout;

  @NonNull
  public final WebView postDetailView;

  @NonNull
  public final AppCompatImageView postImage;

  @NonNull
  public final NeoSansProTextView postTitle;

  @NonNull
  public final RecyclerView relatedProducts;

  @NonNull
  public final LinearLayout relatedProductsLayout;

  @NonNull
  public final AppCompatImageView savePost;

  @NonNull
  public final AppCompatImageView sharePost;

  @NonNull
  public final ShimmerRelatedPostsLayoutBinding shimmerRelatedProducts;

  @NonNull
  public final AppCompatButton viewPostComments;

  @NonNull
  public final CardView youtubeLayout;

  protected ActivityPostDetailLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbar,
      ShimmerPostDetailLayoutBinding detailShimmerLayout, DetailsToolbarLayoutBinding detailToolbar,
      FloatingActionButton fabWriteComment, AdView footerBannerAdLayout,
      AdView headerBannerAdLayout, CircleImageView postAuthorImage, LinearLayout postAuthorLayout,
      NeoSansProTextView postAuthorName, RobotoTextView postCategory, RobotoTextView postDate,
      NestedScrollView postDetailLayout, WebView postDetailView, AppCompatImageView postImage,
      NeoSansProTextView postTitle, RecyclerView relatedProducts,
      LinearLayout relatedProductsLayout, AppCompatImageView savePost, AppCompatImageView sharePost,
      ShimmerRelatedPostsLayoutBinding shimmerRelatedProducts, AppCompatButton viewPostComments,
      CardView youtubeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBarLayout = appBarLayout;
    this.collapsingToolbar = collapsingToolbar;
    this.detailShimmerLayout = detailShimmerLayout;
    this.detailToolbar = detailToolbar;
    this.fabWriteComment = fabWriteComment;
    this.footerBannerAdLayout = footerBannerAdLayout;
    this.headerBannerAdLayout = headerBannerAdLayout;
    this.postAuthorImage = postAuthorImage;
    this.postAuthorLayout = postAuthorLayout;
    this.postAuthorName = postAuthorName;
    this.postCategory = postCategory;
    this.postDate = postDate;
    this.postDetailLayout = postDetailLayout;
    this.postDetailView = postDetailView;
    this.postImage = postImage;
    this.postTitle = postTitle;
    this.relatedProducts = relatedProducts;
    this.relatedProductsLayout = relatedProductsLayout;
    this.savePost = savePost;
    this.sharePost = sharePost;
    this.shimmerRelatedProducts = shimmerRelatedProducts;
    this.viewPostComments = viewPostComments;
    this.youtubeLayout = youtubeLayout;
  }

  @NonNull
  public static ActivityPostDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_post_detail_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPostDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPostDetailLayoutBinding>inflateInternal(inflater, R.layout.activity_post_detail_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPostDetailLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_post_detail_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPostDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPostDetailLayoutBinding>inflateInternal(inflater, R.layout.activity_post_detail_layout, null, false, component);
  }

  public static ActivityPostDetailLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityPostDetailLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityPostDetailLayoutBinding)bind(component, view, R.layout.activity_post_detail_layout);
  }
}