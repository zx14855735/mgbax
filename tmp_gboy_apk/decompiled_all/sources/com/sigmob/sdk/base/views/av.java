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
public class av extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13276a;
    private Path b;
    private int c;
    private RectF d;
    private RectF e;
    private RectF f;
    private int g;
    private int h;

    public av(Context context) {
        super(context);
    }

    private void a() {
        this.f13276a = new Paint();
        this.b = new Path();
        int width = getWidth();
        int height = getHeight();
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f = dipsToIntPixels;
        this.f13276a.setStrokeWidth(f);
        float f2 = width;
        float f3 = f2 / (100.0f * f);
        this.g = (int) (15.0f * f3);
        this.h = (int) (6.0f * f3);
        this.c = Math.max((int) (f3 * f * 3.0f), dipsToIntPixels * 2);
        float f4 = height;
        float f5 = 0.4f * f4;
        float f6 = (10.0f * f5) / 16.0f;
        float f7 = (f2 - f6) / 2.0f;
        float f8 = (f4 - f5) / 2.0f;
        this.f = new RectF(f7, f8, f6 + f7, f5 + f8);
        RectF rectF = this.f;
        float f9 = rectF.left;
        int i = this.c;
        this.e = new RectF(f9 + i, rectF.top + i, rectF.right - i, rectF.bottom - (i * 3));
        RectF rectF2 = this.f;
        float f10 = rectF2.left;
        float width2 = rectF2.width();
        int i2 = this.c;
        float f11 = ((width2 - (i2 * 2)) / 2.2f) + f10;
        RectF rectF3 = this.f;
        this.d = new RectF(f11, rectF3.bottom - (i2 * 2), rectF3.right - ((rectF3.width() - (r6 * 2)) / 2.2f), this.f.bottom - this.c);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public av(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(Canvas canvas) {
        this.b.reset();
        this.f13276a.setColor(-1);
        this.f13276a.setStyle(Paint.Style.FILL);
        Path path = this.b;
        RectF rectF = this.f;
        int i = this.g;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        Path path2 = this.b;
        RectF rectF2 = this.e;
        int i2 = this.h;
        Path.Direction direction = Path.Direction.CCW;
        path2.addRoundRect(rectF2, i2, i2, direction);
        Path path3 = this.b;
        RectF rectF3 = this.d;
        int i3 = this.h;
        path3.addRoundRect(rectF3, i3, i3, direction);
        this.b.close();
        canvas.drawPath(this.b, this.f13276a);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
