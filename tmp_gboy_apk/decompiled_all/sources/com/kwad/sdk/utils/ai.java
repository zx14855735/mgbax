package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ai {
    public static String a(Context context, String str, aj.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ar = aj.ar(context, aj.a(str, aVar));
        String dC = bd.dC(context);
        if (!TextUtils.isEmpty(dC)) {
            ar = ar.replace("__MAC__", dC).replace("__MAC2__", al.md5(dC)).replace("__MAC3__", al.md5(dC.replace(":", "")));
        }
        String dA = bd.dA(context);
        if (!TextUtils.isEmpty(dA)) {
            ar = ar.replace("__IMEI__", dA).replace("__IMEI2__", al.md5(dA)).replace("__IMEI3__", al.sha1(dA));
        }
        String oaid = bd.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            ar = ar.replace("__OAID__", oaid).replace("__OAID2__", al.md5(oaid));
        }
        String dB = bd.dB(context);
        if (!TextUtils.isEmpty(dB)) {
            ar = ar.replace("__ANDROIDID2__", al.md5(dB)).replace("__ANDROIDID3__", al.sha1(dB)).replace("__ANDROIDID__", dB);
        }
        return aj.d(context, ar, z);
    }

    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(bd.dC(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.dA(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.getOaid())) {
            if (str2.contains("__OAID__")) {
                arrayList.add("__OAID__");
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (TextUtils.isEmpty(bd.dB(context))) {
            return;
        }
        if (str2.contains("__ANDROIDID__")) {
            arrayList.add("__ANDROIDID__");
        }
        if (str2.contains("__ANDROIDID2__")) {
            arrayList.add("__ANDROIDID2__");
        }
        if (str2.contains("__ANDROIDID3__")) {
            arrayList.add("__ANDROIDID3__");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.kwad.sdk.commercial.j.a.a(adTemplate, "ANDROID", str, str2, (String) it4.next());
        }
        arrayList.clear();
    }
}
