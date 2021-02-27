package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewStoryTemplateLayoutBindingImpl extends ViewStoryTemplateLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(1, 
            new String[] {"shimmer_template_slider_layout"},
            new int[] {4},
            new int[] {com.bestweby.enewz.R.layout.shimmer_template_slider_layout});
        sIncludes.setIncludes(2, 
            new String[] {"shimmer_template_category_layout"},
            new int[] {5},
            new int[] {com.bestweby.enewz.R.layout.shimmer_template_category_layout});
        sIncludes.setIncludes(3, 
            new String[] {"shimmer_story_post_layout"},
            new int[] {6},
            new int[] {com.bestweby.enewz.R.layout.shimmer_story_post_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.slider_viewpager, 7);
        sViewsWithIds.put(R.id.category_card_view, 8);
        sViewsWithIds.put(R.id.category_recycler, 9);
        sViewsWithIds.put(R.id.primary_recycler, 10);
        sViewsWithIds.put(R.id.progress_bar, 11);
        sViewsWithIds.put(R.id.empty_list_layout, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewStoryTemplateLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ViewStoryTemplateLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (androidx.cardview.widget.CardView) bindings[8]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (com.bestweby.enewz.databinding.ShimmerTemplateCategoryLayoutBinding) bindings[5]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (android.widget.ProgressBar) bindings[11]
            , (android.widget.RelativeLayout) bindings[1]
            , (com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding) bindings[4]
            , (androidx.viewpager.widget.ViewPager) bindings[7]
            , (com.bestweby.enewz.databinding.ShimmerStoryPostLayoutBinding) bindings[6]
            );
        this.categoryLayout.setTag(null);
        setContainedBinding(this.categoryShimmerView);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.RelativeLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.sliderLayout.setTag(null);
        setContainedBinding(this.sliderShimmerView);
        setContainedBinding(this.storyShimmerView);
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
        categoryShimmerView.invalidateAll();
        storyShimmerView.invalidateAll();
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
        if (categoryShimmerView.hasPendingBindings()) {
            return true;
        }
        if (storyShimmerView.hasPendingBindings()) {
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
        categoryShimmerView.setLifecycleOwner(lifecycleOwner);
        storyShimmerView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeStoryShimmerView((com.bestweby.enewz.databinding.ShimmerStoryPostLayoutBinding) object, fieldId);
            case 1 :
                return onChangeSliderShimmerView((com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding) object, fieldId);
            case 2 :
                return onChangeCategoryShimmerView((com.bestweby.enewz.databinding.ShimmerTemplateCategoryLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeStoryShimmerView(com.bestweby.enewz.databinding.ShimmerStoryPostLayoutBinding StoryShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSliderShimmerView(com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBinding SliderShimmerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCategoryShimmerView(com.bestweby.enewz.databinding.ShimmerTemplateCategoryLayoutBinding CategoryShimmerView, int fieldId) {
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
        executeBindingsOn(categoryShimmerView);
        executeBindingsOn(storyShimmerView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): storyShimmerView
        flag 1 (0x2L): sliderShimmerView
        flag 2 (0x3L): categoryShimmerView
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}