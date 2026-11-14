package com.bytedance.sdk.component.adexpress.widget;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CircleRippleView extends View {
    private int am;
    private boolean c;
    private List<Integer> d;
    private List<Integer> f;
    private float g;
    private int hf;
    private float kd;
    private Paint p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10195pl;
    private Paint tf;
    private int u;
    private float w;
    private int xj;
    private int y;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    private void w() {
        Paint paint = new Paint();
        this.tf = paint;
        paint.setAntiAlias(true);
        this.tf.setStrokeWidth(this.am);
        this.f.add(255);
        this.d.add(0);
        Paint paint2 = new Paint();
        this.p = paint2;
        paint2.setAntiAlias(true);
        this.p.setColor(Color.parseColor("#0FFFFFFF"));
        this.p.setStyle(Paint.Style.FILL);
    }

    public void hf() {
        this.c = false;
        this.d.clear();
        this.f.clear();
        this.f.add(255);
        this.d.add(0);
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.tf.setShader(new LinearGradient(this.f10195pl, 0.0f, this.g, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.f.size()) {
                break;
            }
            Integer num = this.f.get(i);
            this.tf.setAlpha(num.intValue());
            Integer num2 = this.d.get(i);
            if (this.w + num2.intValue() < this.kd) {
                canvas.drawCircle(this.f10195pl, this.g, this.w + num2.intValue(), this.tf);
            }
            if (num.intValue() > 0 && num2.intValue() < this.kd) {
                this.f.set(i, Integer.valueOf(num.intValue() - this.y > 0 ? num.intValue() - (this.y * 3) : 1));
                this.d.set(i, Integer.valueOf(num2.intValue() + this.y));
            }
            i++;
        }
        if (((Integer) A2egSU.AlLFFp(this.d, 1)).intValue() >= this.kd / this.u) {
            this.f.add(255);
            this.d.add(0);
        }
        if (this.d.size() >= 3) {
            this.d.remove(0);
            this.f.remove(0);
        }
        this.tf.setAlpha(255);
        this.tf.setColor(this.hf);
        canvas.drawCircle(this.f10195pl, this.g, this.w, this.p);
        if (this.c) {
            invalidate();
        }
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
        float f = i / 2.0f;
        this.f10195pl = f;
        this.g = i2 / 2.0f;
        float f2 = f - (this.am / 2.0f);
        this.kd = f2;
        this.w = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void setColor(int i) {
        this.xj = i;
    }

    public void setCoreColor(int i) {
        this.hf = i;
    }

    public void setCoreRadius(int i) {
        this.w = i;
    }

    public void setDiffuseSpeed(int i) {
        this.y = i;
    }

    public void setDiffuseWidth(int i) {
        this.u = i;
    }

    public void setMaxWidth(int i) {
        this.kd = i;
    }

    public void xj() {
        this.c = true;
        invalidate();
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xj = -1;
        this.hf = -65536;
        this.w = 18.0f;
        this.u = 3;
        this.kd = 50.0f;
        this.y = 2;
        this.c = false;
        this.f = new ArrayList();
        this.d = new ArrayList();
        this.am = 24;
        w();
    }
}
