package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCategoryPostLayoutBindingImpl extends ActivityCategoryPostLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_main_layout"},
            new int[] {2},
            new int[] {com.bestweby.enewz.R.layout.toolbar_main_layout});
        sIncludes.setIncludes(1, 
            new String[] {"shimmer_grid_category_post_layout", "shimmer_linear_category_post_layout"},
            new int[] {3, 4},
            new int[] {com.bestweby.enewz.R.layout.shimmer_grid_category_post_layout,
                com.bestweby.enewz.R.layout.shimmer_linear_category_post_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.swipe_refresh, 5);
        sViewsWithIds.put(R.id.nestedscroll_view, 6);
        sViewsWithIds.put(R.id.post_recycler, 7);
        sViewsWithIds.put(R.id.progress_bar, 8);
        sViewsWithIds.put(R.id.empty_list_layout, 9);
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

    public ActivityCategoryPostLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityCategoryPostLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.LinearLayout) bindings[9]
            , (com.bestweby.enewz.databinding.ShimmerGridCategoryPostLayoutBinding) bindings[3]
            , (com.bestweby.enewz.databinding.ShimmerLinearCategoryPostLayoutBinding) bindings[4]
            , (androidx.core.widget.NestedScrollView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) bindings[2]
            , (android.widget.ProgressBar) bindings[8]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[5]
            );
        setContainedBinding(this.gridShimmerView);
        setContainedBinding(this.linearShimmerView);
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
                mDirtyFlags = 0x8L;
        }
        primaryToolbar.invalidateAll();
        gridShimmerView.invalidateAll();
        linearShimmerView.invalidateAll();
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
        if (gridShimmerView.hasPendingBindings()) {
            return true;
        }
        if (linearShimmerView.hasPendingBindings()) {
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
        gridShimmerView.setLifecycleOwner(lifecycleOwner);
        linearShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeGridShimmerView((com.bestweby.enewz.databinding.ShimmerGridCategoryPostLayoutBinding) object, fieldId);
            case 1 :
                return onChangePrimaryToolbar((com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) object, fieldId);
            case 2 :
                return onChangeLinearShimmerView((com.bestweby.enewz.databinding.ShimmerLinearCategoryPostLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeGridShimmerView(com.bestweby.enewz.databinding.ShimmerGridCategoryPostLayoutBinding GridShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePrimaryToolbar(com.bestweby.enewz.databinding.ToolbarMainLayoutBinding PrimaryToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLinearShimmerView(com.bestweby.enewz.databinding.ShimmerLinearCategoryPostLayoutBinding LinearShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        executeBindingsOn(gridShimmerView);
        executeBindingsOn(linearShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): gridShimmerView
        flag 1 (0x2L): primaryToolbar
        flag 2 (0x3L): linearShimmerView
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}