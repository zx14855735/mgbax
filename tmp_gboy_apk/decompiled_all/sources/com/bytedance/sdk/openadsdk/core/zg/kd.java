package com.bytedance.sdk.openadsdk.core.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends hf {
    private static volatile kd xj;

    private kd() {
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new kd();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg.hf
    public int hf() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg.hf
    public long w() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().hf();
    }
}
