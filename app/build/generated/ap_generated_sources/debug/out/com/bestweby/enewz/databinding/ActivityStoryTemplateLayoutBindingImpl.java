package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStoryTemplateLayoutBindingImpl extends ActivityStoryTemplateLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(1, 
            new String[] {"home_toolbar_layout"},
            new int[] {3},
            new int[] {com.bestweby.enewz.R.layout.home_toolbar_layout});
        sIncludes.setIncludes(2, 
            new String[] {"view_story_template_layout"},
            new int[] {4},
            new int[] {com.bestweby.enewz.R.layout.view_story_template_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.swipe_refresh, 5);
        sViewsWithIds.put(R.id.nestedscroll_view, 6);
        sViewsWithIds.put(R.id.main_nav_view, 7);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    @NonNull
    private final android.widget.RelativeLayout mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityStoryTemplateLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityStoryTemplateLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.bestweby.enewz.databinding.ViewStoryTemplateLayoutBinding) bindings[4]
            , (com.bestweby.enewz.customview.CustomDrawerLayout) bindings[0]
            , (com.bestweby.enewz.databinding.HomeToolbarLayoutBinding) bindings[3]
            , (com.google.android.material.navigation.NavigationView) bindings[7]
            , (androidx.core.widget.NestedScrollView) bindings[6]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[5]
            );
        setContainedBinding(this.contentView);
        this.homeDrawerlayout.setTag(null);
        setContainedBinding(this.homeToolbar);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        homeToolbar.invalidateAll();
        contentView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (homeToolbar.hasPendingBindings()) {
            return true;
        }
        if (contentView.hasPendingBindings()) {
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
        homeToolbar.setLifecycleOwner(lifecycleOwner);
        contentView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContentView((com.bestweby.enewz.databinding.ViewStoryTemplateLayoutBinding) object, fieldId);
            case 1 :
                return onChangeHomeToolbar((com.bestweby.enewz.databinding.HomeToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentView(com.bestweby.enewz.databinding.ViewStoryTemplateLayoutBinding ContentView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeToolbar(com.bestweby.enewz.databinding.HomeToolbarLayoutBinding HomeToolbar, int fieldId) {
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
        executeBindingsOn(homeToolbar);
        executeBindingsOn(contentView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): contentView
        flag 1 (0x2L): homeToolbar
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}