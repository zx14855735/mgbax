package com.bytedance.sdk.openadsdk.core.multipro.w;

import ADYaiT.CtFAbx;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.multipro.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements u.xj {
    private Context xj;

    private Context getContext() {
        Context context = this.xj;
        return context == null ? pz.getContext() : context;
    }

    public static boolean hf(String str) {
        return xj(str, "checkAggFrequency");
    }

    private static ContentResolver kd() {
        try {
            if (pz.getContext() != null) {
                return pz.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u() {
        return u("maxAggRit");
    }

    public static boolean w(String str) {
        if (pz.getContext() == null) {
            return false;
        }
        try {
            ContentResolver kd = kd();
            if (kd != null) {
                return "true".equals(kd.getType(Uri.parse(y() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean xj(String str) {
        return xj(str, "checkFrequency");
    }

    private static String y() {
        return CtFAbx.B25kr6(new StringBuilder(), kd.hf, "/t_frequent/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.kd.xj().xj(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.kd.xj().u() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.kd.xj().kd();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.xj.xj().xj(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isAggSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.xj.xj().u() ? "true" : "false";
        }
        if ("maxAggRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.zg.xj.xj().kd();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
        this.xj = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static boolean hf() {
        return w("isAggSilent");
    }

    public static String u(String str) {
        if (pz.getContext() == null) {
            return null;
        }
        try {
            ContentResolver kd = kd();
            if (kd != null) {
                return kd.getType(Uri.parse(y() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean xj(String str, String str2) {
        if (pz.getContext() == null) {
            return false;
        }
        try {
            ContentResolver kd = kd();
            if (kd != null) {
                return "true".equals(kd.getType(Uri.parse(y() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String w() {
        return u("maxRit");
    }

    public static boolean xj() {
        return w("isSilent");
    }
}
