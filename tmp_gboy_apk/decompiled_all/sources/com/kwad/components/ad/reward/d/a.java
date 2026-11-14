package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static void S(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String dh = ag.dh(context);
        int i = 0;
        if (!TextUtils.isEmpty(dh)) {
            try {
                bVar.parseJson(new JSONObject(dh));
                if (b(bVar.jC, currentTimeMillis)) {
                    i = bVar.uv;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.jC = currentTimeMillis;
        bVar.uv = i + 1;
        ag.af(context, bVar.toJson().toString());
    }

    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static void c(Context context, int i) {
        int dg = ag.dg(context);
        if (dg % i == 0) {
            ag.m(context, 1);
        } else {
            ag.m(context, dg + 1);
        }
    }

    private static boolean d(Context context, int i) {
        return i != 0 && ag.dg(context) % i == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean e(android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.ag.dh(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L29
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.jC     // Catch: java.lang.Exception -> L27
            boolean r7 = b(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L29
            int r7 = r2.uv     // Catch: java.lang.Exception -> L27
            goto L2f
        L27:
            r7 = move-exception
            goto L2b
        L29:
            r7 = 0
            goto L2f
        L2b:
            com.kwad.sdk.core.d.c.printStackTraceOnly(r7)
            goto L29
        L2f:
            if (r7 >= r8) goto L33
            r7 = 1
            return r7
        L33:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.d.a.e(android.content.Context, int):boolean");
    }

    public static boolean b(Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aH(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.b.a.aI(adInfo) + 1, 1);
        boolean d = d(context, max);
        c(context, max);
        return d && e(context, com.kwad.sdk.core.response.b.a.aJ(adInfo));
    }
}
