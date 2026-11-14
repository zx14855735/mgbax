package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f {
    private static boolean Qm;

    public static boolean F(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.j(adTemplate, 1);
            return 0;
        }
        Cursor cursor = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, Constants.FAIL, ""}, null);
            if (query != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(query);
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bw.r(th));
                        com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th2) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        throw th2;
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
            return 1;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aF(boolean z) {
        Qm = z;
    }

    private static int b(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            return 0;
        }
        Cursor cursor = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, Constants.FAIL, ""}, null);
            if (cursor != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return 1;
        } catch (Throwable th) {
            try {
                com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bw.r(th));
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return -1;
            } catch (Throwable th2) {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th2;
            }
        }
    }

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (com.kwad.sdk.core.response.b.a.T(er)) {
            return 0;
        }
        return a(context, er.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    public static int f(Context context, AdTemplate adTemplate) {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (com.kwad.sdk.core.response.b.a.T(er)) {
            return 0;
        }
        return b(context, er.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    private static boolean qm() {
        return Qm;
    }

    private static void a(final JumpFrom jumpFrom, final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (qm()) {
            return;
        }
        aF(true);
        int abs = Math.abs(com.kwad.sdk.core.config.e.Hd());
        if (abs > 0) {
            bw.a(new Runnable() { // from class: com.kwad.components.core.e.d.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.aF(false);
                    com.kwad.sdk.core.c.b.Ji();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.smallApp.a.a(AdTemplate.this, jumpFrom, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            aF(false);
        }
    }
}
