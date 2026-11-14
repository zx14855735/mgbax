package com.bytedance.msdk.kd.xj;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends c {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile y xj;

    private y(Context context) {
        super(context);
    }

    public static y xj(Context context) {
        if (xj == null) {
            synchronized (y.class) {
                try {
                    if (xj == null) {
                        xj = new y(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }
}
