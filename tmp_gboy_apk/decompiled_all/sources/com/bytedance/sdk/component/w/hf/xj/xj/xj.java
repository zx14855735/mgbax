package com.bytedance.sdk.component.w.hf.xj.xj;

import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.xj.w.f;
import com.bytedance.sdk.component.w.hf.xj.xj.w;
import com.bytedance.sdk.component.w.hf.yo;
import com.bytedance.sdk.component.w.hf.z;
import com.bytedance.sdk.component.w.xj.pl;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.yo;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.downloader.core.c;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements jk {
    final y xj;

    public xj(y yVar) {
        this.xj = yVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk
    public q xj(jk.xj xjVar) {
        y yVar = this.xj;
        q xj = yVar != null ? yVar.xj(xjVar.xj()) : null;
        w xj2 = new w.xj(System.currentTimeMillis(), xjVar.xj(), xj).xj();
        io ioVar = xj2.xj;
        q qVar = xj2.hf;
        if (xj != null && qVar == null) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(xj.f());
        }
        if (ioVar == null && qVar == null) {
            return new q.xj().xj(xjVar.xj()).xj(dk.HTTP_1_1).xj(e.E).xj("Unsatisfiable Request (only-if-cached)").xj(com.bytedance.sdk.component.w.hf.xj.w.w).xj(-1L).hf(System.currentTimeMillis()).xj();
        }
        if (ioVar == null) {
            return qVar.d().hf(xj(qVar)).xj();
        }
        try {
            q xj3 = xjVar.xj(ioVar);
            if (xj3 == null && xj != null) {
            }
            if (qVar != null) {
                if (xj3.w() == 304) {
                    q xj4 = qVar.d().xj(xj(qVar.c(), xj3.c())).xj(xj3.g()).hf(xj3.am()).hf(xj(qVar)).xj(xj(xj3)).xj();
                    xj3.f().close();
                    this.xj.update(qVar, xj4);
                    return xj4;
                }
                com.bytedance.sdk.component.w.hf.xj.w.xj(qVar.f());
            }
            q xj5 = xj3.d().hf(xj(qVar)).xj(xj(xj3)).xj();
            if (this.xj != null) {
                if (com.bytedance.sdk.component.w.hf.xj.w.kd.w(xj5) && w.xj(xj5, ioVar)) {
                    return xj(this.xj.xj(xj5), xj5);
                }
                com.bytedance.sdk.component.w.hf.xj.w.y.xj(ioVar.hf());
            }
            return xj5;
        } finally {
            if (xj != null) {
                com.bytedance.sdk.component.w.hf.xj.w.xj(xj.f());
            }
        }
    }

    private static q xj(q qVar) {
        return (qVar == null || qVar.f() == null) ? qVar : qVar.d().xj((z) null).xj();
    }

    private q xj(final hf hfVar, q qVar) {
        yo xj;
        if (hfVar == null || (xj = hfVar.xj()) == null) {
            return qVar;
        }
        final com.bytedance.sdk.component.w.xj.kd w = qVar.f().w();
        final com.bytedance.sdk.component.w.xj.u xj2 = pl.xj(xj);
        return qVar.d().xj(new f(qVar.xj("Content-Type"), qVar.f().hf(), pl.xj(new v() { // from class: com.bytedance.sdk.component.w.hf.xj.xj.xj.1
            boolean xj;

            @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.xj && !com.bytedance.sdk.component.w.hf.xj.w.xj(this, 100, TimeUnit.MILLISECONDS)) {
                    this.xj = true;
                }
                w.close();
            }

            @Override // com.bytedance.sdk.component.w.xj.v
            public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
                try {
                    long xj3 = w.xj(wVar, j);
                    if (xj3 != -1) {
                        wVar.xj(xj2.w(), wVar.hf() - xj3, xj3);
                        xj2.pz();
                        return xj3;
                    }
                    if (!this.xj) {
                        this.xj = true;
                        xj2.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (this.xj) {
                        throw e;
                    }
                    this.xj = true;
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.component.w.xj.v
            public com.bytedance.sdk.component.w.xj.jk xj() {
                return w.xj();
            }
        }))).xj();
    }

    private static com.bytedance.sdk.component.w.hf.yo xj(com.bytedance.sdk.component.w.hf.yo yoVar, com.bytedance.sdk.component.w.hf.yo yoVar2) {
        yo.xj xjVar = new yo.xj();
        int xj = yoVar.xj();
        for (int i = 0; i < xj; i++) {
            String xj2 = yoVar.xj(i);
            String hf = yoVar.hf(i);
            if ((!"Warning".equalsIgnoreCase(xj2) || !hf.startsWith("1")) && (!xj(xj2) || yoVar2.xj(xj2) == null)) {
                com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(xjVar, xj2, hf);
            }
        }
        int xj3 = yoVar2.xj();
        for (int i2 = 0; i2 < xj3; i2++) {
            String xj4 = yoVar2.xj(i2);
            if (!c.e.equalsIgnoreCase(xj4) && xj(xj4)) {
                com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(xjVar, xj4, yoVar2.hf(i2));
            }
        }
        return xjVar.xj();
    }

    public static boolean xj(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || c.h.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
