package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class p {
    private static String aJV = "";
    private static String aJW = "";

    public static String Jt() {
        try {
            if (!TextUtils.isEmpty(aJV)) {
                return aJV;
            }
            String property = System.getProperty("http.agent");
            aJV = property;
            if (TextUtils.isEmpty(property)) {
                return aJV;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aJV.length();
            for (int i = 0; i < length; i++) {
                char charAt = aJV.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            aJV = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Ju() {
        String dj;
        if (!TextUtils.isEmpty(aJW)) {
            return aJW;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            dj = ag.dj(context);
            aJW = dj;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(dj)) {
            return aJW;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        aJW = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        aJW = encode;
        ag.an(context, encode);
        return aJW;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", Ju());
        httpURLConnection.setRequestProperty("SystemUa", Jt());
    }

    private static String getDefaultUserAgent() {
        return Jt() + "-ksad-android-4.9.20.1";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }
}
