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

public abstract class BottomSheetNotificationListBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomSheetLayout;

  @NonNull
  public final LinearLayout closeWindow;

  @NonNull
  public final LinearLayout deleteItem;

  @NonNull
  public final LinearLayout markRead;

  @NonNull
  public final LinearLayout viewDetail;

  protected BottomSheetNotificationListBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomSheetLayout, LinearLayout closeWindow,
      LinearLayout deleteItem, LinearLayout markRead, LinearLayout viewDetail) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomSheetLayout = bottomSheetLayout;
    this.closeWindow = closeWindow;
    this.deleteItem = deleteItem;
    this.markRead = markRead;
    this.viewDetail = viewDetail;
  }

  @NonNull
  public static BottomSheetNotificationListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_notification_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BottomSheetNotificationListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BottomSheetNotificationListBinding>inflateInternal(inflater, R.layout.bottom_sheet_notification_list, root, attachToRoot, component);
  }

  @NonNull
  public static BottomSheetNotificationListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_notification_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BottomSheetNotificationListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BottomSheetNotificationListBinding>inflateInternal(inflater, R.layout.bottom_sheet_notification_list, null, false, component);
  }

  public static BottomSheetNotificationListBinding bind(@NonNull View view) {
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
  public static BottomSheetNotificationListBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (BottomSheetNotificationListBinding)bind(component, view, R.layout.bottom_sheet_notification_list);
  }
}
