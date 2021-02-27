package com.bestweby.enewz.adapter.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bestweby.enewz.R;
import com.bestweby.enewz.databinding.ItemRelatedPostListLayoutBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.listener.ItemViewClickListener;
import com.bestweby.enewz.model.posts.post.PostModel;
import com.bestweby.enewz.model.posts.post.Reply;
import com.bestweby.enewz.network.ApiClient;
import com.bestweby.enewz.network.ApiConfig;
import com.bestweby.enewz.network.ApiRequests;
import com.bestweby.enewz.receiver.NetworkChangeReceiver;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md Sahidul Islam on 07-Jun-19.
 */
public class RelatedPostsAdapter extends RecyclerView.Adapter<RelatedPostsAdapter.RelatedPostsViewHolder> {

    private Context context;
    private List<PostModel> arrayList;

    private ItemViewClickListener itemClickListener;

    public RelatedPostsAdapter() {
    }

    public RelatedPostsAdapter(Context context, List<PostModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void setItemClickListener(ItemViewClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RelatedPostsAdapter.RelatedPostsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RelatedPostsViewHolder((ItemRelatedPostListLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_related_post_list_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedPostsAdapter.RelatedPostsViewHolder holder, int position) {
        int postid = arrayList.get(position).getId();
        String postTitle = arrayList.get(position).getTitle().getRendered();

        loadComments(holder, postid);

        if (arrayList.get(position).getEmbedded().getWpFeaturedmedia().size() > 0) {
            String postImage = arrayList.get(position).getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
            Picasso.get().load(postImage)
                    .placeholder(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .error(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .into(holder.binding.postImage);
        }

        holder.binding.postTitle.setText(AppHelper.fromHtml(postTitle));
    }

    private void loadComments(final RelatedPostsAdapter.RelatedPostsViewHolder holder, int postId) {
        if (NetworkChangeReceiver.isNetworkConnected()) {
            HashMap<String, String> postCommentsMap = ApiRequests.buildPostCommentCount(postId);
            ApiClient.getInstance().getApiInterface().getPostComments(postCommentsMap).enqueue(new Callback<List<Reply>>() {
                @Override
                public void onResponse(@NonNull Call<List<Reply>> call, @NonNull Response<List<Reply>> response) {
                    if (response.isSuccessful()) {
                        int totalComments = Integer.parseInt(response.headers().get(ApiConfig.HEADER_TOTAL_ITEM));
                        holder.binding.postCommentCount.setText(totalComments + " " + context.getResources().getString(R.string.comments));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Reply>> call, @NonNull Throwable t) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RelatedPostsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemRelatedPostListLayoutBinding binding;

        RelatedPostsViewHolder(@NonNull ItemRelatedPostListLayoutBinding layoutBinding) {
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
