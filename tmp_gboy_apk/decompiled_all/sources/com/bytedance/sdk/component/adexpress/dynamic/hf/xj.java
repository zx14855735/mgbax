package com.bytedance.sdk.component.adexpress.dynamic.hf;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.w.c;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean hf(android.view.View r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 2097610707(0x7d06ffd3, float:1.1215304E37)
            java.lang.Object r7 = r7.getTag(r1)     // Catch: java.lang.Exception -> L2a
            android.util.Pair r7 = (android.util.Pair) r7     // Catch: java.lang.Exception -> L2a
            if (r7 != 0) goto L10
            return r0
        L10:
            java.lang.Object r1 = r7.first     // Catch: java.lang.Exception -> L2a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L2a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L2a
            r2 = 1
            if (r1 != 0) goto L2c
            java.lang.String r1 = "0"
            java.lang.Object r3 = r7.first     // Catch: java.lang.Exception -> L2a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L2a
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L28
            goto L2c
        L28:
            r1 = 0
            goto L2d
        L2a:
            r7 = move-exception
            goto L44
        L2c:
            r1 = 1
        L2d:
            java.lang.Object r7 = r7.second     // Catch: java.lang.Exception -> L2a
            java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Exception -> L2a
            long r3 = r7.longValue()     // Catch: java.lang.Exception -> L2a
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L3d
            r7 = 1
            goto L3e
        L3d:
            r7 = 0
        L3e:
            if (r1 == 0) goto L43
            if (r7 == 0) goto L43
            return r2
        L43:
            return r0
        L44:
            r7.getMessage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.hf.xj.hf(android.view.View):boolean");
    }

    public static int xj(c cVar) {
        if (cVar == null) {
            return 0;
        }
        String wo = cVar.wo();
        String dk = cVar.dk();
        if (TextUtils.isEmpty(dk) || TextUtils.isEmpty(wo) || !dk.equals("creative")) {
            return 0;
        }
        if (wo.equals("shake")) {
            return 2;
        }
        if (wo.equals("twist")) {
            return 3;
        }
        return wo.equals("slide") ? 1 : 0;
    }

    public static boolean xj(View view) {
        Object tag;
        if (view == null) {
            return false;
        }
        try {
            tag = view.getTag(2097610708);
        } catch (Exception unused) {
        }
        if (tag == null) {
            return false;
        }
        return ((Integer) tag).intValue() == 1;
    }

    public static boolean xj(View view, float f, float f2, float f3, float f4) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long longValue = ((Long) pair.second).longValue();
                if (str.equals(Constants.FAIL)) {
                    return ((float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d))) >= ((float) longValue);
                }
                if (str.equals("1")) {
                    float f5 = f2 - f4;
                    return f5 < 0.0f && Math.abs(f5) >= ((float) longValue);
                }
                if (str.equals("2")) {
                    float f6 = f - f3;
                    return f6 > 0.0f && Math.abs(f6) >= ((float) longValue);
                }
                if (str.equals("3")) {
                    float f7 = f - f3;
                    return f7 < 0.0f && Math.abs(f7) >= ((float) longValue);
                }
                if (str.equals("4")) {
                    float f8 = f2 - f4;
                    if (f8 > 0.0f && Math.abs(f8) >= longValue) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
