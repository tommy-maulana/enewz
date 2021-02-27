package com.bestweby.enewz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.bestweby.enewz.R;
import com.bestweby.enewz.app.BaseActivity;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.database.helpers.DaoHelper;
import com.bestweby.enewz.database.loader.NotificationItemLoader;
import com.bestweby.enewz.databinding.ActivityNotificationDetailLayoutBinding;
import com.bestweby.enewz.helper.ADHelper;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.model.dbEntity.NotificationModel;
import com.squareup.picasso.Picasso;

/**
 * Created by Md Sahidul Islam on 31-May-19.
 */
public class NotificationDetailActivity extends BaseActivity {

    private ActivityNotificationDetailLayoutBinding binding;

    private NotificationModel notificationModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initView();
        initListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initVars() {

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            if (bundle.containsKey(AppConstants.BUNDLE_NOTIFICATION_DETAIL))
                notificationModel = bundle.getParcelable(AppConstants.BUNDLE_NOTIFICATION_DETAIL);
        }
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_detail_layout);

        setToolbar(binding.primaryToolbar.toolbar, binding.primaryToolbar.toolbarTitle, getString(R.string.toolbar_notification_detail));

        loadNotificationView();
        ADHelper.getInstance(getApplicationContext()).showBannerAd(binding.bannerAdLayout);
    }

    private void initListener() {
        binding.viewPostDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, notificationModel.getTitle());
                bundle.putInt(AppConstants.BUNDLE_POST_ID, notificationModel.getPostId());
                startActivity(new Intent(NotificationDetailActivity.this, PostDetailActivity.class).putExtras(bundle));
            }
        });

        binding.viewUrlDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.BUNDLE_PAGE_TITLE, notificationModel.getTitle());
                bundle.putString(AppConstants.BUNDLE_WEB_URL, notificationModel.getWebUrl());
                startActivity(new Intent(NotificationDetailActivity.this, WebContentActivity.class).putExtras(bundle));
            }
        });
    }

    private void loadNotificationView() {
        String title = notificationModel.getTitle();
        String message = notificationModel.getMessage();
        String image = notificationModel.getImage();
        String type = notificationModel.getType();
        String webUrl = notificationModel.getWebUrl();
        int productId = notificationModel.getPostId();

        if (image != null && !image.isEmpty()) {
            Picasso.get().load(image)
                    .placeholder(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .error(context.getResources().getDrawable(R.drawable.image_placeholder))
                    .into(binding.notificationImage);

            binding.notificationImage.setVisibility(View.VISIBLE);
        } else {
            binding.notificationImage.setVisibility(View.GONE);
        }

        binding.notificationTitle.setText(AppHelper.fromHtml(title));
        binding.notificationMessage.setText(AppHelper.fromHtml(message));

        if (type.equals(AppConstants.NOTIFICATION_POST) && productId > 0) {
            binding.viewPostDetail.setVisibility(View.VISIBLE);
        } else {
            binding.viewPostDetail.setVisibility(View.GONE);
        }

        if (type.equals(AppConstants.NOTIFICATION_URL) && !webUrl.isEmpty()) {
            binding.viewUrlDetail.setVisibility(View.VISIBLE);
        } else {
            binding.viewUrlDetail.setVisibility(View.GONE);
        }

        updateSeenNotification();
    }

    private void updateSeenNotification() {
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.UPDATE, notificationModel.getAutoId());
    }
}
