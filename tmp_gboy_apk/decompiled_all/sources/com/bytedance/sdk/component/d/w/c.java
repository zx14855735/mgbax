package com.bytedance.sdk.component.d.w;

import android.content.Context;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static HashMap<Integer, kd> hf;
    private static HashMap<Integer, xj> w;
    private static volatile c xj;

    private c() {
        hf = new HashMap<>();
        w = new HashMap<>();
    }

    public static synchronized c xj() {
        c cVar;
        synchronized (c.class) {
            try {
                if (xj == null) {
                    synchronized (c.class) {
                        try {
                            if (xj == null) {
                                xj = new c();
                            }
                        } finally {
                        }
                    }
                }
                cVar = xj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public kd xj(int i) {
        kd kdVar = hf.get(Integer.valueOf(i));
        if (kdVar != null) {
            return kdVar;
        }
        kd kdVar2 = new kd(i);
        hf.put(Integer.valueOf(i), kdVar2);
        return kdVar2;
    }

    public xj xj(int i, Context context) {
        xj xjVar = w.get(Integer.valueOf(i));
        if (xjVar != null) {
            return xjVar;
        }
        xj xjVar2 = new xj(context, i);
        w.put(Integer.valueOf(i), xjVar2);
        return xjVar2;
    }
}
