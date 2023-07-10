package com.example.server.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.server.constant.UserInfoContent;
import com.example.server.database.UserDBHelper;

//内容提供者，供client操作数据
public class UserInfoProvider extends ContentProvider {

    private UserDBHelper dbHelper;
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int USERS = 1;
    private static final int USER = 2;

    static {
        //往Uri匹配器中添加指定的数据路径
        URI_MATCHER.addURI(UserInfoContent.AUTHORITIES, "/user", USERS);
        URI_MATCHER.addURI(UserInfoContent.AUTHORITIES, "/user/#", USER);
    }

    public UserInfoProvider() {
    }

    /*在应用启动时就运行*/
    @Override
    public boolean onCreate() {
        Log.d("boge", "UserInfoProvider onCreate");
        dbHelper = UserDBHelper.getInstance(getContext());
        return true;
    }

    // content://com.dongnaoedu.chapter07_server.provider.UserInfoProvider/user
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d("boge", "UserInfoProvider insert");
        if (URI_MATCHER.match(uri) == USERS) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long rowId = db.insert(UserDBHelper.TABLE_NAME, null, values);
            /*if (rowId > 0) { // 判断插入是否执行成功
                // 如果添加成功，就利用新记录的行号生成新的地址
                Uri newUri = ContentUris.withAppendedId(UserInfoContent.CONTENT_URI, rowId);
                // 通知client监听器，数据已经改变
                getContext().getContentResolver().notifyChange(newUri, null);
            }*/
        }
        return uri;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d("boge", "UserInfoProvider query");
        if (URI_MATCHER.match(uri) == USERS){
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            return db.query(UserDBHelper.TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (URI_MATCHER.match(uri)){
            //content://com.dongnaoedu.chapter07_server.provider.UserInfoProvider/user
            // 删除多行
            case USERS:
                SQLiteDatabase db1 = dbHelper.getWritableDatabase();
                count = db1.delete(UserDBHelper.TABLE_NAME, selection, selectionArgs);
                db1.close();
                break;
            //content://com.dongnaoedu.chapter07_server.provider.UserInfoProvider/user/2
            //删除单行
            case USER:
                String id = uri.getLastPathSegment();
                SQLiteDatabase db2 = dbHelper.getWritableDatabase();
                count = db2.delete(UserDBHelper.TABLE_NAME,"_id=?",new String[]{id});
                db2.close();
                break;
        }

        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}