// Generated by data binding compiler. Do not edit!
package com.example.uv_eats.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.uv_eats.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCategoryEditBinding extends ViewDataBinding {
  @NonNull
  public final Button ButtonRegister;

  @NonNull
  public final ImageView ImageCategory;

  @NonNull
  public final EditText TextNameCategory;

  @NonNull
  public final TextView TitleCategory;

  protected ActivityCategoryEditBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button ButtonRegister, ImageView ImageCategory, EditText TextNameCategory,
      TextView TitleCategory) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ButtonRegister = ButtonRegister;
    this.ImageCategory = ImageCategory;
    this.TextNameCategory = TextNameCategory;
    this.TitleCategory = TitleCategory;
  }

  @NonNull
  public static ActivityCategoryEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_edit, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryEditBinding>inflateInternal(inflater, R.layout.activity_category_edit, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCategoryEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_edit, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryEditBinding>inflateInternal(inflater, R.layout.activity_category_edit, null, false, component);
  }

  public static ActivityCategoryEditBinding bind(@NonNull View view) {
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
  public static ActivityCategoryEditBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCategoryEditBinding)bind(component, view, R.layout.activity_category_edit);
  }
}
