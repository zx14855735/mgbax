package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ak extends bm {
    private int beK;
    private int beL;
    private int beM;
    private int beN;

    public ak(int i, int i2) {
        super(i, i2);
    }

    private int SI() {
        return this.beK;
    }

    private int SJ() {
        return this.beL;
    }

    private int SK() {
        return this.beM;
    }

    private int SL() {
        return this.beN;
    }

    public static ak a(int i, int i2, int i3, int i4, int i5, int i6) {
        ak akVar = new ak(i, i2);
        akVar.fl(0);
        akVar.fm(0);
        akVar.fj(i4);
        akVar.fk(0);
        return akVar;
    }

    private void fk(int i) {
        this.beL = i;
    }

    public final ak c(Context context, float f) {
        ak akVar = new ak(com.kwad.sdk.c.a.a.a(context, this.mWidth * f), com.kwad.sdk.c.a.a.a(context, this.mHeight * f));
        akVar.beM = com.kwad.sdk.c.a.a.a(context, this.beM * f);
        akVar.beL = com.kwad.sdk.c.a.a.a(context, this.beL * f);
        akVar.beN = com.kwad.sdk.c.a.a.a(context, this.beN * f);
        akVar.beK = com.kwad.sdk.c.a.a.a(context, this.beK * f);
        return akVar;
    }

    public final void fj(int i) {
        this.beK = i;
    }

    public final void fl(int i) {
        this.beM = i;
    }

    public final void fm(int i) {
        this.beN = i;
    }

    public static void a(View view, ak akVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (akVar.getHeight() > 0) {
            layoutParams.height = akVar.getHeight();
        }
        if (akVar.getWidth() > 0) {
            layoutParams.width = akVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (akVar.SK() > 0) {
                marginLayoutParams.leftMargin = akVar.SK();
            }
            if (akVar.SJ() > 0) {
                marginLayoutParams.bottomMargin = akVar.SJ();
            }
            if (akVar.SL() > 0) {
                marginLayoutParams.rightMargin = akVar.SL();
            }
            if (akVar.SI() > 0) {
                marginLayoutParams.topMargin = akVar.SI();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
