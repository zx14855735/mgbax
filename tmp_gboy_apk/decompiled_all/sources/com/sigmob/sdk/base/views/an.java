package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class an extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13263a;
    private Paint b;
    private RectF c;
    private RectF d;
    private float e;
    private Float f;
    private float g;
    private Paint h;
    private float i;
    private PointF j;
    private Path k;
    private Paint l;
    private int m;
    private int n;
    private float o;
    private float p;
    private PointF q;
    private float r;

    public an(Context context) {
        super(context);
        this.e = 0.0f;
        this.g = 3.0f;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f13263a == null) {
            Paint paint = new Paint(1);
            this.f13263a = paint;
            paint.setColor(-1);
            this.f13263a.setStyle(Paint.Style.STROKE);
            float dipsToIntPixels = Dips.dipsToIntPixels(this.g, getContext());
            this.g = dipsToIntPixels;
            this.f13263a.setStrokeWidth(dipsToIntPixels);
            Paint paint2 = new Paint(1);
            this.b = paint2;
            paint2.setColor(-3355444);
            Paint paint3 = this.b;
            Paint.Style style = Paint.Style.FILL;
            paint3.setStyle(style);
            Paint paint4 = new Paint(1);
            this.h = paint4;
            paint4.setColor(-1);
            this.h.setStyle(style);
            float dipsToIntPixels2 = (this.m * 1.0f) / Dips.dipsToIntPixels(92.0f, getContext());
            this.r = dipsToIntPixels2;
            this.i = dipsToIntPixels2 * Dips.dipsToIntPixels(11.0f, getContext());
            this.c = new RectF();
            this.d = new RectF();
            this.j = new PointF(getWidth() / 2.0f, 0.0f);
            this.q = new PointF(getWidth() / 2.0f, this.i);
            this.k = new Path();
            Paint paint5 = new Paint(1);
            this.l = paint5;
            paint5.setStyle(style);
            this.l.setColor(-1);
            this.o = this.m - (this.i * 3.0f);
            this.p = this.g / 2.0f;
        }
    }

    private void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.an.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                an.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(2000L);
        ofFloat.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l == null) {
            return;
        }
        this.k.reset();
        a(this.k, this.j);
        canvas.drawPath(this.k, this.l);
        this.k.reset();
        a(this.k, this.q);
        canvas.drawPath(this.k, this.l);
        float f = this.g;
        float f2 = this.m;
        float f3 = this.o;
        float f4 = this.p;
        float f5 = (f2 - f3) - f4;
        this.c.set(f, f5, this.n - f, (f3 + f5) - (f4 * 2.0f));
        RectF rectF = this.c;
        float f6 = this.p;
        canvas.drawRoundRect(rectF, f6, f6, this.f13263a);
        float f7 = this.e;
        float f8 = (f7 > 0.98f ? this.g - this.p : ((1.0f - f7) * this.o) + this.g) + f5;
        float f9 = this.o;
        float f10 = this.g;
        float f11 = f5 + f9 + f10;
        if (f7 > 0.2f) {
            f11 = (f9 + f5) - f10;
        }
        this.d.set(f + this.p, f8, this.n - f10, f11);
        canvas.drawRect(this.d, this.b);
        float min = Math.min(this.r * Dips.dipsToIntPixels(3.0f, getContext()), this.g);
        int i = this.n;
        float f12 = i > 0 ? i / 5.0f : this.g;
        float f13 = (i - f12) / 2.0f;
        float f14 = ((f5 + this.o) - min) - this.g;
        canvas.drawRect(f13, f14, f13 + f12, f14 + min, this.h);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i2;
        this.n = i;
        a();
    }

    public an(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0.0f;
        this.g = 3.0f;
        a(context);
    }

    public void a(float f) {
        if (this.l == null) {
            return;
        }
        float max = Math.max(0.2f, f);
        this.e = max;
        float min = Math.min(1.0f, max);
        this.e = min;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f * 40.0f);
        ofFloat.setDuration(50L);
        ofFloat.start();
        this.l.setAlpha((int) (this.e * 255.0f));
        invalidate();
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0.0f;
        this.g = 3.0f;
        a(context);
    }

    private void a(Context context) {
        com.sigmob.sdk.base.utils.r.a(this, new A4TApA(3, this));
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (Math.tan(0.7853981633974483d) * this.i));
        float f = pointF.y;
        float f2 = this.i;
        float f3 = f + f2;
        float tan2 = (float) ((Math.tan(0.7853981633974483d) * f2) + pointF.x);
        float f4 = pointF.y + this.i;
        path.moveTo(tan, f3);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f4);
        path.lineTo(pointF.x, (this.i / 2.0f) + pointF.y);
        path.close();
    }
}
