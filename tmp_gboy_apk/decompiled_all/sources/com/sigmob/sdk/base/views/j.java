package com.sigmob.sdk.base.views;

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
public class j extends View {

    /* renamed from: a, reason: collision with root package name */
    private static float f13302a;
    private Paint b;
    private Path c;
    private PointF d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private Paint i;

    public j(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.b = new Paint();
        this.i = new Paint();
        f13302a = Dips.dipsToIntPixels(6.0f, getContext());
        this.b.setColor(-1);
        this.b.setStrokeWidth(f13302a);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.i.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(51);
    }

    private void b() {
        double d = 0.62831855f;
        this.e = ((this.f / 2.0f) * ((float) Math.tan(d))) / ((float) Math.sin(d));
        this.d = new PointF(this.f / 2.0f, this.e + Dips.dipsToIntPixels(30.0f, getContext()));
        this.c = new Path();
        PointF pointF = this.d;
        float f = pointF.x;
        float f2 = this.e;
        float f3 = pointF.y;
        this.c.addArc(new RectF(f - f2, f3 - f2, f + f2, f3 + f2), 0.0f, -180.0f);
    }

    public float getLineWidth() {
        return this.b.getStrokeWidth();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            canvas.drawPath(this.c, this.i);
        }
        canvas.drawPath(this.c, this.b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i;
        this.g = i2;
        b();
    }

    public void setLineWidth(float f) {
        this.b.setStrokeWidth(f);
        invalidate();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a(boolean z) {
        this.h = z;
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
