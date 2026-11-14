package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RippleView extends View {
    private float c;
    private Animator.AnimatorListener d;
    private float f;
    private float hf;
    private Paint kd;
    private int tf;
    private ValueAnimator u;
    private ValueAnimator w;
    private float xj;
    private long y;

    public RippleView(Context context, int i) {
        super(context);
        this.y = 300L;
        this.c = 0.0f;
        this.tf = i;
        xj();
    }

    public void hf() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f);
        this.w = ofFloat;
        ofFloat.setDuration(this.y);
        this.w.setInterpolator(new LinearInterpolator());
        this.w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.w.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.xj, this.hf, this.c, this.kd);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.xj = i / 2.0f;
        this.hf = i2 / 2.0f;
        this.f = (float) (Math.hypot(i, i2) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.d = animatorListener;
    }

    public void w() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f, 0.0f);
        this.u = ofFloat;
        ofFloat.setDuration(this.y);
        this.u.setInterpolator(new LinearInterpolator());
        this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.d;
        if (animatorListener != null) {
            this.u.addListener(animatorListener);
        }
        this.u.start();
    }

    public void xj() {
        Paint paint = new Paint(1);
        this.kd = paint;
        paint.setStyle(Paint.Style.FILL);
        this.kd.setColor(this.tf);
    }
}
