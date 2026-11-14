package EQurEW;

import FOAO9d.AYUAbz;
import FOAO9d.AcNBzu;
import android.view.ViewTreeObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ A4TApA f2490A2egSU;

    public A2egSU(A4TApA a4TApA) {
        this.f2490A2egSU = a4TApA;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        float A2egSU2 = A4TApA.A2egSU(this.f2490A2egSU.f2491A2egSU);
        if (A2egSU2 == -1.0f) {
            return;
        }
        AYUAbz aYUAbz = this.f2490A2egSU.f2493A5SV6n;
        AcNBzu acNBzu = aYUAbz.f2589AcNBzu;
        acNBzu.f2621G58fqA = Math.max(acNBzu.f2621G58fqA, (int) A2egSU2);
        AcNBzu acNBzu2 = aYUAbz.f2589AcNBzu;
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz.append(aYUAbz.f2589AcNBzu.f2621G58fqA);
        acNBzu2.f3233D9tr6l = AMqCpz.toString();
        if (A2egSU2 >= 50.0f) {
            AcNBzu acNBzu3 = aYUAbz.f2589AcNBzu;
            if (!acNBzu3.f2638HH6JFw) {
                acNBzu3.EY4UKY(3);
                AcNBzu acNBzu4 = aYUAbz.f2589AcNBzu;
                acNBzu4.f2638HH6JFw = true;
                if (!acNBzu4.HHoABE) {
                    aYUAbz.f2589AcNBzu.DaOi9o();
                }
            }
        }
        if (A2egSU2 < 50.0f) {
            AcNBzu acNBzu5 = aYUAbz.f2589AcNBzu;
            if (acNBzu5.f2638HH6JFw) {
                acNBzu5.EY4UKY(4);
                aYUAbz.f2589AcNBzu.f2638HH6JFw = false;
            }
        }
    }
}
