package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j implements u {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13734a = 5;
    private final com.sigmob.sdk.videocache.sourcestorage.c b;
    private final com.sigmob.sdk.videocache.headers.b c;
    private v d;
    private HttpURLConnection e;
    private InputStream f;

    public j(u uVar) {
        this.d = uVar.d();
        this.b = uVar.e();
        this.c = uVar.f();
    }

    private void h() {
        SigmobLog.d("Read content info from " + this.d.f13745a);
        try {
            HttpURLConnection a2 = a(0L, 3000);
            v vVar = new v(this.d.f13745a, a(a2), a2.getContentType());
            this.d = vVar;
            this.b.a(vVar.f13745a, vVar);
            SigmobLog.d("Source info fetched: " + this.d);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.d.f13745a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        InputStream inputStream = this.f;
        if (inputStream == null) {
            throw new q(CtFAbx.B25kr6(new StringBuilder("Error reading data from "), this.d.f13745a, ": connection is absent!"));
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new l(CtFAbx.B25kr6(new StringBuilder("Reading source "), this.d.f13745a, " is interrupted"), e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.d.f13745a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() {
        try {
            if (TextUtils.isEmpty(this.d.c)) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.d.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.d;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.d.f13745a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.d + "}";
    }

    public j(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.b = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.c = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v a2 = cVar.a(str);
        this.d = a2 == null ? new v(str, -2147483648L, r.a(str)) : a2;
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized long a() {
        try {
            if (this.d.b == -2147483648L) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.d.b;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.e);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a2 = a(httpURLConnection);
        return i == 200 ? a2 : i == 206 ? a2 + j : this.d.b;
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        boolean z;
        String str2 = this.d.f13745a;
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null && j > 0 && httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            this.e = null;
            r.a(this.f);
        }
        if (this.e == null) {
            int i2 = 0;
            do {
                StringBuilder sb = new StringBuilder("Open connection ");
                if (j > 0) {
                    str = CtFAbx.AaHO0E(" with offset ", j);
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" to ");
                sb.append(str2);
                SigmobLog.d(sb.toString());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                this.e = httpURLConnection2;
                a(httpURLConnection2, str2);
                if (j > 0) {
                    this.e.setRequestProperty(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
                }
                if (i > 0) {
                    this.e.setConnectTimeout(i);
                    this.e.setReadTimeout(i);
                }
                int responseCode = this.e.getResponseCode();
                z = responseCode == 301 || responseCode == 302 || responseCode == 303;
                if (z) {
                    String headerField = this.e.getHeaderField("Location");
                    URI create = URI.create(headerField);
                    if (create != null && !create.isAbsolute()) {
                        try {
                            URI create2 = URI.create(str2);
                            if (create2 != null) {
                                headerField = create2.resolve(create).toString();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    i2++;
                    this.e.disconnect();
                    str2 = headerField;
                }
                if (i2 > 5) {
                    throw new q(CtFAbx.ARc23Z(i2, "Too many redirects: "));
                }
            } while (z);
        }
        return this.e;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        try {
            HttpURLConnection a2 = a(j, 3000);
            this.e = a2;
            String contentType = a2.getContentType();
            this.f = new BufferedInputStream(this.e.getInputStream(), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            HttpURLConnection httpURLConnection = this.e;
            v vVar = new v(this.d.f13745a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.d = vVar;
            this.b.a(vVar.f13745a, vVar);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.d.f13745a + " with offset " + j, e);
        }
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.c.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
