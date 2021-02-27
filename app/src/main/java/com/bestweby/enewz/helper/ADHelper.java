package com.bestweby.enewz.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.bestweby.enewz.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Sahidul Islam on 05-Jul-19.
 */
public class ADHelper {

    private static ADHelper adHelper = null;
    private InterstitialAd interstitialAd;
    private boolean hideBannerAd = false, hideInterstitialAd = false;

    // create single instance
    public static ADHelper getInstance(Context context) {
        if (adHelper == null) {
            adHelper = new ADHelper(context);
        }
        return adHelper;
    }

    private ADHelper(Context context) {
        MobileAds.initialize(context, context.getResources().getString(R.string.admob_app_id));
    }

    public void showBannerAd(final AdView mAdView) {
        if (hideBannerAd) {
            mAdView.setVisibility(View.GONE);
        } else {
            AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
            mAdView.loadAd(adRequest);

            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mAdView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    mAdView.setVisibility(View.GONE);
                }
            });
        }
    }

    public void loadFullScreenAd(Activity activity) {
        if (!hideInterstitialAd) {
            interstitialAd = new InterstitialAd(activity);
            interstitialAd.setAdUnitId(activity.getResources().getString(R.string.interstitial_ad_unit_id));

            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
    }

    public boolean showFullScreenAd() {
        if (!hideInterstitialAd) {
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
                return true;
            }
        }
        return false;
    }

    public InterstitialAd getInterstitialAd() {
        return interstitialAd;
    }

    public void disableBannerAd() {
        this.hideBannerAd = true;
    }

    public void disableInterstitialAd() {
        this.hideInterstitialAd = true;
    }
}
