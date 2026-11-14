package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class be {
    private static String bfn;
    private static File bfo;

    private static boolean Tm() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String dP(Context context) {
        if (!TextUtils.isEmpty(bfn)) {
            return bfn;
        }
        String str = null;
        if (Tm()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String B25kr62 = CtFAbx.B25kr6(AYUAbz.A4TApA(str), File.separator, "ksadsdk");
        bfn = B25kr62;
        return B25kr62;
    }

    public static File dQ(Context context) {
        File file = bfo;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Tm()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(str), File.separator, "ksadsdk"));
        bfo = file2;
        if (!file2.exists()) {
            bfo.mkdirs();
        }
        return bfo;
    }

    public static File dR(Context context) {
        File file = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(dP(context)), File.separator, "Download"));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dS(Context context) {
        File file = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(dP(context)), File.separator, "downloadFileSync/.temp"));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dT(Context context) {
        String B25kr62;
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            B25kr62 = dP(context);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            B25kr62 = CtFAbx.B25kr6(sb, File.separator, "ksadsdk");
        }
        return new File(CtFAbx.B25kr6(AYUAbz.A4TApA(B25kr62), File.separator, "ksadlog"));
    }

    public static String dU(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : CtFAbx.B25kr6(AYUAbz.A4TApA(filesDir.getPath()), File.separator, "ksadsdk");
    }

    public static String dV(Context context) {
        return dQ(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(dU(context));
        String str2 = File.separator;
        return A2egSU.AzWtSf(A4TApA2, str2, "ksad/download/js", str2, str);
    }

    public static String getTkJsRootDir(Context context) {
        return context == null ? "" : CtFAbx.B25kr6(AYUAbz.A4TApA(dU(context)), File.separator, "ksad/download/js");
    }
}
