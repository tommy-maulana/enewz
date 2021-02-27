package com.bestweby.enewz.database.helpers;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.bestweby.enewz.database.dao.FavouritesDao;
import com.bestweby.enewz.database.dao.FavouritesDao_Impl;
import com.bestweby.enewz.database.dao.NotificationDao;
import com.bestweby.enewz.database.dao.NotificationDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DaoHelper_Impl extends DaoHelper {
  private volatile FavouritesDao _favouritesDao;

  private volatile NotificationDao _notificationDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourite_posts_tbl` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `post_id` INTEGER NOT NULL, `post_name` TEXT, `post_date` TEXT, `post_category` TEXT, `post_image` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `notification_tbl` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `notification_title` TEXT, `notification_message` TEXT, `notification_image` TEXT, `notification_url` TEXT, `notification_post` INTEGER NOT NULL, `notification_type` TEXT, `notification_seen` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '503d205a540689e01b36847d2ef49f21')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `favourite_posts_tbl`");
        _db.execSQL("DROP TABLE IF EXISTS `notification_tbl`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFavouritePostsTbl = new HashMap<String, TableInfo.Column>(6);
        _columnsFavouritePostsTbl.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouritePostsTbl.put("post_id", new TableInfo.Column("post_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouritePostsTbl.put("post_name", new TableInfo.Column("post_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouritePostsTbl.put("post_date", new TableInfo.Column("post_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouritePostsTbl.put("post_category", new TableInfo.Column("post_category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouritePostsTbl.put("post_image", new TableInfo.Column("post_image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavouritePostsTbl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavouritePostsTbl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavouritePostsTbl = new TableInfo("favourite_posts_tbl", _columnsFavouritePostsTbl, _foreignKeysFavouritePostsTbl, _indicesFavouritePostsTbl);
        final TableInfo _existingFavouritePostsTbl = TableInfo.read(_db, "favourite_posts_tbl");
        if (! _infoFavouritePostsTbl.equals(_existingFavouritePostsTbl)) {
          return new RoomOpenHelper.ValidationResult(false, "favourite_posts_tbl(com.bestweby.enewz.model.dbEntity.FavouritesModel).\n"
                  + " Expected:\n" + _infoFavouritePostsTbl + "\n"
                  + " Found:\n" + _existingFavouritePostsTbl);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationTbl = new HashMap<String, TableInfo.Column>(8);
        _columnsNotificationTbl.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_title", new TableInfo.Column("notification_title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_message", new TableInfo.Column("notification_message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_image", new TableInfo.Column("notification_image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_url", new TableInfo.Column("notification_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_post", new TableInfo.Column("notification_post", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_type", new TableInfo.Column("notification_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTbl.put("notification_seen", new TableInfo.Column("notification_seen", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationTbl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationTbl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationTbl = new TableInfo("notification_tbl", _columnsNotificationTbl, _foreignKeysNotificationTbl, _indicesNotificationTbl);
        final TableInfo _existingNotificationTbl = TableInfo.read(_db, "notification_tbl");
        if (! _infoNotificationTbl.equals(_existingNotificationTbl)) {
          return new RoomOpenHelper.ValidationResult(false, "notification_tbl(com.bestweby.enewz.model.dbEntity.NotificationModel).\n"
                  + " Expected:\n" + _infoNotificationTbl + "\n"
                  + " Found:\n" + _existingNotificationTbl);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "503d205a540689e01b36847d2ef49f21", "636e944ad4e909809f2a2f133b75829a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "favourite_posts_tbl","notification_tbl");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `favourite_posts_tbl`");
      _db.execSQL("DELETE FROM `notification_tbl`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public FavouritesDao getFavouritesDao() {
    if (_favouritesDao != null) {
      return _favouritesDao;
    } else {
      synchronized(this) {
        if(_favouritesDao == null) {
          _favouritesDao = new FavouritesDao_Impl(this);
        }
        return _favouritesDao;
      }
    }
  }

  @Override
  public NotificationDao getNotificationDao() {
    if (_notificationDao != null) {
      return _notificationDao;
    } else {
      synchronized(this) {
        if(_notificationDao == null) {
          _notificationDao = new NotificationDao_Impl(this);
        }
        return _notificationDao;
      }
    }
  }
}
