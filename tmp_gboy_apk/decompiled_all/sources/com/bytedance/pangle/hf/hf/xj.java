package com.bytedance.pangle.hf.hf;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static Method hf;
    private static Method u;
    private static Method w;
    private static Method xj;

    static {
        try {
            xj = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            hf = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            w = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            u = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Field xj(java.lang.Class<?> r5, java.lang.String r6) {
        /*
            r0 = 1
            java.lang.reflect.Method r1 = com.bytedance.pangle.hf.hf.xj.xj
            r2 = 0
            if (r1 == 0) goto L47
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1c
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r1 = r1.invoke(r5, r3)     // Catch: java.lang.Throwable -> L1c
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L1a
            r1.setAccessible(r0)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r0 = move-exception
            r2 = r1
            goto L1d
        L1a:
            r2 = r1
            goto L47
        L1c:
            r0 = move-exception
        L1d:
            java.lang.String r1 = r5.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getField "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = "#"
            r3.append(r1)
            r3.append(r6)
            java.lang.String r1 = " failed !!!"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "DoubleReflector"
            java.lang.String r1 = r3.concat(r1)
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r1, r0)
        L47:
            if (r2 == 0) goto L4a
            return r2
        L4a:
            java.lang.reflect.Field r5 = com.bytedance.pangle.hf.xj.xj.xj(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.hf.hf.xj.xj(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Method xj(java.lang.Class<?> r5, java.lang.String r6, java.lang.Class<?>... r7) {
        /*
            r0 = 1
            java.lang.reflect.Method r1 = com.bytedance.pangle.hf.hf.xj.hf
            r2 = 0
            if (r1 == 0) goto L4a
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1f
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L1f
            r3[r0] = r7     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r1 = r1.invoke(r5, r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L1d
            r1.setAccessible(r0)     // Catch: java.lang.Throwable -> L1a
            goto L1d
        L1a:
            r0 = move-exception
            r2 = r1
            goto L20
        L1d:
            r2 = r1
            goto L4a
        L1f:
            r0 = move-exception
        L20:
            java.lang.String r1 = r5.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getMethod "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = "#"
            r3.append(r1)
            r3.append(r6)
            java.lang.String r1 = " failed !!!"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "DoubleReflector"
            java.lang.String r1 = r3.concat(r1)
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r1, r0)
        L4a:
            if (r2 == 0) goto L4d
            return r2
        L4d:
            java.lang.reflect.Method r5 = com.bytedance.pangle.hf.xj.xj.xj(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.hf.hf.xj.xj(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Constructor xj(java.lang.Class<?> r5, java.lang.Class<?>... r6) {
        /*
            r0 = 0
            java.lang.reflect.Method r1 = com.bytedance.pangle.hf.hf.xj.w
            if (r1 == 0) goto L3f
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L11
            r2[r0] = r6     // Catch: java.lang.Throwable -> L11
            java.lang.Object r1 = r1.invoke(r5, r2)     // Catch: java.lang.Throwable -> L11
            java.lang.reflect.Constructor r1 = (java.lang.reflect.Constructor) r1     // Catch: java.lang.Throwable -> L11
            goto L40
        L11:
            r1 = move-exception
            java.lang.String r2 = r5.getName()
            if (r6 == 0) goto L19
            int r0 = r6.length
        L19:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getConstructor "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "<init>"
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = " failed !!!"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r2 = "DoubleReflector"
            java.lang.String r0 = r2.concat(r0)
            java.lang.String r2 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r2, r0, r1)
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L43
            return r1
        L43:
            java.lang.reflect.Constructor r5 = com.bytedance.pangle.hf.xj.xj.xj(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.hf.hf.xj.xj(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }
}
