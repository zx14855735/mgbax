package com.kwad.sdk.core.network.a;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bw;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static final Pattern aJZ = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String aKa = "UTF-8";
    private static OkHttpClient aKb = null;
    public static OkHttpClient aKc = Jy();

    static {
        UeOSGP();
    }

    public static OkHttpClient Jx() {
        if (!com.kwad.framework.a.a.oy.booleanValue()) {
            return aKc;
        }
        if (aKb == null) {
            aKb = aKc.newBuilder().build();
        }
        return aKb;
    }

    private static OkHttpClient Jy() {
        if (aKc == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectionSpecs = builder.connectTimeout(3000L, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            aKc = connectionSpecs.build();
        }
        return aKc;
    }

    private static /* synthetic */ void UeOSGP() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z, boolean z2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            if (z2) {
                a(url);
            }
            a(url, map);
            Response execute = Jx().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aIU = code;
            cVar.aIW = z ? a(execute) : "";
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBody = builder2.build();
        }
        if (builder == null || formBody == null) {
            return;
        }
        builder.post(formBody);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = Jx().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aIU = code;
            cVar.aIW = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap BI9f7h2 = A2egSU.BI9f7h("Accept-Language", "zh-CN");
        if (z) {
            BI9f7h2.put("Connection", "keep-alive");
        } else {
            BI9f7h2.put("Connection", "close");
        }
        BI9f7h2.put("Charset", "UTF-8");
        a(url);
        a(url, BI9f7h2);
        Response execute = Jx().newCall(url.build()).execute();
        int code = execute.code();
        cVar.code = code;
        cVar.aIU = code;
        if (execute.code() != 200) {
            throw new FileNotFoundException(str);
        }
        a(execute, outputStream, j, adHttpResponseListener);
        return true;
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

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.Ju());
        builder.addHeader("SystemUa", p.Jt());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = Jx().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aIU = code;
            cVar.aIW = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.aIV = exc;
        if (cVar.aIU == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = aJZ.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.aIU = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
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

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = Jx().newCall(post.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aIU = code;
            cVar.aIW = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    private static void a(Request.Builder builder, Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r4;
        InputStream inputStream3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            inputStream3 = new GZIPInputStream(inputStream);
                            inputStream2 = inputStream3;
                            break;
                        }
                    }
                }
                inputStream2 = null;
                inputStream3 = inputStream;
                try {
                    r4 = new InputStreamReader(inputStream3, aKa);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                } else {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    return sb.toString();
                                }
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r4 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                r4 = inputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStream2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    private static boolean a(Response response, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) {
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        long b;
        InputStream inputStream3;
        ?? bufferedInputStream;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                b = b(response);
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            inputStream3 = new GZIPInputStream(inputStream);
                            inputStream2 = inputStream3;
                            break;
                        }
                    }
                }
                inputStream2 = null;
                inputStream3 = inputStream;
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream3);
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStream2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
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
                    AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, b);
                } while (j2 <= j);
            } else if (j < 0) {
                r0 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                do {
                    int read2 = bufferedInputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    if (r0 != null) {
                        r0.write(bArr, 0, read2);
                    }
                    j2 += read2;
                } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, b));
                if (r0 != null) {
                    r0.flush();
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(r0);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            return true;
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            r0 = bufferedInputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(r0);
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }
}
