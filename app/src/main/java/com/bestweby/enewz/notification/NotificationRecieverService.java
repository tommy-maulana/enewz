package com.bestweby.enewz.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.bestweby.enewz.R;
import com.bestweby.enewz.activity.NewsTemplateActivity;
import com.bestweby.enewz.activity.NotificationDetailActivity;
import com.bestweby.enewz.activity.PostDetailActivity;
import com.bestweby.enewz.activity.WebContentActivity;
import com.bestweby.enewz.app.BaseApplication;
import com.bestweby.enewz.cache.constant.AppConstants;
import com.bestweby.enewz.database.helpers.DaoHelper;
import com.bestweby.enewz.database.loader.NotificationItemLoader;
import com.bestweby.enewz.model.dbEntity.NotificationModel;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by Md Sahidul Islam on 29-May-19.
 */
public class NotificationRecieverService extends FirebaseMessagingService implements OneSignal.NotificationReceivedHandler, OneSignal.NotificationOpenedHandler {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0) {
            Map<String, String> data = remoteMessage.getData();

            Log.e("onMessageFirebase: ", remoteMessage.getData().toString());

            if (data.get("post_id") != null) {
                String type = data.get("type");
                String title = data.get("title");
                String message = data.get("message");
                String imageUrl = data.get("image");
                String webUrl = data.get("web_url");
                String post = data.get("post_id");
                int postId = post == null || post.equals("") ? 0 : Integer.valueOf(post);

                createNotification(title, message, webUrl, imageUrl, postId, type);
            }
        }
    }

    @Override
    public void notificationReceived(OSNotification notification) {
        Log.e("onMessageReceived: ", notification.payload.toString());

        JSONObject data = notification.payload.additionalData;

        if (data != null && data.has("post_id")) {
            String type = data.optString("type");
            String title = data.optString("title");
            String message = data.optString("message");
            String imageUrl = data.optString("image");
            String post = data.optString("post_id");
            int postId = post.equals("") ? 0 : Integer.valueOf(post);

            NotificationItemLoader notificationItemLoader = new NotificationItemLoader(BaseApplication.getInstance());
            NotificationModel model = new NotificationModel(title, message, imageUrl, "", postId, type, false);
            notificationItemLoader.execute(DaoHelper.INSERT, model);

            Log.e("onMessageReceived: ", post);
        }
    }

    @Override
    public void notificationOpened(OSNotificationOpenResult result) {
        Log.e("onMessageOpened: ", result.notification.payload.toString());

        JSONObject data = result.notification.payload.additionalData;

        if (data != null && data.has("post_id")) {
            String title = data.optString("title");
            String post = data.optString("post_id");
            int postId = post.equals("") ? 0 : Integer.valueOf(post);

            Intent intent = new Intent(BaseApplication.getInstance(), PostDetailActivity.class);

            intent.putExtra(AppConstants.BUNDLE_PAGE_TITLE, title);
            intent.putExtra(AppConstants.BUNDLE_POST_ID, postId);
            intent.putExtra(AppConstants.BUNDLE_FROM_NOTIFICATION, true);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BaseApplication.getInstance().startActivity(intent);
        }
    }

    private void createNotification(String title, String message, String webUrl, String imageUrl, int postId, String type) {
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        NotificationModel model = new NotificationModel(title, message, imageUrl, webUrl, postId, type, false);
        notificationItemLoader.execute(DaoHelper.INSERT, model);

        Intent intent;
        if (type != null && !type.isEmpty() && type.equals(AppConstants.NOTIFICATION_MESSAGE)) {
            intent = new Intent(this, NotificationDetailActivity.class);
            intent.putExtra(AppConstants.BUNDLE_NOTIFICATION_DETAIL, model);
        } else if (type != null && !type.isEmpty() && type.equals(AppConstants.NOTIFICATION_POST)) {
            intent = new Intent(this, PostDetailActivity.class);
            intent.putExtra(AppConstants.BUNDLE_PAGE_TITLE, title);
            intent.putExtra(AppConstants.BUNDLE_POST_ID, postId);
            intent.putExtra(AppConstants.BUNDLE_FROM_NOTIFICATION, true);
        } else if (type != null && !type.isEmpty() && type.equals(AppConstants.NOTIFICATION_URL)) {
            intent = new Intent(this, WebContentActivity.class);
            intent.putExtra(AppConstants.BUNDLE_PAGE_TITLE, title);
            intent.putExtra(AppConstants.BUNDLE_WEB_URL, webUrl);
            intent.putExtra(AppConstants.BUNDLE_FROM_NOTIFICATION, true);
        } else {
            intent = new Intent(this, NewsTemplateActivity.class);
        }

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = getApplicationContext().getString(R.string.app_name);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            notificationBuilder.setPriority(Notification.PRIORITY_MAX);
        } else {
            notificationBuilder.setPriority(NotificationManager.IMPORTANCE_HIGH);
        }

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notificationBuilder.setSound(alarmSound).setVibrate(new long[]{100, 200, 300, 400});

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, getString(R.string.app_name), NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.shouldShowLights();
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Bitmap image = fetchBitmap(imageUrl);
            if (image != null) {
                notificationBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(image));
            }
        }

        assert notificationManager != null;
        notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
    }

    private Bitmap fetchBitmap(String src) {
        try {
            if (src != null) {
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.setConnectTimeout(1200000);
                connection.setReadTimeout(1200000);
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
