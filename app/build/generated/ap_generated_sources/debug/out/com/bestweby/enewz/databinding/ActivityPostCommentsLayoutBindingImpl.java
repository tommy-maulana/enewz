package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPostCommentsLayoutBindingImpl extends ActivityPostCommentsLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(1, 
            new String[] {"toolbar_main_layout"},
            new int[] {3},
            new int[] {com.bestweby.enewz.R.layout.toolbar_main_layout});
        sIncludes.setIncludes(2, 
            new String[] {"shimmer_post_comment_layout"},
            new int[] {4},
            new int[] {com.bestweby.enewz.R.layout.shimmer_post_comment_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nestedscroll_view, 5);
        sViewsWithIds.put(R.id.primary_recycler, 6);
        sViewsWithIds.put(R.id.progress_bar, 7);
        sViewsWithIds.put(R.id.empty_list_layout, 8);
        sViewsWithIds.put(R.id.fab_write_comment, 9);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @NonNull
    private final android.widget.RelativeLayout mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPostCommentsLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityPostCommentsLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.bestweby.enewz.databinding.ShimmerPostCommentLayoutBinding) bindings[4]
            , (android.widget.LinearLayout) bindings[8]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[9]
            , (androidx.core.widget.NestedScrollView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) bindings[3]
            , (android.widget.ProgressBar) bindings[7]
            );
        setContainedBinding(this.commentShimmerView);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
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
        commentShimmerView.invalidateAll();
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
        if (commentShimmerView.hasPendingBindings()) {
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
        commentShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePrimaryToolbar((com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) object, fieldId);
            case 1 :
                return onChangeCommentShimmerView((com.bestweby.enewz.databinding.ShimmerPostCommentLayoutBinding) object, fieldId);
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
    private boolean onChangeCommentShimmerView(com.bestweby.enewz.databinding.ShimmerPostCommentLayoutBinding CommentShimmerView, int fieldId) {
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
        executeBindingsOn(commentShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): primaryToolbar
        flag 1 (0x2L): commentShimmerView
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}