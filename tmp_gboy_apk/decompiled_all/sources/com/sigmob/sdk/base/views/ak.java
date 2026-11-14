package com.sigmob.sdk.base.views;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ak extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f13259a;
    private Paint b;
    private Paint c;
    private Paint d;
    private Path e;
    private Path f;
    private Path g;
    private PointF h;
    private PointF i;
    private PointF j;
    private float k;

    public ak(Context context) {
        super(context);
        b();
    }

    private AnimatorSet a(PointF pointF, Paint paint, int i) {
        int alpha = paint.getAlpha();
        float f = pointF.y;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, (f - getHeight()) - this.f13259a);
        ofFloat.addUpdateListener(new Nm94Z2.A4TApA(this, 3, pointF));
        ofFloat.setRepeatCount(-1);
        ValueAnimator ofInt = ValueAnimator.ofInt(alpha, 0);
        ofInt.addUpdateListener(new Nm94Z2.A4TApA(this, 4, paint));
        ofInt.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i * 1000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofInt);
        return animatorSet;
    }

    private void b() {
        float dipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        this.f13259a = dipsToIntPixels;
        this.k = dipsToIntPixels * 2.0f;
        Paint paint = new Paint(1);
        this.b = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.b.setStrokeWidth(this.f13259a);
        this.b.setColor(-1);
        this.b.setAlpha(255);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(style);
        this.c.setStrokeWidth(this.f13259a);
        this.c.setColor(-1);
        this.c.setAlpha(127);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(style);
        this.d.setStrokeWidth(this.f13259a);
        this.d.setColor(-1);
        this.d.setAlpha(76);
        this.e = new Path();
        this.f = new Path();
        this.g = new Path();
    }

    private void c() {
        this.e.reset();
        this.f.reset();
        this.g.reset();
        a(this.e, this.h);
        a(this.f, this.i);
        a(this.g, this.j);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.e, this.b);
        canvas.drawPath(this.f, this.c);
        canvas.drawPath(this.g, this.d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        float f2 = i2;
        float dipsToIntPixels = Dips.dipsToIntPixels(13.0f, getContext());
        this.h = new PointF(f, this.f13259a + f2);
        this.i = new PointF(f, this.f13259a + f2 + dipsToIntPixels);
        this.j = new PointF(f, (dipsToIntPixels * 2.0f) + f2 + this.f13259a);
        c();
        a();
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void a() {
        AnimatorSet a2 = a(this.h, this.b, 2);
        AnimatorSet a3 = a(this.i, this.c, 2);
        AnimatorSet a4 = a(this.j, this.d, 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a2, a3, a4);
        animatorSet.start();
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Paint paint, ValueAnimator valueAnimator) {
        paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        invalidate();
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (Math.tan(2.0943951023931953d) * this.k));
        float f = pointF.y;
        float f2 = this.k;
        float f3 = f + f2;
        float tan2 = (float) ((Math.tan(2.0943951023931953d) * f2) + pointF.x);
        float f4 = pointF.y + this.k;
        path.moveTo(tan, f3);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PointF pointF, ValueAnimator valueAnimator) {
        pointF.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        c();
        invalidate();
    }
}
