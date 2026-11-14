package com.octopus.ad.internal.a;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class e {
    private static final Pattern d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a, reason: collision with root package name */
    public final String f12389a;
    public final long b;
    public final boolean c;

    static {
        xnrjcpX();
    }

    public e(String str) {
        n.a(str);
        long a2 = a(str);
        this.b = Math.max(0L, a2);
        this.c = a2 >= 0;
        this.f12389a = b(str);
    }

    public static e a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new e(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Invalid request `", str, "`: url not found!"));
    }

    private static /* synthetic */ void xnrjcpX() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetRequest{rangeOffset=");
        sb.append(this.b);
        sb.append(", partial=");
        sb.append(this.c);
        sb.append(", uri='");
        return CtFAbx.B25kr6(sb, this.f12389a, "'}");
    }

    private long a(String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
