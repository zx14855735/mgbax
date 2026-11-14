package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.m;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class p implements m {
    private static Class<?> hf;
    private static Method w;
    private static Object xj;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            hf = cls;
            xj = cls.newInstance();
            w = hf.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            cu.xj("Api#static reflect exception! " + e.getMessage());
        }
    }

    public static boolean xj() {
        return (hf == null || xj == null || w == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        try {
            m.xj xjVar = new m.xj();
            xjVar.hf = xj(context, w);
            return xjVar;
        } catch (Exception e) {
            cu.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        return xj();
    }

    private static String xj(Context context, Method method) {
        Object obj = xj;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
