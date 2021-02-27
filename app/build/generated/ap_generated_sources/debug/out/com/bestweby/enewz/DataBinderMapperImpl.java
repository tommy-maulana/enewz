package com.bestweby.enewz;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bestweby.enewz.databinding.ActivityAppSettingsLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityArticleTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityBlogTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityCategoryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityCategoryPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityFeedTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityMyFavouritesLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityNewsTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityNotificationDetailLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityNotificationLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityPostCommentsLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityPostDetailLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivitySearchPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivitySplashLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityStoryTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivitySubcategoryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ActivityWebContentLayoutBindingImpl;
import com.bestweby.enewz.databinding.BlogPostListFragmentLayoutBindingImpl;
import com.bestweby.enewz.databinding.BottomSheetNotificationListBindingImpl;
import com.bestweby.enewz.databinding.DetailsToolbarLayoutBindingImpl;
import com.bestweby.enewz.databinding.DetailsToolbarLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.DialogPostCommentLayoutBindingImpl;
import com.bestweby.enewz.databinding.DialogPostCommentLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.EmptyListPrimaryLayoutBindingImpl;
import com.bestweby.enewz.databinding.FeedPostListFragmentLayoutBindingImpl;
import com.bestweby.enewz.databinding.HomeToolbarLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemArticlePostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemArticlePostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemBlogPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemBlogPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemCategoryGridPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemCategoryGridPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemCategoryLinearPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemCategoryLinearPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemCategoryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemCommentListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemCommentListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemFavouritePostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemFavouritePostLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemFeedPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemFeedPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemHomeCategoryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemImageSliderBindingImpl;
import com.bestweby.enewz.databinding.ItemImageSliderBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemNewsPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemNewsPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemNotificationLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemNotificationLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemRelatedPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemRelatedPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemSearchPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemSearchPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ItemStoryPostListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ItemStoryPostListLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.NavHeaderLayoutBindingImpl;
import com.bestweby.enewz.databinding.NewsPostListFragmentLayoutBindingImpl;
import com.bestweby.enewz.databinding.NotificationToolbarLayoutBindingImpl;
import com.bestweby.enewz.databinding.PrimaryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.PrimaryToolbarLayoutBindingImpl;
import com.bestweby.enewz.databinding.RecyclerMainLayoutBindingImpl;
import com.bestweby.enewz.databinding.SearchToolbarLayoutBindingImpl;
import com.bestweby.enewz.databinding.SearchToolbarLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ShimmerArticlePostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerBlogPagerLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerBlogPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerCategoryListLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerFeedPagerLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerFeedPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerGridCategoryPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerLinearCategoryPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerNewsPagerLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerNewsPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerPostCommentLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerPostDetailLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerRelatedPostsLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerSearchPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerStoryPostLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerTemplateCategoryLayoutBindingImpl;
import com.bestweby.enewz.databinding.ShimmerTemplateSliderLayoutBindingImpl;
import com.bestweby.enewz.databinding.SpinnerItemLayoutBindingImpl;
import com.bestweby.enewz.databinding.ToolbarMainLayoutBindingImpl;
import com.bestweby.enewz.databinding.ToolbarMainLayoutBindingLdrtlImpl;
import com.bestweby.enewz.databinding.ViewArticleTemplateLayoutBindingImpl;
import com.bestweby.enewz.databinding.ViewStoryTemplateLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAPPSETTINGSLAYOUT = 1;

  private static final int LAYOUT_ACTIVITYARTICLETEMPLATELAYOUT = 2;

  private static final int LAYOUT_ACTIVITYBLOGTEMPLATELAYOUT = 3;

  private static final int LAYOUT_ACTIVITYCATEGORYLISTLAYOUT = 4;

  private static final int LAYOUT_ACTIVITYCATEGORYPOSTLAYOUT = 5;

  private static final int LAYOUT_ACTIVITYFEEDTEMPLATELAYOUT = 6;

  private static final int LAYOUT_ACTIVITYMYFAVOURITESLAYOUT = 7;

  private static final int LAYOUT_ACTIVITYNEWSTEMPLATELAYOUT = 8;

  private static final int LAYOUT_ACTIVITYNOTIFICATIONDETAILLAYOUT = 9;

  private static final int LAYOUT_ACTIVITYNOTIFICATIONLAYOUT = 10;

  private static final int LAYOUT_ACTIVITYPOSTCOMMENTSLAYOUT = 11;

  private static final int LAYOUT_ACTIVITYPOSTDETAILLAYOUT = 12;

  private static final int LAYOUT_ACTIVITYSEARCHPOSTLAYOUT = 13;

  private static final int LAYOUT_ACTIVITYSPLASHLAYOUT = 14;

  private static final int LAYOUT_ACTIVITYSTORYTEMPLATELAYOUT = 15;

  private static final int LAYOUT_ACTIVITYSUBCATEGORYLISTLAYOUT = 16;

  private static final int LAYOUT_ACTIVITYWEBCONTENTLAYOUT = 17;

  private static final int LAYOUT_BLOGPOSTLISTFRAGMENTLAYOUT = 18;

  private static final int LAYOUT_BOTTOMSHEETNOTIFICATIONLIST = 19;

  private static final int LAYOUT_DETAILSTOOLBARLAYOUT = 20;

  private static final int LAYOUT_DIALOGPOSTCOMMENTLAYOUT = 21;

  private static final int LAYOUT_EMPTYLISTPRIMARYLAYOUT = 22;

  private static final int LAYOUT_FEEDPOSTLISTFRAGMENTLAYOUT = 23;

  private static final int LAYOUT_HOMETOOLBARLAYOUT = 24;

  private static final int LAYOUT_ITEMARTICLEPOSTLISTLAYOUT = 25;

  private static final int LAYOUT_ITEMBLOGPOSTLISTLAYOUT = 26;

  private static final int LAYOUT_ITEMCATEGORYGRIDPOSTLISTLAYOUT = 27;

  private static final int LAYOUT_ITEMCATEGORYLINEARPOSTLISTLAYOUT = 28;

  private static final int LAYOUT_ITEMCATEGORYLISTLAYOUT = 29;

  private static final int LAYOUT_ITEMCOMMENTLISTLAYOUT = 30;

  private static final int LAYOUT_ITEMFAVOURITEPOSTLAYOUT = 31;

  private static final int LAYOUT_ITEMFEEDPOSTLISTLAYOUT = 32;

  private static final int LAYOUT_ITEMHOMECATEGORYLISTLAYOUT = 33;

  private static final int LAYOUT_ITEMIMAGESLIDER = 34;

  private static final int LAYOUT_ITEMNEWSPOSTLISTLAYOUT = 35;

  private static final int LAYOUT_ITEMNOTIFICATIONLAYOUT = 36;

  private static final int LAYOUT_ITEMRELATEDPOSTLISTLAYOUT = 37;

  private static final int LAYOUT_ITEMSEARCHPOSTLISTLAYOUT = 38;

  private static final int LAYOUT_ITEMSTORYPOSTLISTLAYOUT = 39;

  private static final int LAYOUT_NAVHEADERLAYOUT = 40;

  private static final int LAYOUT_NEWSPOSTLISTFRAGMENTLAYOUT = 41;

  private static final int LAYOUT_NOTIFICATIONTOOLBARLAYOUT = 42;

  private static final int LAYOUT_PRIMARYLISTLAYOUT = 43;

  private static final int LAYOUT_PRIMARYTOOLBARLAYOUT = 44;

  private static final int LAYOUT_RECYCLERMAINLAYOUT = 45;

  private static final int LAYOUT_SEARCHTOOLBARLAYOUT = 46;

  private static final int LAYOUT_SHIMMERARTICLEPOSTLAYOUT = 47;

  private static final int LAYOUT_SHIMMERBLOGPAGERLAYOUT = 48;

  private static final int LAYOUT_SHIMMERBLOGPOSTLAYOUT = 49;

  private static final int LAYOUT_SHIMMERCATEGORYLISTLAYOUT = 50;

  private static final int LAYOUT_SHIMMERFEEDPAGERLAYOUT = 51;

  private static final int LAYOUT_SHIMMERFEEDPOSTLAYOUT = 52;

  private static final int LAYOUT_SHIMMERGRIDCATEGORYPOSTLAYOUT = 53;

  private static final int LAYOUT_SHIMMERLINEARCATEGORYPOSTLAYOUT = 54;

  private static final int LAYOUT_SHIMMERNEWSPAGERLAYOUT = 55;

  private static final int LAYOUT_SHIMMERNEWSPOSTLAYOUT = 56;

  private static final int LAYOUT_SHIMMERPOSTCOMMENTLAYOUT = 57;

  private static final int LAYOUT_SHIMMERPOSTDETAILLAYOUT = 58;

  private static final int LAYOUT_SHIMMERRELATEDPOSTSLAYOUT = 59;

  private static final int LAYOUT_SHIMMERSEARCHPOSTLAYOUT = 60;

  private static final int LAYOUT_SHIMMERSTORYPOSTLAYOUT = 61;

  private static final int LAYOUT_SHIMMERTEMPLATECATEGORYLAYOUT = 62;

  private static final int LAYOUT_SHIMMERTEMPLATESLIDERLAYOUT = 63;

  private static final int LAYOUT_SPINNERITEMLAYOUT = 64;

  private static final int LAYOUT_TOOLBARMAINLAYOUT = 65;

  private static final int LAYOUT_VIEWARTICLETEMPLATELAYOUT = 66;

  private static final int LAYOUT_VIEWSTORYTEMPLATELAYOUT = 67;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(67);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_app_settings_layout, LAYOUT_ACTIVITYAPPSETTINGSLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_article_template_layout, LAYOUT_ACTIVITYARTICLETEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_blog_template_layout, LAYOUT_ACTIVITYBLOGTEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_category_list_layout, LAYOUT_ACTIVITYCATEGORYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_category_post_layout, LAYOUT_ACTIVITYCATEGORYPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_feed_template_layout, LAYOUT_ACTIVITYFEEDTEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_my_favourites_layout, LAYOUT_ACTIVITYMYFAVOURITESLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_news_template_layout, LAYOUT_ACTIVITYNEWSTEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_notification_detail_layout, LAYOUT_ACTIVITYNOTIFICATIONDETAILLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_notification_layout, LAYOUT_ACTIVITYNOTIFICATIONLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_post_comments_layout, LAYOUT_ACTIVITYPOSTCOMMENTSLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_post_detail_layout, LAYOUT_ACTIVITYPOSTDETAILLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_search_post_layout, LAYOUT_ACTIVITYSEARCHPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_splash_layout, LAYOUT_ACTIVITYSPLASHLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_story_template_layout, LAYOUT_ACTIVITYSTORYTEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_subcategory_list_layout, LAYOUT_ACTIVITYSUBCATEGORYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.activity_web_content_layout, LAYOUT_ACTIVITYWEBCONTENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.blog_post_list_fragment_layout, LAYOUT_BLOGPOSTLISTFRAGMENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.bottom_sheet_notification_list, LAYOUT_BOTTOMSHEETNOTIFICATIONLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.details_toolbar_layout, LAYOUT_DETAILSTOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.dialog_post_comment_layout, LAYOUT_DIALOGPOSTCOMMENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.empty_list_primary_layout, LAYOUT_EMPTYLISTPRIMARYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.feed_post_list_fragment_layout, LAYOUT_FEEDPOSTLISTFRAGMENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.home_toolbar_layout, LAYOUT_HOMETOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_article_post_list_layout, LAYOUT_ITEMARTICLEPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_blog_post_list_layout, LAYOUT_ITEMBLOGPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_category_grid_post_list_layout, LAYOUT_ITEMCATEGORYGRIDPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_category_linear_post_list_layout, LAYOUT_ITEMCATEGORYLINEARPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_category_list_layout, LAYOUT_ITEMCATEGORYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_comment_list_layout, LAYOUT_ITEMCOMMENTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_favourite_post_layout, LAYOUT_ITEMFAVOURITEPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_feed_post_list_layout, LAYOUT_ITEMFEEDPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_home_category_list_layout, LAYOUT_ITEMHOMECATEGORYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_image_slider, LAYOUT_ITEMIMAGESLIDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_news_post_list_layout, LAYOUT_ITEMNEWSPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_notification_layout, LAYOUT_ITEMNOTIFICATIONLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_related_post_list_layout, LAYOUT_ITEMRELATEDPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_search_post_list_layout, LAYOUT_ITEMSEARCHPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.item_story_post_list_layout, LAYOUT_ITEMSTORYPOSTLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.nav_header_layout, LAYOUT_NAVHEADERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.news_post_list_fragment_layout, LAYOUT_NEWSPOSTLISTFRAGMENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.notification_toolbar_layout, LAYOUT_NOTIFICATIONTOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.primary_list_layout, LAYOUT_PRIMARYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.primary_toolbar_layout, LAYOUT_PRIMARYTOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.recycler_main_layout, LAYOUT_RECYCLERMAINLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.search_toolbar_layout, LAYOUT_SEARCHTOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_article_post_layout, LAYOUT_SHIMMERARTICLEPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_blog_pager_layout, LAYOUT_SHIMMERBLOGPAGERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_blog_post_layout, LAYOUT_SHIMMERBLOGPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_category_list_layout, LAYOUT_SHIMMERCATEGORYLISTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_feed_pager_layout, LAYOUT_SHIMMERFEEDPAGERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_feed_post_layout, LAYOUT_SHIMMERFEEDPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_grid_category_post_layout, LAYOUT_SHIMMERGRIDCATEGORYPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_linear_category_post_layout, LAYOUT_SHIMMERLINEARCATEGORYPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_news_pager_layout, LAYOUT_SHIMMERNEWSPAGERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_news_post_layout, LAYOUT_SHIMMERNEWSPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_post_comment_layout, LAYOUT_SHIMMERPOSTCOMMENTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_post_detail_layout, LAYOUT_SHIMMERPOSTDETAILLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_related_posts_layout, LAYOUT_SHIMMERRELATEDPOSTSLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_search_post_layout, LAYOUT_SHIMMERSEARCHPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_story_post_layout, LAYOUT_SHIMMERSTORYPOSTLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_template_category_layout, LAYOUT_SHIMMERTEMPLATECATEGORYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.shimmer_template_slider_layout, LAYOUT_SHIMMERTEMPLATESLIDERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.spinner_item_layout, LAYOUT_SPINNERITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.toolbar_main_layout, LAYOUT_TOOLBARMAINLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.view_article_template_layout, LAYOUT_VIEWARTICLETEMPLATELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bestweby.enewz.R.layout.view_story_template_layout, LAYOUT_VIEWSTORYTEMPLATELAYOUT);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYAPPSETTINGSLAYOUT: {
        if ("layout/activity_app_settings_layout_0".equals(tag)) {
          return new ActivityAppSettingsLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_app_settings_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYARTICLETEMPLATELAYOUT: {
        if ("layout/activity_article_template_layout_0".equals(tag)) {
          return new ActivityArticleTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_article_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBLOGTEMPLATELAYOUT: {
        if ("layout/activity_blog_template_layout_0".equals(tag)) {
          return new ActivityBlogTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_blog_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCATEGORYLISTLAYOUT: {
        if ("layout/activity_category_list_layout_0".equals(tag)) {
          return new ActivityCategoryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_category_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCATEGORYPOSTLAYOUT: {
        if ("layout/activity_category_post_layout_0".equals(tag)) {
          return new ActivityCategoryPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_category_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFEEDTEMPLATELAYOUT: {
        if ("layout/activity_feed_template_layout_0".equals(tag)) {
          return new ActivityFeedTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_feed_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYFAVOURITESLAYOUT: {
        if ("layout/activity_my_favourites_layout_0".equals(tag)) {
          return new ActivityMyFavouritesLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_favourites_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNEWSTEMPLATELAYOUT: {
        if ("layout/activity_news_template_layout_0".equals(tag)) {
          return new ActivityNewsTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_news_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNOTIFICATIONDETAILLAYOUT: {
        if ("layout/activity_notification_detail_layout_0".equals(tag)) {
          return new ActivityNotificationDetailLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_notification_detail_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNOTIFICATIONLAYOUT: {
        if ("layout/activity_notification_layout_0".equals(tag)) {
          return new ActivityNotificationLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_notification_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPOSTCOMMENTSLAYOUT: {
        if ("layout/activity_post_comments_layout_0".equals(tag)) {
          return new ActivityPostCommentsLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_post_comments_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPOSTDETAILLAYOUT: {
        if ("layout/activity_post_detail_layout_0".equals(tag)) {
          return new ActivityPostDetailLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_post_detail_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEARCHPOSTLAYOUT: {
        if ("layout/activity_search_post_layout_0".equals(tag)) {
          return new ActivitySearchPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_search_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASHLAYOUT: {
        if ("layout/activity_splash_layout_0".equals(tag)) {
          return new ActivitySplashLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSTORYTEMPLATELAYOUT: {
        if ("layout/activity_story_template_layout_0".equals(tag)) {
          return new ActivityStoryTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_story_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUBCATEGORYLISTLAYOUT: {
        if ("layout/activity_subcategory_list_layout_0".equals(tag)) {
          return new ActivitySubcategoryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_subcategory_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWEBCONTENTLAYOUT: {
        if ("layout/activity_web_content_layout_0".equals(tag)) {
          return new ActivityWebContentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_web_content_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_BLOGPOSTLISTFRAGMENTLAYOUT: {
        if ("layout/blog_post_list_fragment_layout_0".equals(tag)) {
          return new BlogPostListFragmentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for blog_post_list_fragment_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETNOTIFICATIONLIST: {
        if ("layout/bottom_sheet_notification_list_0".equals(tag)) {
          return new BottomSheetNotificationListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_notification_list is invalid. Received: " + tag);
      }
      case  LAYOUT_DETAILSTOOLBARLAYOUT: {
        if ("layout-ldrtl/details_toolbar_layout_0".equals(tag)) {
          return new DetailsToolbarLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/details_toolbar_layout_0".equals(tag)) {
          return new DetailsToolbarLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for details_toolbar_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGPOSTCOMMENTLAYOUT: {
        if ("layout-ldrtl/dialog_post_comment_layout_0".equals(tag)) {
          return new DialogPostCommentLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/dialog_post_comment_layout_0".equals(tag)) {
          return new DialogPostCommentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_post_comment_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_EMPTYLISTPRIMARYLAYOUT: {
        if ("layout/empty_list_primary_layout_0".equals(tag)) {
          return new EmptyListPrimaryLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for empty_list_primary_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_FEEDPOSTLISTFRAGMENTLAYOUT: {
        if ("layout/feed_post_list_fragment_layout_0".equals(tag)) {
          return new FeedPostListFragmentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for feed_post_list_fragment_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_HOMETOOLBARLAYOUT: {
        if ("layout/home_toolbar_layout_0".equals(tag)) {
          return new HomeToolbarLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for home_toolbar_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMARTICLEPOSTLISTLAYOUT: {
        if ("layout-ldrtl/item_article_post_list_layout_0".equals(tag)) {
          return new ItemArticlePostListLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/item_article_post_list_layout_0".equals(tag)) {
          return new ItemArticlePostListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_article_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBLOGPOSTLISTLAYOUT: {
        if ("layout-ldrtl/item_blog_post_list_layout_0".equals(tag)) {
          return new ItemBlogPostListLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/item_blog_post_list_layout_0".equals(tag)) {
          return new ItemBlogPostListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_blog_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCATEGORYGRIDPOSTLISTLAYOUT: {
        if ("layout/item_category_grid_post_list_layout_0".equals(tag)) {
          return new ItemCategoryGridPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_category_grid_post_list_layout_0".equals(tag)) {
          return new ItemCategoryGridPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_category_grid_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCATEGORYLINEARPOSTLISTLAYOUT: {
        if ("layout/item_category_linear_post_list_layout_0".equals(tag)) {
          return new ItemCategoryLinearPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_category_linear_post_list_layout_0".equals(tag)) {
          return new ItemCategoryLinearPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_category_linear_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCATEGORYLISTLAYOUT: {
        if ("layout/item_category_list_layout_0".equals(tag)) {
          return new ItemCategoryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_category_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCOMMENTLISTLAYOUT: {
        if ("layout-ldrtl/item_comment_list_layout_0".equals(tag)) {
          return new ItemCommentListLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/item_comment_list_layout_0".equals(tag)) {
          return new ItemCommentListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_comment_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFAVOURITEPOSTLAYOUT: {
        if ("layout/item_favourite_post_layout_0".equals(tag)) {
          return new ItemFavouritePostLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_favourite_post_layout_0".equals(tag)) {
          return new ItemFavouritePostLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_favourite_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFEEDPOSTLISTLAYOUT: {
        if ("layout/item_feed_post_list_layout_0".equals(tag)) {
          return new ItemFeedPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_feed_post_list_layout_0".equals(tag)) {
          return new ItemFeedPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_feed_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMHOMECATEGORYLISTLAYOUT: {
        if ("layout/item_home_category_list_layout_0".equals(tag)) {
          return new ItemHomeCategoryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_home_category_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGESLIDER: {
        if ("layout/item_image_slider_0".equals(tag)) {
          return new ItemImageSliderBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_image_slider_0".equals(tag)) {
          return new ItemImageSliderBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image_slider is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMNEWSPOSTLISTLAYOUT: {
        if ("layout/item_news_post_list_layout_0".equals(tag)) {
          return new ItemNewsPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_news_post_list_layout_0".equals(tag)) {
          return new ItemNewsPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_news_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMNOTIFICATIONLAYOUT: {
        if ("layout/item_notification_layout_0".equals(tag)) {
          return new ItemNotificationLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_notification_layout_0".equals(tag)) {
          return new ItemNotificationLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_notification_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMRELATEDPOSTLISTLAYOUT: {
        if ("layout-ldrtl/item_related_post_list_layout_0".equals(tag)) {
          return new ItemRelatedPostListLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/item_related_post_list_layout_0".equals(tag)) {
          return new ItemRelatedPostListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_related_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEARCHPOSTLISTLAYOUT: {
        if ("layout/item_search_post_list_layout_0".equals(tag)) {
          return new ItemSearchPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_search_post_list_layout_0".equals(tag)) {
          return new ItemSearchPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_search_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSTORYPOSTLISTLAYOUT: {
        if ("layout/item_story_post_list_layout_0".equals(tag)) {
          return new ItemStoryPostListLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/item_story_post_list_layout_0".equals(tag)) {
          return new ItemStoryPostListLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_story_post_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_NAVHEADERLAYOUT: {
        if ("layout/nav_header_layout_0".equals(tag)) {
          return new NavHeaderLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for nav_header_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_NEWSPOSTLISTFRAGMENTLAYOUT: {
        if ("layout/news_post_list_fragment_layout_0".equals(tag)) {
          return new NewsPostListFragmentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for news_post_list_fragment_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_NOTIFICATIONTOOLBARLAYOUT: {
        if ("layout/notification_toolbar_layout_0".equals(tag)) {
          return new NotificationToolbarLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for notification_toolbar_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_PRIMARYLISTLAYOUT: {
        if ("layout/primary_list_layout_0".equals(tag)) {
          return new PrimaryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for primary_list_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_PRIMARYTOOLBARLAYOUT: {
        if ("layout/primary_toolbar_layout_0".equals(tag)) {
          return new PrimaryToolbarLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for primary_toolbar_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_RECYCLERMAINLAYOUT: {
        if ("layout/recycler_main_layout_0".equals(tag)) {
          return new RecyclerMainLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recycler_main_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SEARCHTOOLBARLAYOUT: {
        if ("layout/search_toolbar_layout_0".equals(tag)) {
          return new SearchToolbarLayoutBindingImpl(component, view);
        }
        if ("layout-ldrtl/search_toolbar_layout_0".equals(tag)) {
          return new SearchToolbarLayoutBindingLdrtlImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for search_toolbar_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERARTICLEPOSTLAYOUT: {
        if ("layout/shimmer_article_post_layout_0".equals(tag)) {
          return new ShimmerArticlePostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_article_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERBLOGPAGERLAYOUT: {
        if ("layout/shimmer_blog_pager_layout_0".equals(tag)) {
          return new ShimmerBlogPagerLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_blog_pager_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERBLOGPOSTLAYOUT: {
        if ("layout/shimmer_blog_post_layout_0".equals(tag)) {
          return new ShimmerBlogPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_blog_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERCATEGORYLISTLAYOUT: {
        if ("layout/shimmer_category_list_layout_0".equals(tag)) {
          return new ShimmerCategoryListLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_category_list_layout is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_SHIMMERFEEDPAGERLAYOUT: {
        if ("layout/shimmer_feed_pager_layout_0".equals(tag)) {
          return new ShimmerFeedPagerLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_feed_pager_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERFEEDPOSTLAYOUT: {
        if ("layout/shimmer_feed_post_layout_0".equals(tag)) {
          return new ShimmerFeedPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_feed_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERGRIDCATEGORYPOSTLAYOUT: {
        if ("layout/shimmer_grid_category_post_layout_0".equals(tag)) {
          return new ShimmerGridCategoryPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_grid_category_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERLINEARCATEGORYPOSTLAYOUT: {
        if ("layout/shimmer_linear_category_post_layout_0".equals(tag)) {
          return new ShimmerLinearCategoryPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_linear_category_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERNEWSPAGERLAYOUT: {
        if ("layout/shimmer_news_pager_layout_0".equals(tag)) {
          return new ShimmerNewsPagerLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_news_pager_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERNEWSPOSTLAYOUT: {
        if ("layout/shimmer_news_post_layout_0".equals(tag)) {
          return new ShimmerNewsPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_news_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERPOSTCOMMENTLAYOUT: {
        if ("layout/shimmer_post_comment_layout_0".equals(tag)) {
          return new ShimmerPostCommentLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_post_comment_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERPOSTDETAILLAYOUT: {
        if ("layout/shimmer_post_detail_layout_0".equals(tag)) {
          return new ShimmerPostDetailLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_post_detail_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERRELATEDPOSTSLAYOUT: {
        if ("layout/shimmer_related_posts_layout_0".equals(tag)) {
          return new ShimmerRelatedPostsLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_related_posts_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERSEARCHPOSTLAYOUT: {
        if ("layout/shimmer_search_post_layout_0".equals(tag)) {
          return new ShimmerSearchPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_search_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERSTORYPOSTLAYOUT: {
        if ("layout/shimmer_story_post_layout_0".equals(tag)) {
          return new ShimmerStoryPostLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_story_post_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERTEMPLATECATEGORYLAYOUT: {
        if ("layout/shimmer_template_category_layout_0".equals(tag)) {
          return new ShimmerTemplateCategoryLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_template_category_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SHIMMERTEMPLATESLIDERLAYOUT: {
        if ("layout/shimmer_template_slider_layout_0".equals(tag)) {
          return new ShimmerTemplateSliderLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for shimmer_template_slider_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SPINNERITEMLAYOUT: {
        if ("layout/spinner_item_layout_0".equals(tag)) {
          return new SpinnerItemLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for spinner_item_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_TOOLBARMAINLAYOUT: {
        if ("layout-ldrtl/toolbar_main_layout_0".equals(tag)) {
          return new ToolbarMainLayoutBindingLdrtlImpl(component, view);
        }
        if ("layout/toolbar_main_layout_0".equals(tag)) {
          return new ToolbarMainLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for toolbar_main_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_VIEWARTICLETEMPLATELAYOUT: {
        if ("layout/view_article_template_layout_0".equals(tag)) {
          return new ViewArticleTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for view_article_template_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_VIEWSTORYTEMPLATELAYOUT: {
        if ("layout/view_story_template_layout_0".equals(tag)) {
          return new ViewStoryTemplateLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for view_story_template_layout is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(84);

    static {
      sKeys.put("layout/activity_app_settings_layout_0", com.bestweby.enewz.R.layout.activity_app_settings_layout);
      sKeys.put("layout/activity_article_template_layout_0", com.bestweby.enewz.R.layout.activity_article_template_layout);
      sKeys.put("layout/activity_blog_template_layout_0", com.bestweby.enewz.R.layout.activity_blog_template_layout);
      sKeys.put("layout/activity_category_list_layout_0", com.bestweby.enewz.R.layout.activity_category_list_layout);
      sKeys.put("layout/activity_category_post_layout_0", com.bestweby.enewz.R.layout.activity_category_post_layout);
      sKeys.put("layout/activity_feed_template_layout_0", com.bestweby.enewz.R.layout.activity_feed_template_layout);
      sKeys.put("layout/activity_my_favourites_layout_0", com.bestweby.enewz.R.layout.activity_my_favourites_layout);
      sKeys.put("layout/activity_news_template_layout_0", com.bestweby.enewz.R.layout.activity_news_template_layout);
      sKeys.put("layout/activity_notification_detail_layout_0", com.bestweby.enewz.R.layout.activity_notification_detail_layout);
      sKeys.put("layout/activity_notification_layout_0", com.bestweby.enewz.R.layout.activity_notification_layout);
      sKeys.put("layout/activity_post_comments_layout_0", com.bestweby.enewz.R.layout.activity_post_comments_layout);
      sKeys.put("layout/activity_post_detail_layout_0", com.bestweby.enewz.R.layout.activity_post_detail_layout);
      sKeys.put("layout/activity_search_post_layout_0", com.bestweby.enewz.R.layout.activity_search_post_layout);
      sKeys.put("layout/activity_splash_layout_0", com.bestweby.enewz.R.layout.activity_splash_layout);
      sKeys.put("layout/activity_story_template_layout_0", com.bestweby.enewz.R.layout.activity_story_template_layout);
      sKeys.put("layout/activity_subcategory_list_layout_0", com.bestweby.enewz.R.layout.activity_subcategory_list_layout);
      sKeys.put("layout/activity_web_content_layout_0", com.bestweby.enewz.R.layout.activity_web_content_layout);
      sKeys.put("layout/blog_post_list_fragment_layout_0", com.bestweby.enewz.R.layout.blog_post_list_fragment_layout);
      sKeys.put("layout/bottom_sheet_notification_list_0", com.bestweby.enewz.R.layout.bottom_sheet_notification_list);
      sKeys.put("layout-ldrtl/details_toolbar_layout_0", com.bestweby.enewz.R.layout.details_toolbar_layout);
      sKeys.put("layout/details_toolbar_layout_0", com.bestweby.enewz.R.layout.details_toolbar_layout);
      sKeys.put("layout-ldrtl/dialog_post_comment_layout_0", com.bestweby.enewz.R.layout.dialog_post_comment_layout);
      sKeys.put("layout/dialog_post_comment_layout_0", com.bestweby.enewz.R.layout.dialog_post_comment_layout);
      sKeys.put("layout/empty_list_primary_layout_0", com.bestweby.enewz.R.layout.empty_list_primary_layout);
      sKeys.put("layout/feed_post_list_fragment_layout_0", com.bestweby.enewz.R.layout.feed_post_list_fragment_layout);
      sKeys.put("layout/home_toolbar_layout_0", com.bestweby.enewz.R.layout.home_toolbar_layout);
      sKeys.put("layout-ldrtl/item_article_post_list_layout_0", com.bestweby.enewz.R.layout.item_article_post_list_layout);
      sKeys.put("layout/item_article_post_list_layout_0", com.bestweby.enewz.R.layout.item_article_post_list_layout);
      sKeys.put("layout-ldrtl/item_blog_post_list_layout_0", com.bestweby.enewz.R.layout.item_blog_post_list_layout);
      sKeys.put("layout/item_blog_post_list_layout_0", com.bestweby.enewz.R.layout.item_blog_post_list_layout);
      sKeys.put("layout/item_category_grid_post_list_layout_0", com.bestweby.enewz.R.layout.item_category_grid_post_list_layout);
      sKeys.put("layout-ldrtl/item_category_grid_post_list_layout_0", com.bestweby.enewz.R.layout.item_category_grid_post_list_layout);
      sKeys.put("layout/item_category_linear_post_list_layout_0", com.bestweby.enewz.R.layout.item_category_linear_post_list_layout);
      sKeys.put("layout-ldrtl/item_category_linear_post_list_layout_0", com.bestweby.enewz.R.layout.item_category_linear_post_list_layout);
      sKeys.put("layout/item_category_list_layout_0", com.bestweby.enewz.R.layout.item_category_list_layout);
      sKeys.put("layout-ldrtl/item_comment_list_layout_0", com.bestweby.enewz.R.layout.item_comment_list_layout);
      sKeys.put("layout/item_comment_list_layout_0", com.bestweby.enewz.R.layout.item_comment_list_layout);
      sKeys.put("layout/item_favourite_post_layout_0", com.bestweby.enewz.R.layout.item_favourite_post_layout);
      sKeys.put("layout-ldrtl/item_favourite_post_layout_0", com.bestweby.enewz.R.layout.item_favourite_post_layout);
      sKeys.put("layout/item_feed_post_list_layout_0", com.bestweby.enewz.R.layout.item_feed_post_list_layout);
      sKeys.put("layout-ldrtl/item_feed_post_list_layout_0", com.bestweby.enewz.R.layout.item_feed_post_list_layout);
      sKeys.put("layout/item_home_category_list_layout_0", com.bestweby.enewz.R.layout.item_home_category_list_layout);
      sKeys.put("layout/item_image_slider_0", com.bestweby.enewz.R.layout.item_image_slider);
      sKeys.put("layout-ldrtl/item_image_slider_0", com.bestweby.enewz.R.layout.item_image_slider);
      sKeys.put("layout/item_news_post_list_layout_0", com.bestweby.enewz.R.layout.item_news_post_list_layout);
      sKeys.put("layout-ldrtl/item_news_post_list_layout_0", com.bestweby.enewz.R.layout.item_news_post_list_layout);
      sKeys.put("layout/item_notification_layout_0", com.bestweby.enewz.R.layout.item_notification_layout);
      sKeys.put("layout-ldrtl/item_notification_layout_0", com.bestweby.enewz.R.layout.item_notification_layout);
      sKeys.put("layout-ldrtl/item_related_post_list_layout_0", com.bestweby.enewz.R.layout.item_related_post_list_layout);
      sKeys.put("layout/item_related_post_list_layout_0", com.bestweby.enewz.R.layout.item_related_post_list_layout);
      sKeys.put("layout/item_search_post_list_layout_0", com.bestweby.enewz.R.layout.item_search_post_list_layout);
      sKeys.put("layout-ldrtl/item_search_post_list_layout_0", com.bestweby.enewz.R.layout.item_search_post_list_layout);
      sKeys.put("layout/item_story_post_list_layout_0", com.bestweby.enewz.R.layout.item_story_post_list_layout);
      sKeys.put("layout-ldrtl/item_story_post_list_layout_0", com.bestweby.enewz.R.layout.item_story_post_list_layout);
      sKeys.put("layout/nav_header_layout_0", com.bestweby.enewz.R.layout.nav_header_layout);
      sKeys.put("layout/news_post_list_fragment_layout_0", com.bestweby.enewz.R.layout.news_post_list_fragment_layout);
      sKeys.put("layout/notification_toolbar_layout_0", com.bestweby.enewz.R.layout.notification_toolbar_layout);
      sKeys.put("layout/primary_list_layout_0", com.bestweby.enewz.R.layout.primary_list_layout);
      sKeys.put("layout/primary_toolbar_layout_0", com.bestweby.enewz.R.layout.primary_toolbar_layout);
      sKeys.put("layout/recycler_main_layout_0", com.bestweby.enewz.R.layout.recycler_main_layout);
      sKeys.put("layout/search_toolbar_layout_0", com.bestweby.enewz.R.layout.search_toolbar_layout);
      sKeys.put("layout-ldrtl/search_toolbar_layout_0", com.bestweby.enewz.R.layout.search_toolbar_layout);
      sKeys.put("layout/shimmer_article_post_layout_0", com.bestweby.enewz.R.layout.shimmer_article_post_layout);
      sKeys.put("layout/shimmer_blog_pager_layout_0", com.bestweby.enewz.R.layout.shimmer_blog_pager_layout);
      sKeys.put("layout/shimmer_blog_post_layout_0", com.bestweby.enewz.R.layout.shimmer_blog_post_layout);
      sKeys.put("layout/shimmer_category_list_layout_0", com.bestweby.enewz.R.layout.shimmer_category_list_layout);
      sKeys.put("layout/shimmer_feed_pager_layout_0", com.bestweby.enewz.R.layout.shimmer_feed_pager_layout);
      sKeys.put("layout/shimmer_feed_post_layout_0", com.bestweby.enewz.R.layout.shimmer_feed_post_layout);
      sKeys.put("layout/shimmer_grid_category_post_layout_0", com.bestweby.enewz.R.layout.shimmer_grid_category_post_layout);
      sKeys.put("layout/shimmer_linear_category_post_layout_0", com.bestweby.enewz.R.layout.shimmer_linear_category_post_layout);
      sKeys.put("layout/shimmer_news_pager_layout_0", com.bestweby.enewz.R.layout.shimmer_news_pager_layout);
      sKeys.put("layout/shimmer_news_post_layout_0", com.bestweby.enewz.R.layout.shimmer_news_post_layout);
      sKeys.put("layout/shimmer_post_comment_layout_0", com.bestweby.enewz.R.layout.shimmer_post_comment_layout);
      sKeys.put("layout/shimmer_post_detail_layout_0", com.bestweby.enewz.R.layout.shimmer_post_detail_layout);
      sKeys.put("layout/shimmer_related_posts_layout_0", com.bestweby.enewz.R.layout.shimmer_related_posts_layout);
      sKeys.put("layout/shimmer_search_post_layout_0", com.bestweby.enewz.R.layout.shimmer_search_post_layout);
      sKeys.put("layout/shimmer_story_post_layout_0", com.bestweby.enewz.R.layout.shimmer_story_post_layout);
      sKeys.put("layout/shimmer_template_category_layout_0", com.bestweby.enewz.R.layout.shimmer_template_category_layout);
      sKeys.put("layout/shimmer_template_slider_layout_0", com.bestweby.enewz.R.layout.shimmer_template_slider_layout);
      sKeys.put("layout/spinner_item_layout_0", com.bestweby.enewz.R.layout.spinner_item_layout);
      sKeys.put("layout-ldrtl/toolbar_main_layout_0", com.bestweby.enewz.R.layout.toolbar_main_layout);
      sKeys.put("layout/toolbar_main_layout_0", com.bestweby.enewz.R.layout.toolbar_main_layout);
      sKeys.put("layout/view_article_template_layout_0", com.bestweby.enewz.R.layout.view_article_template_layout);
      sKeys.put("layout/view_story_template_layout_0", com.bestweby.enewz.R.layout.view_story_template_layout);
    }
  }
}
