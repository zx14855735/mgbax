package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A5SV6n f11582A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A5SV6n f11583A4TApA;

    public ADYaiT(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(P3rngT.A4TApA.ADYaiT(context, 2130969551, AlLFFp.class.getCanonicalName()).data, R$styleable.f11235BJ7GGh);
        A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(4, 0));
        A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(2, 0));
        A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(3, 0));
        A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList BPw6Q82 = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 7);
        this.f11582A2egSU = A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(9, 0));
        A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f11583A4TApA = A5SV6n.A2egSU(context, obtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(BPw6Q82.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
