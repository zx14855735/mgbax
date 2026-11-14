package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashClickBarArrow extends FrameLayout {
    private ImageView c;
    private RelativeLayout d;
    private SplashDiffuseView f;
    private RelativeLayout hf;
    private ImageView kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private AnimatorSet f10326pl;
    private boolean tf;
    private ImageView u;
    private ImageView w;
    private ImageView xj;
    private FrameLayout y;

    public static class xj implements Interpolator {
        private xj() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SplashClickBarArrow(Context context) {
        super(context);
        this.tf = true;
        this.f10326pl = new AnimatorSet();
        hf(context);
    }

    public Animator getAnimator() {
        return this.f10326pl;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.f10326pl;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            pl.w(e.getMessage());
        }
    }

    private void hf(Context context) {
        View xj2 = xj(getContext());
        if (xj2 == null) {
            return;
        }
        addView(xj2);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.f = splashDiffuseView;
        this.y.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f.setVisibility(4);
    }

    private void w() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.tf) {
                    SplashClickBarArrow.this.f.xj();
                }
                SplashClickBarArrow.this.tf = !r2.tf;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.c, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                SplashClickBarArrow.this.c.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.f10326pl.playTogether(ofFloat, ofFloat2);
        this.f10326pl.setStartDelay(1000L);
    }

    public void xj(int i) {
        this.p = i;
        xj();
    }

    private View xj(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.xj = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.xj.setId(2114387592);
        layoutParams2.gravity = 16;
        xj(context, "tt_splash_click_bar_go", this.xj, true);
        this.xj.setLayoutParams(layoutParams2);
        frameLayout.addView(this.xj);
        r.xj((View) this.xj, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.hf = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.hf.setPadding(r.w(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.hf);
        r.xj((View) this.hf, 8);
        ImageView imageView = new ImageView(context);
        this.w = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.w.setAlpha(0.0f);
        xj(context, "tt_splash_arrow", this.w, false);
        this.w.setLayoutParams(layoutParams3);
        this.hf.addView(this.w);
        ImageView imageView2 = new ImageView(context);
        this.u = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.u.setAlpha(0.0f);
        xj(context, "tt_splash_arrow", this.u, true);
        this.u.setLayoutParams(layoutParams4);
        this.hf.addView(this.u);
        ImageView imageView3 = new ImageView(context);
        this.kd = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.kd.setAlpha(0.0f);
        xj(context, "tt_splash_arrow", this.kd, true);
        this.kd.setLayoutParams(layoutParams5);
        this.hf.addView(this.kd);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.hf.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.y = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.y.setClipChildren(false);
        this.y.setLayoutParams(layoutParams6);
        frameLayout.addView(this.y);
        r.xj((View) this.y, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.d = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.d.setClipChildren(false);
        this.d.setLayoutParams(layoutParams7);
        this.y.addView(this.d);
        ImageView imageView4 = new ImageView(context);
        this.c = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        xj(context, "tt_splash_hand", this.c, false);
        this.c.setLayoutParams(layoutParams8);
        this.d.addView(this.c);
        r.xj((View) this.c, 4);
        return frameLayout;
    }

    private void hf() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new xj());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "translationX", 0.0f, r.w(getContext(), 20.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new xj());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.u, "translationX", r.w(getContext(), 23.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.kd, "alpha", 0.0f, 1.0f);
        ofFloat5.setInterpolator(new xj());
        ofFloat5.setDuration(1300L);
        ofFloat5.setStartDelay(200L);
        ofFloat5.setRepeatCount(-1);
        ofFloat5.setRepeatMode(1);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.kd, "translationX", r.w(getContext(), 25.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat6.setDuration(1300L);
        ofFloat6.setStartDelay(200L);
        ofFloat6.setRepeatCount(-1);
        ofFloat6.setRepeatMode(1);
        this.f10326pl.playTogether(ofFloat, ofFloat3, ofFloat5, ofFloat2, ofFloat4, ofFloat6);
    }

    private void xj() {
        this.xj.setVisibility(8);
        this.hf.setVisibility(8);
        int i = this.p;
        if (i == 1) {
            this.hf.setVisibility(0);
            hf();
            return;
        }
        if (i == 2) {
            this.y.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.d.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.f.getMeasuredHeight() / 2.0f) - r.w(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.f.getMeasuredWidth() / 2.0f) - r.w(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.f.getMeasuredHeight()) / 2.0f) + r.w(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.f.getMeasuredWidth()) / 2.0f) + r.w(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.d.setLayoutParams(layoutParams);
                }
            });
            w();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.xj.setVisibility(0);
        }
    }

    private void xj(final Context context, final String str, final ImageView imageView, final boolean z) {
        com.bytedance.sdk.component.utils.f.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3
            @Override // java.lang.Runnable
            public void run() {
                final Drawable w = jk.w(context, str);
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        try {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ImageView imageView2 = imageView;
                            if (imageView2 == null || (drawable = w) == null) {
                                return;
                            }
                            if (z) {
                                imageView2.setBackground(drawable);
                            } else {
                                imageView2.setImageDrawable(drawable);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }
}
