package com.bytedance.sdk.openadsdk.core.am;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.openadsdk.core.x.hf {
    private static hf xj;

    private hf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String hf() {
        return "AdEventCollector";
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public void xj(String str, String str2) {
    }

    public static synchronized hf xj() {
        hf hfVar;
        synchronized (hf.class) {
            try {
                if (xj == null) {
                    xj = new hf();
                }
                hfVar = xj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String xj(String str) {
        return "";
    }
}
