package com.czhj.sdk.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.Constants;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AESUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10586a = 12;
    private static final int b = 128;
    private static volatile byte[] c;

    public static String DecryptString(String str, String str2) {
        return DecryptString(str, str2, Constants.GCMNONCE);
    }

    public static String DecryptStringServer(String str, String str2) {
        return DecryptString(str, str2, null);
    }

    public static byte[] Encrypt(byte[] bArr, String str) {
        return Encrypt(bArr, str, null);
    }

    public static String EncryptString(String str, String str2) {
        return EncryptString(str, str2, Constants.GCMNONCE);
    }

    public static String EncryptStringServer(String str, String str2) {
        return EncryptString(str, str2, null);
    }

    private static byte[] a(byte[] bArr, String str, int i, String str2) {
        if (bArr.length == 0 || TextUtils.isEmpty(str)) {
            return bArr;
        }
        byte[] decode = !TextUtils.isEmpty(str2) ? Base64.decode(str2, 2) : generateNonce();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, new SecretKeySpec(str.getBytes("utf-8"), "AES"), new GCMParameterSpec(128, decode));
        return cipher.doFinal(bArr);
    }

    public static synchronized byte[] generateNonce() {
        byte[] bArr;
        synchronized (AESUtil.class) {
            try {
                if (c == null) {
                    c = new byte[12];
                    new SecureRandom().nextBytes(c);
                }
                bArr = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    public static String DecryptString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return new String(a(Base64.decode(str.getBytes("utf-8"), 2), str2, 2, str3), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] Encrypt(byte[] bArr, String str, String str2) {
        if (bArr.length == 0 || TextUtils.isEmpty(str)) {
            return bArr;
        }
        try {
            return a(bArr, str, 1, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String EncryptString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return Base64.encodeToString(Encrypt(str.getBytes("utf-8"), str2, str3), 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
