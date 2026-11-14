package com.ss.android.downloadlib.u;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private static volatile w hf;
    private SQLiteDatabase xj;

    private w() {
        try {
            this.xj = new hf(pl.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.kd.w.xj().xj(th, "ClickEventHelper");
        }
    }

    public static w xj() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public boolean hf() {
        return com.ss.android.socialbase.downloader.f.xj.w().xj("click_event_switch", 0) == 1;
    }

    public boolean w() {
        return com.ss.android.socialbase.downloader.f.xj.w().xj("click_event_switch", 0) == 2;
    }

    private void w(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.xj.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public boolean hf(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.xj.query("click_event", hf.xj, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                cursor.close();
                return z;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } finally {
        }
    }

    public void xj(long j, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.xj;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
        contentValues.put("req_id", optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.xj.insert("click_event", null, contentValues);
        w(j, str);
    }
}
