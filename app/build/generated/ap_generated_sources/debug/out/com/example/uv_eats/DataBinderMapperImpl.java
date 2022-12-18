package com.example.uv_eats;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.uv_eats.databinding.ActivityCategoryEditBindingImpl;
import com.example.uv_eats.databinding.ActivityCategoryRegisterBindingImpl;
import com.example.uv_eats.databinding.ActivityConsultCategoriesBindingImpl;
import com.example.uv_eats.databinding.ActivityConsultMenusBindingImpl;
import com.example.uv_eats.databinding.ActivityConsultOrdersBindingImpl;
import com.example.uv_eats.databinding.ActivityConsultProductsBindingImpl;
import com.example.uv_eats.databinding.ActivityEmployeeOptionsBindingImpl;
import com.example.uv_eats.databinding.ActivityFavoriteProductsBindingImpl;
import com.example.uv_eats.databinding.ActivityMainBindingImpl;
import com.example.uv_eats.databinding.ActivityPrincipalTabMenuActivityBindingImpl;
import com.example.uv_eats.databinding.ActivityProceedPurchaseBindingImpl;
import com.example.uv_eats.databinding.ActivityProductEditBindingImpl;
import com.example.uv_eats.databinding.ActivityProductRegisterBindingImpl;
import com.example.uv_eats.databinding.ActivitySignInBindingImpl;
import com.example.uv_eats.databinding.ActivityUserOptionsBindingImpl;
import com.example.uv_eats.databinding.CartItemBindingImpl;
import com.example.uv_eats.databinding.ConsultmenusItemBindingImpl;
import com.example.uv_eats.databinding.ConsultordersItemBindingImpl;
import com.example.uv_eats.databinding.FavoriteProductItemBindingImpl;
import com.example.uv_eats.databinding.FragmentCartBindingImpl;
import com.example.uv_eats.databinding.FragmentMenuBindingImpl;
import com.example.uv_eats.databinding.FragmentProductsBindingImpl;
import com.example.uv_eats.databinding.FragmentRecordBindingImpl;
import com.example.uv_eats.databinding.MenuItemBindingImpl;
import com.example.uv_eats.databinding.ProceedpurchaseItemBindingImpl;
import com.example.uv_eats.databinding.ProductItemBindingImpl;
import com.example.uv_eats.databinding.RecordItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCATEGORYEDIT = 1;

  private static final int LAYOUT_ACTIVITYCATEGORYREGISTER = 2;

  private static final int LAYOUT_ACTIVITYCONSULTCATEGORIES = 3;

  private static final int LAYOUT_ACTIVITYCONSULTMENUS = 4;

  private static final int LAYOUT_ACTIVITYCONSULTORDERS = 5;

  private static final int LAYOUT_ACTIVITYCONSULTPRODUCTS = 6;

  private static final int LAYOUT_ACTIVITYEMPLOYEEOPTIONS = 7;

  private static final int LAYOUT_ACTIVITYFAVORITEPRODUCTS = 8;

  private static final int LAYOUT_ACTIVITYMAIN = 9;

  private static final int LAYOUT_ACTIVITYPRINCIPALTABMENUACTIVITY = 10;

  private static final int LAYOUT_ACTIVITYPROCEEDPURCHASE = 11;

  private static final int LAYOUT_ACTIVITYPRODUCTEDIT = 12;

  private static final int LAYOUT_ACTIVITYPRODUCTREGISTER = 13;

  private static final int LAYOUT_ACTIVITYSIGNIN = 14;

  private static final int LAYOUT_ACTIVITYUSEROPTIONS = 15;

  private static final int LAYOUT_CARTITEM = 16;

  private static final int LAYOUT_CONSULTMENUSITEM = 17;

  private static final int LAYOUT_CONSULTORDERSITEM = 18;

  private static final int LAYOUT_FAVORITEPRODUCTITEM = 19;

  private static final int LAYOUT_FRAGMENTCART = 20;

  private static final int LAYOUT_FRAGMENTMENU = 21;

  private static final int LAYOUT_FRAGMENTPRODUCTS = 22;

  private static final int LAYOUT_FRAGMENTRECORD = 23;

  private static final int LAYOUT_MENUITEM = 24;

  private static final int LAYOUT_PROCEEDPURCHASEITEM = 25;

  private static final int LAYOUT_PRODUCTITEM = 26;

  private static final int LAYOUT_RECORDITEM = 27;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(27);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_category_edit, LAYOUT_ACTIVITYCATEGORYEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_category_register, LAYOUT_ACTIVITYCATEGORYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_consult_categories, LAYOUT_ACTIVITYCONSULTCATEGORIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_consult_menus, LAYOUT_ACTIVITYCONSULTMENUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_consult_orders, LAYOUT_ACTIVITYCONSULTORDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_consult_products, LAYOUT_ACTIVITYCONSULTPRODUCTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_employee_options, LAYOUT_ACTIVITYEMPLOYEEOPTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_favorite_products, LAYOUT_ACTIVITYFAVORITEPRODUCTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_principal_tab_menu_activity, LAYOUT_ACTIVITYPRINCIPALTABMENUACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_proceed_purchase, LAYOUT_ACTIVITYPROCEEDPURCHASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_product_edit, LAYOUT_ACTIVITYPRODUCTEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_product_register, LAYOUT_ACTIVITYPRODUCTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_sign_in, LAYOUT_ACTIVITYSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.activity_user_options, LAYOUT_ACTIVITYUSEROPTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.cart_item, LAYOUT_CARTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.consultmenus_item, LAYOUT_CONSULTMENUSITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.consultorders_item, LAYOUT_CONSULTORDERSITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.favorite_product_item, LAYOUT_FAVORITEPRODUCTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.fragment_cart, LAYOUT_FRAGMENTCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.fragment_menu, LAYOUT_FRAGMENTMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.fragment_products, LAYOUT_FRAGMENTPRODUCTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.fragment_record, LAYOUT_FRAGMENTRECORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.menu_item, LAYOUT_MENUITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.proceedpurchase_item, LAYOUT_PROCEEDPURCHASEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.product_item, LAYOUT_PRODUCTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.uv_eats.R.layout.record_item, LAYOUT_RECORDITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCATEGORYEDIT: {
          if ("layout/activity_category_edit_0".equals(tag)) {
            return new ActivityCategoryEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_category_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCATEGORYREGISTER: {
          if ("layout/activity_category_register_0".equals(tag)) {
            return new ActivityCategoryRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_category_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSULTCATEGORIES: {
          if ("layout/activity_consult_categories_0".equals(tag)) {
            return new ActivityConsultCategoriesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consult_categories is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSULTMENUS: {
          if ("layout/activity_consult_menus_0".equals(tag)) {
            return new ActivityConsultMenusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consult_menus is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSULTORDERS: {
          if ("layout/activity_consult_orders_0".equals(tag)) {
            return new ActivityConsultOrdersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consult_orders is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSULTPRODUCTS: {
          if ("layout/activity_consult_products_0".equals(tag)) {
            return new ActivityConsultProductsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consult_products is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEMPLOYEEOPTIONS: {
          if ("layout/activity_employee_options_0".equals(tag)) {
            return new ActivityEmployeeOptionsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_employee_options is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFAVORITEPRODUCTS: {
          if ("layout/activity_favorite_products_0".equals(tag)) {
            return new ActivityFavoriteProductsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_favorite_products is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRINCIPALTABMENUACTIVITY: {
          if ("layout/activity_principal_tab_menu_activity_0".equals(tag)) {
            return new ActivityPrincipalTabMenuActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_principal_tab_menu_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPROCEEDPURCHASE: {
          if ("layout/activity_proceed_purchase_0".equals(tag)) {
            return new ActivityProceedPurchaseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_proceed_purchase is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTEDIT: {
          if ("layout/activity_product_edit_0".equals(tag)) {
            return new ActivityProductEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTREGISTER: {
          if ("layout/activity_product_register_0".equals(tag)) {
            return new ActivityProductRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNIN: {
          if ("layout/activity_sign_in_0".equals(tag)) {
            return new ActivitySignInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_in is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUSEROPTIONS: {
          if ("layout/activity_user_options_0".equals(tag)) {
            return new ActivityUserOptionsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_user_options is invalid. Received: " + tag);
        }
        case  LAYOUT_CARTITEM: {
          if ("layout/cart_item_0".equals(tag)) {
            return new CartItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cart_item is invalid. Received: " + tag);
        }
        case  LAYOUT_CONSULTMENUSITEM: {
          if ("layout/consultmenus_item_0".equals(tag)) {
            return new ConsultmenusItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for consultmenus_item is invalid. Received: " + tag);
        }
        case  LAYOUT_CONSULTORDERSITEM: {
          if ("layout/consultorders_item_0".equals(tag)) {
            return new ConsultordersItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for consultorders_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FAVORITEPRODUCTITEM: {
          if ("layout/favorite_product_item_0".equals(tag)) {
            return new FavoriteProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for favorite_product_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCART: {
          if ("layout/fragment_cart_0".equals(tag)) {
            return new FragmentCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMENU: {
          if ("layout/fragment_menu_0".equals(tag)) {
            return new FragmentMenuBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_menu is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPRODUCTS: {
          if ("layout/fragment_products_0".equals(tag)) {
            return new FragmentProductsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_products is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRECORD: {
          if ("layout/fragment_record_0".equals(tag)) {
            return new FragmentRecordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_record is invalid. Received: " + tag);
        }
        case  LAYOUT_MENUITEM: {
          if ("layout/menu_item_0".equals(tag)) {
            return new MenuItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for menu_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PROCEEDPURCHASEITEM: {
          if ("layout/proceedpurchase_item_0".equals(tag)) {
            return new ProceedpurchaseItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for proceedpurchase_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PRODUCTITEM: {
          if ("layout/product_item_0".equals(tag)) {
            return new ProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for product_item is invalid. Received: " + tag);
        }
        case  LAYOUT_RECORDITEM: {
          if ("layout/record_item_0".equals(tag)) {
            return new RecordItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for record_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(27);

    static {
      sKeys.put("layout/activity_category_edit_0", com.example.uv_eats.R.layout.activity_category_edit);
      sKeys.put("layout/activity_category_register_0", com.example.uv_eats.R.layout.activity_category_register);
      sKeys.put("layout/activity_consult_categories_0", com.example.uv_eats.R.layout.activity_consult_categories);
      sKeys.put("layout/activity_consult_menus_0", com.example.uv_eats.R.layout.activity_consult_menus);
      sKeys.put("layout/activity_consult_orders_0", com.example.uv_eats.R.layout.activity_consult_orders);
      sKeys.put("layout/activity_consult_products_0", com.example.uv_eats.R.layout.activity_consult_products);
      sKeys.put("layout/activity_employee_options_0", com.example.uv_eats.R.layout.activity_employee_options);
      sKeys.put("layout/activity_favorite_products_0", com.example.uv_eats.R.layout.activity_favorite_products);
      sKeys.put("layout/activity_main_0", com.example.uv_eats.R.layout.activity_main);
      sKeys.put("layout/activity_principal_tab_menu_activity_0", com.example.uv_eats.R.layout.activity_principal_tab_menu_activity);
      sKeys.put("layout/activity_proceed_purchase_0", com.example.uv_eats.R.layout.activity_proceed_purchase);
      sKeys.put("layout/activity_product_edit_0", com.example.uv_eats.R.layout.activity_product_edit);
      sKeys.put("layout/activity_product_register_0", com.example.uv_eats.R.layout.activity_product_register);
      sKeys.put("layout/activity_sign_in_0", com.example.uv_eats.R.layout.activity_sign_in);
      sKeys.put("layout/activity_user_options_0", com.example.uv_eats.R.layout.activity_user_options);
      sKeys.put("layout/cart_item_0", com.example.uv_eats.R.layout.cart_item);
      sKeys.put("layout/consultmenus_item_0", com.example.uv_eats.R.layout.consultmenus_item);
      sKeys.put("layout/consultorders_item_0", com.example.uv_eats.R.layout.consultorders_item);
      sKeys.put("layout/favorite_product_item_0", com.example.uv_eats.R.layout.favorite_product_item);
      sKeys.put("layout/fragment_cart_0", com.example.uv_eats.R.layout.fragment_cart);
      sKeys.put("layout/fragment_menu_0", com.example.uv_eats.R.layout.fragment_menu);
      sKeys.put("layout/fragment_products_0", com.example.uv_eats.R.layout.fragment_products);
      sKeys.put("layout/fragment_record_0", com.example.uv_eats.R.layout.fragment_record);
      sKeys.put("layout/menu_item_0", com.example.uv_eats.R.layout.menu_item);
      sKeys.put("layout/proceedpurchase_item_0", com.example.uv_eats.R.layout.proceedpurchase_item);
      sKeys.put("layout/product_item_0", com.example.uv_eats.R.layout.product_item);
      sKeys.put("layout/record_item_0", com.example.uv_eats.R.layout.record_item);
    }
  }
}
