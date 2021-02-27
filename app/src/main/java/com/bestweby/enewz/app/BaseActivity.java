package com.bestweby.enewz.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bestweby.enewz.R;
import com.bestweby.enewz.activity.AppSettingsActivity;
import com.bestweby.enewz.activity.ArticleTemplateActivity;
import com.bestweby.enewz.activity.BlogTemplateActivity;
import com.bestweby.enewz.activity.CategoryActivity;
import com.bestweby.enewz.activity.FeedTemplateActivity;
import com.bestweby.enewz.activity.MyFavouritesActivity;
import com.bestweby.enewz.activity.NewsTemplateActivity;
import com.bestweby.enewz.activity.StoryTemplateActivity;
import com.bestweby.enewz.cache.preference.AppPreference;
import com.bestweby.enewz.customview.RotateProgressDialog;
import com.bestweby.enewz.database.helpers.DaoHelper;
import com.bestweby.enewz.database.helpers.DbLoaderInterface;
import com.bestweby.enewz.database.loader.FavouriteItemLoader;
import com.bestweby.enewz.database.loader.NotificationItemLoader;
import com.bestweby.enewz.databinding.EmptyListPrimaryLayoutBinding;
import com.bestweby.enewz.helper.ADHelper;
import com.bestweby.enewz.helper.AppHelper;
import com.bestweby.enewz.model.dbEntity.FavouritesModel;
import com.bestweby.enewz.model.dbEntity.NotificationModel;
import com.bestweby.enewz.model.posts.post.PostModel;
import com.bestweby.enewz.model.posts.post.WpTerm;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

/**
 * Created by Md Sahidul Islam on 22/12/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Context context;
    public RotateProgressDialog progressDialog;
    public DrawerLayout navDrawerLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();
        progressDialog = new RotateProgressDialog(this);

        setAppLocality();
        setAppTheme();

/*        ADHelper.getInstance(this).disableBannerAd();
        ADHelper.getInstance(this).disableInterstitialAd();*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        ADHelper.getInstance(getApplicationContext()).loadFullScreenAd(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        navDrawerLayout.closeDrawer(GravityCompat.START);

        switch (id) {
            case R.id.nav_news_template:
                startActivity(new Intent(this, NewsTemplateActivity.class));
                finish();
                break;
            case R.id.nav_blog_template:
                startActivity(new Intent(this, BlogTemplateActivity.class));
                finish();
                break;
            case R.id.nav_article_template:
                startActivity(new Intent(this, ArticleTemplateActivity.class));
                finish();
                break;
            case R.id.nav_story_template:
                startActivity(new Intent(this, StoryTemplateActivity.class));
                finish();
                break;
            case R.id.nav_feed_template:
                startActivity(new Intent(this, FeedTemplateActivity.class));
                finish();
                break;
            case R.id.nav_categories:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.nav_bookmarks:
                startActivity(new Intent(this, MyFavouritesActivity.class));
                break;
            case R.id.nav_facebook:
                AppHelper.faceBookLink(this);
                break;
            case R.id.nav_youtube:
                AppHelper.youtubeLink(this);
                break;
            case R.id.nav_twitter:
                AppHelper.twitterLink(this);
                break;
            case R.id.nav_instagram:
                AppHelper.instagramLink(this);
                break;
            case R.id.nav_pinterest:
                AppHelper.pinterestLink(this);
                break;
            case R.id.nav_app_settings:
                startActivity(new Intent(this, AppSettingsActivity.class));
                break;
            case R.id.nav_terms_condition:
                AppHelper.browseUrl(this, getString(R.string.nav_terms_condition), getString(R.string.terms_url), false);
                break;
            case R.id.nav_privacy_policy:
                AppHelper.browseUrl(this, getString(R.string.nav_privacy_policy), getString(R.string.privacy_url), false);
                break;
            case R.id.nav_faq:
                AppHelper.browseUrl(this, getString(R.string.nav_faq), getString(R.string.faq_url), false);
                break;
            case R.id.nav_rate_app:
                AppHelper.rateThisApp(this);
                break;
            case R.id.nav_more_apps:
                AppHelper.developerMoreApps(this);
                break;
        }
        return true;
    }

    public void initDrawerLayout(DrawerLayout drawerLayout, NavigationView navigationView, Toolbar toolbar) {
        navDrawerLayout = drawerLayout;

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setToolbar(Toolbar toolbar, TextView titleView, CharSequence title) {
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setSubtitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle(title);
        titleView.setText(title);
    }

    public static View setEmptyLayout(Context context, String message) {
        EmptyListPrimaryLayoutBinding layoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.empty_list_primary_layout, null, false);
        layoutBinding.warningMessage.setText(message);

        return layoutBinding.getRoot();
    }

    public void updateToolbarNotificationCount(final TextView textView) {
        NotificationItemLoader notificationItemLoader = new NotificationItemLoader(this);
        notificationItemLoader.execute(DaoHelper.FETCH_UNSEEN);
        notificationItemLoader.setDbLoaderInterface(new DbLoaderInterface() {
            @Override
            public void onFinished(Object object) {
                if (object != null) {
                    List<NotificationModel> modelList = (List<NotificationModel>) object;

                    if (modelList.size() > 0) {
                        textView.setText(String.valueOf(modelList.size()));
                        textView.setVisibility(View.VISIBLE);
                    } else {
                        textView.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    public void sharePost(PostModel postModel) {
        String postTitle = postModel.getTitle().getRendered();
        String postLink = postModel.getLink();

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);

        sharingIntent.putExtra(Intent.EXTRA_TEXT, postTitle + "\n\nLink : " + postLink);
        sharingIntent.setType("text/plain");

        startActivity(Intent.createChooser(sharingIntent, "Sharing via"));
    }

    public void checkAndSaveFavourite(final PostModel postModel) {
        int postid = postModel.getId();

        FavouriteItemLoader favouriteItemLoader = new FavouriteItemLoader(context);
        favouriteItemLoader.execute(DaoHelper.FETCH, postid);
        favouriteItemLoader.setDbLoaderInterface(new DbLoaderInterface() {
            @Override
            public void onFinished(Object object) {
                if (object == null) {
                    savePost(postModel);
                } else {
                    AppHelper.showShortToast(context, context.getResources().getString(R.string.already_saved));
                }
            }
        });
    }

    public void savePost(PostModel postModel) {
        int postid = postModel.getId();
        String postTitle = AppHelper.fromHtml(postModel.getTitle().getRendered()).toString();
        String postDate = postModel.getDateGmt();
        String postCategory = "";
        String postImage = "";
        StringBuilder stringBuilder = new StringBuilder();

        if (postModel.getEmbedded().getWpTerm().get(0).size() > 0) {
            for (WpTerm wpTerm : postModel.getEmbedded().getWpTerm().get(0)) {
                if (stringBuilder.length() > 0) stringBuilder.append(", ");
                stringBuilder.append(wpTerm.getName());
            }
        }

        postCategory = stringBuilder.toString();

        if (postModel.getEmbedded().getWpFeaturedmedia().size() > 0)
            postImage = postModel.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();

        FavouritesModel model = new FavouritesModel(postid, postTitle, postDate, postCategory, postImage);
        FavouriteItemLoader favouriteItemLoader1 = new FavouriteItemLoader(context);
        favouriteItemLoader1.execute(DaoHelper.INSERT, model);
        AppHelper.showShortToast(context, context.getResources().getString(R.string.saved));
    }

    public void setAppTheme() {
        int themeValue = AppPreference.getInstance(this).getInteger(getResources().getString(R.string.pref_theme));
        String themeMode = getResources().getStringArray(R.array.app_theme_entries)[themeValue];

        if (themeMode.equals(getResources().getString(R.string.theme_light))) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (themeMode.equals(getResources().getString(R.string.theme_dark))) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void setAppLocality() {
        int languageValue = AppPreference.getInstance(this).getInteger(getResources().getString(R.string.pref_language));
        String languageCode = getResources().getStringArray(R.array.app_locality)[languageValue];

        AppHelper.setAppLanguage(this, languageCode);
    }

    public void enableDisableSwipeRefresh(SwipeRefreshLayout swipeRefreshLayout, boolean enable) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(enable);
        }
    }
}
