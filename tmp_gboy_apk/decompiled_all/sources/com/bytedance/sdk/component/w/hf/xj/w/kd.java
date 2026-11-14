package com.bytedance.sdk.component.w.hf.xj.w;

import com.bytedance.sdk.component.w.hf.g;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.v;
import com.bytedance.sdk.component.w.hf.yo;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class kd {
    private static final Pattern xj = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    static {
        zFLYSb();
    }

    public static Set<String> hf(yo yoVar) {
        Set<String> set = Collections.EMPTY_SET;
        int xj2 = yoVar.xj();
        for (int i = 0; i < xj2; i++) {
            if ("Vary".equalsIgnoreCase(yoVar.xj(i))) {
                String hf = yoVar.hf(i);
                if (set.isEmpty()) {
                    set = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : hf.split(",")) {
                    set.add(str.trim());
                }
            }
        }
        return set;
    }

    public static boolean w(q qVar) {
        if (qVar.xj().hf().equals(com.sigmob.sdk.downloader.core.c.f13360a)) {
            return false;
        }
        int w = qVar.w();
        return (((w >= 100 && w < 200) || w == 204 || w == 304) && xj(qVar) == -1 && !"chunked".equalsIgnoreCase(qVar.xj(com.sigmob.sdk.downloader.core.c.h))) ? false : true;
    }

    public static long xj(q qVar) {
        return xj(qVar.c());
    }

    private static /* synthetic */ void zFLYSb() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static long xj(yo yoVar) {
        return xj(yoVar.xj(com.sigmob.sdk.downloader.core.c.e));
    }

    private static long xj(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static yo xj(yo yoVar, yo yoVar2) {
        Set<String> hf = hf(yoVar2);
        if (hf.isEmpty()) {
            return new yo.xj().xj();
        }
        yo.xj xjVar = new yo.xj();
        int xj2 = yoVar.xj();
        for (int i = 0; i < xj2; i++) {
            String xj3 = yoVar.xj(i);
            if (hf.contains(xj3)) {
                xjVar.xj(xj3, yoVar.hf(i));
            }
        }
        return xjVar.xj();
    }

    public static yo hf(q qVar) {
        return xj(qVar.tf().xj().w(), qVar.c());
    }

    public static int hf(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void xj(g gVar, v vVar, yo yoVar) {
        if (gVar == g.xj) {
            return;
        }
        com.bytedance.sdk.component.w.hf.pl.xj(vVar, yoVar).isEmpty();
    }

    public static int xj(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int xj(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }
}
