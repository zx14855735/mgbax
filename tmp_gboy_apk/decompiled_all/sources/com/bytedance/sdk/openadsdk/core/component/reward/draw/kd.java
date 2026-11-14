package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.u.w;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends RecyclerView.ra implements ai.xj {

    /* renamed from: a, reason: collision with root package name */
    private final ai f10303a;
    private boolean ai;
    private int b;
    public TTProgressBar dk;
    public FullRewardExpressView e;
    private boolean en;
    public u et;
    private w.xj ff;
    public FrameLayout ht;

    /* renamed from: io, reason: collision with root package name */
    protected final AtomicBoolean f10304io;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.hf j;
    public FrameLayout jk;
    private int l;
    public FrameLayout pz;
    private boolean q;
    private final AnimatorSet r;
    public FrameLayout ra;
    public FrameLayout v;
    private LinearLayout wo;
    protected final AtomicBoolean x;
    public ViewGroup yo;
    private boolean z;

    public static class xj implements Interpolator {
        private xj() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public kd(View view) {
        super(view);
        this.f10303a = new ai(Looper.getMainLooper(), this);
        this.r = new AnimatorSet();
        this.f10304io = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.b = Integer.MAX_VALUE;
        this.yo = (ViewGroup) view.findViewById(2114387892);
        this.v = (FrameLayout) view.findViewById(2114387778);
        this.jk = (FrameLayout) view.findViewById(2114387812);
        this.pz = (FrameLayout) view.findViewById(2114387670);
        this.ht = (FrameLayout) view.findViewById(2114387821);
        this.ra = (FrameLayout) view.findViewById(2114387679);
        this.dk = (TTProgressBar) view.findViewById(2114387767);
        xj(view.getContext());
    }

    private void b() {
        FullRewardExpressView fullRewardExpressView = this.e;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
        this.b = Integer.MAX_VALUE;
        this.z = false;
        this.q = false;
        this.en = false;
        this.jk.removeAllViews();
        this.pz.removeAllViews();
        this.ht.removeAllViews();
        this.ra.removeAllViews();
        this.f10304io.set(false);
        this.x.set(false);
        this.v.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        u uVar = this.et;
        if (uVar != null) {
            uVar.tf();
        }
    }

    public com.bykv.vk.openvk.component.video.api.u.w a() {
        return this.et;
    }

    public void ai() {
        if (this.r.isStarted() && this.r.isPaused()) {
            this.r.resume();
        }
    }

    public void en() {
        u uVar = this.et;
        if (uVar != null) {
            uVar.y();
        }
    }

    public void ff() {
        FullRewardExpressView fullRewardExpressView = this.e;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
        u uVar = this.et;
        if (uVar != null) {
            uVar.d();
        }
    }

    public long j() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar = this.j;
        if (hfVar == null) {
            return -1L;
        }
        return hfVar.p();
    }

    public void l() {
        u uVar = this.et;
        if (uVar != null) {
            uVar.f();
        }
    }

    public void q() {
        if (this.r.isStarted() && this.r.isRunning()) {
            this.r.cancel();
        }
    }

    public boolean r() {
        return this.x.get();
    }

    public boolean wo() {
        u uVar = this.et;
        if (uVar == null) {
            return false;
        }
        return uVar.et();
    }

    public void x() {
        if (this.r.isStarted() && this.r.isRunning()) {
            this.r.pause();
        }
    }

    public void z() {
        if (this.et != null && this.q && this.z) {
            this.j.d();
            this.e.zg();
            if (this.en && this.et.dk()) {
                w(this.j.y());
                l();
            } else {
                this.en = true;
                this.f10303a.sendEmptyMessageDelayed(101, PushUIConfig.dismissTime);
                this.j.xj(this.e);
                this.et.xj(this.j.tf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (this.q) {
            if (this.b > r.kd(this.xj.getContext()) * 0.7f) {
                r.xj((View) this.wo, 0);
                this.r.start();
            }
            if (!z || this.f10304io.get()) {
                return;
            }
            this.f10304io.set(true);
        }
    }

    public void w(boolean z) {
        u uVar = this.et;
        if (uVar != null) {
            uVar.hf(z);
        }
    }

    public void hf(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        if (z) {
            z();
            return;
        }
        en();
        r.xj((View) this.wo, 8);
        this.r.cancel();
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar, float f, float f2) {
        this.j = hfVar;
        this.dk.setVisibility(0);
        b();
        FullRewardExpressView hf2 = hfVar.hf(f, f2);
        this.e = hf2;
        if (hfVar.kd) {
            if (hf2.pz()) {
                this.ht.setVisibility(8);
                this.ra.addView(xj(this.xj.getContext(), hfVar));
                this.ra.setVisibility(0);
            } else {
                this.e.xj((ViewGroup) this.v, false);
            }
            this.l = this.e.getDynamicShowType();
            this.z = true;
            z();
            this.dk.setVisibility(8);
        } else {
            hf2.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, float f3, float f4) {
                    if (kd.this.e.pz()) {
                        kd.this.ht.setVisibility(8);
                        kd kdVar = kd.this;
                        kdVar.ra.addView(kdVar.xj(view.getContext(), hfVar));
                        kd.this.ra.setVisibility(0);
                    } else {
                        kd kdVar2 = kd.this;
                        kdVar2.e.xj((ViewGroup) kdVar2.v, false);
                    }
                    kd kdVar3 = kd.this;
                    kdVar3.l = kdVar3.e.getDynamicShowType();
                    kd.this.z = true;
                    kd.this.z();
                    kd.this.dk.setVisibility(8);
                }
            });
        }
        this.e.setExpressVideoListenerProxy(new tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void f() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long getActualPlayDuration() {
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int hf() {
                if (kd.this.f10304io.get()) {
                    return 4;
                }
                kd kdVar = kd.this;
                if (kdVar.et == null || !kdVar.en) {
                    return 2;
                }
                if (kd.this.et.s()) {
                    return 5;
                }
                if (kd.this.et.ht()) {
                    return 1;
                }
                if (kd.this.et.dq()) {
                    return 2;
                }
                kd.this.et.dk();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void kd() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void p() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void tf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void u() {
                kd.this.x.set(true);
                if (kd.this.q) {
                    kd.this.ff.xj();
                    kd.this.j.hf(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void w(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(float f3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void y() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int w() {
                u uVar = kd.this.et;
                if (uVar == null) {
                    return 0;
                }
                return (int) (uVar.p() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i) {
                kd kdVar = kd.this;
                u uVar = kdVar.et;
                if (uVar == null) {
                    return;
                }
                if (i == 2) {
                    uVar.c(true);
                    if (kd.this.q) {
                        kd.this.ff.xj();
                        kd.this.en();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                kdVar.x.set(false);
                kd.this.et.c(false);
                if (kd.this.q) {
                    kd.this.ff.hf();
                    kd.this.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void hf(int i) {
                kd.this.ff.xj(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long xj() {
                return kd.this.et.p();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(float f3, float f4, float f5, float f6, int i) {
                kd.this.xj(f3, f4, f5, f6, i);
            }
        });
        this.e.setOnVideoSizeChangeListener(new FullRewardExpressView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.xj
            public void xj(int i) {
                kd.this.b = i;
            }
        });
        this.ht.addView(this.e);
        u uVar = new u(this.yo.getContext(), this.jk, hfVar.xj());
        this.et = uVar;
        this.e.setVideoController(uVar);
        hfVar.xj(this.jk, this.pz, this.e);
        this.et.xj(new hf(hfVar.kd(), vm.w(this.j.xj()), new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.hf.xj
            public void xj(boolean z) {
                kd.this.u(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.hf.xj
            public void xj() {
                kd.this.ff.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.kd.hf.xj
            public void xj(long j, long j2) {
                kd.this.ff.xj(j, j2);
            }
        }, this.f10303a));
        this.et.hf(this.j.p());
        this.e.yo();
    }

    public static class hf implements xj.InterfaceC0194xj {
        private final xj hf;
        private final ai kd;
        private final int u;
        private boolean w = false;
        private final xj.InterfaceC0194xj xj;

        public interface xj {
            void xj();

            void xj(long j, long j2);

            void xj(boolean z);
        }

        public hf(xj.InterfaceC0194xj interfaceC0194xj, int i, xj xjVar, ai aiVar) {
            this.xj = interfaceC0194xj;
            this.hf = xjVar;
            this.u = i;
            this.kd = aiVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void hf() {
            xj(true);
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.hf();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void w() {
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.w();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj() {
            this.w = false;
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj();
            }
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.xj();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj(int i, String str) {
            xj(true);
            this.w = false;
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj(long j, long j2) {
            this.kd.removeMessages(101);
            if (j2 > 20000 && j > Math.min(this.u * 1000, j2) * 0.75f) {
                xj(false);
                this.w = true;
            }
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj(j, j2);
            }
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.xj(j, j2);
            }
        }

        private void xj(boolean z) {
            xj xjVar;
            if (this.w || (xjVar = this.hf) == null) {
                return;
            }
            xjVar.xj(z);
        }
    }

    public View xj(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar) {
        String bh;
        String valueOf;
        View am = com.bytedance.sdk.openadsdk.res.kd.am(context);
        RelativeLayout relativeLayout = (RelativeLayout) am.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) am.findViewById(2114387793);
        TextView textView = (TextView) am.findViewById(2114387875);
        TextView textView2 = (TextView) am.findViewById(2114387630);
        TextView textView3 = (TextView) am.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) am.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(r.w(context, 15.0f));
            tTRatingBar.setStarImageHeight(r.w(context, 14.0f));
            tTRatingBar.setStarImagePadding(r.w(context, 4.0f));
            tTRatingBar.xj();
        }
        if (tTRoundRectImageView != null) {
            z uf = hfVar.xj().uf();
            if (uf != null && !TextUtils.isEmpty(uf.xj())) {
                com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(tTRoundRectImageView);
            } else {
                jk.xj(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            if (hfVar.xj().vh() != null && !TextUtils.isEmpty(hfVar.xj().vh().w())) {
                textView.setText(hfVar.xj().vh().w());
            } else {
                textView.setText(hfVar.xj().kr());
            }
        }
        if (textView2 != null) {
            int y = hfVar.xj().vh() != null ? hfVar.xj().vh().y() : 6870;
            String xj2 = jk.xj(context, "tt_comment_num");
            if (y > 10000) {
                valueOf = (y / 10000) + "万";
            } else {
                valueOf = String.valueOf(y);
            }
            textView2.setText(String.format(xj2, valueOf));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(hfVar.xj().bh())) {
                if (hfVar.xj().vw() != 4) {
                    bh = "查看详情";
                } else {
                    bh = "立即下载";
                }
            } else {
                bh = hfVar.xj().bh();
            }
            textView3.setText(bh);
        }
        r.xj((View) relativeLayout, (View.OnClickListener) hfVar.w(), "reward_draw_listener");
        return am;
    }

    private void xj(Context context) {
        if (this.ai) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.wo = linearLayout;
            linearLayout.setClipChildren(false);
            this.wo.setGravity(1);
            this.wo.setOrientation(1);
            ImageView imageView = new ImageView(context);
            jk.xj(context, "tt_ic_back_light", imageView);
            this.wo.addView(imageView, -1, -2);
            ImageView imageView2 = new ImageView(context);
            jk.xj(context, "tt_ic_back_light", imageView2);
            imageView2.setAlpha(0.7f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = r.w(context, -8.0f);
            this.wo.addView(imageView2, layoutParams);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setTextColor(-1);
            textView.setText("上滑浏览更多内容");
            this.wo.addView(textView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = r.w(context, 156.0f);
            this.yo.addView(this.wo, layoutParams2);
            this.yo.setClipChildren(false);
            this.wo.setVisibility(8);
            xj(imageView, imageView2);
        }
    }

    private void xj(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new xj());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, r.w(this.yo.getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new xj());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", r.w(this.yo.getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.r.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void xj(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar = this.j;
        if (hfVar == null || hfVar.w() == null) {
            return;
        }
        this.j.w().onClick(view);
    }

    public void xj(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.e;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.e.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.e.getVideoFrameLayout().getMeasuredHeight();
        if (this.et.aq()) {
            this.e.getVideoFrameLayout().animate().translationY(-((1.0f - f2) * measuredHeight)).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.e.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 101) {
            return;
        }
        u(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar = this.j;
        if (hfVar != null) {
            hfVar.c();
        }
    }

    public void xj(w.xj xjVar) {
        u uVar;
        this.ff = xjVar;
        if (xjVar == null || (uVar = this.et) == null) {
            return;
        }
        uVar.hf(xjVar.w());
    }
}
