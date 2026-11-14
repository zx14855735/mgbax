package com.skydoves.colorpickerview.sliders;

import BPw6Q8.ASJ6gh;
import BTvldC.AcNBzu;
import BTvldC.B4ZgIw;
import NOd7IU.AlLFFp;
import QdhHFU.A2egSU;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BrightnessSlideBar extends A2egSU {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f13822BI9f7h = 0;

    public BrightnessSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // QdhHFU.A2egSU
    public final int A2egSU() {
        float[] fArr = {0.0f, 0.0f, this.f7477AzWtSf};
        Color.colorToHSV(getColor(), fArr);
        ColorPickerView colorPickerView = this.f7474AcNBzu;
        return (colorPickerView == null || colorPickerView.getAlphaSlideBar() == null) ? Color.HSVToColor(fArr) : Color.HSVToColor((int) (this.f7474AcNBzu.getAlphaSlideBar().getSelectorPosition() * 255.0f), fArr);
    }

    @Override // QdhHFU.A2egSU
    public final void A4TApA(AttributeSet attributeSet) {
        int resourceId;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f13818A4TApA);
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
        this.f7483B9tovu.post(new CtFAbx.A2egSU(15, this));
    }

    @Override // QdhHFU.A2egSU
    public final void ARc23Z(Paint paint) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(getColor(), fArr);
        int HSVToColor = Color.HSVToColor(fArr);
        fArr[2] = 1.0f;
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), HSVToColor, Color.HSVToColor(fArr), Shader.TileMode.CLAMP));
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
