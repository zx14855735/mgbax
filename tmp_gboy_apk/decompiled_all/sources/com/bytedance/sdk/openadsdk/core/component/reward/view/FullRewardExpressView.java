package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.u;
import com.bytedance.sdk.component.adexpress.hf.w;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.xj.xj;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FullRewardExpressView extends NativeExpressView implements tf {
    private com.bytedance.sdk.openadsdk.core.ugeno.tf.xj ai;
    private xj dk;
    private View et;
    FullRewardExpressBackupView hf;
    private ImageView ht;

    /* renamed from: io, reason: collision with root package name */
    private xj.InterfaceC0196xj f10323io;
    private am kd;
    private HashSet<String> ra;
    private u u;
    com.bytedance.sdk.openadsdk.core.video.hf.xj w;
    private FullSwiperItemView.xj x;
    tf xj;

    public interface xj {
        void xj(int i);
    }

    public FullRewardExpressView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z, String str2) {
        super(context, wsVar, hfVar, str, z, str2);
        this.ra = new HashSet<>();
    }

    private void qt() {
        setBackupListener(new w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.hf.w
            public boolean xj(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).v();
                    FullRewardExpressView.this.hf = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                    fullRewardExpressView.hf.xj(((NativeExpressView) fullRewardExpressView).d, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    private void ra() {
        com.bytedance.sdk.openadsdk.core.video.hf.xj xjVar;
        if ((this.u instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) && (xjVar = this.w) != null) {
            if (xjVar.dq()) {
                this.w.y();
                hf(true);
            } else {
                this.w.f();
                hf(false);
            }
        }
    }

    public boolean am() {
        am amVar = this.kd;
        if (amVar == null) {
            return true;
        }
        return amVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w ? ((com.bytedance.sdk.openadsdk.core.ugeno.express.w) amVar).zg() != null : (amVar.f() == 0.0d || this.kd.d() == 0.0d) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
        super.c();
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g() {
        super.g();
        this.ra.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long getActualPlayDuration() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.getActualPlayDuration();
        }
        return 0L;
    }

    public am getRenderResult() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.u.w getVideoController() {
        return this.w;
    }

    public FrameLayout getVideoFrameLayout() {
        return pz() ? this.hf.getVideoContainer() : this.am;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void pl() {
        this.zg = true;
        this.am = new FrameLayout(this.y);
        super.pl();
        qt();
        if (getJsObject() != null) {
            getJsObject().pl(this.jk);
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.et = view;
    }

    public void setExpressVideoListenerProxy(tf tfVar) {
        this.xj = tfVar;
    }

    public void setInteractListener(FullSwiperItemView.xj xjVar) {
        this.x = xjVar;
    }

    public void setOnVideoSizeChangeListener(xj xjVar) {
        this.dk = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(boolean z) {
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.u.w wVar) {
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
            com.bytedance.sdk.openadsdk.core.video.hf.xj xjVar = (com.bytedance.sdk.openadsdk.core.video.hf.xj) wVar;
            this.w = xjVar;
            xjVar.u(50);
            this.w.xj(this.f10323io);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.tf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(com.bytedance.sdk.component.adexpress.hf.u<? extends android.view.View> r4, com.bytedance.sdk.component.adexpress.hf.am r5) {
        /*
            r3 = this;
            r3.u = r4
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.am
            if (r0 == 0) goto L25
            r0 = r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.am r0 = (com.bytedance.sdk.openadsdk.core.nativeexpress.am) r0
            com.bytedance.sdk.openadsdk.core.j r1 = r0.D_()
            if (r1 == 0) goto L16
            com.bytedance.sdk.openadsdk.core.j r1 = r0.D_()
            r1.xj(r3)
        L16:
            com.bytedance.sdk.openadsdk.core.j r1 = r0.D_()
            if (r1 == 0) goto L25
            com.bytedance.sdk.openadsdk.core.j r0 = r0.D_()
            java.lang.String r1 = r3.tf
            r0.w(r1)
        L25:
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.xj
            if (r0 == 0) goto L2f
            r0 = r4
            com.bytedance.sdk.openadsdk.core.ugeno.express.xj r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.xj) r0
            r0.xj(r3)
        L2f:
            if (r5 == 0) goto L96
            boolean r0 = r5.w()
            if (r0 == 0) goto L96
            r3.kd = r5
            int r0 = r5.hf()
            r1 = 2
            if (r0 != r1) goto L52
            android.view.View r0 = r5.xj()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L52
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.ViewGroup r1 = r3.getVideoContainer()
            r0.addView(r1)
            goto L58
        L52:
            android.widget.FrameLayout r0 = r3.am
            r1 = 1
            r3.xj(r0, r1)
        L58:
            int r0 = r5.hf()
            r1 = 10
            if (r0 != r1) goto L6d
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w
            if (r0 == 0) goto L6d
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.w r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.w) r0
            com.bytedance.sdk.openadsdk.core.ugeno.tf.xj r0 = r0.yo()
            r3.ai = r0
        L6d:
            int r0 = r5.hf()
            if (r0 != r1) goto L96
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w
            if (r0 == 0) goto L96
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.w r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.w) r0
            android.widget.FrameLayout r0 = r0.e()
            if (r0 == 0) goto L96
            android.view.View r1 = r3.et
            if (r1 == 0) goto L96
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 == 0) goto L91
            android.view.View r2 = r3.et
            r1.removeView(r2)
        L91:
            android.view.View r1 = r3.et
            r0.addView(r1)
        L96:
            super.hf(r4, r5)
            int r4 = r3.getVisibility()
            r3.kd(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.hf(com.bytedance.sdk.component.adexpress.hf.u, com.bytedance.sdk.component.adexpress.hf.am):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void kd() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.kd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void u() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int w() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.w();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.y();
        }
    }

    public void xj(final ViewGroup viewGroup, final boolean z) {
        if (this.kd == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.hf(viewGroup, z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(int i) {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.w(i);
        }
    }

    private void w(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.hf.xj xjVar;
        if ((this.u instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj) && z) {
            ImageView imageView = this.ht;
            if (imageView != null && imageView.getVisibility() == 0 && (xjVar = this.w) != null) {
                xjVar.y();
            } else {
                xj(this.jk);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
        super.xj(z);
        this.jk = z;
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.xj(z);
        }
        u uVar = this.u;
        if (uVar == null || !(uVar instanceof com.bytedance.sdk.component.adexpress.dynamic.xj.xj)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.xj.xj) uVar).xj(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i) {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.xj(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.xj();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f, float f2, float f3, float f4, int i) {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.xj(f, f2, f3, f4, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(final int i, final String str) {
        this.f10323io = new xj.InterfaceC0196xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj.InterfaceC0196xj
            public void xj(long j, long j2) {
                tf tfVar;
                int abs = (int) Math.abs(i - j);
                if (FullRewardExpressView.this.w.l() && (tfVar = FullRewardExpressView.this.xj) != null) {
                    abs = (int) Math.abs(i - tfVar.getActualPlayDuration());
                }
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                int i2 = fullRewardExpressView.w instanceof com.bytedance.sdk.openadsdk.core.component.reward.draw.u ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || abs > i2 || i3 > j2 || abs >= i2 || fullRewardExpressView.ra.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.w.y();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FullRewardExpressView.this.hf(i, str);
                            if (aq.e(((NativeExpressView) FullRewardExpressView.this).d) || vm.xj(((NativeExpressView) FullRewardExpressView.this).d)) {
                                FullRewardExpressView.this.xj.xj(2);
                            }
                            tf tfVar2 = FullRewardExpressView.this.xj;
                            if (tfVar2 != null) {
                                tfVar2.setPauseFromExpressView(true);
                            }
                        }
                    }, abs);
                } else {
                    FullRewardExpressView.this.w.y();
                    FullRewardExpressView.this.hf(i, str);
                    if (aq.e(((NativeExpressView) FullRewardExpressView.this).d) || vm.xj(((NativeExpressView) FullRewardExpressView.this).d)) {
                        FullRewardExpressView.this.xj.xj(2);
                    }
                    tf tfVar2 = FullRewardExpressView.this.xj;
                    if (tfVar2 != null) {
                        tfVar2.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.ra.add(str);
            }
        };
        com.bytedance.sdk.openadsdk.core.video.hf.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.u(50);
            this.w.xj(this.f10323io);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f) {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.xj(f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
        FullSwiperItemView.xj xjVar = this.x;
        if (xjVar != null) {
            xjVar.xj();
        }
        if (i != -1 && wVar != null && i == 3) {
            tf();
            return;
        }
        if (i == 5) {
            xj(!this.jk);
        } else if (i == 4) {
            ra();
        } else {
            super.xj(view, i, wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ViewGroup viewGroup, boolean z) {
        xj xjVar;
        am amVar = this.kd;
        if (amVar == null) {
            return;
        }
        double y = amVar.y();
        double c = this.kd.c();
        double f = this.kd.f();
        double d = this.kd.d();
        int w = r.w(this.y, (float) y);
        int w2 = r.w(this.y, (float) c);
        int w3 = r.w(this.y, (float) f);
        int w4 = r.w(this.y, (float) d);
        float w5 = this.kd.pl() > 0.0f ? r.w(this.y, this.kd.pl()) : 0.0f;
        float w6 = this.kd.g() > 0.0f ? r.w(this.y, this.kd.g()) : 0.0f;
        float w7 = this.kd.am() > 0.0f ? r.w(this.y, this.kd.am()) : 0.0f;
        float w8 = this.kd.qt() > 0.0f ? r.w(this.y, this.kd.qt()) : 0.0f;
        if (w6 < w5) {
            w5 = w6;
        }
        if (w7 >= w5) {
            w7 = w5;
        }
        if (w8 >= w7) {
            w8 = w7;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(w3, w4);
        }
        layoutParams.width = w3;
        layoutParams.height = w4;
        layoutParams.topMargin = w2;
        layoutParams.leftMargin = w;
        viewGroup.setLayoutParams(layoutParams);
        r.hf(viewGroup, w8);
        if (z) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.u.w() == 7 || this.u.w() == 10) {
                am amVar2 = this.kd;
                if (amVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w) {
                    FrameLayout zg = ((com.bytedance.sdk.openadsdk.core.ugeno.express.w) amVar2).zg();
                    if (zg != null) {
                        zg.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                    xjVar = this.dk;
                    if (xjVar != null || w4 == 0) {
                    }
                    xjVar.xj(w4);
                    return;
                }
            }
            this.pz.addView(viewGroup);
            xjVar = this.dk;
            if (xjVar != null) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
        FullSwiperItemView.xj xjVar = this.x;
        if (xjVar != null) {
            xjVar.xj();
        }
        if (i != -1 && wVar != null && i == 3) {
            tf();
        } else {
            super.xj(view, i, wVar, i2);
        }
    }

    public void xj(int i, int i2, int i3, int i4) {
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.ai;
        if (xjVar != null) {
            xjVar.xj(i, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.hf();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void hf(int i) {
        tf tfVar = this.xj;
        if (tfVar != null) {
            tfVar.hf(i);
        }
    }

    public void hf(boolean z) {
        if (this.ht == null) {
            this.ht = new ImageView(getContext());
            if (f.zg().eu() != null) {
                this.ht.setImageBitmap(f.zg().eu());
            } else {
                jk.xj(pz.getContext(), "tt_new_play_video", this.ht);
            }
            this.ht.setScaleType(ImageView.ScaleType.FIT_XY);
            int w = r.w(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(w, w);
            layoutParams.gravity = 17;
            this.am.addView(this.ht, layoutParams);
        }
        if (z) {
            this.ht.setVisibility(0);
        } else {
            this.ht.setVisibility(8);
        }
    }
}
