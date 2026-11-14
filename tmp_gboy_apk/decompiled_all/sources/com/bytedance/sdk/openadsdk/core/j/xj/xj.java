package com.bytedance.sdk.openadsdk.core.j.xj;

import com.kuaishou.weapon.p0.bi;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static String xj(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(".");
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            if (i2 > 0 && i2 % i == 0 && i2 != bArr.length - 1) {
                sb.append(bi.j);
            }
        }
        return sb.toString();
    }

    public static byte[] xj(String str) {
        String replaceAll = str.replaceAll("/", "").replaceAll("\\.", "");
        int length = replaceAll.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(replaceAll.charAt(i + 1), 16) + (Character.digit(replaceAll.charAt(i), 16) << 4));
        }
        return bArr;
    }
}
