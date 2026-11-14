package com.bytedance.sdk.openadsdk.core.multipro.xj;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.core.multipro.kd;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver xj = xj(context);
            if (xj != null) {
                return xj.delete(Uri.parse(xj(str) + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver xj = xj(context);
            if (xj != null) {
                xj.insert(Uri.parse(xj(str) + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver xj = xj(context);
            if (xj != null) {
                return xj.query(Uri.parse(xj(str) + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver xj = xj(context);
                if (xj != null) {
                    return xj.update(Uri.parse(xj(str) + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static ContentResolver xj(Context context) {
        if (context == null) {
            try {
                context = pz.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String xj(String str) {
        String str2;
        if (com.bytedance.sdk.openadsdk.core.tf.hf.xj(str)) {
            str2 = "ttopensdk2.db";
        } else {
            str2 = "ttopensdk.db";
        }
        return A2egSU.AzWtSf(new StringBuilder(), kd.hf, "/t_db/", str2, "/");
    }

    public static void xj(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver xj = xj(context);
            if (xj != null) {
                xj.getType(Uri.parse(xj(str2) + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
