package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class au {
    private static Map<String, Integer> bfa;
    private static Set<String> bfb;
    private static Method bfc;

    static {
        HashSet hashSet = new HashSet();
        bfb = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        bfb.add("android.permission.WRITE_SETTINGS");
        bfb.add("android.permission.SYSTEM_ALERT_WINDOW");
        ruUlEV();
    }

    public static int aw(Context context, String str) {
        int ax;
        if (bfa == null) {
            h(y.cW(context));
        }
        if (bfb.contains(str) && (ax = ax(context, str)) != -2) {
            return ax;
        }
        int ay = ay(context, str);
        if (ay == -2) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable unused) {
            }
        }
        return ay;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int ax(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            r5.getClass()
            r1 = 23
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case -2078357533: goto L26;
                case -1561629405: goto L1b;
                case 1777263169: goto L10;
                default: goto Le;
            }
        Le:
            r5 = -1
            goto L30
        L10:
            java.lang.String r3 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L19
            goto Le
        L19:
            r5 = 2
            goto L30
        L1b:
            java.lang.String r3 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L24
            goto Le
        L24:
            r5 = 1
            goto L30
        L26:
            java.lang.String r3 = "android.permission.WRITE_SETTINGS"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L2f
            goto Le
        L2f:
            r5 = 0
        L30:
            switch(r5) {
                case 0: goto L51;
                case 1: goto L41;
                case 2: goto L34;
                default: goto L33;
            }
        L33:
            goto L5d
        L34:
            int r5 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r5 < r1) goto L5d
            boolean r4 = com.kwad.sdk.utils.y.cV(r4)
            if (r4 == 0) goto L5c
            goto L5b
        L41:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r1) goto L5d
            boolean r4 = com.game.boy.activity.CQhlFr.AaHO0E(r4)     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L5c
            goto L5b
        L4c:
            r4 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r4)
            goto L5d
        L51:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r1) goto L5d
            boolean r4 = com.bytedance.pangle.wrapper.AMqCpz.B7CMnp(r4)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L5c
        L5b:
            return r0
        L5c:
            return r2
        L5d:
            r4 = -2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.ax(android.content.Context, java.lang.String):int");
    }

    private static int ay(Context context, String str) {
        if (bfa == null || str == null || !bfa.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = bfa.get(str);
            if (num == null) {
                return -2;
            }
            if (bfc == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                bfc = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) bfc.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    public static boolean dw(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        bfa = new HashMap();
        for (String str : strArr) {
            try {
                Integer num = (Integer) z.c(AppOpsManager.class, CtFAbx.BChYOn("OP_", hx(str)));
                if (num.intValue() >= 0) {
                    bfa.put(str, num);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String hx(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private static /* synthetic */ void ruUlEV() {
        char[] charArray = "<02q8>2:q=0&q,7:33q\u001516\u001d-6;8:".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '_');
        }
        String str = new String(charArray);
        char[] charArray2 = "<3616+".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '_');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
