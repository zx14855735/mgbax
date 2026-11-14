package com.bytedance.pangle.util;

import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class y {
    private static final char[] xj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String hf(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = xj;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String xj(String str) {
        return xj(str.getBytes());
    }

    public static String xj(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return hf(messageDigest.digest());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String xj(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = fileInputStream.read(bArr, 0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return hf(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
