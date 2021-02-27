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
import com.bestweby.enewz.model.dbEntity.NotificationModel;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotificationDao_Impl implements NotificationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NotificationModel> __insertionAdapterOfNotificationModel;

  private final EntityDeletionOrUpdateAdapter<NotificationModel> __deletionAdapterOfNotificationModel;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSeenNotification;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNotification;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllNotification;

  public NotificationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotificationModel = new EntityInsertionAdapter<NotificationModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `notification_tbl` (`auto_id`,`notification_title`,`notification_message`,`notification_image`,`notification_url`,`notification_post`,`notification_type`,`notification_seen`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationModel value) {
        stmt.bindLong(1, value.getAutoId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage());
        }
        if (value.getWebUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWebUrl());
        }
        stmt.bindLong(6, value.getPostId());
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getType());
        }
        final Integer _tmp;
        _tmp = value.getRead() == null ? null : (value.getRead() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp);
        }
      }
    };
    this.__deletionAdapterOfNotificationModel = new EntityDeletionOrUpdateAdapter<NotificationModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `notification_tbl` WHERE `auto_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationModel value) {
        stmt.bindLong(1, value.getAutoId());
      }
    };
    this.__preparedStmtOfUpdateSeenNotification = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE notification_tbl SET notification_seen= 1 WHERE auto_id=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteNotification = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM notification_tbl WHERE auto_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllNotification = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM notification_tbl";
        return _query;
      }
    };
  }

  @Override
  public void insert(final NotificationModel notificationModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotificationModel.insert(notificationModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final NotificationModel notificationModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNotificationModel.handle(notificationModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSeenNotification(final int rowId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSeenNotification.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, rowId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSeenNotification.release(_stmt);
    }
  }

  @Override
  public void deleteNotification(final int rowId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNotification.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, rowId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteNotification.release(_stmt);
    }
  }

  @Override
  public void deleteAllNotification() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllNotification.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllNotification.release(_stmt);
    }
  }

  @Override
  public List<NotificationModel> getAll() {
    final String _sql = "SELECT * FROM notification_tbl ORDER BY auto_id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAutoId = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_title");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_message");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_image");
      final int _cursorIndexOfWebUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_url");
      final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_post");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_type");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_seen");
      final List<NotificationModel> _result = new ArrayList<NotificationModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NotificationModel _item;
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpMessage;
        _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final String _tmpWebUrl;
        _tmpWebUrl = _cursor.getString(_cursorIndexOfWebUrl);
        final int _tmpPostId;
        _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final Boolean _tmpIsRead;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsRead)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        }
        _tmpIsRead = _tmp == null ? null : _tmp != 0;
        _item = new NotificationModel(_tmpTitle,_tmpMessage,_tmpImage,_tmpWebUrl,_tmpPostId,_tmpType,_tmpIsRead);
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
  public List<NotificationModel> getUnseenList() {
    final String _sql = "SELECT * FROM notification_tbl WHERE notification_seen = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAutoId = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_title");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_message");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_image");
      final int _cursorIndexOfWebUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_url");
      final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_post");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_type");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_seen");
      final List<NotificationModel> _result = new ArrayList<NotificationModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NotificationModel _item;
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpMessage;
        _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final String _tmpWebUrl;
        _tmpWebUrl = _cursor.getString(_cursorIndexOfWebUrl);
        final int _tmpPostId;
        _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final Boolean _tmpIsRead;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsRead)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        }
        _tmpIsRead = _tmp == null ? null : _tmp != 0;
        _item = new NotificationModel(_tmpTitle,_tmpMessage,_tmpImage,_tmpWebUrl,_tmpPostId,_tmpType,_tmpIsRead);
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
}
