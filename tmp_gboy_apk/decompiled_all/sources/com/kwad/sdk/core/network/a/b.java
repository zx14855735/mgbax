package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bw;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z, boolean z2) {
        InputStream inputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection2);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.setRequestMethod(an.c);
                httpURLConnection2.setRequestProperty("Accept", an.d);
                if (z2) {
                    p.b(httpURLConnection2);
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.aIU = responseCode;
                StringBuilder sb = new StringBuilder();
                if (z) {
                    inputStream2 = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                }
                cVar.aIW = sb.toString();
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                return cVar;
            } catch (Exception e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                InputStream inputStream4 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private static long c(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null && "content-length".equals(key.toLowerCase())) {
                try {
                    return Long.parseLong(entry.getValue().get(0));
                } catch (Throwable unused) {
                }
            }
        }
        return -1L;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                A2egSU.BIYEnU(sb, entry.getKey(), "=", encode(entry.getValue()), "&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                if (z) {
                    httpURLConnection.setRequestProperty("Connection", "keep-alive");
                } else {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                p.b(httpURLConnection);
                long c = c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    long j2 = 0;
                    if (j > 0) {
                        do {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            j2 += read;
                            AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, c);
                        } while (j2 <= j);
                    } else if (j < 0) {
                        r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                        do {
                            int read2 = bufferedInputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            if (r2 != null) {
                                r2.write(bArr, 0, read2);
                            }
                            j2 += read2;
                        } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, c));
                        if (r2 != null) {
                            r2.flush();
                        }
                    }
                    AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
                    com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    httpURLConnection.disconnect();
                    return true;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod(an.b);
                if (z) {
                    httpURLConnection2.setRequestProperty("Content-Type", an.d);
                } else {
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                p.b(httpURLConnection2);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection2.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.aIU = responseCode;
                if (responseCode == 200) {
                    cVar.aIW = inputStream2String(httpURLConnection2.getInputStream());
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
                return cVar;
            } catch (Exception e) {
                e = e;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i = cVar.code;
        if (i == 0) {
            i = -1;
        }
        cVar.aIU = i;
        cVar.aIV = exc;
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.aIX;
            cVar.code = eVar.errorCode;
            cVar.aIW = eVar.msg;
        } else {
            cVar.code = e.aIY.errorCode;
            cVar.aIW = e.aIY.msg + "/" + bw.r(exc);
        }
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }
}
