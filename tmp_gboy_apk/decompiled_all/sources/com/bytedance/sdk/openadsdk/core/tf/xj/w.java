package com.bytedance.sdk.openadsdk.core.tf.xj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w extends SQLiteOpenHelper {
    private final String hf;
    protected final Context xj;

    public w(Context context, String str, int i) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.xj(context), str, (SQLiteDatabase.CursorFactory) null, i);
        this.hf = "CSJSQLiteOpenHelper";
        this.xj = context;
    }

    private ArrayList<String> hf(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!TextUtils.equals(string, "android_metadata") && !TextUtils.equals(string, "sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            xj(sQLiteDatabase, this.xj);
        } catch (Throwable th) {
            pl.u("CSJSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            xj(sQLiteDatabase);
            xj(sQLiteDatabase, this.xj);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                xj(sQLiteDatabase);
            } catch (Throwable th) {
                pl.u("CSJSQLiteOpenHelper", th.getMessage());
                return;
            }
        }
        xj(sQLiteDatabase, this.xj);
        xj(sQLiteDatabase, i, i2);
    }

    public void xj(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void xj(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    public void xj(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> hf = hf(sQLiteDatabase);
        if (hf == null || hf.size() <= 0) {
            return;
        }
        Iterator<String> it = hf.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next() + " ;");
        }
    }
}
