package okhttp3.internal.http2;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z {
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] FLAGS = new String[64];
    static final String[] BINARY = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = BINARY;
            if (i2 >= strArr.length) {
                break;
            }
            Object[] objArr = {Integer.toBinaryString(i2)};
            byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
            strArr[i2] = String.format(Locale.US, "%8s", objArr).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = FLAGS;
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
            String[] strArr3 = FLAGS;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i6]);
            sb.append('|');
            strArr3[i7 | 8] = CtFAbx.B25kr6(sb, strArr3[i5], "|PADDED");
        }
        while (true) {
            String[] strArr4 = FLAGS;
            if (i >= strArr4.length) {
                CWwk();
                return;
            } else {
                if (strArr4[i] == null) {
                    strArr4[i] = BINARY[i];
                }
                i++;
            }
        }
    }

    private ARc23Z() {
    }

    public static String A2egSU(boolean z, int i, int i2, byte b, byte b2) {
        String format;
        String str;
        String[] strArr = FRAME_NAMES;
        if (b < strArr.length) {
            format = strArr[b];
        } else {
            Object[] objArr = {Byte.valueOf(b)};
            byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
            format = String.format(Locale.US, "0x%02x", objArr);
        }
        if (b2 == 0) {
            str = "";
        } else {
            if (b != 2 && b != 3) {
                if (b == 4 || b == 6) {
                    str = b2 == 1 ? "ACK" : BINARY[b2];
                } else if (b != 7 && b != 8) {
                    String[] strArr2 = FLAGS;
                    String str2 = b2 < strArr2.length ? strArr2[b2] : BINARY[b2];
                    str = (b != 5 || (b2 & 4) == 0) ? (b != 0 || (b2 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED") : str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            str = BINARY[b2];
        }
        Object[] objArr2 = {z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), format, str};
        byte[] bArr2 = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", objArr2);
    }

    public static void A4TApA(String str, Object... objArr) {
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static void A5SV6n(String str, Object... objArr) {
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    private static /* synthetic */ void CWwk() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
