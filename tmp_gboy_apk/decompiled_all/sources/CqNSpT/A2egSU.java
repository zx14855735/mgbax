package CqNSpT;

import COJEAR.DG07BK;
import CQhlFr.AYUAbz;
import CQhlFr.AaHO0E;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends AaHO0E {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ A4TApA f1818A4TApA;

    public A2egSU(A4TApA a4TApA) {
        this.f1818A4TApA = a4TApA;
    }

    @Override // CQhlFr.AaHO0E
    public final AYUAbz A2egSU(int i) {
        return new AYUAbz(AccessibilityNodeInfo.obtain(this.f1818A4TApA.B3GDIM(i).f1773A2egSU));
    }

    @Override // CQhlFr.AaHO0E
    public final AYUAbz A4TApA(int i) {
        A4TApA a4TApA = this.f1818A4TApA;
        int i2 = i == 2 ? a4TApA.f1828AaHO0E : a4TApA.f1829AcNBzu;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return A2egSU(i2);
    }

    @Override // CQhlFr.AaHO0E
    public final boolean A5SV6n(int i, int i2, Bundle bundle) {
        int i3;
        A4TApA a4TApA = this.f1818A4TApA;
        View view = a4TApA.f1826AZOQYO;
        if (i == -1) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            return view.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return a4TApA.BI9f7h(i);
        }
        if (i2 == 2) {
            return a4TApA.AZkASS(i);
        }
        if (i2 != 64) {
            if (i2 != 128) {
                return a4TApA.B4ZgIw(i, i2, bundle);
            }
            if (a4TApA.f1828AaHO0E != i) {
                return false;
            }
            a4TApA.f1828AaHO0E = Integer.MIN_VALUE;
            view.invalidate();
            a4TApA.BIYEnU(i, 65536);
            return true;
        }
        AccessibilityManager accessibilityManager = a4TApA.f1825AYUAbz;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = a4TApA.f1828AaHO0E) == i) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a4TApA.f1828AaHO0E = Integer.MIN_VALUE;
            a4TApA.f1826AZOQYO.invalidate();
            a4TApA.BIYEnU(i3, 65536);
        }
        a4TApA.f1828AaHO0E = i;
        view.invalidate();
        a4TApA.BIYEnU(i, 32768);
        return true;
    }
}
