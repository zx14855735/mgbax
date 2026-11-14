package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaau {
    static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] aaaaaaa0 = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] aaaaaaao = new String[64];
    static final String[] aaaaaaac = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = aaaaaaac;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = aaaaaaao;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = CtFAbx.B25kr6(new StringBuilder(), strArr2[i3], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = aaaaaaao;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i6]);
            sb.append('|');
            strArr3[i7 | 8] = CtFAbx.B25kr6(sb, strArr3[i5], "|PADDED");
        }
        while (true) {
            String[] strArr4 = aaaaaaao;
            if (i >= strArr4.length) {
                LVmZX();
                return;
            } else {
                if (strArr4[i] == null) {
                    strArr4[i] = aaaaaaac[i];
                }
                i++;
            }
        }
    }

    private static /* synthetic */ void LVmZX() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static IOException aaaaaaa0(String str, Object... objArr) {
        throw new IOException(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, objArr));
    }

    public static IllegalArgumentException aaaaaaaa(String str, Object... objArr) {
        throw new IllegalArgumentException(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, objArr));
    }

    public static String aaaaaaaa(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = aaaaaaa0;
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), b < strArr.length ? strArr[b] : io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("0x%02x", Byte.valueOf(b)), aaaaaaaa(b, b2));
    }

    public static String aaaaaaaa(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : aaaaaaac[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = aaaaaaao;
                String str = b2 < strArr.length ? strArr[b2] : aaaaaaac[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return aaaaaaac[b2];
    }
}
