package com.czhj.volley.toolbox;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import com.czhj.volley.Header;
import com.czhj.volley.Request;
import com.sigmob.sdk.downloader.core.c;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HurlStack extends BaseHttpStack {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10646a = 100;
    private final UrlRewriter b;
    private final SSLSocketFactory c;

    public static class UrlConnectionInputStream extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f10647a;

        public UrlConnectionInputStream(HttpURLConnection httpURLConnection) {
            super(HurlStack.b(httpURLConnection));
            this.f10647a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f10647a.disconnect();
        }
    }

    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        UrlRewriter urlRewriter = this.b;
        if (urlRewriter != null) {
            String rewriteUrl = urlRewriter.rewriteUrl(url);
            if (rewriteUrl == null) {
                throw new IOException(CtFAbx.BChYOn("URL blocked by rewriter: ", url));
            }
            url = rewriteUrl;
        }
        HttpURLConnection a2 = a(new URL(url), request);
        try {
            for (String str : hashMap.keySet()) {
                a2.setRequestProperty(str, (String) hashMap.get(str));
            }
            a(a2, request);
            int responseCode = a2.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (a(request.getMethod(), responseCode)) {
                return new HttpResponse(responseCode, a(a2.getHeaderFields()), a2.getContentLength(), new UrlConnectionInputStream(a2));
            }
            HttpResponse httpResponse = new HttpResponse(responseCode, a(a2.getHeaderFields()));
            a2.disconnect();
            return httpResponse;
        } catch (Throwable th) {
            if (0 == 0) {
                a2.disconnect();
            }
            throw th;
        }
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    private HttpURLConnection a(URL url, Request<?> request) {
        HttpURLConnection createConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        createConnection.setConnectTimeout(request.getConnectTimeoutMs());
        createConnection.setReadTimeout(timeoutMs);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        return createConnection;
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) {
        byte[] body = request.getBody();
        if (body != null) {
            a(httpURLConnection, request, body);
        }
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.b = urlRewriter;
        this.c = sSLSocketFactory;
    }

    public static List<Header> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static void a(HttpURLConnection httpURLConnection, Request<?> request) {
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    httpURLConnection.setRequestMethod(an.b);
                    a(httpURLConnection, request, body);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(an.c);
                return;
            case 1:
                httpURLConnection.setRequestMethod(an.b);
                b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod(c.f13360a);
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static boolean a(int i, int i2) {
        if (i != 4) {
            return ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
        }
        return false;
    }
}
