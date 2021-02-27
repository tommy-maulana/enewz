// Generated by data binding compiler. Do not edit!
package com.bestweby.enewz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.customview.RobotoTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemImageSliderBinding extends ViewDataBinding {
  @NonNull
  public final CardView parentView;

  @NonNull
  public final ImageView sliderImage;

  @NonNull
  public final RobotoTextView sliderTitle;

  protected ItemImageSliderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView parentView, ImageView sliderImage, RobotoTextView sliderTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.parentView = parentView;
    this.sliderImage = sliderImage;
    this.sliderTitle = sliderTitle;
  }

  @NonNull
  public static ItemImageSliderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_image_slider, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemImageSliderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemImageSliderBinding>inflateInternal(inflater, R.layout.item_image_slider, root, attachToRoot, component);
  }

  @NonNull
  public static ItemImageSliderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_image_slider, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemImageSliderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemImageSliderBinding>inflateInternal(inflater, R.layout.item_image_slider, null, false, component);
  }

  public static ItemImageSliderBinding bind(@NonNull View view) {
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
  public static ItemImageSliderBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemImageSliderBinding)bind(component, view, R.layout.item_image_slider);
  }
}