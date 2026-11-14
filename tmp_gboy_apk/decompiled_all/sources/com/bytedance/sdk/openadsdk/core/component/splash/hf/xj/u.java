package com.bytedance.sdk.openadsdk.core.component.splash.hf.xj;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj {
    private c xj = new c();

    private void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<f, c> wVar) {
        if (hfVar == null || wVar == null) {
            return;
        }
        this.xj.hf(hfVar.am());
        this.xj.xj(hfVar.hf());
        int d = hfVar.d();
        com.bykv.vk.openvk.component.video.api.w.w f = hfVar.f();
        this.xj.xj(true);
        if (f == null) {
            this.xj.hf(2);
            this.xj.xj("no video info");
            wVar.xj(this.xj);
            return;
        }
        String pl2 = f.pl();
        if (TextUtils.isEmpty(pl2)) {
            this.xj.hf(2);
            this.xj.xj("no video url");
            wVar.xj(this.xj);
            return;
        }
        String qt = f.qt();
        if (TextUtils.isEmpty(qt)) {
            qt = kd.hf(pl2);
        }
        if (TextUtils.isEmpty(qt)) {
            this.xj.hf(2);
            this.xj.xj("no video cahce filename");
            wVar.xj(this.xj);
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "加载视频素材");
        ws hf = hfVar.hf();
        if (hf == null) {
            return;
        }
        boolean tf = hfVar.tf();
        f.kd(1);
        if (f.zg() == 0) {
            f.u(307200);
        }
        com.bykv.vk.openvk.component.video.api.w.u xj = tf ? h.xj(2, hf) : h.xj(3, hf);
        xj.xj("material_meta", hf);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (d.xj(hf.ul()).xj(xj)) {
            f fVar = new f(hfVar.hf(), hfVar.am());
            fVar.xj(true);
            fVar.w(true);
            fVar.xj(hfVar.xj());
            fVar.kd(hfVar.w());
            wVar.hf(fVar);
            xj.d(1);
            com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj, hf, SystemClock.elapsedRealtime() - elapsedRealtime);
            return;
        }
        if (pz.hf().f(String.valueOf(d)) && !am.u(pz.getContext())) {
            this.xj.hf(2);
            this.xj.xj("network error");
            wVar.xj(this.xj);
        } else {
            if (hfVar.hf() == null || hfVar.hf().ss() != 3) {
                com.bykv.vk.openvk.component.video.xj.xj.xj();
                xj(xj, hfVar, hfVar.hf(), wVar);
                return;
            }
            f fVar2 = new f(hfVar.hf(), hfVar.am());
            fVar2.xj(true);
            fVar2.w(false);
            fVar2.xj(hfVar.xj());
            fVar2.kd(hfVar.w());
            fVar2.xj(h.xj(hfVar.hf()));
            wVar.hf(fVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<f, c> wVar) {
        hf(hfVar, wVar);
    }

    private void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, ws wsVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<f, c> wVar) {
        if (wsVar == null || wVar == null || hfVar == null || uVar == null || h.am(wsVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.u.hf.xj(uVar, new com.bykv.vk.openvk.component.video.api.kd.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.u.1
            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar2, int i) {
                if (wVar != null) {
                    f fVar = new f(hfVar.hf(), hfVar.am());
                    fVar.xj(true);
                    fVar.w(false);
                    fVar.xj((com.bytedance.sdk.component.d.hf) null);
                    fVar.xj(hfVar.xj());
                    fVar.kd(hfVar.w());
                    wVar.hf(fVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar2, int i, String str) {
                if (wVar != null) {
                    u.this.xj.hf(2);
                    u.this.xj.xj("preload video fail");
                    wVar.xj(u.this.xj);
                }
            }
        });
    }
}
