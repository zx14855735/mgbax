package com.bytedance.sdk.openadsdk.core.pl.u;

import android.text.TextUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {

    public static class xj {
        public Map<String, String> hf;
        public HttpURLConnection u;
        public int w;
        public InputStream xj;

        public xj(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.xj = inputStream;
            this.hf = map;
            this.w = i;
            this.u = httpURLConnection;
        }
    }

    public static HttpURLConnection xj(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? xj(httpURLConnection.getHeaderField("Location"), map) : httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Map<String, String> xj(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }

    public static xj xj(String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                hashMap.put(wVar.xj(), wVar.hf());
            }
        }
        HttpURLConnection xj2 = xj(str, hashMap);
        if (xj2 == null || (responseCode = xj2.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> xj3 = xj(xj2);
        InputStream inputStream = xj2.getInputStream();
        String contentEncoding = xj2.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new xj(inputStream, xj3, responseCode, xj2);
    }
}
