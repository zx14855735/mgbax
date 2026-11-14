package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {
    public static A5SV6n A2egSU(Context context, int i) {
        JrXYwF.A4TApA.B2KMhB(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.f11236BNL6CD);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 4);
        com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 9);
        com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 7);
        obtainStyledAttributes.getDimensionPixelSize(8, 0);
        PCV8se.B2KMhB.A2egSU(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0)).A2egSU();
        obtainStyledAttributes.recycle();
        A5SV6n a5SV6n = new A5SV6n();
        JrXYwF.A4TApA.B3GDIM(rect.left);
        JrXYwF.A4TApA.B3GDIM(rect.top);
        JrXYwF.A4TApA.B3GDIM(rect.right);
        JrXYwF.A4TApA.B3GDIM(rect.bottom);
        return a5SV6n;
    }
}
