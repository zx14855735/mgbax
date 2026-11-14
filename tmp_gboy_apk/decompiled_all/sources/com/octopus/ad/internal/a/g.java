package com.octopus.ad.internal.a;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class g extends o {

    /* renamed from: a, reason: collision with root package name */
    private final j f12390a;
    private final com.octopus.ad.internal.a.a.b b;
    private b c;

    public g(j jVar, com.octopus.ad.internal.a.a.b bVar) {
        super(jVar, bVar);
        this.b = bVar;
        this.f12390a = jVar;
    }

    private String b(e eVar) {
        String c = this.f12390a.c();
        boolean isEmpty = TextUtils.isEmpty(c);
        long a2 = this.b.d() ? this.b.a() : this.f12390a.a();
        boolean z = a2 >= 0;
        boolean z2 = eVar.c;
        long j = z2 ? a2 - eVar.b : a2;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(eVar.b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        return CtFAbx.B25kr6(sb, isEmpty ? "" : a("Content-Type: %s\n", c), "\n");
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(e eVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(eVar).getBytes("UTF-8"));
        long j = eVar.b;
        if (a(eVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private boolean a(e eVar) {
        long a2 = this.f12390a.a();
        boolean z = a2 > 0;
        long a3 = this.b.a();
        if (z && eVar.c) {
            if (eVar.b > (a2 * 0.2f) + a3) {
                return false;
            }
        }
        return true;
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        while (true) {
            int a2 = a(bArr, j, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            if (a2 != -1) {
                outputStream.write(bArr, 0, a2);
                j += a2;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void b(OutputStream outputStream, long j) {
        j jVar = new j(this.f12390a);
        try {
            jVar.a((int) j);
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int a2 = jVar.a(bArr);
                if (a2 != -1) {
                    outputStream.write(bArr, 0, a2);
                } else {
                    outputStream.flush();
                    jVar.b();
                    return;
                }
            }
        } catch (Throwable th) {
            jVar.b();
            throw th;
        }
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.octopus.ad.internal.a.o
    public void a(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.f12383a, this.f12390a.d(), i);
        }
    }
}
