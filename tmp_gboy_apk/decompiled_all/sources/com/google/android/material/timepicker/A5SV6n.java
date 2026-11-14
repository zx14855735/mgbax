package com.google.android.material.timepicker;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f11983ADYaiT;

    public A5SV6n(ClockFaceView clockFaceView) {
        this.f11983ADYaiT = clockFaceView;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(2131297579)).intValue();
        if (intValue > 0) {
            View view2 = (View) this.f11983ADYaiT.f11997COJEAR.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(view2);
            }
        }
        aYUAbz.AaHO0E(CQhlFr.ASJ6gh.A2egSU(0, 1, intValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1758ASJ6gh);
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        if (i != 16) {
            return super.ASJ6gh(view, i, bundle);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f11983ADYaiT;
        view.getHitRect(clockFaceView.f11994C4FrIb);
        float centerX = clockFaceView.f11994C4FrIb.centerX();
        float centerY = clockFaceView.f11994C4FrIb.centerY();
        clockFaceView.f11993C2rE4F.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
        clockFaceView.f11993C2rE4F.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
        return true;
    }
}
