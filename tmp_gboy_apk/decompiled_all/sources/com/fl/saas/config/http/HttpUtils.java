package com.fl.saas.config.http;

import Dphsd2.AlLFFp;
import H0qugq.A4TApA;
import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.sigmob.sdk.downloader.core.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class HttpUtils {
    public static final int MAX_REDIRECTION = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #1 {all -> 0x0016, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x0029, B:9:0x002f, B:11:0x0039, B:12:0x0045, B:14:0x004b, B:16:0x0061, B:18:0x0076, B:20:0x0081, B:21:0x008d, B:23:0x0093, B:25:0x0097, B:26:0x009d, B:30:0x00aa, B:32:0x00b2, B:33:0x00c1, B:34:0x0022, B:51:0x00e6, B:43:0x00fc), top: B:2:0x0001, inners: #4, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$doGet$0(java.lang.String r6, com.fl.saas.config.http.HttpCallbackStringListener r7) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.config.http.HttpUtils.lambda$doGet$0(java.lang.String, com.fl.saas.config.http.HttpCallbackStringListener):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #1 {all -> 0x0045, blocks: (B:3:0x000d, B:5:0x0024, B:7:0x002f, B:8:0x003b, B:10:0x0041, B:12:0x004e, B:13:0x0054, B:17:0x0061, B:19:0x0069, B:20:0x0078, B:37:0x0098, B:29:0x00ae), top: B:2:0x000d, inners: #4, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$doGet$1(java.lang.String r6, com.fl.saas.config.http.HttpCallbackStringListener r7) {
        /*
            r5 = this;
            java.lang.String r0 = "response err code:"
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r1.<init>()
            r2 = 10
            r1.set(r2)
            r2 = 0
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r3 = 0
            java.net.HttpURLConnection r2 = r5.innerRequest(r6, r3, r1)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.lang.String r6 = "GET"
            r2.setRequestMethod(r6)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            int r6 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r1 = 200(0xc8, float:2.8E-43)
            if (r6 != r1) goto L61
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r6.<init>()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.io.InputStream r0 = r2.getInputStream()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            if (r0 == 0) goto L54
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.lang.String r4 = "UTF-8"
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
        L3b:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            if (r3 == 0) goto L4e
            r6.append(r3)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            goto L3b
        L45:
            r6 = move-exception
            goto Lb7
        L48:
            r6 = move-exception
            goto L96
        L4a:
            r6 = move-exception
            goto Lac
        L4c:
            r6 = move-exception
            goto Lac
        L4e:
            r1.close()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r0.close()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
        L54:
            com.fl.saas.config.http.ResponseCall r0 = new com.fl.saas.config.http.ResponseCall     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r0.doSuccess(r6)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            goto Lbf
        L61:
            int r6 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r1 = 302(0x12e, float:4.23E-43)
            if (r6 != r1) goto L78
            java.lang.String r6 = "Location"
            java.lang.String r6 = r2.getHeaderField(r6)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            com.fl.saas.config.http.ResponseCall r0 = new com.fl.saas.config.http.ResponseCall     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r0.doJump(r6)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            goto Lbf
        L78:
            com.fl.saas.config.http.ResponseCall r6 = new com.fl.saas.config.http.ResponseCall     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            android.accounts.NetworkErrorException r1 = new android.accounts.NetworkErrorException     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            int r0 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r3.append(r0)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            r6.doFail(r1)     // Catch: java.lang.Throwable -> L45 java.lang.OutOfMemoryError -> L48 java.lang.ArrayIndexOutOfBoundsException -> L4a java.io.IOException -> L4c
            goto Lbf
        L96:
            if (r7 == 0) goto La9
            com.fl.saas.config.http.ResponseCall r0 = new com.fl.saas.config.http.ResponseCall     // Catch: java.lang.Throwable -> L45
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L45
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L45
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L45
            r0.doFail(r7)     // Catch: java.lang.Throwable -> L45
        La9:
            if (r2 == 0) goto Lc2
            goto Lbf
        Lac:
            if (r7 == 0) goto Lbd
            com.fl.saas.config.http.ResponseCall r0 = new com.fl.saas.config.http.ResponseCall     // Catch: java.lang.Throwable -> L45
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L45
            r0.doFail(r6)     // Catch: java.lang.Throwable -> L45
            goto Lbd
        Lb7:
            if (r2 == 0) goto Lbc
            r2.disconnect()
        Lbc:
            throw r6
        Lbd:
            if (r2 == 0) goto Lc2
        Lbf:
            r2.disconnect()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.config.http.HttpUtils.lambda$doGet$1(java.lang.String, com.fl.saas.config.http.HttpCallbackStringListener):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doGet$2(String str, HttpCallbackBytesListener httpCallbackBytesListener) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (getHeaders() != null && !getHeaders().isEmpty()) {
                    for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod(an.c);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() != 200) {
                    new ResponseCall(httpCallbackBytesListener).doFail(new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                        bufferedInputStream.close();
                        inputStream.close();
                    }
                    new ResponseCall(httpCallbackBytesListener).doSuccess(byteArrayOutputStream.toByteArray());
                }
            } catch (Exception e) {
                if (httpCallbackBytesListener != null) {
                    new ResponseCall(httpCallbackBytesListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e2) {
                if (httpCallbackBytesListener != null) {
                    new ResponseCall(httpCallbackBytesListener).doFail(new Exception(e2.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0148 A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #2 {all -> 0x0018, blocks: (B:3:0x0003, B:5:0x0010, B:8:0x002d, B:10:0x0033, B:11:0x003b, B:13:0x0041, B:15:0x0057, B:17:0x0072, B:19:0x007c, B:20:0x0088, B:22:0x008e, B:24:0x00a4, B:26:0x00d8, B:28:0x00e3, B:29:0x00ed, B:31:0x00f3, B:33:0x00f7, B:34:0x00fd, B:38:0x010a, B:39:0x0024, B:57:0x012f, B:47:0x0143, B:49:0x0148), top: B:2:0x0003, inners: #4, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$doPost$3(java.lang.String r5, java.util.Map r6, java.lang.String r7, com.fl.saas.config.http.HttpCallbackStringListener r8) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.config.http.HttpUtils.lambda$doPost$3(java.lang.String, java.util.Map, java.lang.String, com.fl.saas.config.http.HttpCallbackStringListener):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$uploadFile$4(java.lang.String r10, java.io.File[] r11, com.fl.saas.config.http.HttpCallbackStringListener r12) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.config.http.HttpUtils.lambda$uploadFile$4(java.lang.String, java.io.File[], com.fl.saas.config.http.HttpCallbackStringListener):void");
    }

    public SSLContext createSSLContext() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.fl.saas.config.http.HttpUtils.1
                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void doGet(String str, HttpCallbackBytesListener httpCallbackBytesListener) {
        ThreadPoolManager.getInstance().addTask(new AlLFFp(6, this, str, httpCallbackBytesListener));
    }

    public void doPost(String str, String str2, HttpCallbackStringListener httpCallbackStringListener) {
        doPost(str, null, str2, httpCallbackStringListener);
    }

    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    public HttpURLConnection innerRequest(Uri uri, long j, AtomicInteger atomicInteger) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext createSSLContext = createSSLContext();
            httpURLConnection = httpsURLConnection;
            if (createSSLContext != null) {
                httpsURLConnection.setSSLSocketFactory(createSSLContext.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (getHeaders() != null && !getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!TextUtils.isEmpty(DeviceUtil.getUserAgent())) {
            httpURLConnection.setRequestProperty("User-Agent", DeviceUtil.getUserAgent());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        if (j > 0) {
            httpURLConnection.setRequestProperty(c.b, "bytes=" + j + "-");
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 307) {
            switch (responseCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return httpURLConnection;
            }
        }
        if (atomicInteger.decrementAndGet() < 0) {
            throw new HttpRetryException("redirects too many times", responseCode);
        }
        LogcatUtil.d("YdSDK-HttpUtils", "statusCode 302 :" + atomicInteger.get());
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpRetryException("redirectUrl is null", responseCode);
        }
        return innerRequest(Uri.parse(headerField), j, atomicInteger);
    }

    public void uploadFile(String str, File[] fileArr, HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new AlLFFp(7, str, fileArr, httpCallbackStringListener));
    }

    public void doGet(String str, HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new A2egSU(this, str, httpCallbackStringListener, 1));
    }

    public void doPost(String str, Map<String, String> map, String str2, HttpCallbackStringListener httpCallbackStringListener) {
        LogcatUtil.d("YdSDK", str2);
        ThreadPoolManager.getInstance().addTask(new A4TApA(this, str, map, str2, httpCallbackStringListener, 1));
    }

    public void doGet(boolean z, String str, HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new A2egSU(this, str, httpCallbackStringListener, 0));
    }
}
