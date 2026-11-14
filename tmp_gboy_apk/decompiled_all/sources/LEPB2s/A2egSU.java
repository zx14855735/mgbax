package LEPB2s;

import android.app.Dialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static A2egSU f4445A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Dialog f4446A2egSU;

    public static A2egSU A4TApA() {
        if (f4445A4TApA == null) {
            f4445A4TApA = new A2egSU();
        }
        return f4445A4TApA;
    }

    public final void A2egSU() {
        Dialog dialog = this.f4446A2egSU;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f4446A2egSU.dismiss();
        this.f4446A2egSU = null;
    }

    public final boolean A5SV6n() {
        Dialog dialog = this.f4446A2egSU;
        return dialog != null && dialog.isShowing();
    }
}
