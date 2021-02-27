package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNotificationLayoutBindingImpl extends ActivityNotificationLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(0, 
            new String[] {"bottom_sheet_notification_list"},
            new int[] {3},
            new int[] {com.bestweby.enewz.R.layout.bottom_sheet_notification_list});
        sIncludes.setIncludes(1, 
            new String[] {"notification_toolbar_layout"},
            new int[] {2},
            new int[] {com.bestweby.enewz.R.layout.notification_toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.notification_recycler, 4);
        sViewsWithIds.put(R.id.empty_list_layout, 5);
        sViewsWithIds.put(R.id.banner_ad_layout, 6);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNotificationLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityNotificationLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.gms.ads.AdView) bindings[6]
            , (com.bestweby.enewz.databinding.BottomSheetNotificationListBinding) bindings[3]
            , (android.widget.LinearLayout) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (com.bestweby.enewz.databinding.NotificationToolbarLayoutBinding) bindings[2]
            );
        setContainedBinding(this.bottomSheet);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
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
        bottomSheet.invalidateAll();
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
        if (bottomSheet.hasPendingBindings()) {
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
        bottomSheet.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePrimaryToolbar((com.bestweby.enewz.databinding.NotificationToolbarLayoutBinding) object, fieldId);
            case 1 :
                return onChangeBottomSheet((com.bestweby.enewz.databinding.BottomSheetNotificationListBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangePrimaryToolbar(com.bestweby.enewz.databinding.NotificationToolbarLayoutBinding PrimaryToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBottomSheet(com.bestweby.enewz.databinding.BottomSheetNotificationListBinding BottomSheet, int fieldId) {
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
        executeBindingsOn(bottomSheet);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): primaryToolbar
        flag 1 (0x2L): bottomSheet
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}