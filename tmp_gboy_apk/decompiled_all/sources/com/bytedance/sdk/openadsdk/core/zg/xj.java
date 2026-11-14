package com.bytedance.sdk.openadsdk.core.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private static volatile xj xj;

    private xj() {
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg.hf
    public synchronized int hf() {
        int w = com.bytedance.sdk.openadsdk.core.w.kd.xj().w();
        if (com.bytedance.sdk.openadsdk.core.w.kd.xj().u() <= 0.0f) {
            return w;
        }
        return (int) Math.ceil(r1 * w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg.hf
    public synchronized long w() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().hf();
    }
}
