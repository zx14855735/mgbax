package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.ADBidEvent;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static String a(int i, String str) {
        String a2;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        if (i == 0) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str2, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str3, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str4, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            a2 = "";
        }
        return a2 == null ? "" : a2;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        if (!str.equalsIgnoreCase(ADBidEvent.XIAOMI)) {
            String str2 = Build.BRAND;
            if (!str2.equalsIgnoreCase(ADBidEvent.XIAOMI) && !str2.equalsIgnoreCase("REDMI") && !str2.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(a("ro.miui.ui.version.name", "")) && !str.equalsIgnoreCase("BLACKSHARK") && !str2.equalsIgnoreCase("BLACKSHARK")) {
                if (!str.equalsIgnoreCase("SAMSUNG") && !str2.equalsIgnoreCase("SAMSUNG")) {
                    if (!str.equalsIgnoreCase(ADBidEvent.VIVO) && !str2.equalsIgnoreCase(ADBidEvent.VIVO) && !str2.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(a("ro.vivo.os.version", ""))) {
                        if (str.equalsIgnoreCase(ADBidEvent.HUAWEI) || str2.equalsIgnoreCase(ADBidEvent.HUAWEI)) {
                            return "1";
                        }
                        return (str.equalsIgnoreCase("OPPO") || str2.equalsIgnoreCase("OPPO") || str2.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a("ro.build.version.opporom", "")) || str.equalsIgnoreCase("ONEPLUS") || str2.equalsIgnoreCase("ONEPLUS")) ? "5" : str2.equalsIgnoreCase("HONOR") ? "7" : Constants.FAIL;
                    }
                    return "2";
                }
                return "3";
            }
            return "4";
        }
        return "4";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0 A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #1 {all -> 0x00ae, blocks: (B:37:0x00b8, B:41:0x00c0), top: B:36:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6 A[Catch: all -> 0x00dd, TRY_LEAVE, TryCatch #0 {all -> 0x00dd, blocks: (B:3:0x0002, B:6:0x0016, B:8:0x0020, B:10:0x002a, B:17:0x006a, B:19:0x0070, B:24:0x0077, B:26:0x0081, B:29:0x0091, B:31:0x0097, B:32:0x00ae, B:47:0x00d0, B:49:0x00d6, B:55:0x0087, B:57:0x0044, B:59:0x004e, B:61:0x0058, B:63:0x0066), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = a(r8, r0)     // Catch: java.lang.Throwable -> Ldd
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r3 = "Lm91a2R0ZnQ="
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r5 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String r6 = "KWE_N"
            java.lang.String r7 = ""
            if (r2 == 0) goto L44
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            boolean r2 = r2.b()     // Catch: java.lang.Throwable -> Ldd
            if (r2 != 0) goto L3f
            java.lang.String[] r2 = new java.lang.String[]{r5, r4}     // Catch: java.lang.Throwable -> Ldd
            boolean r2 = com.yxcorp.kuaishou.addfp.android.b.f.a(r8, r2)     // Catch: java.lang.Throwable -> Ldd
            if (r2 == 0) goto L41
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r7 = r2.a(r3)     // Catch: java.lang.Throwable -> Ldd
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Ldd
            if (r2 != 0) goto L3f
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3f
            android.provider.Settings.System.putString(r2, r0, r7)     // Catch: java.lang.Throwable -> L3f
        L3f:
            r0 = r6
            goto L6a
        L41:
            java.lang.String r0 = "KWE_PN"
            goto L6a
        L44:
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> Ldd
            if (r0 != 0) goto L3f
            java.lang.String[] r0 = new java.lang.String[]{r5, r4}     // Catch: java.lang.Throwable -> Ldd
            boolean r0 = com.yxcorp.kuaishou.addfp.android.b.f.a(r8, r0)     // Catch: java.lang.Throwable -> Ldd
            if (r0 == 0) goto L3f
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r7 = r0.a(r3)     // Catch: java.lang.Throwable -> Ldd
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Ldd
            if (r0 == 0) goto L3f
            com.yxcorp.kuaishou.addfp.android.a.d.a(r8, r1)     // Catch: java.lang.Throwable -> Ldd
            goto L3f
        L6a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ldd
            if (r2 == 0) goto L77
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Ldd
            if (r2 == 0) goto L77
            goto Le3
        L77:
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            java.util.LinkedHashMap r1 = r2.b(r1)     // Catch: java.lang.Throwable -> Ldd
            if (r1 == 0) goto L87
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Ldd
            if (r2 != 0) goto L8f
        L87:
            com.yxcorp.kuaishou.addfp.android.a.d r8 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Ldd
            java.util.LinkedHashMap r1 = r8.b(r7)     // Catch: java.lang.Throwable -> Ldd
        L8f:
            if (r1 == 0) goto Ldb
            int r8 = r1.size()     // Catch: java.lang.Throwable -> Ldd
            if (r8 <= 0) goto Ldb
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ldd
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Throwable -> Ldd
            r8.<init>(r2)     // Catch: java.lang.Throwable -> Ldd
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Ldd
            java.util.ListIterator r8 = r8.listIterator(r1)     // Catch: java.lang.Throwable -> Ldd
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ldd
            r1.<init>()     // Catch: java.lang.Throwable -> Ldd
            r2 = 0
        Lae:
            boolean r3 = r8.hasPrevious()     // Catch: java.lang.Throwable -> Ldd
            if (r3 == 0) goto Ld0
            r3 = 10
            if (r2 >= r3) goto Ld0
            java.lang.Object r3 = r8.previous()     // Catch: java.lang.Throwable -> Lae
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Lae
            if (r3 == 0) goto Lcd
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lae
            r1.put(r4, r3)     // Catch: java.lang.Throwable -> Lae
        Lcd:
            int r2 = r2 + 1
            goto Lae
        Ld0:
            int r8 = r1.length()     // Catch: java.lang.Throwable -> Ldd
            if (r8 <= 0) goto Ldb
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> Ldd
            return r8
        Ldb:
            r6 = r0
            goto Le3
        Ldd:
            r8 = move-exception
            r8.printStackTrace()
            java.lang.String r6 = "KWE_PE"
        Le3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }
}
