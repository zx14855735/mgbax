package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class d {
    private static final Pattern aPG = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aPH = Pattern.compile("GET /(.*) HTTP");
    public final long aPI;
    public final boolean aPJ;
    public final String uri;

    static {
        cFGgZMR();
    }

    private d(String str) {
        ax.hy(str);
        long eX = eX(str);
        this.aPI = Math.max(0L, eX);
        this.aPJ = eX >= 0;
        this.uri = eY(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private static /* synthetic */ void cFGgZMR() {
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

    private static long eX(String str) {
        Matcher matcher = aPG.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eY(String str) {
        Matcher matcher = aPH.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Invalid request `", str, "`: url not found!"));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetRequest{rangeOffset=");
        sb.append(this.aPI);
        sb.append(", partial=");
        sb.append(this.aPJ);
        sb.append(", uri='");
        return CtFAbx.B25kr6(sb, this.uri, "'}");
    }
}
