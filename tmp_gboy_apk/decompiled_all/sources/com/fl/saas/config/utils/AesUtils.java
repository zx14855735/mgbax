package com.fl.saas.config.utils;

import android.annotation.SuppressLint;
import com.czhj.sdk.common.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.language.Soundex;

@SuppressLint({"NewApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AesUtils {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM2 = "AES/ECB/PKCS5Padding";
    private static final String IV = "ABCDEF1234567890";
    private static final String KEY = "!@#_123_sda_12!_";

    public static String decrypt(String str) {
        return decrypt(str, KEY, IV, ALGORITHM);
    }

    public static String decryptHex(String str) {
        return decryptHex(str, KEY, IV, ALGORITHM);
    }

    public static String encrypt(String str) {
        return encrypt(str, KEY, IV, ALGORITHM);
    }

    public static String encrypt2(String str, String str2) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM2);
            cipher.init(1, secretKeySpec);
            return Base64Utils.safeUrlBase64Encode(cipher.doFinal(str.getBytes(charset))).replace('+', Soundex.SILENT_MARKER).replace('/', '_').replaceAll("=", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encryptHex(String str) {
        return encryptHex(str, KEY, IV, ALGORITHM);
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = Constants.FAIL.concat(hexString);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static String decrypt(String str, String str2) {
        return decrypt(str, str2, ALGORITHM);
    }

    public static String decryptHex(String str, String str2) {
        return decryptHex(str, str2, ALGORITHM);
    }

    public static String encrypt(String str, String str2) {
        return encrypt(str, str2, ALGORITHM);
    }

    public static String encryptHex(String str, String str2) {
        return encryptHex(str, str2, ALGORITHM);
    }

    public static String decrypt(String str, String str2, String str3) {
        return decrypt(str, str2, (String) null, str3);
    }

    public static String decryptHex(String str, String str2, String str3) {
        return decryptHex(str, str2, null, str3);
    }

    public static String encrypt(String str, String str2, String str3) {
        return encrypt(str, str2, (String) null, str3);
    }

    public static String encryptHex(String str, String str2, String str3) {
        return encryptHex(str, str2, null, ALGORITHM);
    }

    public static String decrypt(String str, String str2, String str3, String str4) {
        byte[] bytes = str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null;
        try {
            byte[] safeUrlBase64Decode = Base64Utils.safeUrlBase64Decode(str);
            Charset charset = StandardCharsets.UTF_8;
            byte[] decrypt = decrypt(safeUrlBase64Decode, str2.getBytes(charset), bytes, str4);
            Objects.requireNonNull(decrypt);
            return new String(decrypt, charset);
        } catch (UnsupportedEncodingException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decryptHex(String str, String str2, String str3, String str4) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "AES");
            Cipher cipher = Cipher.getInstance(str4);
            if (str3 != null) {
                cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes(charset)));
            } else {
                cipher.init(2, secretKeySpec);
            }
            return new String(cipher.doFinal(parseHexStr2Byte(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2, String str3, String str4) {
        byte[] bytes = str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null;
        Charset charset = StandardCharsets.UTF_8;
        return encrypt(str.getBytes(charset), str2.getBytes(charset), bytes, str4);
    }

    public static String encryptHex(String str, String str2, String str3, String str4) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "AES");
            Cipher cipher = Cipher.getInstance(str4);
            if (str3 != null) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes(charset)));
            } else {
                cipher.init(1, secretKeySpec);
            }
            return parseByte2HexStr(cipher.doFinal(str.getBytes(charset)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String str, byte[] bArr, String str2) {
        try {
            return new String(decrypt(Base64Utils.safeUrlBase64Decode(str), bArr, (byte[]) null, str2), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(str);
            if (bArr3 != null) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            } else {
                cipher.init(1, secretKeySpec);
            }
            return Base64Utils.safeUrlBase64Encode(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(str);
            if (bArr3 != null) {
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            } else {
                cipher.init(2, secretKeySpec);
            }
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
