package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static final Map<String, List<String>> bdn;

    static {
        HashMap hashMap = new HashMap();
        bdn = hashMap;
        hashMap.put("huawei", Arrays.asList("com.huawei.appmarket"));
        hashMap.put("oppo", Arrays.asList("com.oppo.market", "com.heytap.market"));
        hashMap.put("vivo", Arrays.asList("com.bbk.appstore"));
        hashMap.put(MediationConstant.ADN_XIAOMI, Arrays.asList("com.xiaomi.market"));
        hashMap.put("oneplus", Arrays.asList("com.oppo.market"));
        hashMap.put("meizu", Arrays.asList("com.meizu.mstore"));
        hashMap.put("samsung", Arrays.asList("com.sec.android.app.samsungapps"));
        hashMap.put("smartisan", Arrays.asList("com.smartisanos.appstore"));
        hashMap.put("realme", Arrays.asList("com.oppo.market"));
        hashMap.put("honor", Arrays.asList("com.hihonor.appmarket", "com.huawei.appmarket"));
        CFnIPJ();
    }

    private static /* synthetic */ void CFnIPJ() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (bb.Tb() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new b.C0360b() { // from class: com.kwad.sdk.utils.e.1
                @Override // com.kwad.sdk.core.download.a.b.C0360b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    super.onError(th);
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bw.r(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.C0360b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0360b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    AdTemplate adTemplate2 = AdTemplate.this;
                    adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate2.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(AdTemplate adTemplate, Context context, String str, String str2) {
        String str3;
        Throwable th;
        String str4;
        int i;
        String str5;
        Map<String, List<String>> map = bdn;
        String str6 = Build.BRAND;
        List<String> list = map.get(str6.toLowerCase());
        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            str3 = "";
        } else {
            str3 = list.get(0);
        }
        String str7 = str3;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) && adTemplate != null) {
            com.kwad.sdk.commercial.b.a.a(adTemplate, str7, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(str6)) {
                str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
            }
            if (adTemplate != null) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, str, str7, 1, 0);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            for (String str8 : list) {
                PackageInfo packageInfo = y.getPackageInfo(context, str8, 1);
                if (packageInfo != null && (str5 = packageInfo.packageName) != null && str5.equals(str8)) {
                    intent.setPackage(str5);
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    context.startActivity(intent);
                    if (adTemplate != null) {
                        adTemplate.mClickOpenAppStore = true;
                        com.kwad.sdk.commercial.b.a.b(adTemplate, str, str8, 1, 0);
                    }
                    return true;
                }
            }
            try {
                context.startActivity(intent);
                if (adTemplate != null) {
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, str, str7, 0, 0);
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                str4 = str;
                i = 0;
                if (adTemplate != null) {
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str4, str7, i, 0, bw.r(th));
                }
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            str4 = str;
            i = 1;
        }
    }

    public static boolean l(Context context, AdTemplate adTemplate) {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        return c(adTemplate, context, com.kwad.sdk.core.response.b.a.cX(er), com.kwad.sdk.core.response.b.a.az(er));
    }
}
