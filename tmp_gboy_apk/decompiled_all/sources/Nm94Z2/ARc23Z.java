package Nm94Z2;

import COJEAR.DG07BK;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View f6067A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f6068A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f6069A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6070ADYaiT;

    public ARc23Z(View view) {
        this.f6067A2egSU = view;
    }

    public final void A2egSU() {
        int i = this.f6070ADYaiT;
        View view = this.f6067A2egSU;
        DG07BK.AlLFFp(i - (view.getTop() - this.f6068A4TApA), view);
        DG07BK.AcNBzu(0 - (view.getLeft() - this.f6069A5SV6n), view);
    }
}
