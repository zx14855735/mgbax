package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.xj.xj;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeExpressVideoView extends NativeExpressView implements w.u, w.InterfaceC0013w, tf {
    private long dk;
    private com.bytedance.sdk.component.adexpress.hf.u et;
    boolean hf;
    private com.bytedance.sdk.openadsdk.core.multipro.hf.xj ht;

    /* renamed from: io, reason: collision with root package name */
    private HashSet<String> f10375io;
    boolean kd;
    private long ra;
    int u;
    boolean w;
    int xj;

    public NativeExpressVideoView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        super(context, wsVar, hfVar, str, true);
        this.xj = 1;
        this.hf = false;
        this.w = true;
        this.kd = true;
        this.jk = com.bytedance.sdk.openadsdk.core.pz.hf().u(wo.d(this.d));
        am();
    }

    private void dk() {
        ExpressVideoView expressVideoView;
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if (((uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) || (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u)) && (expressVideoView = this.p) != null) {
            expressVideoView.hf(true);
            if (this.p.A_()) {
                this.p.setPauseIcon(true);
                this.p.setVideoPlayStatus(2);
            } else {
                this.p.setVideoPlayStatus(3);
                this.p.setPauseIcon(false);
            }
            this.p.performClick();
            this.p.y();
        }
    }

    private void ra() {
        try {
            this.ht = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
            ExpressVideoView xj = xj(this.y, this.d, this.c);
            this.p = xj;
            xj.setNativeExpressVideoView(this);
            this.p.setAdCreativeClickListener(new NativeVideoTsView.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xj
                public void xj(View view, int i) {
                    xj expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.xj(view, i);
                }
            });
            this.p.setShouldCheckNetChange(false);
            this.p.setControllerStatusCallBack(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
                public void xj(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                    NativeExpressVideoView.this.ht.xj = z;
                    NativeExpressVideoView.this.ht.kd = j;
                    NativeExpressVideoView.this.ht.y = j2;
                    NativeExpressVideoView.this.ht.c = j3;
                    NativeExpressVideoView.this.ht.u = z2;
                    NativeExpressVideoView.this.ht.f = z3;
                }
            });
            this.p.setVideoAdLoadListener(this);
            this.p.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.c)) {
                this.p.setIsAutoPlay(this.hf ? this.f.kd() : this.w);
            } else if ("splash_ad".equals(this.c)) {
                this.p.setIsAutoPlay(true);
            } else {
                this.p.setIsAutoPlay(this.w);
            }
            if ("splash_ad".equals(this.c)) {
                this.p.setIsQuiet(true);
            } else {
                this.p.setIsQuiet(com.bytedance.sdk.openadsdk.core.pz.hf().u(this.u));
            }
            this.p.w();
        } catch (Exception e) {
            this.p = null;
            com.bytedance.sdk.component.utils.pl.u("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    public void am() {
        this.am = new FrameLayout(this.y);
        this.u = wo.d(this.d);
        this.f10375io = new HashSet<>();
        u(this.u);
        ra();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g() {
        super.g();
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null) {
            expressVideoView.v();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.u.w getVideoController() {
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null) {
            return expressVideoView.getVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj getVideoModel() {
        return this.ht;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ExpressVideoView expressVideoView;
        int i;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if ((!(uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) && !(uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u)) || (expressVideoView = this.p) == null || (i = this.xj) == 2 || i == 5) {
            return;
        }
        expressVideoView.setNeedNativeVideoPlayBtnVisible(true);
        this.p.z_();
        this.p.y_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ExpressVideoView expressVideoView;
        ImageView imageView;
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if (((uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) || (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u)) && (expressVideoView = this.p) != null && z && (imageView = expressVideoView.hf) != null && imageView.getVisibility() == 0) {
            this.p.hf.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void p_() {
        w.u uVar = this.f10378pl;
        if (uVar != null) {
            uVar.p_();
        }
        com.bytedance.sdk.component.adexpress.hf.u uVar2 = this.et;
        if (uVar2 != null) {
            if (uVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) {
                ((com.bytedance.sdk.component.adexpress.dynamic.xj.xj) uVar2).kd();
            }
            com.bytedance.sdk.component.adexpress.hf.u uVar3 = this.et;
            if (uVar3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.u) uVar3).g();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void q_() {
        this.kd = false;
        w.InterfaceC0013w interfaceC0013w = this.g;
        if (interfaceC0013w != null) {
            interfaceC0013w.q_();
        }
        this.xj = 2;
    }

    public void qt() {
        this.p.tf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void r_() {
        this.kd = false;
        w.InterfaceC0013w interfaceC0013w = this.g;
        if (interfaceC0013w != null) {
            interfaceC0013w.r_();
        }
        this.qt = true;
        this.xj = 3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void s_() {
        this.kd = false;
        w.InterfaceC0013w interfaceC0013w = this.g;
        if (interfaceC0013w != null) {
            interfaceC0013w.s_();
        }
        this.qt = false;
        this.xj = 2;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void t_() {
        this.kd = false;
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if (uVar != null) {
            if (uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) {
                ((com.bytedance.sdk.component.adexpress.dynamic.xj.xj) uVar).u();
            }
            com.bytedance.sdk.component.adexpress.hf.u uVar2 = this.et;
            if (uVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.u) uVar2).pl();
            }
        }
        w.InterfaceC0013w interfaceC0013w = this.g;
        if (interfaceC0013w != null) {
            interfaceC0013w.t_();
        }
        this.xj = 5;
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xjVar.xj = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
    }

    public void u(int i) {
        int c = com.bytedance.sdk.openadsdk.core.pz.hf().c(i);
        if (3 == c) {
            this.hf = false;
            this.w = false;
        } else if (1 == c) {
            this.hf = false;
            this.w = com.bytedance.sdk.component.utils.am.u(this.y);
        } else if (2 == c) {
            if (com.bytedance.sdk.component.utils.am.kd(this.y) || com.bytedance.sdk.component.utils.am.u(this.y) || com.bytedance.sdk.component.utils.am.y(this.y)) {
                this.hf = false;
                this.w = true;
            }
        } else if (5 == c) {
            if (com.bytedance.sdk.component.utils.am.u(this.y) || com.bytedance.sdk.component.utils.am.y(this.y)) {
                this.hf = false;
                this.w = true;
            }
        } else if (4 == c) {
            this.hf = true;
        }
        if (!this.w) {
            this.xj = 3;
        }
        com.bytedance.sdk.component.utils.pl.xj("NativeVideoAdView", "mIsAutoPlay=" + this.w + ",status=" + c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void hf(com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar, com.bytedance.sdk.component.adexpress.hf.am amVar) {
        ExpressVideoView expressVideoView;
        this.et = uVar;
        if ((uVar instanceof am) && ((am) uVar).D_() != null) {
            ((am) this.et).D_().xj((tf) this);
        }
        if (amVar != null && amVar.w()) {
            if ((amVar.hf() == 2 || amVar.hf() == 7) && (expressVideoView = this.p) != null) {
                expressVideoView.xj(this.y, 25, h.hf(this.d));
            }
            xj(amVar);
        }
        com.bytedance.sdk.component.adexpress.hf.u uVar2 = this.et;
        if (uVar2 != null && (uVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.xj.xj) uVar2).xj(com.bytedance.sdk.openadsdk.core.pz.hf().u(this.u));
        }
        super.hf(uVar, amVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f, float f2, float f3, float f4, int i) {
    }

    public ExpressVideoView xj(Context context, ws wsVar, String str) {
        return new ExpressVideoView(context, wsVar, str, false);
    }

    private void xj(final com.bytedance.sdk.component.adexpress.hf.am amVar) {
        if (amVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(amVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.hf(amVar);
                }
            });
        }
    }

    public NativeExpressVideoView(boolean z, Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        super(z, context, wsVar, hfVar, str, true);
        this.xj = 1;
        this.hf = false;
        this.w = true;
        this.kd = true;
        this.jk = com.bytedance.sdk.openadsdk.core.pz.hf().u(wo.d(this.d));
        am();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
        super.xj(z);
        this.jk = z;
        this.p.hf(z, true);
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.p.getNativeVideoController().hf(z);
        }
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if (uVar == null || !(uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.xj.xj) uVar).xj(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.component.adexpress.hf.am amVar) {
        if (amVar == null) {
            return;
        }
        double y = amVar.y();
        double c = amVar.c();
        double f = amVar.f();
        double d = amVar.d();
        int w = r.w(this.y, (float) y);
        int w2 = r.w(this.y, (float) c);
        int w3 = r.w(this.y, (float) f);
        int w4 = r.w(this.y, (float) d);
        float w5 = amVar.pl() > 0.0f ? r.w(this.y, amVar.pl()) : 0.0f;
        float w6 = amVar.g() > 0.0f ? r.w(this.y, amVar.g()) : 0.0f;
        float w7 = amVar.am() > 0.0f ? r.w(this.y, amVar.am()) : 0.0f;
        float w8 = amVar.qt() > 0.0f ? r.w(this.y, amVar.qt()) : 0.0f;
        if (w6 < w5) {
            w5 = w6;
        }
        if (w7 >= w5) {
            w7 = w5;
        }
        if (w8 >= w7) {
            w8 = w7;
        }
        if (amVar.hf() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.am.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(w3, w4);
            }
            layoutParams.width = w3;
            layoutParams.height = w4;
            layoutParams.topMargin = w2;
            layoutParams.leftMargin = w;
            this.am.setLayoutParams(layoutParams);
        }
        r.hf(this.am, w8);
        this.am.removeAllViews();
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView != null) {
            this.am.addView(expressVideoView);
            this.p.xj(0L, true, false);
            u(this.u);
            if (!com.bytedance.sdk.component.utils.am.u(this.y) && !this.w && this.kd) {
                this.p.z_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.am.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.am);
        }
        if (amVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w) {
            FrameLayout zg = ((com.bytedance.sdk.openadsdk.core.ugeno.express.w) amVar).zg();
            if (zg != null) {
                ExpressVideoView expressVideoView2 = this.p;
                if (expressVideoView2 != null) {
                    expressVideoView2.setClickable(false);
                }
                zg.addView(this.am, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (amVar.hf() == 2) {
            View xj = amVar.xj();
            if (xj instanceof ViewGroup) {
                ExpressVideoView expressVideoView3 = this.p;
                if (expressVideoView3 != null) {
                    expressVideoView3.setClickable(false);
                }
                ((ViewGroup) xj).addView(this.am);
                return;
            }
            return;
        }
        this.pz.addView(this.am);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i) {
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView == null) {
            com.bytedance.sdk.component.utils.pl.u("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            expressVideoView.xj(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            expressVideoView.setVideoPlayStatus(i);
            this.p.setCanInterruptVideoPlay(true);
            this.p.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().tf();
        } else {
            if (i != 5) {
                return;
            }
            expressVideoView.xj(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
        if (i == -1 || wVar == null) {
            return;
        }
        if (i == 4) {
            dk();
        } else if (i != 5) {
            super.xj(view, i, wVar);
        } else {
            xj(!this.jk);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
        if (i == -1 || wVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.xj(view, i, wVar, i2);
                return;
            }
        } else if (this.c == "draw_ad") {
            ExpressVideoView expressVideoView = this.p;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        xj(!this.jk);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        return this.ra;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void xj(long j, long j2) {
        this.kd = false;
        w.InterfaceC0013w interfaceC0013w = this.g;
        if (interfaceC0013w != null) {
            interfaceC0013w.xj(j, j2);
        }
        if (xj(j)) {
            this.xj = 2;
        }
        this.ra = j;
        this.dk = j2;
        if (!this.f10375io.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.u.w videoController = this.p.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) videoController).u(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xjVar.c = j;
        }
        com.bytedance.sdk.component.adexpress.hf.u uVar = this.et;
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.u) uVar).xj(j, j2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void xj(int i, int i2) {
        w.u uVar = this.f10378pl;
        if (uVar != null) {
            uVar.xj(i, i2);
        }
        this.ra = this.dk;
        this.xj = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final int i, final String str) {
        super.xj(i, str);
        com.bykv.vk.openvk.component.video.api.u.w videoController = this.p.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.u uVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.u) videoController;
            uVar.u(50);
            uVar.xj(new xj.InterfaceC0196xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj.InterfaceC0196xj
                public void xj(long j, long j2) {
                    int abs = (int) Math.abs(i - j);
                    int i2 = i;
                    if (i2 < 0 || abs > 50 || i2 > j2 || abs >= 50 || NativeExpressVideoView.this.f10375io.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.p.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.p.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.p.performClick();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                NativeExpressVideoView.this.hf(i, str);
                            }
                        }, abs);
                    } else {
                        NativeExpressVideoView.this.p.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.p.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.p.performClick();
                        NativeExpressVideoView.this.hf(i, str);
                    }
                    NativeExpressVideoView.this.f10375io.add(str);
                }
            });
        }
    }

    private boolean xj(long j) {
        int i = this.xj;
        if (i != 5 && i != 3 && j > this.ra) {
            return true;
        }
        ExpressVideoView expressVideoView = this.p;
        return expressVideoView != null && expressVideoView.A_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        ExpressVideoView expressVideoView;
        if (this.xj == 3 && (expressVideoView = this.p) != null) {
            expressVideoView.w();
        }
        ExpressVideoView expressVideoView2 = this.p;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().ht()) {
            return this.xj;
        }
        return 1;
    }
}
