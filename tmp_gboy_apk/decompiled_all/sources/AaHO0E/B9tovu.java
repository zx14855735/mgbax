package AaHO0E;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B9tovu extends Button implements CikNvS.B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f640AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DRlcZ9 f641AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BTvldC f642AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B9tovu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GIl1rw.A2egSU(context);
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f640AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, i);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f641AlLFFp = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, i);
        dRlcZ9.A4TApA();
        getEmojiTextViewHelper().A4TApA(attributeSet, i);
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f642AmA8tU == null) {
            this.f642AmA8tU = new BTvldC(this);
        }
        return this.f642AmA8tU;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeMaxTextSize();
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.AMqCpz);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeMinTextSize();
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.f747ADYaiT);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeStepGranularity();
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.f746A5SV6n);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeTextAvailableSizes();
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        return dRlcZ9 != null ? dRlcZ9.f735AZOQYO.f748ARc23Z : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            return dRlcZ9.f735AZOQYO.f744A2egSU;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return JrXYwF.A4TApA.DcUJf1(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f641AlLFFp.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f641AlLFFp.AMqCpz();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 == null || HSHyT0.f935A5SV6n) {
            return;
        }
        dRlcZ9.f735AZOQYO.A2egSU();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 == null || HSHyT0.f935A5SV6n) {
            return;
        }
        De4eam de4eam = dRlcZ9.f735AZOQYO;
        if (de4eam.ARc23Z()) {
            de4eam.A2egSU();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AZOQYO(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AZkASS(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AaHO0E(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(JrXYwF.A4TApA.Ddcejp(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().ADYaiT(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().A2egSU(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.f728A2egSU.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f640AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.ASJ6gh(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = HSHyT0.f935A5SV6n;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f641AlLFFp;
        if (dRlcZ9 == null || z) {
            return;
        }
        De4eam de4eam = dRlcZ9.f735AZOQYO;
        if (de4eam.ARc23Z()) {
            return;
        }
        de4eam.ASJ6gh(f, i);
    }
}
