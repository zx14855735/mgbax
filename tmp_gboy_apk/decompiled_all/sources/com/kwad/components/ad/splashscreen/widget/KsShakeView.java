package com.kwad.components.ad.splashscreen.widget;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.s.x;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsShakeView extends KSFrameLayout {
    private int KE;
    private float KF;
    private int KG;
    private int KH;
    private int KI;
    private float KJ;
    private float KK;
    private int KL;
    private Animator KM;
    private boolean KN;
    private ImageView ig;
    private Animator ih;
    private Paint mPaint;

    public KsShakeView(Context context) {
        this(context, null, 0);
    }

    private void nF() {
        this.ig.setImageResource(this.KL);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.KH);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.KJ);
        paint.setColor(this.KI);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.KF);
        paint.setColor(this.KG);
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void as(int i) {
        this.KE = i;
        if (i != 2) {
            setIconDrawableRes(R.drawable.ksad_ic_shake_hand);
        } else {
            setIconDrawableRes(R.drawable.ksad_ic_shake_phone);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.KE == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.KK, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    public final void nI() {
        this.KN = false;
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
            this.ih = null;
        }
        Animator a2 = a(this.ig, 100L, 16.0f);
        this.ih = a2;
        if (a2 != null) {
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.ig.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.KN || KsShakeView.this.ih == null) {
                        return;
                    }
                    KsShakeView.this.ih.start();
                }
            });
            this.ih.start();
        }
    }

    public final void nJ() {
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.KM;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.ih = null;
        this.KM = null;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setIconDrawableRes(int i) {
        ImageView imageView = this.ig;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public KsShakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.KF = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.KG = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.KH = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.KE = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.KI = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.KJ = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.KL = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.KK = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.c.a.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.ig, layoutParams);
        nF();
    }

    private static Animator b(View view, long j, float f) {
        Interpolator A4TApA2 = A2egSU.A4TApA(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L);
        duration.setInterpolator(A4TApA2);
        float f2 = -f;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration2.setInterpolator(A4TApA2);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(200L);
        duration3.setInterpolator(A4TApA2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration4.setInterpolator(A4TApA2);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    public KsShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.KN = false;
        a(context, attributeSet, i);
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.KN = true;
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
        this.ig.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.KM;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b = b(this, 100L, dimensionPixelSize);
        this.KM = b;
        b.addListener(animatorListenerAdapter);
        this.KM.start();
    }

    private Animator a(View view, long j, float f) {
        Interpolator A4TApA2;
        if (view == null) {
            return null;
        }
        if (this.KE == 1) {
            A4TApA2 = A2egSU.A4TApA(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            A4TApA2 = A2egSU.A4TApA(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        }
        return x.a(view, A4TApA2, 100L, 16.0f);
    }
}
