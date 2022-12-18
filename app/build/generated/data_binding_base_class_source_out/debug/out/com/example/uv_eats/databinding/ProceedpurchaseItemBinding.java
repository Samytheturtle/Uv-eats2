// Generated by data binding compiler. Do not edit!
package com.example.uv_eats.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.uv_eats.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ProceedpurchaseItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView amount;

  @NonNull
  public final TextView amountNumber;

  @NonNull
  public final ImageView iconProduct;

  @NonNull
  public final TextView price;

  @NonNull
  public final TextView productName;

  @NonNull
  public final TextView productPrice;

  protected ProceedpurchaseItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView amount, TextView amountNumber, ImageView iconProduct, TextView price,
      TextView productName, TextView productPrice) {
    super(_bindingComponent, _root, _localFieldCount);
    this.amount = amount;
    this.amountNumber = amountNumber;
    this.iconProduct = iconProduct;
    this.price = price;
    this.productName = productName;
    this.productPrice = productPrice;
  }

  @NonNull
  public static ProceedpurchaseItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.proceedpurchase_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ProceedpurchaseItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ProceedpurchaseItemBinding>inflateInternal(inflater, R.layout.proceedpurchase_item, root, attachToRoot, component);
  }

  @NonNull
  public static ProceedpurchaseItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.proceedpurchase_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ProceedpurchaseItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ProceedpurchaseItemBinding>inflateInternal(inflater, R.layout.proceedpurchase_item, null, false, component);
  }

  public static ProceedpurchaseItemBinding bind(@NonNull View view) {
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
  public static ProceedpurchaseItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (ProceedpurchaseItemBinding)bind(component, view, R.layout.proceedpurchase_item);
  }
}