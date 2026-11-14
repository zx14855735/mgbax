package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ua {
    /* JADX WARN: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String hf(android.content.Context r3) {
        /*
            r0 = 0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> Le java.lang.SecurityException -> L10
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch: java.lang.Throwable -> Le java.lang.SecurityException -> L10
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> Le java.lang.SecurityException -> L10
            goto L15
        Le:
            goto L14
        L10:
            r1 = move-exception
            com.bytedance.embedapplog.cu.hf(r1)
        L14:
            r1 = r0
        L15:
            if (r1 == 0) goto L43
            boolean r2 = r1.isAvailable()
            if (r2 == 0) goto L43
            int r1 = r1.getType()
            r2 = 1
            if (r2 != r1) goto L27
            java.lang.String r0 = "wifi"
            goto L43
        L27:
            if (r1 != 0) goto L43
            java.lang.String r0 = "phone"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            int r3 = r3.getNetworkType()
            switch(r3) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L41;
                case 5: goto L3e;
                case 6: goto L3e;
                case 7: goto L41;
                case 8: goto L3e;
                case 9: goto L3e;
                case 10: goto L3e;
                case 11: goto L41;
                case 12: goto L3e;
                case 13: goto L3b;
                case 14: goto L3e;
                case 15: goto L3e;
                case 16: goto L41;
                case 17: goto L3e;
                case 18: goto L3b;
                case 19: goto L3b;
                default: goto L38;
            }
        L38:
            java.lang.String r0 = "mobile"
            goto L43
        L3b:
            java.lang.String r0 = "4g"
            goto L43
        L3e:
            java.lang.String r0 = "3g"
            goto L43
        L41:
            java.lang.String r0 = "2g"
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ua.hf(android.content.Context):java.lang.String");
    }

    public static String xj(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - hf.getLong("start_mills", 0L) < 900000) {
            String string = hf.getString("access", null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String hf2 = hf(context);
        SharedPreferences.Editor edit = hf.edit();
        if (!TextUtils.isEmpty(hf2)) {
            edit.putString("access", hf2);
        }
        edit.putLong("start_mills", System.currentTimeMillis());
        edit.apply();
        return hf2;
    }
}
