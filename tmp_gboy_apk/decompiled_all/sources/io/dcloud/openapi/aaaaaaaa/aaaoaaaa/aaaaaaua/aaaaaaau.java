package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaau {
    private static String aaaaaaa0;
    private static String aaaaaaaa;

    public static String aaaaaaa0() {
        if (TextUtils.isEmpty(aaaaaaaa)) {
            try {
                aaaaaaaa = aaaaaaaa("LKdg}l.:\"8V9+>88");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aaaaaaaa;
    }

    public static String aaaaaaaa() {
        if (TextUtils.isEmpty(aaaaaaa0)) {
            try {
                aaaaaaa0 = aaaaaaaa("@\\ED=XD][Z]F\\AEM");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aaaaaaa0;
    }

    private static String aaaaaaaa(String str) {
        byte[] bytes = str.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return new String(bytes, "GBK");
    }
}
