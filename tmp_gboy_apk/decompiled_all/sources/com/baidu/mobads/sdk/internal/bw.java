package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bw {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9772a = "PackageUtils";

    public static boolean a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                if (str.equals(applicationInfo.packageName)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            return packageManager.queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
