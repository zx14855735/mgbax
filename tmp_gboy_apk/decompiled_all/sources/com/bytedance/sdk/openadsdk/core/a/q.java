package com.bytedance.sdk.openadsdk.core.a;

import android.os.Looper;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class q {
    /* JADX INFO: Access modifiers changed from: private */
    public static void w(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, Double d) {
        if (wsVar == null || wsVar.pu() == null) {
            return;
        }
        wsVar.rz().w(1);
        try {
            Object obj = wsVar.pu().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str = (String) wsVar.pu().get("nurl");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (d != null) {
                    str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.pz.xj().xj(xj(wsVar, str, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void xj(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d(PointCategory.WIN) { // from class: com.bytedance.sdk.openadsdk.core.a.q.1
                @Override // java.lang.Runnable
                public void run() {
                    q.w(wsVar, d);
                }
            });
        } else {
            w(wsVar, d);
        }
    }

    public static void xj(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("loss") { // from class: com.bytedance.sdk.openadsdk.core.a.q.2
                @Override // java.lang.Runnable
                public void run() {
                    q.w(wsVar, d, str, str2);
                }
            });
        } else {
            w(wsVar, d, str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String xj(com.bytedance.sdk.openadsdk.core.ra.ws r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "&abort_aes=1"
            java.lang.String r1 = "?abort_aes=1"
            if (r5 == 0) goto L64
            if (r6 == 0) goto L64
            boolean r2 = r6.contains(r7)
            if (r2 != 0) goto Lf
            goto L64
        Lf:
            java.lang.String r5 = r5.jf()
            com.bytedance.sdk.openadsdk.core.w.y r2 = com.bytedance.sdk.openadsdk.core.w.y.xj()
            r3 = 0
            android.util.Pair r5 = r2.xj(r5, r3)
            java.lang.String r2 = ""
            r3 = 3
            if (r5 == 0) goto L38
            java.lang.Object r4 = r5.second
            if (r4 == 0) goto L2d
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r2 = "message"
            java.lang.String r2 = r4.optString(r2)
        L2d:
            java.lang.Object r5 = r5.first
            if (r5 == 0) goto L38
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L39
        L38:
            r5 = 3
        L39:
            if (r5 == r3) goto L59
            java.net.URL r5 = new java.net.URL     // Catch: java.lang.Exception -> L4f
            r5.<init>(r6)     // Catch: java.lang.Exception -> L4f
            java.lang.String r5 = r5.getQuery()     // Catch: java.lang.Exception -> L4f
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L4f
            if (r5 == 0) goto L51
            java.lang.String r6 = r6.concat(r1)     // Catch: java.lang.Exception -> L4f
            goto L59
        L4f:
            r5 = move-exception
            goto L56
        L51:
            java.lang.String r6 = r6.concat(r0)     // Catch: java.lang.Exception -> L4f
            goto L59
        L56:
            com.bytedance.sdk.component.utils.pl.xj(r5)
        L59:
            java.lang.String r5 = "UTF-8"
            java.lang.String r5 = java.net.URLEncoder.encode(r2, r5)
            java.lang.String r5 = r6.replace(r7, r5)
            return r5
        L64:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.q.xj(com.bytedance.sdk.openadsdk.core.ra.ws, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, Double d, String str, String str2) {
        if (wsVar == null || wsVar.pu() == null) {
            return;
        }
        try {
            wsVar.rz().w(2);
            Object obj = wsVar.pu().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str3 = (String) wsVar.pu().get("lurl");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                if (d != null) {
                    str3 = str3.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    str3 = str3.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    str3 = str3.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.pz.xj().xj(xj(wsVar, str3, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }
}
