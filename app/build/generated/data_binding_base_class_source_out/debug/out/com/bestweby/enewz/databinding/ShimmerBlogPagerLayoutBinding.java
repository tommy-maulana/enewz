// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ShimmerBlogPagerLayoutBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout shimmerView;

  protected ShimmerBlogPagerLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout shimmerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.shimmerView = shimmerView;
  }

  @NonNull
  public static ShimmerBlogPagerLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shimmer_blog_pager_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ShimmerBlogPagerLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ShimmerBlogPagerLayoutBinding>inflateInternal(inflater, R.layout.shimmer_blog_pager_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ShimmerBlogPagerLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shimmer_blog_pager_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ShimmerBlogPagerLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ShimmerBlogPagerLayoutBinding>inflateInternal(inflater, R.layout.shimmer_blog_pager_layout, null, false, component);
  }

  public static ShimmerBlogPagerLayoutBinding bind(@NonNull View view) {
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
  public static ShimmerBlogPagerLayoutBinding bind(@NonNull View view, @Nullable Object component) {
    return (ShimmerBlogPagerLayoutBinding)bind(component, view, R.layout.shimmer_blog_pager_layout);
  }
}
