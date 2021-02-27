package com.bestweby.enewz.databinding;
import com.bestweby.enewz.R;
import com.bestweby.enewz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogPostCommentLayoutBindingImpl extends DialogPostCommentLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.dialog_title, 1);
        sViewsWithIds.put(R.id.author_name_layout, 2);
        sViewsWithIds.put(R.id.author_name_icon, 3);
        sViewsWithIds.put(R.id.author_name, 4);
        sViewsWithIds.put(R.id.author_email_layout, 5);
        sViewsWithIds.put(R.id.author_email_icon, 6);
        sViewsWithIds.put(R.id.author_email, 7);
        sViewsWithIds.put(R.id.comment_content_layout, 8);
        sViewsWithIds.put(R.id.comment_content_icon, 9);
        sViewsWithIds.put(R.id.comment_content, 10);
        sViewsWithIds.put(R.id.cancel_comment, 11);
        sViewsWithIds.put(R.id.submit_comment, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogPostCommentLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private DialogPostCommentLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[7]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[6]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (android.widget.RelativeLayout) bindings[2]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[11]
            , (android.widget.EditText) bindings[10]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[9]
            , (android.widget.RelativeLayout) bindings[8]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[1]
            , (com.bestweby.enewz.customview.RobotoTextView) bindings[12]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}