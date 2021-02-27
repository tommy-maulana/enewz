package com.bestweby.enewz.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bestweby.enewz.R;
import com.bestweby.enewz.adapter.recycler.NotificationListAdapter;
import com.bestweby.enewz.app.BaseActivity;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.database.helpers.DaoHelper;
import com.bestweby.enewz.database.helpers.DbLoaderInterface;
import com.bestweby.enewz.database.loader.NotificationItemLoader;
import com.bestweby.enewz.databinding.ActivityNotificationLayoutBinding;
import com.bestweby.enewz.helper.ADHelper;
import com.bestweby.enewz.listener.ItemViewClickListener;
import com.bestweby.enewz.model.dbEntity.NotificationModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Md Sahidul Islam on 15-May-19.
 */

public class NotificationActivity extends BaseActivity {

    private ActivityNotificationLayoutBinding binding;
    private NotificationListAdapter notificationAdapter;

    private BottomSheetBehavior sheetBehavior;

    private List<NotificationModel> notificationList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initView();
        initRecyclerView();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadNotifications();
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

    @Override
    public void onBackPressed() {
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {

                Rect outRect = new Rect();
                binding.bottomSheet.bottomSheetLayout.getGlobalVisibleRect(outRect);

                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY()))
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

        return super.dispatchTouchEvent(event);
    }

    private void initVars() {
        notificationList = new ArrayList<>();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_layout);
        setToolbar(binding.primaryToolbar.toolbar, binding.primaryToolbar.toolbarTitle, getString(R.string.toolbar_notification));

        sheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.bottomSheetLayout);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        ADHelper.getInstance(getApplicationContext()).showFullScreenAd();
        ADHelper.getInstance(getApplicationContext()).showBannerAd(binding.bannerAdLayout);
    }

    private void initListener() {
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        binding.primaryToolbar.toolbarMenuDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAllNotification();
            }
        });

        notificationAdapter.setItemClickListener(new ItemViewClickListener() {
            @Override
            public void onItemViewClickGetPosition(final int position, View view) {
                toggleBottomSheet();

                final NotificationModel model = notificationList.get(position);

                binding.bottomSheet.viewDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toggleBottomSheet();

                        Bundle bundle = new Bundle();
                        bundle.putParcelable(AppConstants.BUNDLE_NOTIFICATION_DETAIL, model);
                        startActivity(new Intent(NotificationActivity.this, NotificationDetailActivity.class).putExtras(bundle));
                    }
                });

                binding.bottomSheet.markRead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toggleBottomSheet();

                        updateSeenNotification(position);
                    }
                });

                binding.bottomSheet.deleteItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toggleBottomSheet();
                        deleteNotification(position);
                    }
                });

                binding.bottomSheet.closeWindow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toggleBottomSheet();
                    }
                });
            }
        });
    }

    private void initRecyclerView() {
        notificationAdapter = new NotificationListAdapter(NotificationActivity.this, notificationList);
        binding.notificationRecycler.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
        binding.notificationRecycler.setAdapter(notificationAdapter);
    }

    private void loadNotifications() {
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.FETCH_ALL);
        notificationItemLoader.setDbLoaderInterface(new DbLoaderInterface() {
            @Override
            public void onFinished(Object object) {
                if (object != null) {
                    List<NotificationModel> modelList = (List<NotificationModel>) object;

                    if (modelList.size() > 0) {
                        notificationList.clear();
                        notificationList.addAll(modelList);
                        notificationAdapter.notifyDataSetChanged();
                        binding.emptyListLayout.setVisibility(View.GONE);
                        binding.notificationRecycler.setVisibility(View.VISIBLE);
                        binding.primaryToolbar.toolbarMenuDelete.setVisibility(View.VISIBLE);
                    } else {
                        binding.emptyListLayout.removeAllViews();
                        binding.emptyListLayout.addView(setEmptyLayout(NotificationActivity.this, getString(R.string.no_notification)));
                        binding.notificationRecycler.setVisibility(View.GONE);
                        binding.primaryToolbar.toolbarMenuDelete.setVisibility(View.GONE);
                        binding.emptyListLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void updateSeenNotification(int position) {
        NotificationModel model = notificationList.get(position);
        model.setRead(true);
        notificationAdapter.notifyItemChanged(position);

        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.UPDATE, model.getAutoId());
    }

    private void deleteNotification(int position) {
        NotificationModel model = notificationList.get(position);
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.DELETE, model.getAutoId());

        notificationList.remove(position);
        notificationAdapter.notifyItemRemoved(position);

        loadNotifications();
    }

    private void deleteAllNotification() {
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.DELETE_ALL);

        notificationList.clear();
        notificationAdapter.notifyDataSetChanged();

        loadNotifications();
    }

    private void toggleBottomSheet() {
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
