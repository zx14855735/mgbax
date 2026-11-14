package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class al extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13260a;
    private Paint b;
    private RectF c;
    private RectF d;
    private float e;
    private float f;
    private Paint g;
    private float h;
    private PointF i;
    private Path j;
    private Paint k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private PointF q;
    private float r;

    public al(Context context) {
        super(context);
        this.e = 0.0f;
        this.f = 1.0f;
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f13260a = paint;
        paint.setColor(-1);
        this.f13260a.setStyle(Paint.Style.STROKE);
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.f = dipsToIntPixels;
        this.f13260a.setStrokeWidth((this.l / (100.0f * dipsToIntPixels)) * 3.0f * dipsToIntPixels);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(Color.parseColor("#B7B7B7"));
        Paint paint3 = this.b;
        Paint.Style style = Paint.Style.FILL;
        paint3.setStyle(style);
        Paint paint4 = new Paint(1);
        this.g = paint4;
        paint4.setColor(-1);
        this.g.setStyle(style);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(92.0f, getContext());
        int i = this.l;
        this.r = (i * 1.0f) / dipsToIntPixels2;
        this.h = i * 0.1f;
        this.c = new RectF();
        this.d = new RectF();
        float f = this.l * 0.2f;
        this.i = new PointF(getWidth() / 2.0f, f);
        this.q = new PointF(getWidth() / 2.0f, f + this.h);
        this.j = new Path();
        Paint paint5 = new Paint(1);
        this.k = paint5;
        paint5.setStyle(style);
        this.k.setColor(-1);
        float f2 = this.l * 0.3f;
        this.n = f2;
        this.o = f2 * 0.9f;
        this.p = this.f * 2.0f;
    }

    private void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.al.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                al.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
        if (this.f13260a == null) {
            return;
        }
        this.j.reset();
        a(this.j, this.i);
        canvas.drawPath(this.j, this.k);
        this.j.reset();
        a(this.j, this.q);
        canvas.drawPath(this.j, this.k);
        int i = this.l;
        float f = this.m;
        float f2 = this.o;
        float f3 = (f - f2) / 2.0f;
        float f4 = this.n;
        float f5 = (i - f4) - (i * 0.2f);
        RectF rectF = this.c;
        float f6 = this.p;
        rectF.set(f3 + f6, f5, (f2 + f3) - f6, f4 + f5 + this.f);
        RectF rectF2 = this.c;
        float f7 = this.p;
        canvas.drawRoundRect(rectF2, f7, f7, this.f13260a);
        float f8 = this.e;
        float f9 = (f8 > 0.98f ? this.f : this.f + ((1.0f - f8) * this.n)) + f5;
        float f10 = this.c.bottom;
        float f11 = this.f;
        if (f9 >= f10 - f11) {
            f9 = f10 - f11;
        }
        this.d.set(this.p + f3, f9, (f3 + this.o) - (f11 * 2.0f), f10);
        canvas.drawRect(this.d, this.b);
        float min = Math.min(this.r * Dips.dipsToIntPixels(3.0f, getContext()), this.f * 2.0f);
        float f12 = this.o;
        float f13 = f12 > 0.0f ? f12 / 5.0f : this.f * 3.0f;
        float f14 = (this.m - f13) / 2.0f;
        float f15 = this.n;
        float f16 = (f5 + f15) - (f15 / 4.0f);
        canvas.drawRect(f14, f16, f14 + f13, f16 + min, this.g);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = i2;
        this.m = i;
        a();
    }

    public al(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0.0f;
        this.f = 1.0f;
    }

    public void a(float f) {
        if (this.k == null) {
            return;
        }
        float max = Math.max(0.0f, f);
        this.e = max;
        float min = Math.min(1.0f, max);
        this.e = min;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f * 40.0f);
        ofFloat.setDuration(50L);
        ofFloat.start();
        this.k.setAlpha((int) (this.e * 255.0f));
        invalidate();
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0.0f;
        this.f = 1.0f;
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (Math.tan(0.7853981633974483d) * this.h));
        float f = pointF.y;
        float f2 = this.h;
        float f3 = f + f2;
        float tan2 = (float) ((Math.tan(0.7853981633974483d) * f2) + pointF.x);
        float f4 = pointF.y + this.h;
        path.moveTo(tan, f3);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f4);
        path.lineTo(pointF.x, (this.h / 2.0f) + pointF.y);
        path.close();
    }
}
