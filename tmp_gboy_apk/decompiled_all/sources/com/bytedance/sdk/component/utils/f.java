package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static volatile Handler xj;

    public static Handler hf() {
        if (xj == null) {
            synchronized (f.class) {
                try {
                    if (xj == null) {
                        xj = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public static Handler w() {
        return com.bytedance.sdk.component.tf.hf.xj.xj().w();
    }

    public static Handler xj() {
        return com.bytedance.sdk.component.tf.hf.xj.xj().hf();
    }
}
