package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySubcategoryListLayoutBindingImpl extends ActivitySubcategoryListLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_main_layout"},
            new int[] {2},
            new int[] {com.bestweby.enewz.R.layout.toolbar_main_layout});
        sIncludes.setIncludes(1, 
            new String[] {"shimmer_category_list_layout"},
            new int[] {3},
            new int[] {com.bestweby.enewz.R.layout.shimmer_category_list_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.category_recycler, 4);
        sViewsWithIds.put(R.id.empty_list_layout, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySubcategoryListLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivitySubcategoryListLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (com.bestweby.enewz.databinding.ShimmerCategoryListLayoutBinding) bindings[3]
            , (android.widget.LinearLayout) bindings[5]
            , (com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) bindings[2]
            );
        setContainedBinding(this.categoryShimmerView);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        setContainedBinding(this.primaryToolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        primaryToolbar.invalidateAll();
        categoryShimmerView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (primaryToolbar.hasPendingBindings()) {
            return true;
        }
        if (categoryShimmerView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        primaryToolbar.setLifecycleOwner(lifecycleOwner);
        categoryShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePrimaryToolbar((com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) object, fieldId);
            case 1 :
                return onChangeCategoryShimmerView((com.bestweby.enewz.databinding.ShimmerCategoryListLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangePrimaryToolbar(com.bestweby.enewz.databinding.ToolbarMainLayoutBinding PrimaryToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCategoryShimmerView(com.bestweby.enewz.databinding.ShimmerCategoryListLayoutBinding CategoryShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        executeBindingsOn(primaryToolbar);
        executeBindingsOn(categoryShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): primaryToolbar
        flag 1 (0x2L): categoryShimmerView
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}