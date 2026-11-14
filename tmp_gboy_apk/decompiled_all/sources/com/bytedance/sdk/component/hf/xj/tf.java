package com.bytedance.sdk.component.hf.xj;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class tf {
    private final String kd;
    private final String u;
    private final String w;
    private final String y;
    private static final Pattern xj = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern hf = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    static {
        gmuv();
    }

    public tf(String str, String str2, String str3, String str4) {
        this.w = str;
        this.u = str2;
        this.kd = str3;
        this.y = str4;
    }

    private static /* synthetic */ void gmuv() {
        char[] charArray = "ÑÝß\u009cÕÓß×\u009cÐÝË\u009cÁÚ×ÞÞ\u009cøÜÛðÀÛÖÕ×".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 178);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÑÞÛÜÛÆ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 178);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static tf xj(String str) {
        Matcher matcher = xj.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = group.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = hf.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = CtFAbx.AMqCpz(1, 1, group3);
                }
                if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group3;
            }
        }
        return new tf(str, lowerCase, lowerCase2, str2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof tf) && ((tf) obj).w.equals(this.w);
    }

    public int hashCode() {
        return this.w.hashCode();
    }

    public String hf() {
        return this.kd;
    }

    public String toString() {
        return this.w;
    }

    public Charset w() {
        return xj((Charset) null);
    }

    public String xj() {
        return this.u;
    }

    public Charset xj(Charset charset) {
        try {
            String str = this.y;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
