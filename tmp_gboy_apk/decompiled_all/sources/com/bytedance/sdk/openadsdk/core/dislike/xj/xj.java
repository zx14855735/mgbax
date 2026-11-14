package com.bytedance.sdk.openadsdk.core.dislike.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static w hf;
    private static u w;
    private static volatile boolean xj;

    public static u hf() {
        return w;
    }

    public static void xj(w wVar, u uVar) {
        if (xj) {
            return;
        }
        xj = true;
        hf = wVar;
        w = uVar;
    }

    public static w xj() {
        return hf;
    }
}
