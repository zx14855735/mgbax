package com.bytedance.sdk.openadsdk.core.component.splash.w.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.nb;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private int c;
    private int d;
    private com.bykv.vk.openvk.component.video.api.w.w f;
    private boolean g;
    private com.bytedance.sdk.openadsdk.g.hf kd;
    private com.bytedance.sdk.openadsdk.core.ra.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10340pl;
    private boolean tf;
    private int u;
    private int y;

    public hf(ws wsVar, boolean z) {
        if (wsVar == null) {
            return;
        }
        this.hf = wsVar;
        this.g = z;
        this.f10340pl = hl.xj(wsVar) == 2;
        hf(wsVar);
    }

    private void hf(ws wsVar) {
        int ss = wsVar.ss();
        nb y = hl.y(wsVar);
        ss c = hl.c(wsVar);
        if (TextUtils.isEmpty(h.xj(wsVar))) {
            this.u = 1;
        } else if (w(wsVar)) {
            if (xj(y) || xj(c)) {
                this.u = 2;
            } else {
                if (hf(y) || hf(c)) {
                    hl.xj(wsVar, 1);
                }
                this.u = 1;
            }
        } else if (ss == 1) {
            this.u = 1;
        } else {
            this.u = 2;
        }
        u(wsVar);
    }

    private void kd(ws wsVar) {
        z zVar;
        if (wsVar.lx() == null || (zVar = wsVar.lx().get(0)) == null) {
            return;
        }
        String xj = zVar.xj();
        if (TextUtils.isEmpty(xj)) {
            return;
        }
        this.y = zVar.hf();
        this.c = zVar.w();
        this.kd = new com.bytedance.sdk.openadsdk.g.hf(xj, zVar.c());
    }

    private boolean w(ws wsVar) {
        return hl.xj(wsVar) == 2;
    }

    private boolean xj(nb nbVar) {
        return nbVar != null && xj(nbVar.f()) == 2;
    }

    private void y(ws wsVar) {
        this.f = h.am(wsVar);
        this.d = wo.d(wsVar);
        this.tf = wsVar.qe();
    }

    public boolean am() {
        return this.g;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public com.bykv.vk.openvk.component.video.api.w.w f() {
        return this.f;
    }

    public boolean g() {
        return this.f10340pl;
    }

    public int p() {
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.core.ra.xj pl() {
        return this.p;
    }

    public boolean tf() {
        return this.tf;
    }

    public boolean u() {
        return this.u == 2;
    }

    private void u(ws wsVar) {
        kd(wsVar);
        y(wsVar);
    }

    private boolean xj(ss ssVar) {
        return ssVar != null && ssVar.c() == 2;
    }

    private int xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int y() {
        return this.y;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        this.p = xjVar;
    }

    public void xj(boolean z) {
        this.g = z;
    }

    public com.bytedance.sdk.openadsdk.g.hf kd() {
        return this.kd;
    }

    private boolean hf(nb nbVar) {
        return nbVar != null && xj(nbVar.f()) == 0;
    }

    private boolean hf(ss ssVar) {
        return ssVar != null && ssVar.c() == 0;
    }
}
