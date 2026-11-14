package com.fl.saas.config.utils;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.archives.tar.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Base64Utils {
    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, e.L, e.M, e.N, e.O, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, e.H, e.I, e.J, e.K, -1, -1, -1, -1, -1};

    public static byte[] decode(String str) {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes(CharEncoding.US_ASCII);
        int length = bytes.length;
        int i5 = 0;
        loop0: while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b = base64DecodeChars[bytes[i5]];
                if (i >= length || b != -1) {
                    break;
                }
                i5 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = base64DecodeChars[bytes[i]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            stringBuffer.append((char) ((b << 2) | ((b2 & e.H) >>> 4)));
            while (true) {
                i3 = i2 + 1;
                byte b5 = bytes[i2];
                if (b5 == 61) {
                    break loop0;
                }
                b3 = base64DecodeChars[b5];
                if (i3 >= length || b3 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b3 == -1) {
                break;
            }
            stringBuffer.append((char) (((b2 & 15) << 4) | ((b3 & 60) >>> 2)));
            while (true) {
                i4 = i3 + 1;
                byte b6 = bytes[i3];
                if (b6 == 61) {
                    break loop0;
                }
                b4 = base64DecodeChars[b6];
                if (i4 >= length || b4 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b4 == -1) {
                break;
            }
            stringBuffer.append((char) (b4 | ((b3 & 3) << 6)));
            i5 = i4;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }

    public static String encode(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte b = bArr[i];
            int i3 = b & 255;
            if (i2 == length) {
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[(b & 3) << 4]);
                str = "==";
            } else {
                int i4 = i + 2;
                byte b2 = bArr[i2];
                if (i4 == length) {
                    stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                    stringBuffer.append(base64EncodeChars[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                    stringBuffer.append(base64EncodeChars[(b2 & 15) << 2]);
                    str = "=";
                } else {
                    i += 3;
                    byte b3 = bArr[i4];
                    stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                    stringBuffer.append(base64EncodeChars[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                    stringBuffer.append(base64EncodeChars[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
                    stringBuffer.append(base64EncodeChars[b3 & 63]);
                }
            }
            stringBuffer.append(str);
            break;
        }
        return stringBuffer.toString();
    }

    public static String md5(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest((str + str2).getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = Constants.FAIL + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] safeUrlBase64Decode(String str) {
        String replace = str.replace(Soundex.SILENT_MARKER, '+').replace('_', '/');
        int length = replace.length() % 4;
        if (length > 0) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(replace);
            A4TApA2.append("====".substring(length));
            replace = A4TApA2.toString();
        }
        return decode(replace);
    }

    public static String safeUrlBase64Encode(byte[] bArr) {
        return encode(bArr).replace('+', Soundex.SILENT_MARKER).replace('/', '_').replaceAll("=", "");
    }
}
