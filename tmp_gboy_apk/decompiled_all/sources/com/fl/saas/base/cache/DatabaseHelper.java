package com.fl.saas.base.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_KEY = "_key";
    public static final String COLUMN_PRICE = "_price";
    public static final String COLUMN_TIME = "_time";
    public static final String COLUMN_VALUE = "_value";
    private static final String DATABASE_NAME = "YdDatabase.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_AD_CACHE = "ad_cache";
    private static final String TABLE_CREATE = "CREATE TABLE ad_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT, _key TEXT NOT NULL, _time INTEGER, _price REAL, _value TEXT NOT NULL);";
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            try {
                if (instance == null && context != null) {
                    instance = new DatabaseHelper(context.getApplicationContext());
                }
                databaseHelper = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return databaseHelper;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ad_cache");
        onCreate(sQLiteDatabase);
    }
}
