package com.bestweby.enewz.adapter.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.bestweby.enewz.R;
import com.bestweby.enewz.databinding.ItemImageSliderBinding;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.listener.ItemClickListener;
import com.bestweby.enewz.model.posts.post.PostModel;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Md Sahidul Islam on 12-Feb-19.
 */

public class TemplateSliderAdapter extends PagerAdapter {

    private Context context;
    private List<PostModel> modelList;
    private Boolean clickable = false;
    private ItemClickListener itemClickListener;

    public TemplateSliderAdapter(Context context) {
        this.context = context;
    }

    public TemplateSliderAdapter(Context context, List<PostModel> modelList, Boolean clickable) {
        this.context = context;
        this.modelList = modelList;
        this.clickable = clickable;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ItemImageSliderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_image_slider, container, false);

        if (modelList.get(position).getEmbedded().getWpFeaturedmedia() != null) {
            String sliderImage = modelList.get(position).getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
            Picasso.get().load(sliderImage)
                    .placeholder(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .error(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .into(binding.sliderImage);
        }

        String sliderTitle = modelList.get(position).getTitle().getRendered();
        binding.sliderTitle.setText(AppHelper.fromHtml(sliderTitle));

        if (clickable)
            binding.parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null)
                        itemClickListener.onItemClickGetPosition(position);
                }
            });

        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    public void setSliderItemClickListerner(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
