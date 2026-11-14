package com.bytedance.sdk.component.w.hf.xj.w;

import J3FDQU.A2egSU;
import com.bytedance.sdk.component.w.hf.ai;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.xj.yo;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class hf implements jk {
    private final boolean xj;

    public static final class xj extends com.bytedance.sdk.component.w.xj.c {
        long xj;

        public xj(yo yoVar) {
            super(yoVar);
        }

        @Override // com.bytedance.sdk.component.w.xj.c, com.bytedance.sdk.component.w.xj.yo
        public void a_(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            super.a_(wVar, j);
            this.xj += j;
        }
    }

    public hf(boolean z) {
        this.xj = z;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk
    public q xj(jk.xj xjVar) {
        ai aiVar;
        c cVar = (c) xjVar;
        w c = cVar.c();
        com.bytedance.sdk.component.w.hf.xj.hf.c y = cVar.y();
        com.bytedance.sdk.component.w.hf.xj.hf.w wVar = (com.bytedance.sdk.component.w.hf.xj.hf.w) cVar.kd();
        io xj2 = cVar.xj();
        long currentTimeMillis = System.currentTimeMillis();
        if (xj2 != null && (aiVar = xj2.y) != null) {
            aiVar.xj(currentTimeMillis);
        }
        cVar.call();
        c.xj(xj2);
        cVar.call();
        q.xj xjVar2 = null;
        if (y.w(xj2.hf()) && xj2.u() != null) {
            if ("100-continue".equalsIgnoreCase(xj2.xj("Expect"))) {
                c.xj();
                cVar.call();
                xjVar2 = c.xj(true);
            }
            if (xjVar2 == null) {
                cVar.call();
                com.bytedance.sdk.component.w.xj.u xj3 = com.bytedance.sdk.component.w.xj.pl.xj(new xj(c.xj(xj2, xj2.u().hf())));
                xj2.u().xj(xj3);
                xj3.close();
                cVar.call();
            } else if (!wVar.kd()) {
                y.u();
            }
        }
        c.hf();
        if (xjVar2 == null) {
            cVar.call();
            xjVar2 = c.xj(false);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ai aiVar2 = xj2.y;
        if (aiVar2 != null) {
            aiVar2.hf(currentTimeMillis2);
        }
        q xj4 = xjVar2.xj(xj2).xj(y.hf().u()).xj(currentTimeMillis).hf(currentTimeMillis2).xj();
        cVar.call();
        int w = xj4.w();
        q xj5 = (this.xj && w == 101) ? xj4.d().xj(com.bytedance.sdk.component.w.hf.xj.w.w).xj() : xj4.d().xj(c.xj(xj4)).xj();
        if ("close".equalsIgnoreCase(xj5.xj().xj("Connection")) || "close".equalsIgnoreCase(xj5.xj("Connection"))) {
            y.u();
        }
        if ((w != 204 && w != 205) || xj5.f().hf() <= 0) {
            return xj5;
        }
        StringBuilder B9tovu2 = A2egSU.B9tovu(w, "HTTP ", " had non-zero Content-Length: ");
        B9tovu2.append(xj5.f().hf());
        throw new ProtocolException(B9tovu2.toString());
    }
}
