package com.bytedance.msdk.f;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ht {
    private static final MessageDigest hf = xj();
    public static final Charset xj = Charset.forName("UTF-8");
    private static final char[] w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private ht() {
    }

    private static MessageDigest xj() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String xj(String str) {
        byte[] digest;
        MessageDigest messageDigest = hf;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(xj);
        synchronized (ht.class) {
            digest = messageDigest.digest(bytes);
        }
        return xj(digest);
    }

    public static String xj(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = w;
            cArr[i] = cArr2[(b & 240) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
