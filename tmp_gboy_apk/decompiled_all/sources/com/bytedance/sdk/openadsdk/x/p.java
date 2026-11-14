package com.bytedance.sdk.openadsdk.x;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class p {
    private static Map<String, Field> xj = new HashMap();

    static {
        qXPIRr();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r4 = r0.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(105).xj(java.lang.Boolean.class).xj(0, r4).hf());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            goto L43
        L8:
            com.bytedance.sdk.openadsdk.core.f r0 = com.bytedance.sdk.openadsdk.core.f.zg()     // Catch: java.lang.Throwable -> L38
            r2 = 4
            java.util.function.Function r0 = r0.y(r2)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L43
            com.bytedance.sdk.openadsdk.zg.u r2 = com.bytedance.sdk.openadsdk.zg.u.xj()     // Catch: java.lang.Throwable -> L38
            r3 = 105(0x69, float:1.47E-43)
            com.bytedance.sdk.openadsdk.zg.u r2 = r2.xj(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            com.bytedance.sdk.openadsdk.zg.u r2 = r2.xj(r3)     // Catch: java.lang.Throwable -> L38
            com.bytedance.sdk.openadsdk.zg.u r4 = r2.xj(r1, r4)     // Catch: java.lang.Throwable -> L38
            android.util.SparseArray r4 = r4.hf()     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = P8ccfD.AaHO0E.ASJ6gh(r0, r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L38
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L38
            return r4
        L38:
            r4 = move-exception
            java.lang.String r0 = "ZeusUtil"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r4
            com.bytedance.sdk.component.utils.pl.hf(r0, r2)
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.x.p.c(java.lang.String):boolean");
    }

    private static void f(String str) {
        try {
            int i = Zeus.f10170A2egSU;
            Zeus.class.getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int hf(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? ai.w : xj(str, 101);
    }

    public static JSONObject kd(String str) {
        Object apply;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> y = com.bytedance.sdk.openadsdk.core.f.zg().y(4);
            if (y == null) {
                return null;
            }
            apply = y.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(13).xj(JSONObject.class).xj(0, str).hf());
            if (apply instanceof JSONObject) {
                return (JSONObject) apply;
            }
            return null;
        } catch (Throwable th) {
            pl.hf("ZeusUtil", th);
            return null;
        }
    }

    private static /* synthetic */ void qXPIRr() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int u(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? ai.w : xj(str, 102);
    }

    public static int w(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7132;
        }
        return xj(str, 103);
    }

    public static void xj(String str) {
        try {
            if (ai.w < 5500) {
                f(str);
                return;
            }
            Function<SparseArray<Object>, Object> y = com.bytedance.sdk.openadsdk.core.f.zg().y(4);
            if (y != null) {
                y.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(100).xj(Void.class).xj(0, str).hf());
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r4 = r0.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(104).xj(java.lang.Boolean.class).xj(0, r4).hf());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            goto L43
        L8:
            com.bytedance.sdk.openadsdk.core.f r0 = com.bytedance.sdk.openadsdk.core.f.zg()     // Catch: java.lang.Throwable -> L38
            r2 = 4
            java.util.function.Function r0 = r0.y(r2)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L43
            com.bytedance.sdk.openadsdk.zg.u r2 = com.bytedance.sdk.openadsdk.zg.u.xj()     // Catch: java.lang.Throwable -> L38
            r3 = 104(0x68, float:1.46E-43)
            com.bytedance.sdk.openadsdk.zg.u r2 = r2.xj(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            com.bytedance.sdk.openadsdk.zg.u r2 = r2.xj(r3)     // Catch: java.lang.Throwable -> L38
            com.bytedance.sdk.openadsdk.zg.u r4 = r2.xj(r1, r4)     // Catch: java.lang.Throwable -> L38
            android.util.SparseArray r4 = r4.hf()     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = P8ccfD.AaHO0E.ASJ6gh(r0, r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L38
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L38
            return r4
        L38:
            r4 = move-exception
            java.lang.String r0 = "ZeusUtil"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r4
            com.bytedance.sdk.component.utils.pl.hf(r0, r2)
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.x.p.y(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r3 = r1.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(r4).xj(java.lang.Integer.class).xj(0, r3).hf());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int xj(java.lang.String r3, int r4) {
        /*
            r0 = 0
            com.bytedance.sdk.openadsdk.core.f r1 = com.bytedance.sdk.openadsdk.core.f.zg()     // Catch: java.lang.Throwable -> L2f
            r2 = 4
            java.util.function.Function r1 = r1.y(r2)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L3a
            com.bytedance.sdk.openadsdk.zg.u r2 = com.bytedance.sdk.openadsdk.zg.u.xj()     // Catch: java.lang.Throwable -> L2f
            com.bytedance.sdk.openadsdk.zg.u r4 = r2.xj(r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            com.bytedance.sdk.openadsdk.zg.u r4 = r4.xj(r2)     // Catch: java.lang.Throwable -> L2f
            com.bytedance.sdk.openadsdk.zg.u r3 = r4.xj(r0, r3)     // Catch: java.lang.Throwable -> L2f
            android.util.SparseArray r3 = r3.hf()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = P8ccfD.AaHO0E.ASJ6gh(r1, r3)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L3a
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2f
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2f
            return r3
        L2f:
            r3 = move-exception
            java.lang.String r4 = "ZeusUtil"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            com.bytedance.sdk.component.utils.pl.hf(r4, r1)
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.x.p.xj(java.lang.String, int):int");
    }
}
