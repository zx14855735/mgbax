package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaae {
    public static String aaaaaaa0(String str) {
        return aaaaaaaa(aaaaaaan(str));
    }

    public static byte[] aaaaaaaa(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return bytes;
    }

    public static String aaaaaaac(String str) {
        try {
            byte[] bytes = str.getBytes("GBK");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 8);
            }
            return new String(bytes, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] aaaaaaan(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    public static String aaaaaaao(String str) {
        return TextUtils.isEmpty(str) ? str : aaaaaaaa(Base64.decode(str, 2));
    }

    public static String aaaaaaau(String str) {
        return TextUtils.isEmpty(str) ? str : Base64.encodeToString(aaaaaaaa(str), 2);
    }

    public static String aaaaaaaa(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 8);
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
