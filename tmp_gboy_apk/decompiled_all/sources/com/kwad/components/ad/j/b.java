package com.kwad.components.ad.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {

    @KsJson
    public static class a extends com.kwad.sdk.commercial.c.a {
        public String Mh = br.TK();
        public String Mi = br.TM();
        public String Mj = br.getOsVersion();
        public String Mk = br.TS();
        public String Ml = bd.getDeviceId();
        public String Mm;
        public String Mn;
        public int status;
    }

    public static void ak(Context context) {
        context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("content://com.kwad.kwadsdk.adFileProvider/ksad_external_files_path/Download/test.apk"), AdBaseConstants.MIME_APK);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller installers size: " + queryIntentActivities.size());
        if (queryIntentActivities.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller info: " + resolveInfo);
                jSONArray.put(resolveInfo.activityInfo.packageName);
            }
            String jSONArray2 = jSONArray.toString();
            a aVar = new a();
            aVar.status = 2;
            aVar.Mn = jSONArray2;
            com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller: " + aVar.toJson());
            com.kwad.sdk.commercial.c.x(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public static void al(Context context) {
        String b = b(context, "SP_OPEN_FILE_RECORD", "");
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord start installCheckRecord: " + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        a aVar = new a();
        aVar.status = 1;
        aVar.Mm = b;
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord report msg:" + aVar.toJson());
        com.kwad.sdk.commercial.c.x(aVar);
        g(context, "SP_OPEN_FILE_RECORD");
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void g(Context context, String str) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
