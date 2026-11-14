package com.google.android.material.materialswitch;

import AaHO0E.GYpKKt;
import JrXYwF.A4TApA;
import NOd7IU.AlLFFp;
import Oay4Bh.C4FrIb;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialSwitch extends SwitchCompat {

    /* renamed from: DuwtYk, reason: collision with root package name */
    public static final int[] f11708DuwtYk = {2130969924};

    /* renamed from: DG07BK, reason: collision with root package name */
    public Drawable f11709DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public Drawable f11710DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f11711DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public Drawable f11712DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public Drawable f11713DXnQ0V;
    public ColorStateList DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public ColorStateList f11714DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public PorterDuff.Mode f11715DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public ColorStateList f11716DdagTj;
    public ColorStateList Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public PorterDuff.Mode f11717De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public int[] f11718DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public int[] f11719Dphsd2;

    static {
        jbVGP();
    }

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969578, 2131952673), attributeSet, 2130969578);
        this.f11711DUi7mC = -1;
        Context context2 = getContext();
        this.f11709DG07BK = super.getThumbDrawable();
        this.DXuj49 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.f11712DV2E8K = super.getTrackDrawable();
        this.f11716DdagTj = super.getTrackTintList();
        super.setTrackTintList(null);
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(context2, attributeSet, R$styleable.f11242C2rE4F, 2130969578, 2131952673, new int[0]);
        this.f11710DRlcZ9 = AzWtSf2.A4TApA(0);
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        this.f11711DUi7mC = typedArray.getDimensionPixelSize(1, -1);
        this.f11714DaOi9o = AzWtSf2.A2egSU(2);
        int i = typedArray.getInt(3, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f11715DcUJf1 = C4FrIb.B25kr6(i, mode);
        this.f11713DXnQ0V = AzWtSf2.A4TApA(4);
        this.Ddcejp = AzWtSf2.A2egSU(5);
        this.f11717De4eam = C4FrIb.B25kr6(typedArray.getInt(6, -1), mode);
        AzWtSf2.ASJ6gh();
        setEnforceSwitchWidth(false);
        AMqCpz();
        ARc23Z();
    }

    public static void ASJ6gh(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        drawable.setTint(BV3sI0.A2egSU.A4TApA(f, colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0)));
    }

    private static /* synthetic */ void jbVGP() {
        char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 237);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 237);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void AMqCpz() {
        this.f11709DG07BK = A4TApA.BPw6Q8(this.f11709DG07BK, this.DXuj49, getThumbTintMode(), false);
        this.f11710DRlcZ9 = A4TApA.BPw6Q8(this.f11710DRlcZ9, this.f11714DaOi9o, this.f11715DcUJf1, false);
        AYUAbz();
        Drawable drawable = this.f11709DG07BK;
        Drawable drawable2 = this.f11710DRlcZ9;
        int i = this.f11711DUi7mC;
        super.setThumbDrawable(A4TApA.B9tovu(drawable, drawable2, i, i));
        refreshDrawableState();
    }

    public final void ARc23Z() {
        this.f11712DV2E8K = A4TApA.BPw6Q8(this.f11712DV2E8K, this.f11716DdagTj, getTrackTintMode(), false);
        this.f11713DXnQ0V = A4TApA.BPw6Q8(this.f11713DXnQ0V, this.Ddcejp, this.f11717De4eam, false);
        AYUAbz();
        Drawable drawable = this.f11712DV2E8K;
        if (drawable != null && this.f11713DXnQ0V != null) {
            drawable = new LayerDrawable(new Drawable[]{this.f11712DV2E8K, this.f11713DXnQ0V});
        } else if (drawable == null) {
            drawable = this.f11713DXnQ0V;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    public final void AYUAbz() {
        if (this.DXuj49 == null && this.f11714DaOi9o == null && this.f11716DdagTj == null && this.Ddcejp == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.DXuj49;
        if (colorStateList != null) {
            ASJ6gh(this.f11709DG07BK, colorStateList, this.f11718DjONCG, this.f11719Dphsd2, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f11714DaOi9o;
        if (colorStateList2 != null) {
            ASJ6gh(this.f11710DRlcZ9, colorStateList2, this.f11718DjONCG, this.f11719Dphsd2, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f11716DdagTj;
        if (colorStateList3 != null) {
            ASJ6gh(this.f11712DV2E8K, colorStateList3, this.f11718DjONCG, this.f11719Dphsd2, thumbPosition);
        }
        ColorStateList colorStateList4 = this.Ddcejp;
        if (colorStateList4 != null) {
            ASJ6gh(this.f11713DXnQ0V, colorStateList4, this.f11718DjONCG, this.f11719Dphsd2, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.f11709DG07BK;
    }

    public Drawable getThumbIconDrawable() {
        return this.f11710DRlcZ9;
    }

    public int getThumbIconSize() {
        return this.f11711DUi7mC;
    }

    public ColorStateList getThumbIconTintList() {
        return this.f11714DaOi9o;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f11715DcUJf1;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.DXuj49;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.f11713DXnQ0V;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.Ddcejp;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f11717De4eam;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.f11712DV2E8K;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.f11716DdagTj;
    }

    @Override // android.view.View
    public final void invalidate() {
        AYUAbz();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f11710DRlcZ9 != null) {
            View.mergeDrawableStates(onCreateDrawableState, f11708DuwtYk);
        }
        int[] iArr = new int[onCreateDrawableState.length];
        int i2 = 0;
        for (int i3 : onCreateDrawableState) {
            if (i3 != 16842912) {
                iArr[i2] = i3;
                i2++;
            }
        }
        this.f11718DjONCG = iArr;
        this.f11719Dphsd2 = A4TApA.BpkvW3(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.f11709DG07BK = drawable;
        AMqCpz();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.f11710DRlcZ9 = drawable;
        AMqCpz();
    }

    public void setThumbIconResource(int i) {
        setThumbIconDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setThumbIconSize(int i) {
        if (this.f11711DUi7mC != i) {
            this.f11711DUi7mC = i;
            AMqCpz();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.f11714DaOi9o = colorStateList;
        AMqCpz();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.f11715DcUJf1 = mode;
        AMqCpz();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.DXuj49 = colorStateList;
        AMqCpz();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        AMqCpz();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.f11713DXnQ0V = drawable;
        ARc23Z();
    }

    public void setTrackDecorationResource(int i) {
        setTrackDecorationDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.Ddcejp = colorStateList;
        ARc23Z();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.f11717De4eam = mode;
        ARc23Z();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.f11712DV2E8K = drawable;
        ARc23Z();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.f11716DdagTj = colorStateList;
        ARc23Z();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        ARc23Z();
    }
}
