// Generated by data binding compiler. Do not edit!
package com.example.uv_eats.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.uv_eats.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityUserOptionsBinding extends ViewDataBinding {
  @NonNull
  public final Button ConsultOrders;

  @NonNull
  public final Button FavoriteProducts;

  @NonNull
  public final Button ProceedPurchase;

  protected ActivityUserOptionsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button ConsultOrders, Button FavoriteProducts, Button ProceedPurchase) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ConsultOrders = ConsultOrders;
    this.FavoriteProducts = FavoriteProducts;
    this.ProceedPurchase = ProceedPurchase;
  }

  @NonNull
  public static ActivityUserOptionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_user_options, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUserOptionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityUserOptionsBinding>inflateInternal(inflater, R.layout.activity_user_options, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityUserOptionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_user_options, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUserOptionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityUserOptionsBinding>inflateInternal(inflater, R.layout.activity_user_options, null, false, component);
  }

  public static ActivityUserOptionsBinding bind(@NonNull View view) {
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
  public static ActivityUserOptionsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityUserOptionsBinding)bind(component, view, R.layout.activity_user_options);
  }
}
