package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.s.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class t extends b implements View.OnClickListener, com.kwad.components.ad.reward.e.o, com.kwad.sdk.core.g.b {
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private ViewGroup km;
    private TextView kn;
    private TextView ko;
    private ImageView kp;
    private FrameLayout kq;
    private ImageView kr;
    private FrameLayout ks;
    private TextView kt;
    private Animator ku;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cW() {
            if (t.this.km != null) {
                t.this.km.setVisibility(8);
            }
            if (t.this.ks != null) {
                t.this.ks.setVisibility(8);
            }
            if (t.this.gX != null) {
                t.this.gX.bQ(t.this.getContext());
            }
            if (t.this.ku != null) {
                t.this.ku.cancel();
                t.this.ku = null;
            }
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void dt() {
        /*
            r9 = this;
            int r0 = com.kwad.sdk.R.id.ksad_root_container
            android.view.View r0 = r9.findViewById(r0)
            com.kwad.sdk.core.view.AdBaseFrameLayout r0 = (com.kwad.sdk.core.view.AdBaseFrameLayout) r0
            android.content.Context r1 = r9.getContext()
            int r2 = com.kwad.sdk.R.layout.ksad_shake_center
            r3 = 0
            android.view.View r1 = com.kwad.sdk.o.m.a(r1, r2, r0, r3)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r9.km = r1
            r1.setVisibility(r3)
            android.view.ViewGroup r1 = r9.km
            android.content.res.Resources r1 = r1.getResources()
            r2 = 1
            com.kwad.components.ad.reward.g r4 = r9.tq     // Catch: java.lang.Throwable -> L33
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate     // Catch: java.lang.Throwable -> L33
            com.kwad.sdk.core.response.model.AdInfo r4 = com.kwad.sdk.core.response.b.e.er(r4)     // Catch: java.lang.Throwable -> L33
            int r4 = com.kwad.sdk.core.response.b.a.bg(r4)     // Catch: java.lang.Throwable -> L33
            r5 = 8
            if (r4 != r5) goto L37
            r4 = 1
            goto L38
        L33:
            r4 = move-exception
            com.kwad.sdk.core.d.c.printStackTrace(r4)
        L37:
            r4 = 0
        L38:
            int r5 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_icon_marginLeft
            int r5 = r1.getDimensionPixelSize(r5)
            com.kwad.components.ad.reward.g r6 = r9.tq
            int r6 = r6.mScreenOrientation
            r7 = 1112014848(0x42480000, float:50.0)
            if (r6 != r2) goto L56
            int r6 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_icon_marginBottom
            int r6 = r1.getDimensionPixelSize(r6)
            android.content.Context r8 = r9.getContext()
            int r8 = com.kwad.sdk.c.a.a.a(r8, r7)
            int r8 = r8 + r6
            goto L65
        L56:
            if (r4 == 0) goto L5f
            int r6 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_icon_live_shop_marginBottom
            int r8 = r1.getDimensionPixelSize(r6)
            goto L65
        L5f:
            int r6 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_icon_marginBottom
            int r8 = r1.getDimensionPixelSize(r6)
        L65:
            com.kwad.components.ad.reward.g r6 = r9.tq
            int r6 = r6.mScreenOrientation
            if (r6 != r2) goto L7b
            int r2 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_title_marginBottom
            int r2 = r1.getDimensionPixelSize(r2)
            android.content.Context r4 = r9.getContext()
            int r4 = com.kwad.sdk.c.a.a.a(r4, r7)
            int r4 = r4 + r2
            goto L8a
        L7b:
            if (r4 == 0) goto L84
            int r2 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_title_live_shop_marginBottom
            int r4 = r1.getDimensionPixelSize(r2)
            goto L8a
        L84:
            int r2 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_title_marginBottom
            int r4 = r1.getDimensionPixelSize(r2)
        L8a:
            int r2 = com.kwad.sdk.R.dimen.ksad_reward_shake_tips_height
            int r1 = r1.getDimensionPixelSize(r2)
            android.content.Context r2 = r9.getContext()
            int r6 = com.kwad.sdk.R.layout.ksad_shake_tips_title
            android.view.View r2 = com.kwad.sdk.o.m.a(r2, r6, r0, r3)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            r9.ks = r2
            int r3 = com.kwad.sdk.R.id.ksad_shake_tips_label
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r9.kt = r2
            android.widget.FrameLayout r2 = r9.ks
            r3 = 4
            r2.setVisibility(r3)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r2.<init>(r3, r1)
            r2.leftMargin = r5
            r2.bottomMargin = r4
            r1 = 83
            r2.gravity = r1
            android.widget.FrameLayout r1 = r9.ks
            r0.addView(r1, r2)
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r3, r3)
            r2 = 17
            r1.gravity = r2
            android.view.ViewGroup r2 = r9.km
            r0.addView(r2, r1)
            com.kwad.components.ad.reward.g r1 = r9.tq
            com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate
            r2 = 185(0xb9, float:2.59E-43)
            r3 = 0
            com.kwad.sdk.core.adlog.c.b(r1, r2, r3)
            android.view.ViewGroup r1 = r9.km
            com.kwad.components.ad.reward.presenter.t$6 r2 = new com.kwad.components.ad.reward.presenter.t$6
            r2.<init>()
            r1.post(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.t.dt():void");
    }

    private void initView() {
        this.kn = (TextView) this.km.findViewById(R.id.ksad_shake_center_title);
        this.ko = (TextView) this.km.findViewById(R.id.ksad_shake_center_sub_title);
        this.kp = (ImageView) this.km.findViewById(R.id.ksad_shake_center_icon);
        this.kq = (FrameLayout) this.km.findViewById(R.id.ksad_shake_center_circle_area);
        this.kr = (ImageView) this.km.findViewById(R.id.ksad_shake_center_circle_area_bg);
        this.kn.setOnClickListener(this);
        this.ko.setOnClickListener(this);
        this.kq.setOnClickListener(this);
        this.kt.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.tq.mAdTemplate);
        this.tq.a(this);
        this.tq.b(this.mPlayEndPageListener);
        dt();
        initView();
        a(er);
        float ei = com.kwad.sdk.core.response.b.b.ei(er);
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(ei);
            this.gX = dVar2;
            dVar2.a(this);
        } else {
            dVar.k(ei);
        }
        this.gX.bP(getContext());
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cc() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int ds() {
        return com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_reward_shake_tips_height) + com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.core.response.b.b.eg(com.kwad.sdk.core.response.b.e.er(this.tq.mAdTemplate))) {
            this.tq.a(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.km;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.km.getParent()).removeView(this.km);
            }
            this.km = null;
        }
        bw.b(getContext(), this.gZ);
        this.gZ = null;
        Animator animator = this.ku;
        if (animator != null) {
            animator.cancel();
            this.ku = null;
        }
        this.tq.c(this.mPlayEndPageListener);
    }

    private void a(AdInfo adInfo) {
        String ek = com.kwad.sdk.core.response.b.b.ek(adInfo);
        TextView textView = this.kn;
        if (textView != null) {
            textView.setText(ek);
        }
        TextView textView2 = this.kt;
        if (textView2 != null) {
            textView2.setText(ek);
        }
        String a2 = a(this.tq, adInfo);
        TextView textView3 = this.ko;
        if (textView3 != null) {
            textView3.setText("或点击" + a2);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String em = com.kwad.sdk.core.response.b.b.em(adInfo);
        com.kwad.components.core.e.d.d dVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo) || dVar == null) {
            return em;
        }
        int pR = dVar.pR();
        AdMatrixInfo.DownloadTexts eo = com.kwad.sdk.core.response.b.b.eo(adInfo);
        if (pR == 8) {
            return eo.installAppLabel;
        }
        if (pR != 12) {
            return eo.adActionDescription;
        }
        return eo.openAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(float f, float f2) {
        if (this.km == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.km.getResources();
        Animator a2 = x.a((View) this.kp, (Interpolator) null, 100L, 16.0f);
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.kp.setPivotX(t.this.kp.getWidth());
                t.this.kp.setPivotY(t.this.kp.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.km, "translationX", f - ((this.km.getWidth() / 2.0f) + this.km.getLeft()));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.km, "translationY", f2 - ((this.km.getHeight() / 2.0f) + this.km.getTop()));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.kq.getWidth();
        float width2 = this.kp.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.kr) { // from class: com.kwad.components.ad.reward.presenter.t.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.kp) { // from class: com.kwad.components.ad.reward.presenter.t.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) t.this.kr.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    t.this.kr.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.kn.setAlpha(floatValue);
                    t.this.ko.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.kn.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.kn) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.ko.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.ko) { // from class: com.kwad.components.ad.reward.presenter.t.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator clone = a2.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2
            private boolean kw = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.kw = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.kw) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.kp.setPivotX(dimension2);
                t.this.kp.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.ks.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    t.this.ks.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.ks.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.kt, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a2, a2.clone(), a2.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        com.kwad.sdk.core.c.b.Ji();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (!com.kwad.components.core.e.c.b.pl() && z) {
            com.kwad.components.ad.reward.g gVar = this.tq;
            if (gVar != null && !gVar.gW()) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d);
                this.tq.a(1, getContext(), 157, 1, 0L, false, bVar);
            }
            bw.a(new bg() { // from class: com.kwad.components.ad.reward.presenter.t.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("RewardShakePresenter", "onShakeEvent openGate2");
                    t.this.gX.KT();
                }
            }, null, 500L);
            com.kwad.sdk.core.response.b.e.er(this.tq.mAdTemplate);
            if (this.tq.gW()) {
                return;
            }
            bw.a(getContext(), this.gZ);
            return;
        }
        bw.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
            @Override // java.lang.Runnable
            public final void run() {
                t.this.gX.KT();
            }
        }, null, 500L);
    }
}
