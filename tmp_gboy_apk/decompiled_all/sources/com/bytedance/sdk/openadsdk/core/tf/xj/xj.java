package com.bytedance.sdk.openadsdk.core.tf.xj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w {
    public xj(Context context) {
        super(context, "ttopensdk2.db", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            xj(sQLiteDatabase, this.xj);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w, android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.tf.xj.w
    public void xj(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_launch (id INTEGER PRIMARY KEY AUTOINCREMENT,dev1 INTEGER,dev2 INTEGER,dev3 INTEGER,dev4 INTEGER,dev5 INTEGER,dev6 INTEGER,dev7 INTEGER,dev8 INTEGER)");
    }
}
