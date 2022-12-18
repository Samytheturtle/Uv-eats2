package com.example.uv_eats.databinding;
import com.example.uv_eats.R;
import com.example.uv_eats.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPrincipalTabMenuActivityBindingImpl extends ActivityPrincipalTabMenuActivityBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.OptionsImage, 1);
        sViewsWithIds.put(R.id.UserImage, 2);
        sViewsWithIds.put(R.id.ExitImage, 3);
        sViewsWithIds.put(R.id.tabLayout, 4);
        sViewsWithIds.put(R.id.tab, 5);
        sViewsWithIds.put(R.id.tabProducts, 6);
        sViewsWithIds.put(R.id.tabCart, 7);
        sViewsWithIds.put(R.id.tabRecord, 8);
        sViewsWithIds.put(R.id.viewPager, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPrincipalTabMenuActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityPrincipalTabMenuActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.tabs.TabItem) bindings[5]
            , (com.google.android.material.tabs.TabItem) bindings[7]
            , (com.google.android.material.tabs.TabLayout) bindings[4]
            , (com.google.android.material.tabs.TabItem) bindings[6]
            , (com.google.android.material.tabs.TabItem) bindings[8]
            , (androidx.viewpager.widget.ViewPager) bindings[9]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}