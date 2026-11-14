package com.bytedance.sdk.component.w.hf.xj.kd;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class kd {
    static final com.bytedance.sdk.component.w.xj.y xj = com.bytedance.sdk.component.w.xj.y.xj("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] u = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] hf = new String[64];
    static final String[] w = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = w;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.bytedance.sdk.component.w.hf.xj.w.xj("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = hf;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = hf;
            strArr3[i4 | 8] = CtFAbx.B25kr6(new StringBuilder(), strArr3[i4], "|PADDED");
        }
        String[] strArr4 = hf;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = hf;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i8]);
                sb.append('|');
                strArr5[i9 | 8] = CtFAbx.B25kr6(sb, strArr5[i6], "|PADDED");
            }
        }
        while (true) {
            String[] strArr6 = hf;
            if (i >= strArr6.length) {
                kmXRHXc();
                return;
            } else {
                if (strArr6[i] == null) {
                    strArr6[i] = w[i];
                }
                i++;
            }
        }
    }

    private kd() {
    }

    public static IOException hf(String str, Object... objArr) {
        throw new IOException(com.bytedance.sdk.component.w.hf.xj.w.xj(str, objArr));
    }

    private static /* synthetic */ void kmXRHXc() {
        char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 198);
        }
        String str = new String(charArray);
        char[] charArray2 = "¥ª¯¨¯²".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 198);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static IllegalArgumentException xj(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.w.hf.xj.w.xj(str, objArr));
    }

    public static String xj(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = u;
        return com.bytedance.sdk.component.w.hf.xj.w.xj("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), b < strArr.length ? strArr[b] : com.bytedance.sdk.component.w.hf.xj.w.xj("0x%02x", Byte.valueOf(b)), xj(b, b2));
    }

    public static String xj(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : w[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = hf;
                String str = b2 < strArr.length ? strArr[b2] : w[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return w[b2];
    }
}
