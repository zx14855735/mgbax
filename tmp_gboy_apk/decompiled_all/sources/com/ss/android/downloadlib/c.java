package com.ss.android.downloadlib;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static volatile c xj;
    private com.ss.android.download.api.config.y hf = null;

    private c() {
    }

    public static c xj() {
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
        return xj;
    }

    public com.ss.android.download.api.config.y hf() {
        return this.hf;
    }
}
