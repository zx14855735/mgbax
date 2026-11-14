package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class f {
    private static final Pattern d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a, reason: collision with root package name */
    public final String f13720a;
    public final long b;
    public final boolean c;

    static {
        TAKSfoD();
    }

    public f(String str) {
        o.a(str);
        long a2 = a(str);
        this.b = Math.max(0L, a2);
        this.c = a2 >= 0;
        this.f13720a = b(str);
    }

    private static /* synthetic */ void TAKSfoD() {
        char[] charArray = "ÚÖÔ\u0097ÞØÔÜ\u0097ÛÖÀ\u0097ÊÑÜÕÕ\u0097ó×ÐûËÐÝÞÜ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 185);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÚÕÐ×ÐÍ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 185);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private long a(String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String b(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Invalid request `", str, "`: url not found!"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetRequest{rangeOffset=");
        sb.append(this.b);
        sb.append(", partial=");
        sb.append(this.c);
        sb.append(", uri='");
        return CtFAbx.B25kr6(sb, this.f13720a, "'}");
    }

    public static f a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new f(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }
}
