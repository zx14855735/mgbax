package com.google.android.material.tabs;

import AaHO0E.GYpKKt;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TabItem extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CharSequence f11838AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Drawable f11839AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f11840AmA8tU;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GYpKKt AMqCpz = GYpKKt.AMqCpz(context, attributeSet, R$styleable.f11261D6yqiO);
        TypedArray typedArray = AMqCpz.f884A4TApA;
        this.f11838AcNBzu = typedArray.getText(2);
        this.f11839AlLFFp = AMqCpz.A4TApA(0);
        this.f11840AmA8tU = typedArray.getResourceId(1, 0);
        AMqCpz.ASJ6gh();
    }
}
