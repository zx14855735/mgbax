package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.tf;
import com.bytedance.sdk.component.utils.ht;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ShakeAnimationView extends LinearLayout {
    private TextView c;
    private LinearLayout d;
    private xj f;
    private TextView hf;
    private ht kd;
    private boolean p;
    private tf tf;
    private ImageView u;
    private TextView w;
    public int xj;
    private TextView y;

    /* renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.u != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new hf(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.u.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                ShakeAnimationView.this.u.startAnimation(rotateAnimation);
            }
        }
    }

    public static class hf implements Interpolator {
        private hf() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        public /* synthetic */ hf(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface xj {
        void xj(boolean z);
    }

    public ShakeAnimationView(Context context, View view, tf tfVar, boolean z, int i) {
        super(context);
        this.tf = tfVar;
        this.p = z;
        this.xj = i;
        xj(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.kd == null) {
                this.kd = new ht(getContext().getApplicationContext(), 1, this.p);
            }
            this.kd.xj(new ht.xj() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.ht.xj
                public void xj(int i) {
                    boolean xj2 = ShakeAnimationView.this.kd != null ? ShakeAnimationView.this.kd.xj() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.f != null) {
                        ShakeAnimationView.this.f.xj(xj2);
                    }
                }
            });
            if (this.tf != null) {
                this.kd.xj(r0.xj());
                this.kd.w(this.tf.c());
                this.kd.w(this.tf.hf());
                this.kd.kd(this.tf.u());
                this.kd.hf(this.tf.w());
                this.kd.y(this.tf.kd());
                this.kd.xj(this.tf.y());
                this.kd.hf(this.tf.f());
                this.kd.xj(this.xj);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ht htVar = this.kd;
        if (htVar != null) {
            htVar.hf(this.xj);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ht htVar = this.kd;
        if (htVar != null) {
            if (z) {
                htVar.xj(this.xj);
            } else {
                htVar.hf(this.xj);
            }
        }
    }

    public void setOnShakeViewListener(xj xjVar) {
        this.f = xjVar;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.y.setText(str);
        } else {
            this.y.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public void xj(Context context, View view) {
        addView(view);
        this.d = (LinearLayout) findViewById(2097610727);
        this.u = (ImageView) findViewById(2097610725);
        this.hf = (TextView) findViewById(2097610724);
        this.w = (TextView) findViewById(2097610726);
        this.y = (TextView) findViewById(2097610723);
        this.c = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.d.setBackground(gradientDrawable);
    }

    public void xj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}
