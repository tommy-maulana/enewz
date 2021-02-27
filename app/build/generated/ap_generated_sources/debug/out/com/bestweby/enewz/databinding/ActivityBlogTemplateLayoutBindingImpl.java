package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBlogTemplateLayoutBindingImpl extends ActivityBlogTemplateLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(12);
        sIncludes.setIncludes(1, 
            new String[] {"home_toolbar_layout"},
            new int[] {5},
            new int[] {com.bestweby.enewz.R.layout.home_toolbar_layout});
        sIncludes.setIncludes(2, 
            new String[] {"shimmer_template_slider_layout"},
            new int[] {4},
            new int[] {com.bestweby.enewz.R.layout.shimmer_template_slider_layout});
        sIncludes.setIncludes(3, 
            new String[] {"shimmer_blog_pager_layout"},
            new int[] {6},
            new int[] {com.bestweby.enewz.R.layout.shimmer_blog_pager_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.slider_viewpager, 7);
        sViewsWithIds.put(R.id.category_tablayout, 8);
        sViewsWithIds.put(R.id.swipe_refresh, 9);
        sViewsWithIds.put(R.id.category_posts_viewpager, 10);
        sViewsWithIds.put(R.id.main_nav_view, 11);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBlogTemplateLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityBlogTemplateLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.bestweby.enewz.databinding.ShimmerBlogPagerLayoutBinding) bindings[6]
            , (androidx.viewpager.widget.ViewPager) bindings[10]
            , (com.google.android.material.tabs.TabLayout) bindings[8]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[1]
            , (com.bestweby.enewz.customview.CustomDrawerLayout) bindings[0]
            , (com.bestweby.enewz.databinding.HomeToolbarLayoutBinding) bindings[5]
            , (com.google.android.material.navigation.NavigationView) bindings[11]
            , (android.widget.RelativeLayout) bindings[2]
            , (com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding) bindings[4]
            , (androidx.viewpager.widget.ViewPager) bindings[7]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[9]
            );
        setContainedBinding(this.blogShimmerView);
        this.collapseToolbar.setTag(null);
        this.homeDrawerlayout.setTag(null);
        setContainedBinding(this.homeToolbar);
        this.mboundView3 = (android.widget.RelativeLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.sliderLayout.setTag(null);
        setContainedBinding(this.sliderShimmerView);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        sliderShimmerView.invalidateAll();
        homeToolbar.invalidateAll();
        blogShimmerView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (sliderShimmerView.hasPendingBindings()) {
            return true;
        }
        if (homeToolbar.hasPendingBindings()) {
            return true;
        }
        if (blogShimmerView.hasPendingBindings()) {
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
        sliderShimmerView.setLifecycleOwner(lifecycleOwner);
        homeToolbar.setLifecycleOwner(lifecycleOwner);
        blogShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSliderShimmerView((com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding) object, fieldId);
            case 1 :
                return onChangeHomeToolbar((com.bestweby.enewz.databinding.HomeToolbarLayoutBinding) object, fieldId);
            case 2 :
                return onChangeBlogShimmerView((com.bestweby.enewz.databinding.ShimmerBlogPagerLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSliderShimmerView(com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding SliderShimmerView, int fieldId) {
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
    private boolean onChangeBlogShimmerView(com.bestweby.enewz.databinding.ShimmerBlogPagerLayoutBinding BlogShimmerView, int fieldId) {
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
        executeBindingsOn(sliderShimmerView);
        executeBindingsOn(homeToolbar);
        executeBindingsOn(blogShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): sliderShimmerView
        flag 1 (0x2L): homeToolbar
        flag 2 (0x3L): blogShimmerView
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}