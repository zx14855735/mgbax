package com.bytedance.msdk.core.pl;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final String xj = "hf";

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean hf(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = com.bytedance.msdk.core.pl.hf.xj
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "checkPermissinKITKATNew，permission："
            java.lang.String r1 = r2.concat(r1)
            com.bytedance.msdk.xj.kd.w.u(r0, r1)
            r1 = 1
            int r2 = r7.hashCode()     // Catch: java.lang.Exception -> L30
            r3 = -1888586689(0xffffffff8f6e743f, float:-1.1756694E-29)
            r4 = 0
            r5 = 2
            if (r2 == r3) goto L3d
            r3 = -63024214(0xfffffffffc3e53aa, float:-3.9529332E36)
            if (r2 == r3) goto L33
            r3 = -5573545(0xffffffffffaaf457, float:NaN)
            if (r2 == r3) goto L26
            goto L47
        L26:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> L30
            if (r2 == 0) goto L47
            r2 = 2
            goto L48
        L30:
            r6 = move-exception
            goto La4
        L33:
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> L30
            if (r2 == 0) goto L47
            r2 = 0
            goto L48
        L3d:
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = r7.equals(r2)     // Catch: java.lang.Exception -> L30
            if (r2 == 0) goto L47
            r2 = 1
            goto L48
        L47:
            r2 = -1
        L48:
            if (r2 == 0) goto L61
            if (r2 == r1) goto L5e
            if (r2 == r5) goto L5b
            java.lang.String r2 = "android.permission."
            java.lang.String r3 = "android:"
            java.lang.String r7 = r7.replaceFirst(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r7 = r7.toLowerCase()     // Catch: java.lang.Exception -> L30
            goto L63
        L5b:
            java.lang.String r7 = "android:read_phone_state"
            goto L63
        L5e:
            java.lang.String r7 = "android:fine_location"
            goto L63
        L61:
            java.lang.String r7 = "android:coarse_location"
        L63:
            java.lang.String r2 = "appops"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Exception -> L30
            android.app.AppOpsManager r2 = (android.app.AppOpsManager) r2     // Catch: java.lang.Exception -> L30
            int r3 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> L30
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L30
            int r6 = r2.checkOp(r7, r3, r6)     // Catch: java.lang.Exception -> L30
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "checkPermissinKITKATNew，locationOp,permission："
            r2.<init>(r3)     // Catch: java.lang.Exception -> L30
            r2.append(r6)     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = ","
            r2.append(r3)     // Catch: java.lang.Exception -> L30
            r2.append(r7)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L30
            com.bytedance.msdk.xj.kd.w.u(r0, r2)     // Catch: java.lang.Exception -> L30
            if (r6 == 0) goto La3
            java.lang.String r6 = "checkPermissinKITKATNew，false,permission："
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> La0
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.Exception -> La0
            com.bytedance.msdk.xj.kd.w.u(r0, r6)     // Catch: java.lang.Exception -> La0
            return r4
        La0:
            r6 = move-exception
            r1 = 0
            goto La4
        La3:
            return r1
        La4:
            java.lang.String r7 = com.bytedance.msdk.core.pl.hf.xj
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "权限检查出错时默认返回有权限，异常代码："
            java.lang.String r6 = r0.concat(r6)
            com.bytedance.msdk.xj.kd.w.u(r7, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.pl.hf.hf(android.content.Context, java.lang.String):boolean");
    }

    private static boolean w(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean xj(Context context, String str) {
        return hf(context, str);
    }
}
