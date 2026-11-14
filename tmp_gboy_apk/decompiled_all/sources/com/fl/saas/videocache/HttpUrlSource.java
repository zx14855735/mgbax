package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.videocache.headers.EmptyHeadersInjector;
import com.fl.saas.videocache.headers.HeaderInjector;
import com.fl.saas.videocache.sourcestorage.SourceInfoStorage;
import com.fl.saas.videocache.sourcestorage.SourceInfoStorageFactory;
import com.sigmob.sdk.downloader.core.c;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fetchContentInfo() {
        /*
            r10 = this;
            java.lang.String r0 = "Error fetching info from "
            java.lang.String r1 = "Source info fetched: "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Read content info from "
            r2.<init>(r3)
            com.fl.saas.videocache.SourceInfo r3 = r10.sourceInfo
            java.lang.String r3 = r3.url
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.fl.saas.config.utils.LogcatUtil.d(r2)
            r2 = 0
            r4 = 10000(0x2710, float:1.4013E-41)
            r5 = 0
            java.net.HttpURLConnection r2 = r10.openConnection(r2, r4)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            long r3 = r10.getContentLength(r2)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.String r6 = r2.getContentType()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.videocache.SourceInfo r7 = new com.fl.saas.videocache.SourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.videocache.SourceInfo r8 = r10.sourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.String r8 = r8.url     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            r7.<init>(r8, r3, r6)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            r10.sourceInfo = r7     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.videocache.sourcestorage.SourceInfoStorage r3 = r10.sourceInfoStorage     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.String r4 = r7.url     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            r3.put(r4, r7)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.videocache.SourceInfo r1 = r10.sourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            r3.append(r1)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.config.utils.LogcatUtil.d(r1)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L61
            com.fl.saas.videocache.ProxyCacheUtils.close(r5)
            r2.disconnect()
            return
        L5c:
            r0 = move-exception
            r9 = r5
            r5 = r2
            r2 = r9
            goto L8f
        L61:
            r1 = move-exception
            r9 = r5
            r5 = r2
            r2 = r9
            goto L6b
        L66:
            r0 = move-exception
            r2 = r5
            goto L8f
        L69:
            r1 = move-exception
            r2 = r5
        L6b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L8e
            com.fl.saas.videocache.SourceInfo r0 = r10.sourceInfo     // Catch: java.lang.Throwable -> L8e
            java.lang.String r0 = r0.url     // Catch: java.lang.Throwable -> L8e
            r3.append(r0)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L8e
            r3.append(r0)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L8e
            com.fl.saas.config.utils.LogcatUtil.e(r0)     // Catch: java.lang.Throwable -> L8e
            com.fl.saas.videocache.ProxyCacheUtils.close(r2)
            if (r5 == 0) goto L8d
            r5.disconnect()
        L8d:
            return
        L8e:
            r0 = move-exception
        L8f:
            com.fl.saas.videocache.ProxyCacheUtils.close(r2)
            if (r5 == 0) goto L97
            r5.disconnect()
        L97:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(c.e);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection openConnection(long j, int i) {
        HttpURLConnection httpURLConnection;
        boolean z;
        String str = this.sourceInfo.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            sb.append(j > 0 ? CtFAbx.AaHO0E(" with offset ", j) : "");
            sb.append(" to ");
            sb.append(str);
            LogcatUtil.d(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            injectCustomHeaders(httpURLConnection, str);
            if (j > 0) {
                httpURLConnection.setRequestProperty(c.b, "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException(CtFAbx.ARc23Z(i2, "Too many redirects: "));
            }
        } while (z);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j, int i) {
        long contentLength = getContentLength(httpURLConnection);
        return i == 200 ? contentLength : i == 206 ? contentLength + j : this.sourceInfo.length;
    }

    @Override // com.fl.saas.videocache.Source
    public void close() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                LogcatUtil.e("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e.toString());
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String getMime() {
        try {
            if (TextUtils.isEmpty(this.sourceInfo.mime)) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.fl.saas.videocache.Source
    public synchronized long length() {
        try {
            if (this.sourceInfo.length == -2147483648L) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.sourceInfo.length;
    }

    @Override // com.fl.saas.videocache.Source
    public void open(long j) {
        try {
            HttpURLConnection openConnection = openConnection(j, -1);
            this.connection = openConnection;
            String contentType = openConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e);
        }
    }

    @Override // com.fl.saas.videocache.Source
    public int read(byte[] bArr) {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            throw new ProxyCacheException(CtFAbx.B25kr6(new StringBuilder("Error reading data from "), this.sourceInfo.url, ": connection is absent!"));
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException(CtFAbx.B25kr6(new StringBuilder("Reading source "), this.sourceInfo.url, " is interrupted"), e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e2);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + "}";
    }

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
        SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new SourceInfo(str, -2147483648L, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }
}
