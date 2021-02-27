// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ShimmerTemplateCategoryLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ShimmerFrameLayout shimmerView;

  protected ShimmerTemplateCategoryLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ShimmerFrameLayout shimmerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.shimmerView = shimmerView;
  }

  @NonNull
  public static ShimmerTemplateCategoryLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shimmer_template_category_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ShimmerTemplateCategoryLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ShimmerTemplateCategoryLayoutBinding>inflateInternal(inflater, R.layout.shimmer_template_category_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ShimmerTemplateCategoryLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shimmer_template_category_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ShimmerTemplateCategoryLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ShimmerTemplateCategoryLayoutBinding>inflateInternal(inflater, R.layout.shimmer_template_category_layout, null, false, component);
  }

  public static ShimmerTemplateCategoryLayoutBinding bind(@NonNull View view) {
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
  public static ShimmerTemplateCategoryLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ShimmerTemplateCategoryLayoutBinding)bind(component, view, R.layout.shimmer_template_category_layout);
  }
}
