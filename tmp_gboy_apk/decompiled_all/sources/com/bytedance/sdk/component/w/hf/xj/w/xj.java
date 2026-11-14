package com.bytedance.sdk.component.w.hf.xj.w;

import com.bytedance.sdk.component.w.hf.g;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.pz;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.x;
import com.sigmob.sdk.base.e;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements jk {
    private final g xj;

    public xj(g gVar) {
        this.xj = gVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk
    public q xj(jk.xj xjVar) {
        io xj = xjVar.xj();
        io.xj y = xj.y();
        x u = xj.u();
        if (u != null) {
            pz xj2 = u.xj();
            if (xj2 != null) {
                y.xj("Content-Type", xj2.toString());
            }
            long hf = u.hf();
            if (hf != -1) {
                y.xj(com.sigmob.sdk.downloader.core.c.e, Long.toString(hf));
                y.hf(com.sigmob.sdk.downloader.core.c.h);
            } else {
                y.xj(com.sigmob.sdk.downloader.core.c.h, "chunked");
                y.hf(com.sigmob.sdk.downloader.core.c.e);
            }
        }
        boolean z = false;
        if (xj.xj("Host") == null) {
            y.xj("Host", com.bytedance.sdk.component.w.hf.xj.w.xj(xj.xj(), false));
        }
        if (xj.xj("Connection") == null) {
            y.xj("Connection", "Keep-Alive");
        }
        if (xj.xj("Accept-Encoding") == null && xj.xj(com.sigmob.sdk.downloader.core.c.b) == null) {
            y.xj("Accept-Encoding", "gzip");
            z = true;
        }
        List<com.bytedance.sdk.component.w.hf.pl> xj3 = this.xj.xj(xj.xj());
        if (!xj3.isEmpty()) {
            y.xj(e.f13172a, xj(xj3));
        }
        if (xj.xj("User-Agent") == null) {
            y.xj("User-Agent", com.bytedance.sdk.component.w.hf.xj.u.xj());
        }
        q xj4 = xjVar.xj(y.xj());
        kd.xj(this.xj, xj.xj(), xj4.c());
        q.xj xj5 = xj4.d().xj(xj);
        if (z && "gzip".equalsIgnoreCase(xj4.xj("Content-Encoding")) && kd.w(xj4)) {
            com.bytedance.sdk.component.w.xj.tf tfVar = new com.bytedance.sdk.component.w.xj.tf(xj4.f().w());
            xj5.xj(xj4.c().hf().hf("Content-Encoding").hf(com.sigmob.sdk.downloader.core.c.e).xj());
            xj5.xj(new f(xj4.xj("Content-Type"), -1L, com.bytedance.sdk.component.w.xj.pl.xj(tfVar)));
        }
        return xj5.xj();
    }

    private String xj(List<com.bytedance.sdk.component.w.hf.pl> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.w.hf.pl plVar = list.get(i);
            sb.append(plVar.xj());
            sb.append('=');
            sb.append(plVar.hf());
        }
        return sb.toString();
    }
}
