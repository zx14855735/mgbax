package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13327a;
    private RectF b;
    private Paint c;
    private int d;
    private int e;
    private String f;

    public w(Context context) {
        super(context);
        this.f = "";
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f13327a == null) {
            Paint paint = new Paint();
            this.f13327a = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f13327a.setColor(-1);
            int asIntPixels = Dips.asIntPixels(1.0f, getContext());
            this.e = asIntPixels;
            this.f13327a.setStrokeWidth(asIntPixels);
            this.f13327a.setAlpha(127);
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setColor(-1);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
            this.d = Dips.asIntPixels(10.0f, getContext());
        }
        int i = this.e;
        this.b = new RectF(i, i, getWidth() - this.e, getHeight() - this.e);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.f13327a;
        if (paint == null) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        this.f13327a.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.f13327a.setAlpha(102);
        RectF rectF = this.b;
        float f = rectF.right;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.f13327a);
        this.f13327a.setStyle(Paint.Style.STROKE);
        this.f13327a.setColor(-1);
        this.f13327a.setAlpha(76);
        RectF rectF2 = this.b;
        float f2 = rectF2.right;
        canvas.drawRoundRect(rectF2, f2 / 2.0f, f2 / 2.0f, this.f13327a);
        canvas.drawText(this.f, (getWidth() - this.c.measureText(this.f)) / 2.0f, (((this.c.getFontMetrics().bottom - this.c.getFontMetrics().top) / 2.0f) + (this.b.bottom / 2.0f)) - this.c.getFontMetrics().bottom, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public void setText(String str) {
        this.f = str;
        invalidate();
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = "";
        a(context);
    }

    private void a(Context context) {
        com.sigmob.sdk.base.utils.r.a(this, new Runnable() { // from class: com.sigmob.sdk.base.views.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.a();
            }
        });
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "";
        a(context);
    }
}
