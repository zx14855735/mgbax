package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class au extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13275a;
    private Path b;
    private int c;
    private RectF d;
    private RectF e;
    private RectF f;

    public au(Context context) {
        super(context);
    }

    private void a() {
        this.f13275a = new Paint();
        this.b = new Path();
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.f13275a.setStrokeWidth(dipsToIntPixels);
        this.c = (int) ((getWidth() / (100.0f * dipsToIntPixels)) * dipsToIntPixels * 20.0f);
        int width = getWidth() - this.c;
        int height = getHeight();
        this.f13275a.setStyle(Paint.Style.STROKE);
        this.f13275a.setColor(-1);
        this.f13275a.setAntiAlias(true);
        float f = height;
        float f2 = f / 2.2f;
        this.d = new RectF(this.c, f2, width / 2.0f, f - f2);
        float f3 = this.c;
        RectF rectF = this.d;
        this.e = new RectF(f3, rectF.top, rectF.right, rectF.bottom);
        float width2 = this.e.width() + this.d.right;
        RectF rectF2 = this.d;
        this.f = new RectF(width2, rectF2.top, this.e.width() + rectF2.width() + rectF2.right, this.d.bottom);
    }

    private void b(Canvas canvas, RectF rectF) {
        this.b.reset();
        this.f13275a.setColor(-1);
        this.f13275a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.f, 90.0f, -180.0f);
        canvas.drawPath(this.b, this.f13275a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.d);
        b(canvas, this.d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(Canvas canvas, RectF rectF) {
        this.b.reset();
        this.f13275a.setColor(-1);
        this.f13275a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.e, 90.0f, 180.0f);
        canvas.drawPath(this.b, this.f13275a);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
