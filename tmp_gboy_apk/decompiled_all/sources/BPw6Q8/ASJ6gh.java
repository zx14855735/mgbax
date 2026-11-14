package BPw6Q8;

import ADYaiT.CtFAbx;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.CkXcdM;
import androidx.core.app.CmUvjW;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ASJ6gh {
    public static int A2egSU(Context context, String str) {
        boolean z = true;
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        CmUvjW cmUvjW = new CmUvjW(context);
        if (i >= 24) {
            z = CkXcdM.A2egSU(cmUvjW.f8562A2egSU);
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i2), packageName)).intValue() != 0) {
                    z = false;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return z ? 0 : -1;
    }

    public static int A4TApA(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? A4TApA.A2egSU(context, i) : context.getResources().getColor(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0046, code lost:
    
        if (r5.f1462A5SV6n == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList A5SV6n(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            BTvldC.AzWtSf r1 = new BTvldC.AzWtSf
            r1.<init>(r0, r8)
            java.lang.Object r2 = BTvldC.B4ZgIw.f1470A5SV6n
            monitor-enter(r2)
            java.util.WeakHashMap r3 = BTvldC.B4ZgIw.f1469A4TApA     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L4f
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L4f
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            BTvldC.AmA8tU r5 = (BTvldC.AmA8tU) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L4f
            android.content.res.Configuration r6 = r5.f1461A4TApA     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4c
            if (r8 != 0) goto L3e
            int r6 = r5.f1462A5SV6n     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L48
            goto L3e
        L3c:
            r8 = move-exception
            goto L95
        L3e:
            if (r8 == 0) goto L4c
            int r6 = r5.f1462A5SV6n     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4c
        L48:
            android.content.res.ColorStateList r3 = r5.f1460A2egSU     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L51
        L4c:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L4f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L51:
            if (r3 == 0) goto L54
            return r3
        L54:
            java.lang.ThreadLocal r2 = BTvldC.B4ZgIw.f1468A2egSU
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L66
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L66:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L75
            r3 = 31
            if (r2 > r3) goto L75
            goto L7f
        L75:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = BTvldC.A5SV6n.A2egSU(r0, r2, r8)     // Catch: java.lang.Exception -> L7e
            goto L7f
        L7e:
        L7f:
            if (r4 == 0) goto L85
            BTvldC.B4ZgIw.A2egSU(r1, r9, r4, r8)
            goto L94
        L85:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L90
            android.content.res.ColorStateList r4 = BTvldC.AlLFFp.A4TApA(r0, r9, r8)
            goto L94
        L90:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9)
        L94:
            return r4
        L95:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: BPw6Q8.ASJ6gh.A5SV6n(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Object ADYaiT(Context context, Class cls) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return A4TApA.A4TApA(context, cls);
        }
        String A5SV6n2 = i >= 23 ? A4TApA.A5SV6n(context, cls) : (String) ARc23Z.f1432A2egSU.get(cls);
        if (A5SV6n2 != null) {
            return context.getSystemService(A5SV6n2);
        }
        return null;
    }

    public static String AMqCpz(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (com.bumptech.glide.A5SV6n.B3GDIM(context, str) == 0) {
            return str;
        }
        throw new RuntimeException(CtFAbx.BI9f7h("Permission ", str, " is required by your application to receive broadcasts, please add it to your manifest"));
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return registerReceiver(context, broadcastReceiver, intentFilter, null, null, i);
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        int i2 = i & 1;
        if (i2 != 0 && (i & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i2 != 0) {
            i |= 2;
        }
        int i3 = i;
        int i4 = i3 & 2;
        if (i4 == 0 && (i3 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i4 != 0 && (i3 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        int i5 = Build.VERSION.SDK_INT;
        return i5 >= 33 ? ADYaiT.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i3) : i5 >= 26 ? A5SV6n.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i3) : ((i3 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler) : context.registerReceiver(broadcastReceiver, intentFilter, AMqCpz(context), handler);
    }
}
