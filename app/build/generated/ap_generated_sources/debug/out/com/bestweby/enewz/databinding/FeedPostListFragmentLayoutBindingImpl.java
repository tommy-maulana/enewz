package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FeedPostListFragmentLayoutBindingImpl extends FeedPostListFragmentLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(1, 
            new String[] {"shimmer_feed_post_layout"},
            new int[] {2},
            new int[] {com.bestweby.enewz.R.layout.shimmer_feed_post_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.primary_recycler, 3);
        sViewsWithIds.put(R.id.progress_bar, 4);
        sViewsWithIds.put(R.id.empty_list_layout, 5);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FeedPostListFragmentLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FeedPostListFragmentLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[5]
            , (com.bestweby.enewz.databinding.ShimmerFeedPostLayoutBinding) bindings[2]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (android.widget.ProgressBar) bindings[4]
            );
        setContainedBinding(this.feedShimmerView);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.nestedscrollView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        feedShimmerView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (feedShimmerView.hasPendingBindings()) {
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
        feedShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFeedShimmerView((com.bestweby.enewz.databinding.ShimmerFeedPostLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFeedShimmerView(com.bestweby.enewz.databinding.ShimmerFeedPostLayoutBinding FeedShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        executeBindingsOn(feedShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): feedShimmerView
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}