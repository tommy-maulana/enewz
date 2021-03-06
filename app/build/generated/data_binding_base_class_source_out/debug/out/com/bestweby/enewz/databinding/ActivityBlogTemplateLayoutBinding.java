// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.CustomDrawerLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityBlogTemplateLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ShimmerBlogPagerLayoutBinding blogShimmerView;

  @NonNull
  public final ViewPager categoryPostsViewpager;

  @NonNull
  public final TabLayout categoryTablayout;

  @NonNull
  public final CollapsingToolbarLayout collapseToolbar;

  @NonNull
  public final CustomDrawerLayout homeDrawerlayout;

  @NonNull
  public final HomeToolbarLayoutBinding homeToolbar;

  @NonNull
  public final NavigationView mainNavView;

  @NonNull
  public final RelativeLayout sliderLayout;

  @NonNull
  public final ShimmerTemplateSliderLayoutBinding sliderShimmerView;

  @NonNull
  public final ViewPager sliderViewpager;

  @NonNull
  public final SwipeRefreshLayout swipeRefresh;

  protected ActivityBlogTemplateLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ShimmerBlogPagerLayoutBinding blogShimmerView,
      ViewPager categoryPostsViewpager, TabLayout categoryTablayout,
      CollapsingToolbarLayout collapseToolbar, CustomDrawerLayout homeDrawerlayout,
      HomeToolbarLayoutBinding homeToolbar, NavigationView mainNavView, RelativeLayout sliderLayout,
      ShimmerTemplateSliderLayoutBinding sliderShimmerView, ViewPager sliderViewpager,
      SwipeRefreshLayout swipeRefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.blogShimmerView = blogShimmerView;
    this.categoryPostsViewpager = categoryPostsViewpager;
    this.categoryTablayout = categoryTablayout;
    this.collapseToolbar = collapseToolbar;
    this.homeDrawerlayout = homeDrawerlayout;
    this.homeToolbar = homeToolbar;
    this.mainNavView = mainNavView;
    this.sliderLayout = sliderLayout;
    this.sliderShimmerView = sliderShimmerView;
    this.sliderViewpager = sliderViewpager;
    this.swipeRefresh = swipeRefresh;
  }

  @NonNull
  public static ActivityBlogTemplateLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_blog_template_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBlogTemplateLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityBlogTemplateLayoutBinding>inflateInternal(inflater, R.layout.activity_blog_template_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBlogTemplateLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_blog_template_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBlogTemplateLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityBlogTemplateLayoutBinding>inflateInternal(inflater, R.layout.activity_blog_template_layout, null, false, component);
  }

  public static ActivityBlogTemplateLayoutBinding bind(@NonNull View view) {
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
  public static ActivityBlogTemplateLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityBlogTemplateLayoutBinding)bind(component, view, R.layout.activity_blog_template_layout);
  }
}
