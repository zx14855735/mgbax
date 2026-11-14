package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f11982AcNBzu;

    public A4TApA(ClockFaceView clockFaceView) {
        this.f11982AcNBzu = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f11982AcNBzu;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f11993C2rE4F.f12012AzWtSf) - clockFaceView.f12001CcAIMM;
        if (height != clockFaceView.f11987BniPrB) {
            clockFaceView.f11987BniPrB = height;
            clockFaceView.ASJ6gh();
            int i = clockFaceView.f11987BniPrB;
            ClockHandView clockHandView = clockFaceView.f11993C2rE4F;
            clockHandView.f12020BI9f7h = i;
            clockHandView.invalidate();
        }
        return true;
    }
}
