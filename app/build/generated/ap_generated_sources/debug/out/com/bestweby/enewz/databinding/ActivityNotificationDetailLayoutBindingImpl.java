package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNotificationDetailLayoutBindingImpl extends ActivityNotificationDetailLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_main_layout"},
            new int[] {1},
            new int[] {com.bestweby.enewz.R.layout.toolbar_main_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.notification_image, 2);
        sViewsWithIds.put(R.id.notification_title, 3);
        sViewsWithIds.put(R.id.notification_message, 4);
        sViewsWithIds.put(R.id.view_post_detail, 5);
        sViewsWithIds.put(R.id.view_url_detail, 6);
        sViewsWithIds.put(R.id.banner_ad_layout, 7);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNotificationDetailLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityNotificationDetailLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.gms.ads.AdView) bindings[7]
            , (android.widget.ImageView) bindings[2]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[4]
            , (com.bestweby.enewz.customview.NeoSansProTextView) bindings[3]
            , (android.widget.LinearLayout) bindings[0]
            , (com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) bindings[1]
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            );
        this.parentView.setTag(null);
        setContainedBinding(this.primaryToolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        primaryToolbar.invalidateAll();
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
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePrimaryToolbar((com.bestweby.enewz.databinding.ToolbarMainLayoutBinding) object, fieldId);
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

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(primaryToolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): primaryToolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}