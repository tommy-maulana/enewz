// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.RobotoTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemSearchPostListLayoutBinding extends ViewDataBinding {
  @NonNull
  public final CardView parentView;

  @NonNull
  public final RobotoTextView postCategory;

  @NonNull
  public final RobotoTextView postDate;

  @NonNull
  public final AppCompatImageView postImage;

  @NonNull
  public final ImageView postMenu;

  @NonNull
  public final RobotoTextView postTitle;

  protected ItemSearchPostListLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CardView parentView, RobotoTextView postCategory,
      RobotoTextView postDate, AppCompatImageView postImage, ImageView postMenu,
      RobotoTextView postTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.parentView = parentView;
    this.postCategory = postCategory;
    this.postDate = postDate;
    this.postImage = postImage;
    this.postMenu = postMenu;
    this.postTitle = postTitle;
  }

  @NonNull
  public static ItemSearchPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_search_post_list_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemSearchPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemSearchPostListLayoutBinding>inflateInternal(inflater, R.layout.item_search_post_list_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSearchPostListLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_search_post_list_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemSearchPostListLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemSearchPostListLayoutBinding>inflateInternal(inflater, R.layout.item_search_post_list_layout, null, false, component);
  }

  public static ItemSearchPostListLayoutBinding bind(@NonNull View view) {
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
  public static ItemSearchPostListLayoutBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemSearchPostListLayoutBinding)bind(component, view, R.layout.item_search_post_list_layout);
  }
}