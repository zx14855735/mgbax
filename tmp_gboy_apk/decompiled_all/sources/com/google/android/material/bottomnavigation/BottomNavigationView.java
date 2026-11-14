package com.google.android.material.bottomnavigation;

import AaHO0E.GYpKKt;
import Hdahpu.AZOQYO;
import O0Tw8S.A4TApA;
import O0Tw8S.A5SV6n;
import O0Tw8S.ADYaiT;
import Oay4Bh.C4FrIb;
import OpB85q.AZkASS;
import OpB85q.B2KMhB;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BottomNavigationView extends B2KMhB {
    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968715, 2131952599);
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(getContext(), attributeSet, R$styleable.f11216ARc23Z, 2130968715, 2131952599, new int[0]);
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(2, true));
        if (typedArray.hasValue(0)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
        }
        AzWtSf2.ASJ6gh();
        C4FrIb.ASJ6gh(this, new AZOQYO(29));
    }

    @Override // OpB85q.B2KMhB
    public final AZkASS A2egSU(Context context) {
        return new A4TApA(context);
    }

    @Override // OpB85q.B2KMhB
    public int getMaxItemCount() {
        return 6;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumHeight <= 0) {
            i3 = i2;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i2), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i3);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), Math.max(getMeasuredHeight(), getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight()));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        A4TApA a4TApA = (A4TApA) getMenuView();
        if (a4TApA.Ddcejp != z) {
            a4TApA.setItemHorizontalTranslationEnabled(z);
            getPresenter().A4TApA(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(A5SV6n a5SV6n) {
        setOnItemReselectedListener(a5SV6n);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(ADYaiT aDYaiT) {
        setOnItemSelectedListener(aDYaiT);
    }
}
