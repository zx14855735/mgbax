package GIl1rw;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final char[] f3027A2egSU = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    static {
        fOLJlr();
    }

    public static int A2egSU(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'G';
        }
        if (c >= '0' && c <= '9') {
            return c + 4;
        }
        if (c == '+') {
            return 62;
        }
        if (c == '/') {
            return 63;
        }
        if (c == '=') {
            return 0;
        }
        throw new RuntimeException("unexpected code: " + c);
    }

    public static String A4TApA(byte[] bArr) {
        char[] cArr;
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        loop0: while (true) {
            int i3 = 0;
            while (true) {
                cArr = f3027A2egSU;
                if (i2 > i) {
                    break loop0;
                }
                int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                stringBuffer.append(cArr[(i4 >> 18) & 63]);
                stringBuffer.append(cArr[(i4 >> 12) & 63]);
                stringBuffer.append(cArr[(i4 >> 6) & 63]);
                stringBuffer.append(cArr[i4 & 63]);
                i2 += 3;
                int i5 = i3 + 1;
                if (i3 >= 14) {
                    break;
                }
                i3 = i5;
            }
            stringBuffer.append("");
        }
        if (i2 == length - 2) {
            int i6 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            stringBuffer.append(cArr[(i6 >> 18) & 63]);
            stringBuffer.append(cArr[(i6 >> 12) & 63]);
            stringBuffer.append(cArr[(i6 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == length - 1) {
            int i7 = (bArr[i2] & 255) << 16;
            stringBuffer.append(cArr[(i7 >> 18) & 63]);
            stringBuffer.append(cArr[(i7 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static void A5SV6n(String str, ByteArrayOutputStream byteArrayOutputStream) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else {
                if (i == length) {
                    return;
                }
                int i2 = i + 2;
                int i3 = i + 3;
                int A2egSU2 = A2egSU(str.charAt(i3)) + (A2egSU(str.charAt(i)) << 18) + (A2egSU(str.charAt(i + 1)) << 12) + (A2egSU(str.charAt(i2)) << 6);
                byteArrayOutputStream.write((A2egSU2 >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                byteArrayOutputStream.write((A2egSU2 >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                byteArrayOutputStream.write(A2egSU2 & 255);
                i += 4;
            }
        }
    }

    public static byte[] ADYaiT(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            A5SV6n(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return byteArray;
        } catch (IOException unused2) {
            throw new RuntimeException();
        }
    }

    private static /* synthetic */ void fOLJlr() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
