// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bestweby.enewz.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySearchPostLayoutBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout emptyListLayout;

  @NonNull
  public final ShimmerSearchPostLayoutBinding listShimmerLayout;

  @NonNull
  public final NestedScrollView nestedscrollView;

  @NonNull
  public final RecyclerView primaryRecycler;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final SearchToolbarLayoutBinding searchToolbar;

  protected ActivitySearchPostLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout emptyListLayout,
      ShimmerSearchPostLayoutBinding listShimmerLayout, NestedScrollView nestedscrollView,
      RecyclerView primaryRecycler, ProgressBar progressBar,
      SearchToolbarLayoutBinding searchToolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.emptyListLayout = emptyListLayout;
    this.listShimmerLayout = listShimmerLayout;
    this.nestedscrollView = nestedscrollView;
    this.primaryRecycler = primaryRecycler;
    this.progressBar = progressBar;
    this.searchToolbar = searchToolbar;
  }

  @NonNull
  public static ActivitySearchPostLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_post_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchPostLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchPostLayoutBinding>inflateInternal(inflater, R.layout.activity_search_post_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchPostLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_post_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchPostLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchPostLayoutBinding>inflateInternal(inflater, R.layout.activity_search_post_layout, null, false, component);
  }

  public static ActivitySearchPostLayoutBinding bind(@NonNull View view) {
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
  public static ActivitySearchPostLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivitySearchPostLayoutBinding)bind(component, view, R.layout.activity_search_post_layout);
  }
}
