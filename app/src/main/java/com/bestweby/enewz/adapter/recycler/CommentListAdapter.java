package com.bestweby.enewz.adapter.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bestweby.enewz.R;
import com.bestweby.enewz.databinding.ItemCommentListLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.helper.DateHelper;
import com.bestweby.enewz.model.posts.post.Reply;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Md Sahidul Islam on 08-Jun-19.
 */
public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.CommentListViewHolder> {

    private Context context;
    private List<Reply> arrayList;

    public CommentListAdapter() {
    }

    public CommentListAdapter(Context context, List<Reply> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CommentListAdapter.CommentListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new CommentListViewHolder((ItemCommentListLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_comment_list_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentListAdapter.CommentListViewHolder holder, int position) {
        String authorName = arrayList.get(position).getAuthorName();
        String comment = arrayList.get(position).getContent().getRendered();
        String commentDate = DateHelper.formateISODate(arrayList.get(position).getDateGmt());

        if (arrayList.get(position).getAuthorAvatarUrls().get96() != null) {
            String avatar = arrayList.get(position).getAuthorAvatarUrls().get96();
            Picasso.get().load(avatar)
                    .placeholder(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .error(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .into(holder.binding.avatarImage);
        }

        holder.binding.commentAuthorName.setText(authorName);
        holder.binding.commentDate.setText(commentDate);
        holder.binding.commentContent.setText(AppHelper.fromHtml(comment));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CommentListViewHolder extends RecyclerView.ViewHolder {

        ItemCommentListLayoutBinding binding;

        public CommentListViewHolder(@NonNull ItemCommentListLayoutBinding layoutBinding) {
            super(layoutBinding.getRoot());
            binding = layoutBinding;
        }
    }
}
