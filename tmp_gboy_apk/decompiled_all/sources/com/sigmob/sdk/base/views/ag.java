package com.sigmob.sdk.base.views;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ag extends View {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13253a = "ag";
    private Paint b;
    private RectF c;
    private Paint d;
    private int e;
    private int f;
    private int g;

    public ag(Context context) {
        super(context);
        this.f = 15;
    }

    private void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.g = asIntPixels;
        this.b.setStrokeWidth(asIntPixels);
        this.b.setAlpha(127);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setColor(-1);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.e = Dips.asIntPixels(10.0f, getContext());
        int i = this.g;
        this.c = new RectF(i, i, getWidth() - this.g, getHeight() - this.g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.b.setAlpha(127);
        RectF rectF = this.c;
        float f = rectF.right;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.b);
        canvas.drawText("跳过", this.e, (((this.d.getFontMetrics().bottom - this.d.getFontMetrics().top) / 2.0f) + (this.c.bottom / 2.0f)) - this.d.getFontMetrics().bottom, this.d);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.g = asIntPixels;
        this.b.setStrokeWidth(asIntPixels);
        this.b.setAlpha(127);
        RectF rectF2 = this.c;
        float f2 = rectF2.right;
        canvas.drawRoundRect(rectF2, f2 / 2.0f, f2 / 2.0f, this.b);
        float measureText = (this.e / 2.0f) + this.d.measureText("跳过") + this.e;
        int i = this.g;
        canvas.drawLine(measureText + (i * 2), i * 2, measureText + (i * 2), this.c.bottom - (i * 2), this.b);
        int i2 = this.f;
        if (i2 > 9) {
            canvas.drawText(String.valueOf(i2), (this.e / 2.0f) + measureText, (((this.d.getFontMetrics().bottom - this.d.getFontMetrics().top) / 2.0f) + (this.c.bottom / 2.0f)) - this.d.getFontMetrics().bottom, this.d);
            return;
        }
        canvas.drawText(String.valueOf(i2), measureText + this.e, (((this.d.getFontMetrics().bottom - this.d.getFontMetrics().top) / 2.0f) + (this.c.bottom / 2.0f)) - this.d.getFontMetrics().bottom, this.d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public ag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 15;
    }

    public void a(int i) {
        SigmobLogger.d(f13253a, CtFAbx.ARc23Z(i, "updateTimer: countdown = "), new Object[0]);
        this.f = i;
        invalidate();
    }

    public ag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 15;
    }
}
