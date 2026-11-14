package com.bytedance.msdk.kd.xj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends SQLiteOpenHelper {
    public f(Context context, String str, int i) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.xj(context), str, (SQLiteDatabase.CursorFactory) null, i);
        com.bytedance.msdk.xj.kd.w.xj("DBHelper", "DatabaseHelper ........");
    }

    private static String hf() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String u() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private static String w() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private void xj(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.msdk.xj.kd.w.xj("DBHelper", "initDB........");
        try {
            sQLiteDatabase.execSQL(xj());
        } catch (Throwable th) {
            pl.xj(th);
        }
        try {
            sQLiteDatabase.execSQL(hf());
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            xj(sQLiteDatabase);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.bytedance.msdk.xj.kd.w.xj("DBHelper", "onUpgrade....数据库版本升级.....");
            if (i == 1 || i == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } else if (i != 3) {
                return;
            }
            sQLiteDatabase.execSQL(hf());
            xj(sQLiteDatabase, i, i2);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void xj(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(w());
        } catch (Throwable th) {
            pl.xj(th);
        }
        try {
            sQLiteDatabase.execSQL(u());
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    private static String xj() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }
}
