package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bytedance.sdk.openadsdk.core.a.ai;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.dk;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.kd c;
    private com.bytedance.sdk.openadsdk.core.hf.xj d;
    private FullRewardExpressView e;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.u f;
    private long g;
    protected final ws hf;
    private ViewGroup p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10302pl;
    private final boolean qt;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w tf;
    public boolean u;
    protected final String w;
    protected final TTBaseVideoActivity xj;
    private int y;
    private boolean zg;
    private final AtomicBoolean am = new AtomicBoolean(false);
    boolean kd = false;

    public hf(final TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, String str, boolean z, boolean z2) {
        this.tf = null;
        this.xj = tTBaseVideoActivity;
        this.hf = wsVar;
        this.w = str;
        this.qt = z;
        this.zg = z2;
        com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.kd(tTBaseVideoActivity, wsVar, str, wo.hf(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.kd, com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, tf tfVar) {
                super.xj(view, tfVar);
                tTBaseVideoActivity.xj(2);
            }
        };
        this.c = kdVar;
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(tTBaseVideoActivity.xj(wsVar));
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.u(tTBaseVideoActivity, wsVar, str, wo.hf(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u, com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, tf tfVar) {
                super.xj(view, tfVar);
                com.bytedance.sdk.openadsdk.core.hf.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.hf.xj.hf) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.class);
                if (hfVar == null || !hfVar.hf(view)) {
                    return;
                }
                tTBaseVideoActivity.xj(2);
            }
        };
        this.f = uVar;
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(tTBaseVideoActivity.xj(wsVar));
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(tTBaseVideoActivity, wsVar, str, 7);
        this.d = xjVar;
        tTBaseVideoActivity.xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.d.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(tTBaseVideoActivity.xj(wsVar));
        if (wsVar.vw() == 4) {
            this.tf = f.xj((Context) tTBaseVideoActivity, wsVar, str, false);
            final String ho = xj().ho();
            this.tf.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.3
                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void hf(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void w(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj() {
                    xj.C0198xj.xj(ho, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, String str2, String str3) {
                    xj.C0198xj.xj(ho, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(String str2, String str3) {
                    xj.C0198xj.xj(ho, 6, 100);
                }
            });
        }
    }

    public void c() {
        r.xj((View) this.p, 0);
        this.xj.g();
    }

    public void d() {
        if (this.qt) {
            this.xj.xj(this.hf, this.d);
        }
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.tf;
        if (wVar != null) {
            wVar.hf();
        }
        FullRewardExpressView fullRewardExpressView = this.e;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
        ws wsVar = this.hf;
        ff.hf(wsVar != null ? wsVar.kd() : 0);
    }

    public String hf() {
        return this.w;
    }

    public xj.InterfaceC0194xj kd() {
        return new xj.InterfaceC0194xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.4
            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void hf() {
                hf.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj() {
                hf.this.f10302pl = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj(int i, String str) {
                hf.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj(long j, long j2) {
                r.xj((View) hf.this.p, 8);
                hf.this.g = j;
            }
        };
    }

    public long p() {
        return this.g;
    }

    public void pl() {
        if (this.zg) {
            return;
        }
        this.zg = true;
        com.bytedance.sdk.openadsdk.zg.w.w.hf xj = ai.xj(7);
        if (h.am(this.hf) != null) {
            com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(1, this.hf);
            xj2.xj("material_meta", this.hf);
            xj2.xj("ad_slot", Integer.valueOf(xj != null ? xj.jk() : 0));
            com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj2, new xj.InterfaceC0012xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.5
                @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
                public void hf(com.bykv.vk.openvk.component.video.api.w.u uVar, int i) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
                public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i) {
                    uVar.zg();
                    uVar.y();
                }

                @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
                public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i, String str) {
                    uVar.zg();
                    uVar.y();
                }
            });
        }
    }

    public com.bykv.vk.openvk.component.video.api.w.u tf() {
        com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(1, this.hf);
        xj.hf(this.hf.ho());
        xj.hf(100);
        xj.w(100);
        xj.w(this.hf.jf());
        xj.hf(this.u);
        return xj;
    }

    public int u() {
        if (vm.tf(this.hf)) {
            if (this.f10302pl) {
                int hf = vm.hf(this.hf) - this.y;
                this.y = vm.hf(this.hf);
                return hf;
            }
            if (this.y >= vm.hf(this.hf)) {
                return 0;
            }
            this.y++;
        }
        return 1;
    }

    public com.bytedance.sdk.openadsdk.core.hf.xj w() {
        return this.d;
    }

    public boolean y() {
        return this.u;
    }

    public void hf(boolean z) {
        this.hf.pl(z);
    }

    public FullRewardExpressView hf(float f, float f2) {
        if (this.e == null) {
            xj(f, f2);
        }
        return this.e;
    }

    public ws xj() {
        return this.hf;
    }

    public void xj(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.p = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || xj() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.tf;
        if (wVar != null) {
            wVar.xj();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.tf.xj((Activity) fullRewardExpressView.getContext());
            }
        }
        this.c.xj(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.c.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.tf);
        fullRewardExpressView.setClickListener(this.c);
        this.f.xj(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.tf);
        fullRewardExpressView.setClickCreativeListener(this.f);
        this.d.xj(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.d.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.tf);
        ImageView imageView = new ImageView(this.xj);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(0)).to(imageView);
        this.p.addView(imageView);
    }

    public void xj(boolean z) {
        this.u = z;
    }

    public void xj(NativeExpressView nativeExpressView) {
        if (this.am.getAndSet(true)) {
            return;
        }
        Map<String, Object> xj = this.xj.xj(this.hf);
        dk.xj(xj, this.hf, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, xj, this.xj.n());
        com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
        ws wsVar = this.hf;
        ff.xj(wsVar != null ? wsVar.kd() : 0);
    }

    public void xj(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.xj, xj(), ai.xj(7, String.valueOf(wo.d(xj())), f, f2), hf(), false, null);
        this.e = fullRewardExpressView;
        fullRewardExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.hf.6
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, float f3, float f4) {
                hf.this.kd = true;
            }
        });
        this.e.e();
    }
}
