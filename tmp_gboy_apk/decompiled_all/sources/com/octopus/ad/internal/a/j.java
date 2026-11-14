package com.octopus.ad.internal.a;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j implements r {

    /* renamed from: a, reason: collision with root package name */
    private final com.octopus.ad.internal.a.b.c f12397a;
    private final f b;
    private s c;
    private HttpURLConnection d;
    private InputStream e;

    public j(String str) {
        this(str, com.octopus.ad.internal.a.b.d.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r9 = this;
            java.lang.String r0 = "Error fetching info from "
            java.lang.String r1 = "Source info fetched: "
            java.lang.String r2 = com.octopus.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read content info from "
            r3.<init>(r4)
            com.octopus.ad.internal.a.s r4 = r9.c
            java.lang.String r4 = r4.f12403a
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.octopus.ad.internal.utilities.HaoboLog.d(r2, r3)
            r2 = 0
            r4 = 10000(0x2710, float:1.4013E-41)
            r5 = 0
            java.net.HttpURLConnection r2 = r9.a(r2, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            long r3 = r9.a(r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r6 = r2.getContentType()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.a.s r7 = new com.octopus.ad.internal.a.s     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.a.s r8 = r9.c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r8 = r8.f12403a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r7.<init>(r8, r3, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r9.c = r7     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.a.b.c r3 = r9.f12397a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r4 = r7.f12403a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r3.a(r4, r7)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r3 = com.octopus.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.a.s r1 = r9.c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.append(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.utilities.HaoboLog.d(r3, r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            com.octopus.ad.internal.a.q.a(r5)
            r2.disconnect()
            return
        L5c:
            r0 = move-exception
            goto L8a
        L5e:
            r1 = move-exception
            goto L65
        L60:
            r0 = move-exception
            r2 = r5
            goto L8a
        L63:
            r1 = move-exception
            r2 = r5
        L65:
            java.lang.String r3 = com.octopus.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            com.octopus.ad.internal.a.s r0 = r9.c     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r0.f12403a     // Catch: java.lang.Throwable -> L5c
            r4.append(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L5c
            r4.append(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            com.octopus.ad.internal.utilities.HaoboLog.e(r3, r0)     // Catch: java.lang.Throwable -> L5c
            com.octopus.ad.internal.a.q.a(r5)
            if (r2 == 0) goto L89
            r2.disconnect()
        L89:
            return
        L8a:
            com.octopus.ad.internal.a.q.a(r5)
            if (r2 == 0) goto L92
            r2.disconnect()
        L92:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.a.j.e():void");
    }

    @Override // com.octopus.ad.internal.a.r
    public synchronized long a() {
        try {
            if (this.c.b == -2147483648L) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c.b;
    }

    @Override // com.octopus.ad.internal.a.r
    public void b() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                HaoboLog.e(HaoboLog.httpUrlSourceLogTag, "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(" + e.getMessage());
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
        }
    }

    public synchronized String c() {
        try {
            if (TextUtils.isEmpty(this.c.c)) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c.c;
    }

    public String d() {
        return this.c.f12403a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }

    public j(String str, com.octopus.ad.internal.a.b.c cVar) {
        this(str, cVar, new d());
    }

    public j(String str, com.octopus.ad.internal.a.b.c cVar, f fVar) {
        this.f12397a = (com.octopus.ad.internal.a.b.c) n.a(cVar);
        this.b = (f) n.a(fVar);
        s a2 = cVar.a(str);
        this.c = a2 == null ? new s(str, -2147483648L, q.a(str)) : a2;
    }

    @Override // com.octopus.ad.internal.a.r
    public void a(long j) {
        try {
            HttpURLConnection a2 = a(j, -1);
            this.d = a2;
            String contentType = a2.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            HttpURLConnection httpURLConnection = this.d;
            s sVar = new s(this.c.f12403a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.c = sVar;
            this.f12397a.a(sVar.f12403a, sVar);
        } catch (Exception e) {
            throw new p("Error opening connection for " + this.c.f12403a + " with offset " + j, e);
        }
    }

    public j(j jVar) {
        this.c = jVar.c;
        this.f12397a = jVar.f12397a;
        this.b = jVar.b;
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a2 = a(httpURLConnection);
        return i == 200 ? a2 : i == 206 ? a2 + j : this.c.b;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.e);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.octopus.ad.internal.a.r
    public int a(byte[] bArr) {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new l(CtFAbx.B25kr6(new StringBuilder("Reading source "), this.c.f12403a, " is interrupted"), e);
            } catch (Exception e2) {
                throw new p("Error reading data from " + this.c.f12403a, e2);
            }
        }
        throw new p(CtFAbx.B25kr6(new StringBuilder("Error reading data from "), this.c.f12403a, ": connection is absent!"));
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.c.f12403a;
        int i2 = 0;
        do {
            String str3 = HaoboLog.httpUrlSourceLogTag;
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j > 0) {
                str = CtFAbx.AaHO0E(" with offset ", j);
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            HaoboLog.d(str3, sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            a(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new p(CtFAbx.ARc23Z(i2, "Too many redirects: "));
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
