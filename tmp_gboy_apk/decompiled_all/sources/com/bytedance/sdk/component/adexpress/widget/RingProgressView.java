package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RingProgressView extends View {
    private boolean c;
    private Paint hf;
    private ValueAnimator kd;
    private float u;
    private RectF w;
    private Context xj;
    private int y;

    public RingProgressView(Context context) {
        super(context);
        this.y = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.xj = context;
        Paint paint = new Paint();
        this.hf = paint;
        paint.setAntiAlias(true);
        this.hf.setStyle(Paint.Style.STROKE);
        this.hf.setStrokeWidth(10.0f);
        this.hf.setColor(Color.parseColor("#80FFFFFF"));
        this.w = new RectF();
    }

    public void hf() {
        ValueAnimator valueAnimator = this.kd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c) {
            return;
        }
        canvas.drawArc(this.w, 270.0f, this.u, false, this.hf);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.w.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void setDuration(int i) {
        this.y = i;
    }

    public void w() {
        this.c = true;
        invalidate();
    }

    public void xj() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.kd = ofFloat;
        ofFloat.setDuration(this.y);
        this.kd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.u = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.kd.start();
    }
}
