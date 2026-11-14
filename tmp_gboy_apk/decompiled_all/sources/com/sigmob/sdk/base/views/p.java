package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f13316a;
    private final Path b;

    public p(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f13316a = paint;
        paint.setColor(-12303292);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.b = new Path();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.b.reset();
        getHeight();
        getWidth();
        this.b.moveTo(0.0f, 0.0f);
        this.b.lineTo(0.0f, getHeight());
        canvas.drawPath(this.b, this.f13316a);
    }
}
