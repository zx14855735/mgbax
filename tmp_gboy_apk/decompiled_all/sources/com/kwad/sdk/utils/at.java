package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class at {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i, Intent intent) {
        return Build.VERSION.SDK_INT >= 23 ? PendingIntent.getBroadcast(context, i, intent, 201326592) : PendingIntent.getBroadcast(context, i, intent, 134217728);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i, Intent intent) {
        return Build.VERSION.SDK_INT >= 23 ? PendingIntent.getActivity(context, i, intent, 201326592) : PendingIntent.getActivity(context, i, intent, 134217728);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    public static PendingIntent d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(C.ENCODING_PCM_MU_LAW);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c = c(context, file);
        intent.setDataAndType(c, AdBaseConstants.MIME_APK);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, c, 3);
        }
        if (z) {
            com.kwad.sdk.c.Ce();
            if (com.kwad.sdk.c.Ch()) {
                intent = j(intent);
            }
        }
        return b(context, i, intent);
    }
}
