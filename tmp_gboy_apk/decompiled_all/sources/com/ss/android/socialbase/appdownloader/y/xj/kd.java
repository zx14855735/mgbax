package com.ss.android.socialbase.appdownloader.y.xj;

import J3FDQU.A2egSU;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private static PackageInfo hf(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            xj("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            xj("unzip_getpackagearchiveinfo", A2egSU.B4ZgIw(th, new StringBuilder("pm.getPackageArchiveInfo failed: ")));
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:107:0x0142
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    public static android.content.pm.PackageInfo xj(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.y.xj.kd.xj(java.io.File):android.content.pm.PackageInfo");
    }

    public static PackageInfo xj(Context context, File file, int i) {
        if (com.ss.android.socialbase.downloader.tf.xj.xj(C.ENCODING_PCM_MU_LAW) && Build.VERSION.SDK_INT < 26) {
            try {
                return xj(file);
            } catch (Throwable th) {
                xj("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return hf(context, file, i);
    }

    private static void xj(String str, String str2) {
        if (com.ss.android.socialbase.downloader.downloader.w.c() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
        }
    }

    private static String xj(int i) {
        if ((i >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String xj(xj xjVar, int i) {
        int hf = xjVar.hf(i);
        int w = xjVar.w(i);
        if (hf == 3) {
            return xjVar.u(i);
        }
        return hf == 2 ? String.format("?%s%08X", xj(w), Integer.valueOf(w)) : (hf < 16 || hf > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(w), Integer.valueOf(hf)) : String.valueOf(w);
    }

    public static String xj(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            xj("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
