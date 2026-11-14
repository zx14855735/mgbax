package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShineButton extends Button {
    private LinearGradient hf;
    private ValueAnimator kd;
    private float u;
    private Matrix w;
    private Paint xj;
    private float y;

    public ShineButton(Context context) {
        super(context);
        this.xj = new Paint(1);
        this.w = new Matrix();
        this.u = 0.0f;
        this.y = 0.3f;
        xj(context);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.kd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.kd.removeAllListeners();
            this.kd.removeAllUpdateListeners();
            this.kd = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.w;
        float f = this.u;
        matrix.setTranslate(f, f);
        this.hf.setLocalMatrix(this.w);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.xj);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.y;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.hf = linearGradient;
        this.xj.setShader(linearGradient);
        xj();
    }

    private void xj(Context context) {
        this.xj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.xj.setColor(-1);
    }

    private void xj() {
        ValueAnimator valueAnimator = this.kd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.kd.removeAllListeners();
            this.kd.removeAllUpdateListeners();
            this.kd = null;
        }
        float sqrt = (float) Math.sqrt((getHeight() * getHeight()) + (getWidth() * getWidth()));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-sqrt, sqrt);
        this.kd = ofFloat;
        ofFloat.setDuration(2000L);
        this.kd.setRepeatCount(-1);
        this.kd.setInterpolator(new LinearInterpolator());
        this.kd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.u = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.kd.start();
    }
}
