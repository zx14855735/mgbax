package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aj extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f13258a;
    private int b;
    private Paint c;
    private Path d;

    public aj(Context context) {
        super(context);
        a();
    }

    private void a() {
    }

    private void b() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        this.f13258a = Dips.dipsToIntPixels(5.0f, getContext());
        this.b = height / 2;
        this.d = new Path();
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.f13258a);
        this.c.setColor(-1);
        a(this.d, new PointF(width / 2.0f, this.b));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.d, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }

    public aj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (Math.tan(2.0943951023931953d) * this.b));
        float f = pointF.y;
        int i = this.b;
        float f2 = f + i;
        float tan2 = (float) ((Math.tan(2.0943951023931953d) * i) + pointF.x);
        float f3 = pointF.y + this.b;
        path.moveTo(tan, f2);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f3);
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
