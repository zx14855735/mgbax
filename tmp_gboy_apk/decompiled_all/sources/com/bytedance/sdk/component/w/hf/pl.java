package com.bytedance.sdk.component.w.hf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.ADYaiT;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class pl {
    private final long c;
    private final String d;
    private final String f;
    private final boolean g;
    private final String kd;
    private final boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private final boolean f10226pl;
    private final boolean tf;
    private final String y;
    private static final Pattern xj = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern hf = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern w = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern u = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    static {
        IYONF();
    }

    private pl(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.kd = str;
        this.y = str2;
        this.c = j;
        this.f = str3;
        this.d = str4;
        this.tf = z;
        this.p = z2;
        this.g = z3;
        this.f10226pl = z4;
    }

    private static /* synthetic */ void IYONF() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pl)) {
            return false;
        }
        pl plVar = (pl) obj;
        return plVar.kd.equals(this.kd) && plVar.y.equals(this.y) && plVar.f.equals(this.f) && plVar.d.equals(this.d) && plVar.c == this.c && plVar.tf == this.tf && plVar.p == this.p && plVar.f10226pl == this.f10226pl && plVar.g == this.g;
    }

    public int hashCode() {
        int A2egSU2 = A2egSU.A2egSU(A2egSU.A2egSU(A2egSU.A2egSU(A2egSU.A2egSU(527, 31, this.kd), 31, this.y), 31, this.f), 31, this.d);
        long j = this.c;
        return ((((((((A2egSU2 + ((int) (j ^ (j >>> 32)))) * 31) + (!this.tf ? 1 : 0)) * 31) + (!this.p ? 1 : 0)) * 31) + (!this.f10226pl ? 1 : 0)) * 31) + (!this.g ? 1 : 0);
    }

    public String hf() {
        return this.y;
    }

    public String toString() {
        return xj(false);
    }

    public String xj() {
        return this.kd;
    }

    private static String hf(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(str);
        if (xj2 != null) {
            return xj2;
        }
        throw new IllegalArgumentException();
    }

    private static boolean xj(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.w.hf.xj.w.w(str);
    }

    public static pl xj(v vVar, String str) {
        return xj(System.currentTimeMillis(), vVar, str);
    }

    public static pl xj(long j, v vVar, String str) {
        long j2;
        String str2;
        int length = str.length();
        char c = ';';
        int xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(str, 0, length, ';');
        int xj3 = com.bytedance.sdk.component.w.hf.xj.w.xj(str, 0, xj2, '=');
        String str3 = null;
        if (xj3 == xj2) {
            return null;
        }
        String w2 = com.bytedance.sdk.component.w.hf.xj.w.w(str, 0, xj3);
        if (w2.isEmpty() || com.bytedance.sdk.component.w.hf.xj.w.hf(w2) != -1) {
            return null;
        }
        String w3 = com.bytedance.sdk.component.w.hf.xj.w.w(str, xj3 + 1, xj2);
        if (com.bytedance.sdk.component.w.hf.xj.w.hf(w3) != -1) {
            return null;
        }
        int i = xj2 + 1;
        String str4 = null;
        long j3 = 253402300799999L;
        long j4 = -1;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (i < length) {
            int xj4 = com.bytedance.sdk.component.w.hf.xj.w.xj(str, i, length, c);
            int xj5 = com.bytedance.sdk.component.w.hf.xj.w.xj(str, i, xj4, '=');
            String w4 = com.bytedance.sdk.component.w.hf.xj.w.w(str, i, xj5);
            String w5 = xj5 < xj4 ? com.bytedance.sdk.component.w.hf.xj.w.w(str, xj5 + 1, xj4) : "";
            if (w4.equalsIgnoreCase("expires")) {
                try {
                    j3 = xj(w5, 0, w5.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (w4.equalsIgnoreCase("max-age")) {
                j4 = xj(w5);
            } else {
                if (w4.equalsIgnoreCase("domain")) {
                    str3 = hf(w5);
                    z = false;
                } else if (w4.equalsIgnoreCase("path")) {
                    str4 = w5;
                } else if (w4.equalsIgnoreCase("secure")) {
                    z3 = true;
                } else if (w4.equalsIgnoreCase("httponly")) {
                    z4 = true;
                }
                i = xj4 + 1;
                c = ';';
            }
            z2 = true;
            i = xj4 + 1;
            c = ';';
        }
        if (j4 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j4 != -1) {
            long j5 = j + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
            j2 = (j5 < j || j5 > ADYaiT.MAX_DATE) ? 253402300799999L : j5;
        } else {
            j2 = j3;
        }
        String c2 = vVar.c();
        if (str3 == null) {
            str2 = c2;
        } else {
            if (!xj(c2, str3)) {
                return null;
            }
            str2 = str3;
        }
        if (c2.length() != str2.length() && com.bytedance.sdk.component.w.hf.xj.f.xj.xj().xj(str2) == null) {
            return null;
        }
        String str5 = "/";
        if (str4 == null || !str4.startsWith("/")) {
            String d = vVar.d();
            int lastIndexOf = d.lastIndexOf(47);
            if (lastIndexOf != 0) {
                str5 = d.substring(0, lastIndexOf);
            }
            str4 = str5;
        }
        return new pl(w2, w3, j2, str2, str4, z3, z4, z, z2);
    }

    private static long xj(String str, int i, int i2) {
        int xj2 = xj(str, i, i2, false);
        Matcher matcher = u.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (xj2 < i2) {
            int xj3 = xj(str, xj2 + 1, i2, true);
            matcher.region(xj2, xj3);
            if (i4 == -1 && matcher.usePattern(u).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(w).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = hf;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(xj).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            xj2 = xj(str, xj3 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        if (i8 >= 0 && i8 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.w.hf.xj.w.c);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int xj(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long xj(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public static List<pl> xj(v vVar, yo yoVar) {
        List<String> hf2 = yoVar.hf("Set-Cookie");
        int size = hf2.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            pl xj2 = xj(vVar, hf2.get(i));
            if (xj2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(xj2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    public String xj(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.kd);
        sb.append('=');
        sb.append(this.y);
        if (this.f10226pl) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.component.w.hf.xj.w.u.xj(new Date(this.c)));
            }
        }
        if (!this.g) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f);
        }
        sb.append("; path=");
        sb.append(this.d);
        if (this.tf) {
            sb.append("; secure");
        }
        if (this.p) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
