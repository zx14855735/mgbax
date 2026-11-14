package com.bytedance.sdk.openadsdk.core.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a {
    private static String xj;

    public static String hf(String str) {
        try {
            if (!xj()) {
                return str;
            }
            String vm = com.bytedance.sdk.openadsdk.core.f.zg().vm();
            return TextUtils.isEmpty(vm) ? str : Uri.parse(str).buildUpon().appendQueryParameter(hf(), vm).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String xj(java.lang.String r6) {
        /*
            java.lang.String r0 = "data/data/com.union_test.toutiao/"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r4.append(r6)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            boolean r6 = r3.exists()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            if (r6 != 0) goto L20
            return r2
        L20:
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
        L2a:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            if (r2 == 0) goto L39
            r1.append(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            goto L2a
        L34:
            r1 = move-exception
        L35:
            r2 = r6
            goto L67
        L37:
            r2 = move-exception
            goto L53
        L39:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            r6.close()     // Catch: java.lang.Throwable -> L40
        L40:
            r0.close()     // Catch: java.lang.Throwable -> L43
        L43:
            return r1
        L44:
            r1 = move-exception
            r0 = r2
            goto L35
        L47:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L53
        L4c:
            r1 = move-exception
            r0 = r2
            goto L67
        L4f:
            r6 = move-exception
            r0 = r2
            r2 = r6
            r6 = r0
        L53:
            com.bytedance.sdk.component.utils.pl.xj(r2)     // Catch: java.lang.Throwable -> L34
            if (r6 == 0) goto L5d
            r6.close()     // Catch: java.lang.Throwable -> L5c
            goto L5d
        L5c:
        L5d:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.lang.Throwable -> L62
        L62:
            java.lang.String r6 = r1.toString()
            return r6
        L67:
            if (r2 == 0) goto L6e
            r2.close()     // Catch: java.lang.Throwable -> L6d
            goto L6e
        L6d:
        L6e:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.lang.Throwable -> L73
        L73:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.a.xj(java.lang.String):java.lang.String");
    }

    public static String hf() {
        if (TextUtils.isEmpty(xj)) {
            xj = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return xj;
    }

    public static boolean xj() {
        if (com.bytedance.sdk.component.utils.pl.w()) {
            return com.bytedance.sdk.openadsdk.core.f.zg().yy();
        }
        return false;
    }

    public static String xj(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static void xj(Map<String, String> map) {
        if (xj()) {
            map.put("x-app-id", "5001121");
            String vm = com.bytedance.sdk.openadsdk.core.f.zg().vm();
            if (TextUtils.isEmpty(vm)) {
                return;
            }
            map.put("x-device-id", vm);
        }
    }
}
