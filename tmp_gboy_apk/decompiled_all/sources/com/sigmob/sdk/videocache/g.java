package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class g extends p {

    /* renamed from: a, reason: collision with root package name */
    private static final float f13727a = 0.2f;
    private final u b;
    private final com.sigmob.sdk.videocache.file.b c;
    private d d;

    public g(u uVar, com.sigmob.sdk.videocache.file.b bVar) {
        super(uVar, bVar);
        this.c = bVar;
        this.b = uVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String b(f fVar) {
        String c = this.b.c();
        boolean isEmpty = TextUtils.isEmpty(c);
        long a2 = this.c.d() ? this.c.a() : this.b.a();
        boolean z = a2 >= 0;
        boolean z2 = fVar.c;
        long j = z2 ? a2 - fVar.b : a2;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(fVar.b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        return CtFAbx.B25kr6(sb, isEmpty ? "" : a("Content-Type: %s\n", c), "\n");
    }

    private String c(f fVar) {
        return "HTTP/1.1 404 Not Found\n";
    }

    @Override // com.sigmob.sdk.videocache.p
    public void a(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.c.f13721a, this.b.g(), i);
        }
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(f fVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(fVar).getBytes("UTF-8"));
        long j = fVar.b;
        if (a(fVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        while (true) {
            int a2 = a(bArr, j, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j += a2;
            }
        }
    }

    private void b(OutputStream outputStream, long j) {
        u a2 = t.a(this.b);
        try {
            a2.a((int) j);
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int a3 = a2.a(bArr);
                if (a3 == -1) {
                    outputStream.flush();
                    a2.b();
                    return;
                }
                outputStream.write(bArr, 0, a3);
            }
        } catch (Throwable th) {
            a2.b();
            throw th;
        }
    }

    @Override // com.sigmob.sdk.videocache.p
    public void a(Throwable th) {
        super.a(th);
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.b.g(), th);
        }
    }

    private boolean a(f fVar) {
        long a2 = this.b.a();
        boolean z = a2 > 0;
        long a3 = this.c.a();
        if (z && fVar.c) {
            if (fVar.b > (a2 * f13727a) + a3) {
                return false;
            }
        }
        return true;
    }
}
