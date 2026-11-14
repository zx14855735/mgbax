package org.apache.commons.codec.digest;

import java.nio.charset.StandardCharsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Crypt {
    public static String crypt(byte[] bArr) {
        return crypt(bArr, (String) null);
    }

    public static String crypt(byte[] bArr, String str) {
        return str == null ? Sha2Crypt.sha512Crypt(bArr) : str.startsWith("$6$") ? Sha2Crypt.sha512Crypt(bArr, str) : str.startsWith("$5$") ? Sha2Crypt.sha256Crypt(bArr, str) : str.startsWith("$1$") ? Md5Crypt.md5Crypt(bArr, str) : UnixCrypt.crypt(bArr, str);
    }

    public static String crypt(String str) {
        return crypt(str, (String) null);
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(StandardCharsets.UTF_8), str2);
    }
}
