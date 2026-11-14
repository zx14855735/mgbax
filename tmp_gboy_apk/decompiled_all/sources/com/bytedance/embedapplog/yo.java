package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo implements Application.ActivityLifecycleCallbacks {
    private static int c = -1;
    private static final HashSet<Integer> d = new HashSet<>(8);
    private static k hf;
    private static long kd;
    private static String u;
    private static long w;
    private static int xj;
    private static String y;
    private final y f;

    static {
        DkpwlOV();
    }

    public yo(y yVar) {
        this.f = yVar;
    }

    private static /* synthetic */ void DkpwlOV() {
        char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 237);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 237);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static k xj(String str, String str2, long j, String str3) {
        k kVar = new k();
        if (TextUtils.isEmpty(str2)) {
            kVar.am = str;
        } else {
            kVar.am = CtFAbx.AlLFFp(str, ":", str2);
        }
        kVar.hf = j;
        kVar.f10105pl = -1L;
        if (str3 == null) {
            str3 = "";
        }
        kVar.g = str3;
        a.xj(kVar);
        return kVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        d.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        d.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        k kVar = hf;
        if (kVar != null) {
            u = kVar.am;
            long currentTimeMillis = System.currentTimeMillis();
            w = currentTimeMillis;
            xj(hf, currentTimeMillis);
            hf = null;
            if (activity.isChild()) {
                return;
            }
            c = -1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        k xj2 = xj(activity.getClass().getName(), "", System.currentTimeMillis(), u);
        hf = xj2;
        xj2.v = !d.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            c = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            cu.hf(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        xj++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (u != null) {
            int i = xj - 1;
            xj = i;
            if (i <= 0) {
                u = null;
                y = null;
                kd = 0L;
                w = 0L;
            }
        }
    }

    public static k xj(k kVar, long j) {
        k kVar2 = (k) kVar.clone();
        kVar2.hf = j;
        long j2 = j - kVar.hf;
        if (j2 >= 0) {
            kVar2.f10105pl = j2;
        } else {
            cu.hf((Throwable) null);
        }
        a.xj(kVar2);
        return kVar2;
    }
}
