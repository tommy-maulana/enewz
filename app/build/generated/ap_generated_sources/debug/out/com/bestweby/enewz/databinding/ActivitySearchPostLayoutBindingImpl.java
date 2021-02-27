package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySearchPostLayoutBindingImpl extends ActivitySearchPostLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(0, 
            new String[] {"search_toolbar_layout"},
            new int[] {2},
            new int[] {com.bestweby.enewz.R.layout.search_toolbar_layout});
        sIncludes.setIncludes(1, 
            new String[] {"shimmer_search_post_layout"},
            new int[] {3},
            new int[] {com.bestweby.enewz.R.layout.shimmer_search_post_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nestedscroll_view, 4);
        sViewsWithIds.put(R.id.primary_recycler, 5);
        sViewsWithIds.put(R.id.progress_bar, 6);
        sViewsWithIds.put(R.id.empty_list_layout, 7);
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

    public ActivitySearchPostLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivitySearchPostLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.LinearLayout) bindings[7]
            , (com.bestweby.enewz.databinding.ShimmerSearchPostLayoutBinding) bindings[3]
            , (androidx.core.widget.NestedScrollView) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (android.widget.ProgressBar) bindings[6]
            , (com.bestweby.enewz.databinding.SearchToolbarLayoutBinding) bindings[2]
            );
        setContainedBinding(this.listShimmerLayout);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        setContainedBinding(this.searchToolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        searchToolbar.invalidateAll();
        listShimmerLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (searchToolbar.hasPendingBindings()) {
            return true;
        }
        if (listShimmerLayout.hasPendingBindings()) {
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
        searchToolbar.setLifecycleOwner(lifecycleOwner);
        listShimmerLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSearchToolbar((com.bestweby.enewz.databinding.SearchToolbarLayoutBinding) object, fieldId);
            case 1 :
                return onChangeListShimmerLayout((com.bestweby.enewz.databinding.ShimmerSearchPostLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSearchToolbar(com.bestweby.enewz.databinding.SearchToolbarLayoutBinding SearchToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeListShimmerLayout(com.bestweby.enewz.databinding.ShimmerSearchPostLayoutBinding ListShimmerLayout, int fieldId) {
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
        executeBindingsOn(searchToolbar);
        executeBindingsOn(listShimmerLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): searchToolbar
        flag 1 (0x2L): listShimmerLayout
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}