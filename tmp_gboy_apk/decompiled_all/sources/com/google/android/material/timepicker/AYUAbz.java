package com.google.android.material.timepicker;

import PCV8se.AzWtSf;
import PCV8se.B2KMhB;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz extends ConstraintLayout {

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final ASJ6gh f11986BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f11987BniPrB;
    public final PCV8se.AaHO0E BpkvW3;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.ASJ6gh] */
    public AYUAbz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969559);
        LayoutInflater.from(context).inflate(2131493218, this);
        PCV8se.AaHO0E aaHO0E = new PCV8se.AaHO0E();
        this.BpkvW3 = aaHO0E;
        AzWtSf azWtSf = new AzWtSf(0.5f);
        B2KMhB.A2egSU ASJ6gh2 = aaHO0E.f7042AlLFFp.f7021A2egSU.ASJ6gh();
        ASJ6gh2.AMqCpz = azWtSf;
        ASJ6gh2.f7098ARc23Z = azWtSf;
        ASJ6gh2.f7099ASJ6gh = azWtSf;
        ASJ6gh2.f7100AYUAbz = azWtSf;
        aaHO0E.setShapeAppearanceModel(ASJ6gh2.A2egSU());
        this.BpkvW3.B3GDIM(ColorStateList.valueOf(-1));
        setBackground(this.BpkvW3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11250CcAIMM, 2130969559, 0);
        this.f11987BniPrB = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11986BmvVmW = new Runnable() { // from class: com.google.android.material.timepicker.ASJ6gh
            @Override // java.lang.Runnable
            public final void run() {
                AYUAbz.this.ASJ6gh();
            }
        };
        obtainStyledAttributes.recycle();
    }

    public abstract void ASJ6gh();

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            ASJ6gh aSJ6gh = this.f11986BmvVmW;
            handler.removeCallbacks(aSJ6gh);
            handler.post(aSJ6gh);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        ASJ6gh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            ASJ6gh aSJ6gh = this.f11986BmvVmW;
            handler.removeCallbacks(aSJ6gh);
            handler.post(aSJ6gh);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.BpkvW3.B3GDIM(ColorStateList.valueOf(i));
    }
}
