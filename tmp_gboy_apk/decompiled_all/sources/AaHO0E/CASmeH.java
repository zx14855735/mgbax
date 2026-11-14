package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CASmeH extends RadioButton implements CikNvS.B7CMnp, CikNvS.B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final BIYEnU f682AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B7CMnp f683AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final DRlcZ9 f684AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BTvldC f685AzWtSf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CASmeH(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969781);
        GIl1rw.A2egSU(context);
        GIi2tl.A2egSU(getContext(), this);
        BIYEnU bIYEnU = new BIYEnU(this);
        this.f682AcNBzu = bIYEnU;
        bIYEnU.A5SV6n(attributeSet, 2130969781);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f683AlLFFp = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, 2130969781);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f684AmA8tU = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, 2130969781);
        getEmojiTextViewHelper().A4TApA(attributeSet, 2130969781);
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f685AzWtSf == null) {
            this.f685AzWtSf = new BTvldC(this);
        }
        return this.f685AzWtSf;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f684AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    @Override // CikNvS.B7CMnp
    public ColorStateList getSupportButtonTintList() {
        BIYEnU bIYEnU = this.f682AcNBzu;
        if (bIYEnU != null) {
            return bIYEnU.f651A2egSU;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        BIYEnU bIYEnU = this.f682AcNBzu;
        if (bIYEnU != null) {
            return bIYEnU.f652A4TApA;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f684AmA8tU.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f684AmA8tU.AMqCpz();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        BIYEnU bIYEnU = this.f682AcNBzu;
        if (bIYEnU != null) {
            if (bIYEnU.AMqCpz) {
                bIYEnU.AMqCpz = false;
            } else {
                bIYEnU.AMqCpz = true;
                bIYEnU.A2egSU();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f684AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f684AmA8tU;
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
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f683AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B7CMnp
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        BIYEnU bIYEnU = this.f682AcNBzu;
        if (bIYEnU != null) {
            bIYEnU.f651A2egSU = colorStateList;
            bIYEnU.f653A5SV6n = true;
            bIYEnU.A2egSU();
        }
    }

    @Override // CikNvS.B7CMnp
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        BIYEnU bIYEnU = this.f682AcNBzu;
        if (bIYEnU != null) {
            bIYEnU.f652A4TApA = mode;
            bIYEnU.f654ADYaiT = true;
            bIYEnU.A2egSU();
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f684AmA8tU;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f684AmA8tU;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(NOd7IU.AlLFFp.CQhlFr(getContext(), i));
    }
}
