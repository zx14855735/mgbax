package com.bytedance.sdk.openadsdk.x;

import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static byte[] xj(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.a(bArr, i);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return null;
    }
}
