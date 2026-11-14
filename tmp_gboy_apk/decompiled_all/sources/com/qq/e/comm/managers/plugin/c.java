package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final byte[] f12953A5SV6n = {82, com.sigmob.sdk.archives.tar.e.Q, 65, 47, 69, 67, 66, 47, 80, 75, 67, com.sigmob.sdk.archives.tar.e.Q, com.sigmob.sdk.archives.tar.e.I, 80, 97, 100, 100, 105, 110, com.sigmob.sdk.archives.tar.e.T};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final PublicKey f12954A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f12955A4TApA;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f12956a = new c();

        static {
            uHDAK();
        }

        private static /* synthetic */ void uHDAK() {
            char[] charArray = "l`b!hnbj!m`v!|gjcc!EafM}fkhj".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 15);
            }
            String str = new String(charArray);
            char[] charArray2 = "lcfaf{".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 15);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public c() {
        boolean z;
        try {
            this.f12954A2egSU = A2egSU();
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f12955A4TApA = z;
    }

    public static PublicKey A2egSU() {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB", 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static c a() {
        return b.f12956a;
    }

    public boolean a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.f12955A4TApA) {
            return true;
        }
        PublicKey publicKey = this.f12954A2egSU;
        if (publicKey != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance(new String(f12953A5SV6n, "UTF-8"));
                cipher.init(2, publicKey);
                str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable unused) {
            }
            return str2.equals(str3);
        }
        str3 = null;
        return str2.equals(str3);
    }

    public boolean a(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return a(str, d.a(file));
    }
}
