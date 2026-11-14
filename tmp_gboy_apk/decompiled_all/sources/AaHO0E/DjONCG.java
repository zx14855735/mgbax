package AaHO0E;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DjONCG extends ToggleButton implements CikNvS.B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f754AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DRlcZ9 f755AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BTvldC f756AmA8tU;

    public DjONCG(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f754AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, R.attr.buttonStyleToggle);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f755AlLFFp = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().A4TApA(attributeSet, R.attr.buttonStyleToggle);
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f756AmA8tU == null) {
            this.f756AmA8tU = new BTvldC(this);
        }
        return this.f756AmA8tU;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f755AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f755AlLFFp.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f755AlLFFp.AMqCpz();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f755AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f755AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().ADYaiT(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().A2egSU(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f754AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f755AlLFFp;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f755AlLFFp;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }
}
