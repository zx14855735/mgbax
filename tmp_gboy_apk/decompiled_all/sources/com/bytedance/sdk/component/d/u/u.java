package com.bytedance.sdk.component.d.u;

import android.content.Context;
import com.bytedance.sdk.component.d.w.c;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static void xj(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(xj(i2), str);
            }
            w.hf("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (c.xj().xj(i2).u() != null) {
                c.xj().xj(i2).u().xj(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String xj(android.content.Context r2, int r3, int r4) {
        /*
            r0 = 1
            java.lang.String r1 = ""
            if (r3 == r0) goto L6
            goto L2a
        L6:
            com.bytedance.sdk.component.d.w.c r3 = com.bytedance.sdk.component.d.w.c.xj()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.d.w.kd r3 = r3.xj(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.d.w.hf r3 = r3.u()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L2a
            com.bytedance.sdk.component.d.w.c r3 = com.bytedance.sdk.component.d.w.c.xj()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.d.w.kd r3 = r3.xj(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.d.w.hf r3 = r3.u()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = xj(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.xj(r2, r4, r1)     // Catch: java.lang.Exception -> L29
            goto L2b
        L29:
        L2a:
            r2 = r1
        L2b:
            if (r2 == 0) goto L31
            java.lang.String r1 = java.lang.String.valueOf(r2)
        L31:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.u.u.xj(android.content.Context, int, int):java.lang.String");
    }

    private static String xj(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
