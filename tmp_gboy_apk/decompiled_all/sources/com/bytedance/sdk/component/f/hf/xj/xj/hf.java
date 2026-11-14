package com.bytedance.sdk.component.f.hf.xj.xj;

import J3FDQU.A2egSU;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.kd;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static int delete(Context context, String str, String str2, String[] strArr, kd kdVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return xj.xj(context).xj().delete(kdVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void insert(Context context, String str, ContentValues contentValues, kd kdVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            xj.xj(context).xj().insert(kdVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, kd kdVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj.xj(context).xj().query(kdVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, kd kdVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return xj.xj(context).xj().update(kdVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String xj(Context context, String str, kd kdVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            xj.xj(context).xj().xj(kdVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return A2egSU.B4ZgIw(th, new StringBuilder("exec sql exception:"));
        }
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.f.xj.hf> list, kd kdVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            xj.xj(context).xj().insert(kdVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }
}
