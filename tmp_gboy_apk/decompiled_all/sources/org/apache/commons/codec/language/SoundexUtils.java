package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.StringEncoder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class SoundexUtils {
    public static String clean(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isLetter(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        return i == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i).toUpperCase(Locale.ENGLISH);
    }

    public static int difference(StringEncoder stringEncoder, String str, String str2) {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    public static int differenceEncoded(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }
}
