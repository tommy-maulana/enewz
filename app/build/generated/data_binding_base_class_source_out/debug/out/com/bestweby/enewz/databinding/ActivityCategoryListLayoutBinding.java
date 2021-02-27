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
import androidx.recyclerview.widget.RecyclerView;
import com.bestweby.enewz.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCategoryListLayoutBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView categoryRecycler;

  @NonNull
  public final ShimmerCategoryListLayoutBinding categoryShimmerView;

  @NonNull
  public final LinearLayout emptyListLayout;

  @NonNull
  public final ToolbarMainLayoutBinding primaryToolbar;

  protected ActivityCategoryListLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView categoryRecycler,
      ShimmerCategoryListLayoutBinding categoryShimmerView, LinearLayout emptyListLayout,
      ToolbarMainLayoutBinding primaryToolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.categoryRecycler = categoryRecycler;
    this.categoryShimmerView = categoryShimmerView;
    this.emptyListLayout = emptyListLayout;
    this.primaryToolbar = primaryToolbar;
  }

  @NonNull
  public static ActivityCategoryListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_list_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryListLayoutBinding>inflateInternal(inflater, R.layout.activity_category_list_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCategoryListLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_list_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryListLayoutBinding>inflateInternal(inflater, R.layout.activity_category_list_layout, null, false, component);
  }

  public static ActivityCategoryListLayoutBinding bind(@NonNull View view) {
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
  public static ActivityCategoryListLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityCategoryListLayoutBinding)bind(component, view, R.layout.activity_category_list_layout);
  }
}