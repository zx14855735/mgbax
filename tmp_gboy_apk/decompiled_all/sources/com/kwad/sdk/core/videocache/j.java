package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aPC;
    private final com.kwad.sdk.core.videocache.b.b aPD;
    private n aQa;
    private InputStream aQc;
    private OkHttpClient aQh = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aPC = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aPD = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n fi = cVar.fi(str);
        this.aQa = fi == null ? new n(str, -2147483648L, l.fg(str)) : fi;
    }

    private void Mm() {
        Response response = null;
        try {
            try {
                response = eh(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aQa.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response == null || !response.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.aQa.url, c(response), response.header("Content-Type"));
            this.aQa = nVar;
            this.aPC.a(nVar.url, nVar);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aQa);
            if (response.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
            throw th;
        }
    }

    private void Mo() {
        n fi;
        com.kwad.sdk.core.videocache.d.c cVar = this.aPC;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (fi = cVar.fi(getUrl())) == null || TextUtils.isEmpty(fi.aQr) || fi.aQq == -2147483648L) {
            return;
        }
        this.aQa = fi;
    }

    private long a(Response response, long j) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j : this.aQa.aQq;
    }

    private static long c(Response response) {
        String header = response.header(com.sigmob.sdk.downloader.core.c.e);
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response eh(int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        newBuilder.readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        newBuilder.writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aQh = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aQh.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException(CtFAbx.ARc23Z(i2, "Too many redirects: "));
            }
        } while (z);
        return execute;
    }

    private Response f(long j, int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aQh.newBuilder();
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aQh = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
            }
            execute = this.aQh.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException(CtFAbx.ARc23Z(i2, "Too many redirects: "));
            }
        } while (z);
        return execute;
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
            Response f = f(j, -1);
            String mediaType = f.body().contentType().toString();
            long a2 = a(f, j);
            this.aQc = new BufferedInputStream(f.body().byteStream(), 1024);
            n nVar = new n(this.aQa.url, a2, mediaType);
            this.aQa = nVar;
            this.aPC.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aQc);
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

    public j(j jVar) {
        this.aQa = jVar.aQa;
        this.aPC = jVar.aPC;
        this.aPD = jVar.aPD;
    }
}
