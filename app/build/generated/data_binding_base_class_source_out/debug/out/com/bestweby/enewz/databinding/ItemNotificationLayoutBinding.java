// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.RobotoTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemNotificationLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ImageView notificationIcon;

  @NonNull
  public final RelativeLayout notificationLayout;

  @NonNull
  public final RobotoTextView notificationMessage;

  @NonNull
  public final RobotoTextView notificationTitle;

  @NonNull
  public final CardView parentView;

  protected ItemNotificationLayoutBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView notificationIcon, RelativeLayout notificationLayout,
      RobotoTextView notificationMessage, RobotoTextView notificationTitle, CardView parentView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.notificationIcon = notificationIcon;
    this.notificationLayout = notificationLayout;
    this.notificationMessage = notificationMessage;
    this.notificationTitle = notificationTitle;
    this.parentView = parentView;
  }

  @NonNull
  public static ItemNotificationLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_notification_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemNotificationLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemNotificationLayoutBinding>inflateInternal(inflater, R.layout.item_notification_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ItemNotificationLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_notification_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemNotificationLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemNotificationLayoutBinding>inflateInternal(inflater, R.layout.item_notification_layout, null, false, component);
  }

  public static ItemNotificationLayoutBinding bind(@NonNull View view) {
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
  public static ItemNotificationLayoutBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemNotificationLayoutBinding)bind(component, view, R.layout.item_notification_layout);
  }
}
