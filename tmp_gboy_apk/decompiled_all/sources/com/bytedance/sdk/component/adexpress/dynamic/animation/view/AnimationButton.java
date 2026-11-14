package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AnimationButton extends TextView implements hf {
    private float hf;
    private float kd;
    private float u;
    private float w;
    xj xj;

    public AnimationButton(Context context) {
        super(context);
        this.xj = new xj();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getMarqueeValue() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getRippleValue() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getShineValue() {
        return this.w;
    }

    public float getStretchValue() {
        return this.kd;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.xj.xj(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.xj.xj(this, i, i2);
    }

    public void setMarqueeValue(float f) {
        this.u = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.hf = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.w = f;
        postInvalidate();
    }

    public void setStretchValue(float f) {
        this.kd = f;
        this.xj.xj(this, f);
    }
}
