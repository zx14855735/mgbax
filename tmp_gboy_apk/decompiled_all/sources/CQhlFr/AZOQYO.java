package CQhlFr;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO extends AccessibilityNodeProvider {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AaHO0E f1775A2egSU;

    public AZOQYO(AaHO0E aaHO0E) {
        this.f1775A2egSU = aaHO0E;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AYUAbz A2egSU2 = this.f1775A2egSU.A2egSU(i);
        if (A2egSU2 == null) {
            return null;
        }
        return A2egSU2.f1773A2egSU;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.f1775A2egSU.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        AYUAbz A4TApA2 = this.f1775A2egSU.A4TApA(i);
        if (A4TApA2 == null) {
            return null;
        }
        return A4TApA2.f1773A2egSU;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.f1775A2egSU.A5SV6n(i, i2, bundle);
    }
}
