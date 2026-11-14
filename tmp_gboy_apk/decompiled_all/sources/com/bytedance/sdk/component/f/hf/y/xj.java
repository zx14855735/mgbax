package com.bytedance.sdk.component.f.hf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile hf xj;

    public static hf xj(com.bytedance.sdk.component.f.xj.kd kdVar) {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new w(new y(kdVar), kdVar);
                    }
                } finally {
                }
            }
        }
        return xj;
    }
}
