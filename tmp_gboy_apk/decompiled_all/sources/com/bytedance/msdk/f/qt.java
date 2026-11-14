package com.bytedance.msdk.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt {
    private static boolean xj = true;

    static {
        try {
            com.bytedance.sdk.openadsdk.x.y.xj("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            xj = false;
        }
    }

    public static byte[] xj(byte[] bArr, int i) {
        com.bytedance.sdk.component.u.kd kdVar = (com.bytedance.sdk.component.u.kd) com.bytedance.sdk.openadsdk.ats.w.xj("embed_applog");
        return kdVar != null ? kdVar.encrypt(bArr, i) : new byte[0];
    }

    public static boolean xj() {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "applogSOLoadSuccess = " + xj);
        return xj;
    }
}
