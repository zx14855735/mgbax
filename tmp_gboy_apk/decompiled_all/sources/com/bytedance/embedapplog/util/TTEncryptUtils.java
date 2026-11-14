package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.cu;
import com.bytedance.sdk.openadsdk.x.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class TTEncryptUtils {
    static {
        try {
            y.xj("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            cu.hf(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static native String clientPackedBase64(byte[] bArr, int i);

    public static native byte[] clientUnpackedBase64(String str);

    public static native String getDA0Result(String str);

    public static native int[] getDI0Result(String[] strArr);

    private static native byte[] ttEncrypt(byte[] bArr, int i);
}
