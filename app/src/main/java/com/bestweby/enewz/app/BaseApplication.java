package com.bestweby.enewz.app;

import androidx.multidex.MultiDexApplication;

import com.bestweby.enewz.R;
import com.bestweby.enewz.cache.preference.AppPreference;
import com.bestweby.enewz.listener.NetworkChangeListener;
import com.bestweby.enewz.notification.NotificationRecieverService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.OneSignal;


/**
 * Created by MD Sahidul Islam on 11/7/2016.
 */

public class BaseApplication extends MultiDexApplication {

    public static NetworkChangeListener networkChangeListener;
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

        if (AppPreference.getInstance(getApplicationContext()).isNotificationOn()) {
            FirebaseMessaging.getInstance().subscribeToTopic(getString(R.string.push_notification_topic));
            OneSignal.startInit(this)
                    .setNotificationOpenedHandler(new NotificationRecieverService())
                    .setNotificationReceivedHandler(new NotificationRecieverService())
                    .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                    .init();
        } else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(getString(R.string.push_notification_topic));
            OneSignal.setSubscription(false);
        }
    }

    public static synchronized BaseApplication getInstance() {
        return baseApplication;
    }

    public void setNetworkChangedListener(NetworkChangeListener listener) {
        networkChangeListener = listener;
    }
}
