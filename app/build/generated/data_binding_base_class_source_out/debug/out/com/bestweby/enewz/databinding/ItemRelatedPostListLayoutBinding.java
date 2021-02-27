// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.RobotoTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemRelatedPostListLayoutBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout parentView;

  @NonNull
  public final RobotoTextView postCommentCount;

  @NonNull
  public final ImageView postImage;

  @NonNull
  public final RobotoTextView postTitle;

  protected ItemRelatedPostListLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout parentView, RobotoTextView postCommentCount,
      ImageView postImage, RobotoTextView postTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.parentView = parentView;
    this.postCommentCount = postCommentCount;
    this.postImage = postImage;
    this.postTitle = postTitle;
  }

  @NonNull
  public static ItemRelatedPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_related_post_list_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemRelatedPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemRelatedPostListLayoutBinding>inflateInternal(inflater, R.layout.item_related_post_list_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRelatedPostListLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_related_post_list_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemRelatedPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemRelatedPostListLayoutBinding>inflateInternal(inflater, R.layout.item_related_post_list_layout, null, false, component);
  }

  public static ItemRelatedPostListLayoutBinding bind(@NonNull View view) {
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
  public static ItemRelatedPostListLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemRelatedPostListLayoutBinding)bind(component, view, R.layout.item_related_post_list_layout);
  }
}