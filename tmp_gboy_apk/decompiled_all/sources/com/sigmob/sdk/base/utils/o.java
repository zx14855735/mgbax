package com.sigmob.sdk.base.utils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o {
    public static String a(String str) {
        int i;
        if (a((CharSequence) str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt == '\\' && (i = i2 + 1) < str.length() && str.charAt(i) == 'u') {
                int i3 = i2 + 2;
                int i4 = i2 + 6;
                try {
                    sb.append((char) Integer.parseInt(str.substring(i3, i4), 16));
                    i = i4;
                } catch (NumberFormatException unused) {
                    sb.append(charAt);
                }
                i2 = i;
            } else {
                sb.append(charAt);
                i2++;
            }
        }
        return sb.toString();
    }

    public static boolean b(CharSequence charSequence) {
        return !a(charSequence);
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return !a(charSequence, charSequence2);
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence != null && charSequence.equals(charSequence2);
    }

    public static boolean a(String str, String str2) {
        return str != null && str.equalsIgnoreCase(str2);
    }
}
