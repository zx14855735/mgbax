package OsNEEq;

import COJEAR.Ddcejp;
import DaOi9o.B4ZgIw;
import DaOi9o.BmvVmW;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends B4ZgIw {
    @Override // DaOi9o.B4ZgIw
    public final void ADYaiT(BmvVmW bmvVmW) {
        bmvVmW.f2281A2egSU.put("NavigationRailLabelVisibility", Integer.valueOf(bmvVmW.f2282A4TApA.getVisibility()));
    }

    @Override // DaOi9o.B4ZgIw
    public final void ASJ6gh(BmvVmW bmvVmW) {
        bmvVmW.f2281A2egSU.put("NavigationRailLabelVisibility", Integer.valueOf(bmvVmW.f2282A4TApA.getVisibility()));
    }

    @Override // DaOi9o.B4ZgIw
    public final Animator AaHO0E(ViewGroup viewGroup, BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        if (bmvVmW == null || bmvVmW2 == null) {
            return null;
        }
        HashMap hashMap = bmvVmW.f2281A2egSU;
        if (hashMap.get("NavigationRailLabelVisibility") == null) {
            return null;
        }
        HashMap hashMap2 = bmvVmW2.f2281A2egSU;
        if (hashMap2.get("NavigationRailLabelVisibility") == null || ((Integer) hashMap.get("NavigationRailLabelVisibility")).intValue() != 8 || ((Integer) hashMap2.get("NavigationRailLabelVisibility")).intValue() != 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new Ddcejp(4, bmvVmW2.f2282A4TApA));
        return ofFloat;
    }
}
