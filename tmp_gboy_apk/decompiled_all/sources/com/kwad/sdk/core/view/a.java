package com.kwad.sdk.core.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends ViewOutlineProvider {
    private int aQO = 0;
    private int aQP;
    private int aQQ;
    private int aQR;
    private float mRadius;

    public a(float f, int i, int i2, int i3, int i4) {
        this.mRadius = f;
        this.aQP = i2;
        this.aQQ = i3;
        this.aQR = i4;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(new Rect(this.aQO, this.aQP, this.aQQ, this.aQR), this.mRadius);
    }
}
