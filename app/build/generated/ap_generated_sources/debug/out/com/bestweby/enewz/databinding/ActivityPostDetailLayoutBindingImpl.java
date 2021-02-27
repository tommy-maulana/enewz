package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPostDetailLayoutBindingImpl extends ActivityPostDetailLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(26);
        sIncludes.setIncludes(1, 
            new String[] {"details_toolbar_layout"},
            new int[] {4},
            new int[] {com.bestweby.enewz.R.layout.details_toolbar_layout});
        sIncludes.setIncludes(2, 
            new String[] {"shimmer_post_detail_layout"},
            new int[] {5},
            new int[] {com.bestweby.enewz.R.layout.shimmer_post_detail_layout});
        sIncludes.setIncludes(3, 
            new String[] {"shimmer_related_posts_layout"},
            new int[] {6},
            new int[] {com.bestweby.enewz.R.layout.shimmer_related_posts_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 7);
        sViewsWithIds.put(R.id.post_image, 8);
        sViewsWithIds.put(R.id.post_author_layout, 9);
        sViewsWithIds.put(R.id.post_author_image, 10);
        sViewsWithIds.put(R.id.post_author_name, 11);
        sViewsWithIds.put(R.id.post_detail_layout, 12);
        sViewsWithIds.put(R.id.youtube_layout, 13);
        sViewsWithIds.put(R.id.post_title, 14);
        sViewsWithIds.put(R.id.post_category, 15);
        sViewsWithIds.put(R.id.post_date, 16);
        sViewsWithIds.put(R.id.save_post, 17);
        sViewsWithIds.put(R.id.share_post, 18);
        sViewsWithIds.put(R.id.header_banner_ad_layout, 19);
        sViewsWithIds.put(R.id.post_detail_view, 20);
        sViewsWithIds.put(R.id.view_post_comments, 21);
        sViewsWithIds.put(R.id.related_products_layout, 22);
        sViewsWithIds.put(R.id.related_products, 23);
        sViewsWithIds.put(R.id.footer_banner_ad_layout, 24);
        sViewsWithIds.put(R.id.fab_write_comment, 25);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPostDetailLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ActivityPostDetailLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.appbar.AppBarLayout) bindings[7]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[1]
            , (com.bestweby.enewz.databinding.ShimmerPostDetailLayoutBinding) bindings[5]
            , (com.bestweby.enewz.databinding.DetailsToolbarLayoutBinding) bindings[4]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[25]
            , (com.google.android.gms.ads.AdView) bindings[24]
            , (com.google.android.gms.ads.AdView) bindings[19]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[10]
            , (android.widget.LinearLayout) bindings[9]
            , (com.bestweby.enewz.customview.NeoSansProTextView) bindings[11]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[15]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[16]
            , (androidx.core.widget.NestedScrollView) bindings[12]
            , (android.webkit.WebView) bindings[20]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[8]
            , (com.bestweby.enewz.customview.NeoSansProTextView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (android.widget.LinearLayout) bindings[22]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[17]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[18]
            , (com.bestweby.enewz.databinding.ShimmerRelatedPostsLayoutBinding) bindings[6]
            , (androidx.appcompat.widget.AppCompatButton) bindings[21]
            , (androidx.cardview.widget.CardView) bindings[13]
            );
        this.collapsingToolbar.setTag(null);
        setContainedBinding(this.detailShimmerLayout);
        setContainedBinding(this.detailToolbar);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        setContainedBinding(this.shimmerRelatedProducts);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        detailToolbar.invalidateAll();
        detailShimmerLayout.invalidateAll();
        shimmerRelatedProducts.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (detailToolbar.hasPendingBindings()) {
            return true;
        }
        if (detailShimmerLayout.hasPendingBindings()) {
            return true;
        }
        if (shimmerRelatedProducts.hasPendingBindings()) {
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
        detailToolbar.setLifecycleOwner(lifecycleOwner);
        detailShimmerLayout.setLifecycleOwner(lifecycleOwner);
        shimmerRelatedProducts.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDetailToolbar((com.bestweby.enewz.databinding.DetailsToolbarLayoutBinding) object, fieldId);
            case 1 :
                return onChangeDetailShimmerLayout((com.bestweby.enewz.databinding.ShimmerPostDetailLayoutBinding) object, fieldId);
            case 2 :
                return onChangeShimmerRelatedProducts((com.bestweby.enewz.databinding.ShimmerRelatedPostsLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDetailToolbar(com.bestweby.enewz.databinding.DetailsToolbarLayoutBinding DetailToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeDetailShimmerLayout(com.bestweby.enewz.databinding.ShimmerPostDetailLayoutBinding DetailShimmerLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeShimmerRelatedProducts(com.bestweby.enewz.databinding.ShimmerRelatedPostsLayoutBinding ShimmerRelatedProducts, int fieldId) {
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
        executeBindingsOn(detailToolbar);
        executeBindingsOn(detailShimmerLayout);
        executeBindingsOn(shimmerRelatedProducts);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): detailToolbar
        flag 1 (0x2L): detailShimmerLayout
        flag 2 (0x3L): shimmerRelatedProducts
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}