package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aPC;
    private final com.kwad.sdk.core.videocache.b.b aPD;
    private n aQa;
    private HttpURLConnection aQb;
    private InputStream aQc;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aPC = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aPD = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n fi = cVar.fi(str);
        this.aQa = fi == null ? new n(str, -2147483648L, l.fg(str)) : fi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void Mm() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.aQa.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = e(0L, 10000);
                try {
                    long d = d(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    n nVar = new n(this.aQa.url, d, contentType);
                    this.aQa = nVar;
                    this.aPC.a(nVar.url, nVar);
                    com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aQa);
                    r0 = httpURLConnection;
                } catch (IOException unused) {
                    com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aQa.url);
                    r0 = httpURLConnection;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r0);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r0);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r0);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r0);
    }

    private void Mo() {
        n fi;
        com.kwad.sdk.core.videocache.d.c cVar = this.aPC;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (fi = cVar.fi(getUrl())) == null || TextUtils.isEmpty(fi.aQr) || fi.aQq == -2147483648L) {
            return;
        }
        this.aQa = fi;
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long d = d(httpURLConnection);
        return i == 200 ? d : i == 206 ? d + j : this.aQa.aQq;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.e);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection e(long j, int i) {
        HttpURLConnection httpURLConnection;
        boolean z;
        String str = this.aQa.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            sb.append(j > 0 ? CtFAbx.AaHO0E(" with offset ", j) : "");
            sb.append(" to ");
            sb.append(str);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str);
            if (j > 0) {
                httpURLConnection.setRequestProperty(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
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

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Mn() {
        try {
            if (TextUtils.isEmpty(this.aQa.aQr)) {
                Mo();
            }
            if (TextUtils.isEmpty(this.aQa.aQr)) {
                Mm();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aQa.aQr;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aK(long j) {
        try {
            HttpURLConnection e = e(j, -1);
            this.aQb = e;
            String contentType = e.getContentType();
            this.aQc = new BufferedInputStream(this.aQb.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aQb;
            n nVar = new n(this.aQa.url, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.aQa = nVar;
            this.aPC.a(nVar.url, nVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.aQa.url + " with offset " + j, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aQb;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aQa.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        try {
            if (this.aQa.aQq == -2147483648L) {
                Mo();
            }
            if (this.aQa.aQq == -2147483648L) {
                Mm();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aQa.aQq;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aQc;
        if (inputStream == null) {
            throw new ProxyCacheException(CtFAbx.B25kr6(new StringBuilder("Error reading data from "), this.aQa.url, ": connection is absent!"));
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException(CtFAbx.B25kr6(new StringBuilder("Reading source "), this.aQa.url, " is interrupted"), e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.aQa.url, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aQa + "}";
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aPD.Mv().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public h(h hVar) {
        this.aQa = hVar.aQa;
        this.aPC = hVar.aPC;
        this.aPD = hVar.aPD;
    }
}
