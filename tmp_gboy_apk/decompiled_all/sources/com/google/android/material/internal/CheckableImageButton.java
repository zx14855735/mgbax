package com.google.android.material.internal;

import AaHO0E.BV3sI0;
import COJEAR.DG07BK;
import O1Vn2F.ADYaiT;
import Oay4Bh.A4TApA;
import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CheckableImageButton extends BV3sI0 implements Checkable {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final int[] f11687B3GDIM = {R.attr.state_checked};

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f11688AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11689B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f11690B2KMhB;

    static {
        MGOlEmZ();
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969244);
        this.f11689B25kr6 = true;
        this.f11690B2KMhB = true;
        DG07BK.B4ZgIw(this, new ADYaiT(3, this));
    }

    private static /* synthetic */ void MGOlEmZ() {
        char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '8');
        }
        String str = new String(charArray);
        char[] charArray2 = "[TQVQL".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '8');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f11688AzWtSf;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.f11688AzWtSf ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), f11687B3GDIM) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof A4TApA)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        A4TApA a4TApA = (A4TApA) parcelable;
        super.onRestoreInstanceState(a4TApA.getSuperState());
        setChecked(a4TApA.f6456AcNBzu);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        A4TApA a4TApA = new A4TApA(super.onSaveInstanceState());
        a4TApA.f6456AcNBzu = this.f11688AzWtSf;
        return a4TApA;
    }

    public void setCheckable(boolean z) {
        if (this.f11689B25kr6 != z) {
            this.f11689B25kr6 = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f11689B25kr6 || this.f11688AzWtSf == z) {
            return;
        }
        this.f11688AzWtSf = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.f11690B2KMhB = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f11690B2KMhB) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f11688AzWtSf);
    }
}
