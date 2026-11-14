package PnmUpl;

import java.lang.reflect.Method;
import java.util.TimeZone;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final TimeZone f7426A2egSU = TimeZone.getTimeZone("UTC");

    static {
        Xlaj();
    }

    public static boolean A2egSU(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8 A[Catch: IllegalArgumentException -> 0x00d8, NumberFormatException -> 0x00db, IndexOutOfBoundsException -> 0x00de, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x00d8, IndexOutOfBoundsException -> 0x00de, NumberFormatException -> 0x00db, blocks: (B:3:0x0006, B:5:0x0019, B:6:0x001b, B:8:0x0027, B:9:0x0029, B:11:0x0038, B:13:0x003e, B:18:0x0053, B:20:0x0063, B:21:0x0065, B:23:0x0071, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:38:0x00a0, B:40:0x00a6, B:44:0x00b3, B:48:0x00be, B:53:0x00f2, B:55:0x00f8, B:59:0x01aa, B:65:0x010c, B:66:0x0125, B:67:0x0126, B:70:0x0143, B:72:0x0150, B:75:0x0159, B:77:0x0178, B:80:0x0187, B:81:0x01a9, B:82:0x0132, B:83:0x01dc, B:84:0x01e3, B:85:0x00ce, B:86:0x00d1, B:89:0x00ba), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01dc A[Catch: IllegalArgumentException -> 0x00d8, NumberFormatException -> 0x00db, IndexOutOfBoundsException -> 0x00de, TryCatch #2 {IllegalArgumentException -> 0x00d8, IndexOutOfBoundsException -> 0x00de, NumberFormatException -> 0x00db, blocks: (B:3:0x0006, B:5:0x0019, B:6:0x001b, B:8:0x0027, B:9:0x0029, B:11:0x0038, B:13:0x003e, B:18:0x0053, B:20:0x0063, B:21:0x0065, B:23:0x0071, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:38:0x00a0, B:40:0x00a6, B:44:0x00b3, B:48:0x00be, B:53:0x00f2, B:55:0x00f8, B:59:0x01aa, B:65:0x010c, B:66:0x0125, B:67:0x0126, B:70:0x0143, B:72:0x0150, B:75:0x0159, B:77:0x0178, B:80:0x0187, B:81:0x01a9, B:82:0x0132, B:83:0x01dc, B:84:0x01e3, B:85:0x00ce, B:86:0x00d1, B:89:0x00ba), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date A4TApA(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: PnmUpl.A2egSU.A4TApA(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int A5SV6n(int i, int i2, String str) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    private static /* synthetic */ void Xlaj() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
