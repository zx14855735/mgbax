package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m implements u {
    private static final int c = 5;
    private static OkHttpClient d;

    /* renamed from: a, reason: collision with root package name */
    protected volatile long f13736a;
    protected volatile String b;
    private InputStream e;
    private v f;
    private final com.sigmob.sdk.videocache.sourcestorage.c g;
    private final com.sigmob.sdk.videocache.headers.b h;
    private Response i;

    public m(u uVar) {
        this.f13736a = -2147483648L;
        this.b = "video/mp4";
        this.f = uVar.d();
        this.g = uVar.e();
        this.h = uVar.f();
    }

    private void h() {
        try {
            SigmobLog.d("Read content info from " + this.f.f13745a);
            Response a2 = a(0L, 10000);
            if (a2 == null || !a2.isSuccessful()) {
                throw new q("Fail to fetchContentInfo: " + this.f.f13745a);
            }
            ResponseBody body = a2.body();
            if (body != null) {
                this.f13736a = (int) body.contentLength();
                if (body.contentType() != null) {
                    this.b = body.contentType().toString();
                }
            }
            v vVar = new v(this.f.f13745a, this.f13736a, this.b);
            this.f = vVar;
            this.g.a(vVar.f13745a, vVar);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.f.f13745a, e);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new q(CtFAbx.B25kr6(new StringBuilder("Error reading data from "), this.f.f13745a, ": connection is absent!"));
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new l(CtFAbx.B25kr6(new StringBuilder("Reading source "), this.f.f13745a, " is interrupted"), e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.f.f13745a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
        try {
            r.a(this.e);
        } catch (ArrayIndexOutOfBoundsException e) {
            SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        } catch (NullPointerException e3) {
            e = e3;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() {
        try {
            if (TextUtils.isEmpty(this.f.c)) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.f;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.g;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.h;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.f.f13745a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f + "}";
    }

    public m(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.f13736a = -2147483648L;
        this.b = "video/mp4";
        this.g = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.h = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v a2 = cVar.a(str);
        this.f = a2 == null ? new v(str, -2147483648L, r.a(str)) : a2;
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() {
        if (this.f13736a == -2147483648L) {
            h();
        }
        return this.f13736a;
    }

    private long a(Response response, long j) {
        int code = response.code();
        int contentLength = (int) response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j : this.f13736a;
    }

    private Response a(long j, int i) {
        if (d == null) {
            OkHttpClient.Builder connectionPool = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            d = connectionPool.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).build();
        }
        String str = this.f.f13745a;
        Response response = this.i;
        if (response != null && j > 0) {
            try {
                response.close();
            } catch (Throwable unused) {
            }
            this.i = null;
            r.a(this.e);
        }
        if (this.i == null) {
            int i2 = 0;
            boolean z = false;
            do {
                Request.Builder builder = new Request.Builder();
                builder.get();
                builder.url(str);
                a(builder, str);
                if (j > 0) {
                    builder.addHeader(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
                }
                Response execute = d.newCall(builder.build()).execute();
                this.i = execute;
                if (execute.isRedirect()) {
                    str = this.i.header("Location");
                    z = this.i.isRedirect();
                    i2++;
                }
                if (i2 > 5) {
                    throw new q(CtFAbx.ARc23Z(i2, "Too many redirects: "));
                }
            } while (z);
        }
        return this.i;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        try {
            Response a2 = a(j, -1);
            this.i = a2;
            ResponseBody body = a2.body();
            if (body != null && body.contentType() != null) {
                this.b = body.contentType().toString();
            }
            this.f13736a = a(this.i, j);
            this.e = new BufferedInputStream(body.byteStream(), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            v vVar = new v(this.f.f13745a, this.f13736a, this.b);
            this.f = vVar;
            this.g.a(vVar.f13745a, vVar);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.f.f13745a + " with offset " + j, e);
        }
    }

    private void a(Request.Builder builder, String str) {
        for (Map.Entry<String, String> entry : this.h.a(str).entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }
}
