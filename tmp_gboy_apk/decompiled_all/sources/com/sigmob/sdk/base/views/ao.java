package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ao extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13265a;
    private RectF b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Path m;
    private AnimatorSet n;
    private boolean o;

    public ao(Context context) {
        super(context);
        this.f13265a = new Paint(1);
        this.m = new Path();
        this.b = new RectF();
        c();
    }

    private Animator a(int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.sigmob.sdk.base.common.a.B, 0.0f, i, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (-this.l) * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new A5SV6n(this, 2));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.ao.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ao.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ao.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.k = getWidth();
        int height = getHeight();
        this.l = height;
        if (this.k == 0 || height == 0) {
            return;
        }
        this.f13265a.setStyle(Paint.Style.STROKE);
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.g = dipsToIntPixels;
        this.f13265a.setStrokeWidth(dipsToIntPixels);
        this.f13265a.setColor(-1);
        this.f = (int) ((this.k / (this.g * 75.0f)) * Dips.dipsToIntPixels(5.0f, getContext()));
        setLayerType(2, null);
        float f = this.k;
        int i = this.g;
        this.h = Math.max((int) ((f / (i * 25.0f)) * i * 11.0f), i * 3);
        float f2 = this.k;
        int i2 = this.g;
        this.i = Math.max((int) ((f2 / (i2 * 25.0f)) * 3.0f * i2), i2 * 2);
        float f3 = this.k;
        int i3 = this.g;
        this.j = Math.max((int) ((f3 / (i3 * 25.0f)) * 11.0f * i3), i3 * 5);
        e();
    }

    private void e() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.n = new AnimatorSet();
        this.n.playSequentially(a(-45), a(45), getFlipLeftAnimation(), getFlipRightAnimation());
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.ao.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ao.this.n == null || !ao.this.o) {
                    return;
                }
                ao.this.n.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.o) {
            this.n.start();
        }
    }

    private Animator getFlipLeftAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, 45.0f, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, this.k * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new A5SV6n(this, 1));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator getFlipRightAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, -45.0f, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (-this.k) * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new A5SV6n(this, 0));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k == 0 || this.l == 0) {
            return;
        }
        this.f13265a.setStyle(Paint.Style.STROKE);
        this.f13265a.setColor(-1);
        this.m.reset();
        RectF rectF = this.b;
        int i = this.g;
        rectF.set(i, i, this.k - i, this.l - i);
        Path path = this.m;
        RectF rectF2 = this.b;
        int i2 = this.f;
        path.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        canvas.drawPath(this.m, this.f13265a);
        canvas.clipPath(this.m);
        Paint paint = this.f13265a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f13265a.setColor(-7829368);
        this.f13265a.setAlpha(204);
        canvas.drawRect(0.0f, 0.0f, this.k, this.l, this.f13265a);
        this.f13265a.setColor(-3355444);
        this.f13265a.setAlpha(255);
        int i3 = this.l;
        canvas.drawRect(0.0f, this.c + i3, this.k, i3, this.f13265a);
        float f = this.d;
        canvas.drawRect(((-this.k) * 0.6f) + f, 0.0f, f, this.l, this.f13265a);
        int i4 = this.k;
        float f2 = this.e;
        canvas.drawRect(i4 + f2, 0.0f, (i4 * 1.6f) + f2, this.l, this.f13265a);
        this.f13265a.setStyle(style);
        int i5 = this.k;
        int i6 = this.h;
        int i7 = (i5 - i6) / 2;
        int i8 = this.l - this.j;
        float f3 = i7 + i6;
        int i9 = this.i;
        canvas.drawRoundRect(i7, i8, f3, i8 + i9, i9, i9, this.f13265a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }

    public ao(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ValueAnimator valueAnimator) {
        this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void a() {
        this.o = true;
        AnimatorSet animatorSet = this.n;
        if (animatorSet == null) {
            return;
        }
        animatorSet.start();
    }

    public void b() {
        this.o = false;
        AnimatorSet animatorSet = this.n;
        if (animatorSet == null) {
            return;
        }
        animatorSet.cancel();
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }
}
