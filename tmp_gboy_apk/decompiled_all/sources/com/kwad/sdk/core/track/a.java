package com.kwad.sdk.core.track;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static List<String> a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo er = e.er(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = er.adTrackInfoList;
        if (!ap.L(list2)) {
            List<String> a2 = a(i, aVar, arrayList, er, list2);
            if (a2 == null) {
                Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdInfo.AdTrackInfo next = it.next();
                    if (next.type == i && (list = next.urls) != null) {
                        arrayList.addAll(list);
                        break;
                    }
                }
            } else {
                return a2;
            }
        }
        return arrayList;
    }

    public static void e(com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo er = e.er(adTemplate);
        int i = aVar.aAV;
        List<String> a2 = a(adTemplate, i, aVar);
        if (ap.L(a2)) {
            return;
        }
        boolean dy = com.kwad.sdk.core.response.b.a.dy(er);
        boolean dz = com.kwad.sdk.core.response.b.a.dz(er);
        for (String str : a2) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i, str);
                return;
            }
            if (bw.hR(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap hashMap = null;
            String a3 = ai.a(ServiceProvider.getContext(), str, i == 2 ? aVar.mJ : null, com.kwad.sdk.core.response.b.a.aC(e.er(adTemplate)));
            ai.f(adTemplate, str, a3);
            AdHttpProxy Cm = g.Cm();
            int i2 = Cm instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            A2egSU.B9tovu("handleTrackUrl useKwaiUA: ", "AdTrackUtil", dy);
            if (dy) {
                c j = com.kwad.sdk.core.i.a.j(dy, dz);
                com.kwad.sdk.core.d.c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + j);
                if (j != null) {
                    hashMap = new HashMap();
                    hashMap.put("User-Agent", j.LK());
                }
            }
            com.kwad.sdk.core.network.c doGetWithoutResponse = Cm.doGetWithoutResponse(a3, hashMap, !dy);
            if (ec(doGetWithoutResponse.code)) {
                com.kwad.components.ad.reward.A2egSU.A4TApA(i, "trackUrl request success actionType: ", "AdTrackUtil");
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, doGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, a3, com.kwad.sdk.commercial.e.cM(doGetWithoutResponse.code), doGetWithoutResponse.aIW, i2);
            }
        }
    }

    private static boolean ec(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r4.addAll(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<java.lang.String> a(int r2, com.kwad.sdk.core.adlog.c.a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L4f
            boolean r2 = com.kwad.sdk.core.response.b.a.bp(r5)
            if (r2 == 0) goto L4f
            java.lang.String r2 = r3.PI     // Catch: java.lang.Throwable -> L4e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L4e
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.PI     // Catch: java.lang.Throwable -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L4e
            goto L22
        L20:
            int r2 = r3.aCm     // Catch: java.lang.Throwable -> L4e
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L4e
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L4e
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L4e
            int r0 = r6.type     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L4e
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L4e
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r6 = r6.urls     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L2f
            r4.addAll(r6)     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r4
        L4f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.a.a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}
