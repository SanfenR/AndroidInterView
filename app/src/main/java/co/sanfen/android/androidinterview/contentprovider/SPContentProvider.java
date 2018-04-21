package co.sanfen.android.androidinterview.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 2018/4/21.
 */

public class SPContentProvider extends ContentProvider {

    private final String TAG = this.getClass().getSimpleName();
    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    public static final String AUTHORITY = "co.sanfen.android.androidinterview.contentprovider.SPContentProvider";  //授权
    public static final Uri PERSON_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/person");


    @Override
    public boolean onCreate() {
        SharedPreferences.Editor data = getContext().getSharedPreferences("data", MODE_PRIVATE).edit();
        data.putString("name", "sanfen");
        data.apply();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
