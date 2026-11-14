package com.sigmob.sdk.base;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.an;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13172a = "Cookie";
    private static final String b = "e";
    private static final CookieManager c = new CookieManager();

    static {
        hkCgy();
    }

    private static /* synthetic */ void hkCgy() {
        char[] charArray = "FJH\u000bBDH@\u000bGJ\\\u000bVM@II\u000boKLgWLAB@".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '%');
        }
        String str = new String(charArray);
        char[] charArray2 = "FILKLQ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '%');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public WebResourceResponse a(String str, String str2, Map<String, String> map) {
        List<String> list;
        String str3 = "UTF-8";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(str2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                for (String str4 : cookie.split(";")) {
                    httpURLConnection.addRequestProperty(f13172a.toLowerCase(), str4.replace(" ", ""));
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String contentType = httpURLConnection.getContentType();
            String contentEncoding = httpURLConnection.getContentEncoding();
            InputStream inputStream = httpURLConnection.getInputStream();
            a(httpURLConnection, c);
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if ((responseCode == 301 || responseCode == 302) && (list = headerFields.get("Location")) != null && list.size() > 0) {
                return a(list.get(0), an.c, null);
            }
            if (contentType != null) {
                contentType = contentType.split(";")[0];
                if (!contentType.contains(com.baidu.mobads.sdk.internal.a.b)) {
                    if (contentType.contains("javascript")) {
                    }
                }
                if (contentType.contains(an.e)) {
                    contentType = "text/html";
                }
                inputStream = a(inputStream, "UTF-8");
                WebResourceResponse webResourceResponse = new WebResourceResponse(contentType, str3, inputStream);
                webResourceResponse.setResponseHeaders(a(headerFields));
                return webResourceResponse;
            }
            inputStream = null;
            str3 = contentEncoding;
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(contentType, str3, inputStream);
            webResourceResponse2.setResponseHeaders(a(headerFields));
            return webResourceResponse2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static InputStream a(InputStream inputStream, String str) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        String str2 = new String(byteArrayOutputStream.toByteArray());
        if (str == null) {
            str = Charset.defaultCharset().displayName();
        }
        return new ByteArrayInputStream(str2.getBytes(str));
    }

    public static Map<String, String> a(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            sb.delete(0, sb.length());
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(";");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        headerFields.toString();
        List<String> list = headerFields.get("Set-Cookie");
        if (list == null) {
            return;
        }
        for (String str : list) {
            try {
                List<HttpCookie> parse = HttpCookie.parse(str);
                if (parse != null && !parse.isEmpty()) {
                    httpURLConnection.getURL().toString();
                    Objects.toString(parse.get(0));
                    for (HttpCookie httpCookie : parse) {
                        httpCookie.toString();
                        android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                    }
                }
            } catch (NullPointerException unused) {
                MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str);
            }
        }
        android.webkit.CookieManager.getInstance().flush();
    }
}
