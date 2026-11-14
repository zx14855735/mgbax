package com.google.android.material.slider;

import BPw6Q8.ASJ6gh;
import NOd7IU.AlLFFp;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PSeUZ5.ADYaiT;
import PSeUZ5.AMqCpz;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.SeekBar;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Slider extends ADYaiT {
    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.value});
        if (obtainStyledAttributes.hasValue(0)) {
            setValue(obtainStyledAttributes.getFloat(0, 0.0f));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.f7239ECyGFg;
    }

    public int getFocusedThumbIndex() {
        return this.f7240EGM26s;
    }

    public int getHaloRadius() {
        return this.f7213CmUvjW;
    }

    public ColorStateList getHaloTintList() {
        return this.f7248EicXu4;
    }

    public int getLabelBehavior() {
        return this.f7208CTkVKb;
    }

    public float getStepSize() {
        return this.f7241EH1KK8;
    }

    public float getThumbElevation() {
        return this.f7262FdMWEC.f7042AlLFFp.f7033AmA8tU;
    }

    public int getThumbHeight() {
        return this.f7212CkXcdM;
    }

    @Override // PSeUZ5.ADYaiT
    public int getThumbRadius() {
        return this.f7211CikNvS / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f7262FdMWEC.f7042AlLFFp.AMqCpz;
    }

    public float getThumbStrokeWidth() {
        return this.f7262FdMWEC.f7042AlLFFp.f7030AaHO0E;
    }

    public ColorStateList getThumbTintList() {
        return this.f7262FdMWEC.f7042AlLFFp.f7024ADYaiT;
    }

    public int getThumbTrackGapSize() {
        return this.f7214CqNSpT;
    }

    public int getThumbWidth() {
        return this.f7211CikNvS;
    }

    public int getTickActiveRadius() {
        return this.f7244EUIRHA;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f7249EmJGcg;
    }

    public int getTickInactiveRadius() {
        return this.f7245EY4UKY;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f7250ErKPGd;
    }

    public ColorStateList getTickTintList() {
        if (this.f7250ErKPGd.equals(this.f7249EmJGcg)) {
            return this.f7249EmJGcg;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.f7243EQurEW;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f7251EsrwYR;
    }

    @Override // PSeUZ5.ADYaiT
    public int getTrackCornerSize() {
        int i = this.f7218D07BeM;
        return i == -1 ? this.f7209CcAIMM / 2 : i;
    }

    public int getTrackHeight() {
        return this.f7209CcAIMM;
    }

    public ColorStateList getTrackIconActiveColor() {
        return this.f7225DG07BK;
    }

    public Drawable getTrackIconActiveEnd() {
        return this.f7223D9tr6l;
    }

    public Drawable getTrackIconActiveStart() {
        return this.f7221D8MqeW;
    }

    public ColorStateList getTrackIconInactiveColor() {
        return this.DXuj49;
    }

    public Drawable getTrackIconInactiveEnd() {
        return this.f7228DV2E8K;
    }

    public Drawable getTrackIconInactiveStart() {
        return this.f7226DRlcZ9;
    }

    public int getTrackIconSize() {
        return this.f7230DaOi9o;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f7252EwN40Z;
    }

    public int getTrackInsideCornerSize() {
        return this.f7219D6DOie;
    }

    public int getTrackSidePadding() {
        return this.f7210Cd8JRx;
    }

    public int getTrackStopIndicatorSize() {
        return this.f7217CtxOCS;
    }

    public ColorStateList getTrackTintList() {
        if (this.f7252EwN40Z.equals(this.f7251EsrwYR)) {
            return this.f7251EsrwYR;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.EdQ5bb;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    public float getValueFrom() {
        return this.f7236DuwtYk;
    }

    public float getValueTo() {
        return this.f7237DvK7DB;
    }

    @Override // PSeUZ5.ADYaiT
    public void setCentered(boolean z) {
        if (this.f7220D6yqiO == z) {
            return;
        }
        this.f7220D6yqiO = z;
        if (z) {
            setValues(Float.valueOf((this.f7236DuwtYk + this.f7237DvK7DB) / 2.0f));
        } else {
            setValues(Float.valueOf(this.f7236DuwtYk));
        }
        CQhlFr(true);
    }

    public void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    @Override // PSeUZ5.ADYaiT, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.f7238DyaChj.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f7240EGM26s = i;
        this.f7188B4ZgIw.BI9f7h(i);
        postInvalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setHaloRadius(int i) {
        if (i == this.f7213CmUvjW) {
            return;
        }
        this.f7213CmUvjW = i;
        Drawable background = getBackground();
        if (!(getBackground() instanceof RippleDrawable) || !(background instanceof RippleDrawable)) {
            postInvalidate();
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) background;
        int i2 = this.f7213CmUvjW;
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i2);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i2));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // PSeUZ5.ADYaiT
    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f7248EicXu4)) {
            return;
        }
        this.f7248EicXu4 = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        Paint paint = this.f7184AzWtSf;
        paint.setColor(AlLFFp(colorStateList));
        paint.setAlpha(63);
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setLabelBehavior(int i) {
        if (this.f7208CTkVKb != i) {
            this.f7208CTkVKb = i;
            CQhlFr(true);
        }
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(AMqCpz aMqCpz) {
    }

    @Override // PSeUZ5.ADYaiT
    public void setOrientation(int i) {
        if (this.f7205COJEAR == i) {
            return;
        }
        this.f7205COJEAR = i;
        CQhlFr(true);
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.f7241EH1KK8 != f) {
                this.f7241EH1KK8 = f;
                this.f7247EiK8oA = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + this.f7236DuwtYk + ")-valueTo(" + this.f7237DvK7DB + ") range");
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbElevation(float f) {
        this.f7262FdMWEC.B2KMhB(f);
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbHeight(int i) {
        if (i == this.f7212CkXcdM) {
            return;
        }
        this.f7212CkXcdM = i;
        this.f7262FdMWEC.setBounds(0, 0, this.f7211CikNvS, i);
        Drawable drawable = this.f7263Ff5QvW;
        if (drawable != null) {
            A2egSU(drawable);
        }
        Iterator it = this.f7264Fmmv0E.iterator();
        while (it.hasNext()) {
            A2egSU((Drawable) it.next());
        }
        CQhlFr(false);
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        int i2 = i * 2;
        setThumbWidth(i2);
        setThumbHeight(i2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f7262FdMWEC.BIYEnU(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(ASJ6gh.A5SV6n(getContext(), i));
        }
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbStrokeWidth(float f) {
        this.f7262FdMWEC.BJ7GGh(f);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        AaHO0E aaHO0E = this.f7262FdMWEC;
        if (colorStateList.equals(aaHO0E.f7042AlLFFp.f7024ADYaiT)) {
            return;
        }
        aaHO0E.B3GDIM(colorStateList);
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbTrackGapSize(int i) {
        if (this.f7214CqNSpT == i) {
            return;
        }
        this.f7214CqNSpT = i;
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setThumbWidth(int i) {
        if (i == this.f7211CikNvS) {
            return;
        }
        this.f7211CikNvS = i;
        AaHO0E aaHO0E = this.f7262FdMWEC;
        B2KMhB.A2egSU a2egSU = new B2KMhB.A2egSU();
        float f = this.f7211CikNvS / 2.0f;
        PCV8se.AMqCpz BV3sI02 = AlLFFp.BV3sI0(0);
        a2egSU.f7094A2egSU = BV3sI02;
        float A4TApA2 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA2 != -1.0f) {
            a2egSU.ARc23Z(A4TApA2);
        }
        a2egSU.f7095A4TApA = BV3sI02;
        float A4TApA3 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA3 != -1.0f) {
            a2egSU.ASJ6gh(A4TApA3);
        }
        a2egSU.f7096A5SV6n = BV3sI02;
        float A4TApA4 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA4 != -1.0f) {
            a2egSU.AMqCpz(A4TApA4);
        }
        a2egSU.f7097ADYaiT = BV3sI02;
        float A4TApA5 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA5 != -1.0f) {
            a2egSU.ADYaiT(A4TApA5);
        }
        a2egSU.A5SV6n(f);
        aaHO0E.setShapeAppearanceModel(a2egSU.A2egSU());
        aaHO0E.setBounds(0, 0, this.f7211CikNvS, this.f7212CkXcdM);
        Drawable drawable = this.f7263Ff5QvW;
        if (drawable != null) {
            A2egSU(drawable);
        }
        Iterator it = this.f7264Fmmv0E.iterator();
        while (it.hasNext()) {
            A2egSU((Drawable) it.next());
        }
        CQhlFr(false);
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    @Override // PSeUZ5.ADYaiT
    public void setTickActiveRadius(int i) {
        if (this.f7244EUIRHA != i) {
            this.f7244EUIRHA = i;
            this.f7186B2KMhB.setStrokeWidth(i * 2);
            CQhlFr(false);
        }
    }

    @Override // PSeUZ5.ADYaiT
    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f7249EmJGcg)) {
            return;
        }
        this.f7249EmJGcg = colorStateList;
        this.f7186B2KMhB.setColor(AlLFFp(colorStateList));
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTickInactiveRadius(int i) {
        if (this.f7245EY4UKY != i) {
            this.f7245EY4UKY = i;
            this.f7185B25kr6.setStrokeWidth(i * 2);
            CQhlFr(false);
        }
    }

    @Override // PSeUZ5.ADYaiT
    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f7250ErKPGd)) {
            return;
        }
        this.f7250ErKPGd = colorStateList;
        this.f7185B25kr6.setColor(AlLFFp(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.f7243EQurEW != i) {
            this.f7243EQurEW = i;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z) {
        setTickVisibilityMode(z ? 0 : 2);
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f7251EsrwYR)) {
            return;
        }
        this.f7251EsrwYR = colorStateList;
        this.f7182AlLFFp.setColor(AlLFFp(colorStateList));
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackCornerSize(int i) {
        if (this.f7218D07BeM == i) {
            return;
        }
        this.f7218D07BeM = i;
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackHeight(int i) {
        if (this.f7209CcAIMM != i) {
            this.f7209CcAIMM = i;
            this.f7181AcNBzu.setStrokeWidth(i);
            this.f7182AlLFFp.setStrokeWidth(this.f7209CcAIMM);
            CQhlFr(false);
        }
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconActiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.f7225DG07BK) {
            return;
        }
        this.f7225DG07BK = colorStateList;
        CASmeH();
        C4FrIb();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconActiveEnd(Drawable drawable) {
        if (drawable == this.f7223D9tr6l) {
            return;
        }
        this.f7223D9tr6l = drawable;
        this.f7224DAk1zC = false;
        C4FrIb();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconActiveStart(Drawable drawable) {
        if (drawable == this.f7221D8MqeW) {
            return;
        }
        this.f7221D8MqeW = drawable;
        this.f7222D8cQ8b = false;
        CASmeH();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconInactiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.DXuj49) {
            return;
        }
        this.DXuj49 = colorStateList;
        COJEAR();
        CNPG0E();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconInactiveEnd(Drawable drawable) {
        if (drawable == this.f7228DV2E8K) {
            return;
        }
        this.f7228DV2E8K = drawable;
        this.f7229DXnQ0V = false;
        CNPG0E();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconInactiveStart(Drawable drawable) {
        if (drawable == this.f7226DRlcZ9) {
            return;
        }
        this.f7226DRlcZ9 = drawable;
        this.f7227DUi7mC = false;
        COJEAR();
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackIconSize(int i) {
        if (this.f7230DaOi9o == i) {
            return;
        }
        this.f7230DaOi9o = i;
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f7252EwN40Z)) {
            return;
        }
        this.f7252EwN40Z = colorStateList;
        this.f7181AcNBzu.setColor(AlLFFp(colorStateList));
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackInsideCornerSize(int i) {
        if (this.f7219D6DOie == i) {
            return;
        }
        this.f7219D6DOie = i;
        invalidate();
    }

    @Override // PSeUZ5.ADYaiT
    public void setTrackStopIndicatorSize(int i) {
        if (this.f7217CtxOCS == i) {
            return;
        }
        this.f7217CtxOCS = i;
        this.f7187B3GDIM.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f) {
        setValues(Float.valueOf(f));
    }

    public void setValueFrom(float f) {
        this.f7236DuwtYk = f;
        this.f7247EiK8oA = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.f7237DvK7DB = f;
        this.f7247EiK8oA = true;
        postInvalidate();
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        A2egSU(newDrawable);
        this.f7263Ff5QvW = newDrawable;
        this.f7264Fmmv0E.clear();
        postInvalidate();
    }

    public void setTrackIconActiveEnd(int i) {
        setTrackIconActiveEnd(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(int i) {
        setTrackIconActiveStart(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(int i) {
        setTrackIconInactiveEnd(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(int i) {
        setTrackIconInactiveStart(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }
}
