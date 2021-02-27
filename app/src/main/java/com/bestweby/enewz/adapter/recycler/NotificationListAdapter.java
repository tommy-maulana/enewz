package com.bestweby.enewz.adapter.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bestweby.enewz.R;
import com.bestweby.enewz.databinding.ItemNotificationLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.listener.ItemViewClickListener;
import com.bestweby.enewz.model.dbEntity.NotificationModel;

import java.util.List;

/**
 * Created by Md Sahidul Islam on 30-May-19.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.NotificationViewHolder> {

    private Context context;
    private List<NotificationModel> arrayList;

    private ItemViewClickListener itemClickListener;

    public NotificationListAdapter() {
    }

    public NotificationListAdapter(Context context, List<NotificationModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void setItemClickListener(ItemViewClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public NotificationListAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new NotificationViewHolder((ItemNotificationLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_notification_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationListAdapter.NotificationViewHolder holder, int position) {
        String title = arrayList.get(position).getTitle();
        String message = arrayList.get(position).getMessage();
        Boolean isRead = arrayList.get(position).getRead();

        holder.binding.notificationTitle.setText(AppHelper.fromHtml(title));
        holder.binding.notificationMessage.setText(message);

        if (isRead) {
            holder.binding.notificationLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        } else {
            holder.binding.notificationLayout.setBackgroundColor(context.getResources().getColor(R.color.grayExtraLight));
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemNotificationLayoutBinding binding;

        NotificationViewHolder(@NonNull ItemNotificationLayoutBinding layoutBinding) {
            super(layoutBinding.getRoot());
            binding = layoutBinding;

            binding.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemViewClickGetPosition(getLayoutPosition(), view);
        }
    }
}
