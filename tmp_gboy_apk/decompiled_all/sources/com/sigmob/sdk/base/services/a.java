package com.sigmob.sdk.base.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.FileUtil;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.utils.k;
import java.io.File;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class a extends BroadcastReceiver {
    public String a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageManager != null && packageInfo != null) {
            try {
                return String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x000a, B:7:0x001c, B:14:0x0054, B:16:0x005e, B:19:0x0069, B:21:0x006d, B:22:0x0075, B:24:0x007b, B:26:0x009f, B:28:0x00a3, B:31:0x00b2, B:35:0x00bc, B:37:0x00c6, B:42:0x00d3, B:43:0x00d8, B:51:0x010f, B:53:0x0117, B:54:0x012f, B:57:0x0165, B:59:0x016d, B:60:0x0183, B:63:0x0189, B:64:0x01a0, B:66:0x01a8, B:69:0x01c1, B:71:0x01c9, B:72:0x00dc, B:75:0x00e6, B:78:0x00f0, B:81:0x00f8, B:91:0x01e2), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x000a, B:7:0x001c, B:14:0x0054, B:16:0x005e, B:19:0x0069, B:21:0x006d, B:22:0x0075, B:24:0x007b, B:26:0x009f, B:28:0x00a3, B:31:0x00b2, B:35:0x00bc, B:37:0x00c6, B:42:0x00d3, B:43:0x00d8, B:51:0x010f, B:53:0x0117, B:54:0x012f, B:57:0x0165, B:59:0x016d, B:60:0x0183, B:63:0x0189, B:64:0x01a0, B:66:0x01a8, B:69:0x01c1, B:71:0x01c9, B:72:0x00dc, B:75:0x00e6, B:78:0x00f0, B:81:0x00f8, B:91:0x01e2), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b7  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r17, android.content.Intent r18) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.a.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void a(Context context, PackageInfo packageInfo, String str) {
        ae.a((BaseAdUnit) null, PointCategory.APP_INSTALL_MONITOR, packageInfo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, BaseAdUnit baseAdUnit) {
        FileUtil.deleteFile(new File(k.a(context.getApplicationContext()), baseAdUnit.getApkName()).getAbsolutePath());
    }

    private void a(Context context, BaseAdUnit baseAdUnit, PackageInfo packageInfo) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.F);
        ae.a(baseAdUnit, PointCategory.APP_INSTALL_END, packageInfo, "1");
        HashMap hashMap = new HashMap();
        hashMap.put("result", "1");
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        baseAdUnit.setApkPackageName(packageInfo.packageName);
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new A2egSU(context, baseAdUnit));
        TextUtils.isEmpty(baseAdUnit.getDeeplinkUrl());
    }
}
