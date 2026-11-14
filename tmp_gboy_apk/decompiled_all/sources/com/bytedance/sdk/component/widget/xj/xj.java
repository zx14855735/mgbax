package com.bytedance.sdk.component.widget.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj hf;
    private volatile hf xj;

    private xj() {
    }

    public static xj xj() {
        if (hf == null) {
            synchronized (xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public hf hf() {
        return this.xj;
    }
}
