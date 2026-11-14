package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class xj extends FrameLayout {
    protected com.bytedance.sdk.openadsdk.et.xj.hf.xj.w c;
    protected boolean d;
    protected int f;
    protected NativeExpressView hf;
    protected com.bytedance.sdk.openadsdk.zg.w.w.hf kd;
    protected String tf;
    protected ws u;
    protected NativeExpressView w;
    protected final Context xj;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.xj y;

    public xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(context);
        this.tf = "banner_ad";
        this.xj = context;
        this.u = wsVar;
        this.kd = hfVar;
        xj();
    }

    private ObjectAnimator hf(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xj.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                xj.this.d = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return ofFloat;
    }

    public NativeExpressView getCurView() {
        return this.hf;
    }

    public NativeExpressView getNextView() {
        return this.w;
    }

    public void kd() {
        NativeExpressView nativeExpressView = this.hf;
        if (nativeExpressView != null) {
            nativeExpressView.e();
        }
    }

    public void setDuration(int i) {
        this.f = i;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar) {
        this.y = xjVar;
        NativeExpressView nativeExpressView = this.hf;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xj.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, int i) {
                    xj xjVar2 = xj.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar3 = xjVar2.y;
                    if (xjVar3 != null) {
                        xjVar3.xj(xjVar2, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, String str, int i) {
                    xj xjVar2 = xj.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar3 = xjVar2.y;
                    if (xjVar3 != null) {
                        xjVar3.xj(xjVar2, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).pz()) {
                        xj.this.xj(f, f2);
                    }
                    xj xjVar2 = xj.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar3 = xjVar2.y;
                    if (xjVar3 != null) {
                        xjVar3.xj(xjVar2, f, f2);
                    }
                }
            });
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        this.c = wVar;
    }

    public void u() {
        NativeExpressView nativeExpressView = this.hf;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.hf.g();
            this.hf = null;
        }
        NativeExpressView nativeExpressView2 = this.w;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.w.g();
            this.w = null;
        }
    }

    public void w() {
        NativeExpressView nativeExpressView = this.w;
        if (nativeExpressView != null) {
            nativeExpressView.e();
        }
    }

    public void xj() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.xj, this.u, this.kd, this.tf);
        this.hf = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void y() {
        if (this.d || this.w == null || this.hf == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(xj(this.hf)).with(hf(this.w));
        animatorSet.setDuration(this.f).start();
        r.xj((View) this.w, 0);
        this.d = true;
        NativeExpressView nativeExpressView = this.hf;
        this.hf = this.w;
        this.w = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.w.g();
            this.w = null;
        }
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.xj, wsVar, hfVar, this.tf);
        this.w = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xj.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, int i) {
                xj xjVar = xj.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar2 = xjVar.y;
                if (xjVar2 != null) {
                    xjVar2.xj(xjVar, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, float f, float f2) {
                xj.this.xj(f, f2);
                xj.this.y();
            }
        });
        r.xj((View) this.w, 8);
        addView(this.w, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean hf() {
        return this.w != null;
    }

    public void xj(float f, float f2) {
        int w = r.w(this.xj, f);
        int w2 = r.w(this.xj, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(w, w2);
        }
        layoutParams.width = w;
        layoutParams.height = w2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator xj(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
