package com.bytedance.sdk.openadsdk.core.l;

import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static String xj(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return p.xj(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
