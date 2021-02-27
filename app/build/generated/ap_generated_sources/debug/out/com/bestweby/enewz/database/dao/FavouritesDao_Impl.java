package com.bestweby.enewz.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bestweby.enewz.model.dbEntity.FavouritesModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouritesDao_Impl implements FavouritesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouritesModel> __insertionAdapterOfFavouritesModel;

  private final EntityDeletionOrUpdateAdapter<FavouritesModel> __deletionAdapterOfFavouritesModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFavoritePost;

  public FavouritesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouritesModel = new EntityInsertionAdapter<FavouritesModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favourite_posts_tbl` (`auto_id`,`post_id`,`post_name`,`post_date`,`post_category`,`post_image`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouritesModel value) {
        stmt.bindLong(1, value.getAutoId());
        stmt.bindLong(2, value.getPostId());
        if (value.getPostName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPostName());
        }
        if (value.getPostDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPostDate());
        }
        if (value.getPostCategory() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPostCategory());
        }
        if (value.getPostImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPostImage());
        }
      }
    };
    this.__deletionAdapterOfFavouritesModel = new EntityDeletionOrUpdateAdapter<FavouritesModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favourite_posts_tbl` WHERE `auto_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouritesModel value) {
        stmt.bindLong(1, value.getAutoId());
      }
    };
    this.__preparedStmtOfDeleteFavoritePost = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM favourite_posts_tbl WHERE post_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final FavouritesModel favoritesModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavouritesModel.insert(favoritesModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final FavouritesModel favouritesModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavouritesModel.handle(favouritesModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFavoritePost(final int postId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFavoritePost.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, postId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteFavoritePost.release(_stmt);
    }
  }

  @Override
  public List<FavouritesModel> getAll() {
    final String _sql = "SELECT * FROM favourite_posts_tbl ORDER BY auto_id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAutoId = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_id");
      final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "post_id");
      final int _cursorIndexOfPostName = CursorUtil.getColumnIndexOrThrow(_cursor, "post_name");
      final int _cursorIndexOfPostDate = CursorUtil.getColumnIndexOrThrow(_cursor, "post_date");
      final int _cursorIndexOfPostCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "post_category");
      final int _cursorIndexOfPostImage = CursorUtil.getColumnIndexOrThrow(_cursor, "post_image");
      final List<FavouritesModel> _result = new ArrayList<FavouritesModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FavouritesModel _item;
        final int _tmpPostId;
        _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
        final String _tmpPostName;
        _tmpPostName = _cursor.getString(_cursorIndexOfPostName);
        final String _tmpPostDate;
        _tmpPostDate = _cursor.getString(_cursorIndexOfPostDate);
        final String _tmpPostCategory;
        _tmpPostCategory = _cursor.getString(_cursorIndexOfPostCategory);
        final String _tmpPostImage;
        _tmpPostImage = _cursor.getString(_cursorIndexOfPostImage);
        _item = new FavouritesModel(_tmpPostId,_tmpPostName,_tmpPostDate,_tmpPostCategory,_tmpPostImage);
        final int _tmpAutoId;
        _tmpAutoId = _cursor.getInt(_cursorIndexOfAutoId);
        _item.setAutoId(_tmpAutoId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public FavouritesModel getFavoritePost(final int postId) {
    final String _sql = "SELECT * FROM favourite_posts_tbl WHERE post_id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, postId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAutoId = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_id");
      final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "post_id");
      final int _cursorIndexOfPostName = CursorUtil.getColumnIndexOrThrow(_cursor, "post_name");
      final int _cursorIndexOfPostDate = CursorUtil.getColumnIndexOrThrow(_cursor, "post_date");
      final int _cursorIndexOfPostCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "post_category");
      final int _cursorIndexOfPostImage = CursorUtil.getColumnIndexOrThrow(_cursor, "post_image");
      final FavouritesModel _result;
      if(_cursor.moveToFirst()) {
        final int _tmpPostId;
        _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
        final String _tmpPostName;
        _tmpPostName = _cursor.getString(_cursorIndexOfPostName);
        final String _tmpPostDate;
        _tmpPostDate = _cursor.getString(_cursorIndexOfPostDate);
        final String _tmpPostCategory;
        _tmpPostCategory = _cursor.getString(_cursorIndexOfPostCategory);
        final String _tmpPostImage;
        _tmpPostImage = _cursor.getString(_cursorIndexOfPostImage);
        _result = new FavouritesModel(_tmpPostId,_tmpPostName,_tmpPostDate,_tmpPostCategory,_tmpPostImage);
        final int _tmpAutoId;
        _tmpAutoId = _cursor.getInt(_cursorIndexOfAutoId);
        _result.setAutoId(_tmpAutoId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
