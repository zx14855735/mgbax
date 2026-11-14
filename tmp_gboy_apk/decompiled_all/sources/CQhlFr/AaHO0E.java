package CQhlFr;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AccessibilityNodeProvider f1776A2egSU;

    public AaHO0E() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1776A2egSU = new AZkASS(this);
        } else {
            this.f1776A2egSU = new AZOQYO(this);
        }
    }

    public AYUAbz A2egSU(int i) {
        return null;
    }

    public AYUAbz A4TApA(int i) {
        return null;
    }

    public boolean A5SV6n(int i, int i2, Bundle bundle) {
        return false;
    }

    public AaHO0E(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f1776A2egSU = accessibilityNodeProvider;
    }
}
