package com.skydoves.colorpickerview.sliders;

import BPw6Q8.ASJ6gh;
import BTvldC.AcNBzu;
import BTvldC.B4ZgIw;
import NOd7IU.AlLFFp;
import QdhHFU.A2egSU;
import QdhHFU.A4TApA;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.skydoves.colorpickerview.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AlphaSlideBar extends A2egSU {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Bitmap f13820BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final A4TApA f13821BIYEnU;

    public AlphaSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13821BIYEnU = new A4TApA();
    }

    @Override // QdhHFU.A2egSU
    public final int A2egSU() {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        return Color.HSVToColor((int) (this.f7477AzWtSf * 255.0f), fArr);
    }

    @Override // QdhHFU.A2egSU
    public final void A4TApA(AttributeSet attributeSet) {
        int resourceId;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f13817A2egSU);
        try {
            if (obtainStyledAttributes.hasValue(2) && (resourceId = obtainStyledAttributes.getResourceId(2, -1)) != -1) {
                this.f7479B2KMhB = AlLFFp.CQhlFr(getContext(), resourceId);
            }
            if (obtainStyledAttributes.hasValue(0)) {
                this.f7481B4ZgIw = obtainStyledAttributes.getColor(0, this.f7481B4ZgIw);
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.f7480B3GDIM = obtainStyledAttributes.getInt(1, this.f7480B3GDIM);
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // QdhHFU.A2egSU
    public final void AMqCpz() {
        int width = getWidth() - this.f7483B9tovu.getWidth();
        if (getPreferenceName() == null) {
            this.f7483B9tovu.setX(width);
            return;
        }
        K7mCWO.A4TApA A2egSU2 = K7mCWO.A4TApA.A2egSU(getContext());
        String preferenceName = getPreferenceName();
        ASJ6gh((getSelectorSize() / 2) + A2egSU2.f4181A2egSU.getInt(preferenceName + "_SLIDER_ALPHA", width));
    }

    @Override // QdhHFU.A2egSU
    public final void ARc23Z(Paint paint) {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getMeasuredHeight(), Color.HSVToColor(0, fArr), Color.HSVToColor(255, fArr), Shader.TileMode.CLAMP));
    }

    public int getColor() {
        return this.f7482B7CMnp;
    }

    public String getPreferenceName() {
        return this.f7484BChYOn;
    }

    public int getSelectedX() {
        return this.f7478B25kr6;
    }

    @Override // QdhHFU.A2egSU, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f13820BI9f7h, 0.0f, 0.0f, (Paint) null);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f13820BI9f7h = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f13820BI9f7h);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        A4TApA a4TApA = this.f13821BIYEnU;
        a4TApA.setBounds(0, 0, width, height);
        canvas.drawPaint(a4TApA.f7485A2egSU);
    }

    public void setBorderColor(int i) {
        this.f7481B4ZgIw = i;
        this.f7476AmA8tU.setColor(i);
        invalidate();
    }

    public void setBorderColorRes(int i) {
        setBorderColor(ASJ6gh.A4TApA(getContext(), i));
    }

    public void setBorderSize(int i) {
        this.f7480B3GDIM = i;
        this.f7476AmA8tU.setStrokeWidth(i);
        invalidate();
    }

    public void setBorderSizeRes(int i) {
        setBorderSize((int) getContext().getResources().getDimension(i));
    }

    @Override // QdhHFU.A2egSU, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setPreferenceName(String str) {
        this.f7484BChYOn = str;
    }

    @Override // QdhHFU.A2egSU
    public /* bridge */ /* synthetic */ void setSelectorByHalfSelectorPosition(float f) {
        super.setSelectorByHalfSelectorPosition(f);
    }

    @Override // QdhHFU.A2egSU
    public /* bridge */ /* synthetic */ void setSelectorDrawable(Drawable drawable) {
        super.setSelectorDrawable(drawable);
    }

    public void setSelectorDrawableRes(int i) {
        Resources resources = getContext().getResources();
        ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
        setSelectorDrawable(AcNBzu.A2egSU(resources, i, null));
    }

    @Override // QdhHFU.A2egSU
    public /* bridge */ /* synthetic */ void setSelectorPosition(float f) {
        super.setSelectorPosition(f);
    }
}
