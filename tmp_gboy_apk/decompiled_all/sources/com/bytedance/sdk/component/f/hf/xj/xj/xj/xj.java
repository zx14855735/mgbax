package com.bytedance.sdk.component.f.hf.xj.xj.xj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.c;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.u;
import com.bytedance.sdk.component.f.xj.y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends SQLiteOpenHelper {
    private y hf;
    final Context xj;

    public xj(Context context, y yVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.xj(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.xj = context;
        this.hf = yVar;
    }

    private void hf(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> w = w(sQLiteDatabase);
        if (w == null || w.size() <= 0) {
            return;
        }
        Iterator<String> it = w.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next() + " ;");
        }
    }

    private ArrayList<String> w(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private void xj(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.xj.xj.hf.y.u(this.hf.hf()));
        sQLiteDatabase.execSQL(u.hf(this.hf.xj()));
        sQLiteDatabase.execSQL(c.u(this.hf.u()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.xj.xj.hf.xj.hf(this.hf.kd()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.f.hf.y.y.hf());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            xj(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i <= i2) {
                xj(sQLiteDatabase);
            } else {
                hf(sQLiteDatabase);
                xj(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
