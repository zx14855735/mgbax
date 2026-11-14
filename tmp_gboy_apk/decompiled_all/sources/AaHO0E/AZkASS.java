package AaHO0E;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f605AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f606AlLFFp;

    public AZkASS(AzWtSf azWtSf, AYUAbz aYUAbz) {
        this.f606AlLFFp = azWtSf;
        this.f605AcNBzu = aYUAbz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AZkASS.AcNBzu acNBzu;
        AzWtSf azWtSf = this.f606AlLFFp;
        AZkASS.AmA8tU amA8tU = azWtSf.f434AmA8tU;
        if (amA8tU != null && (acNBzu = amA8tU.f497B25kr6) != null) {
            acNBzu.AcNBzu(amA8tU);
        }
        View view = (View) azWtSf.f439B4ZgIw;
        if (view != null && view.getWindowToken() != null) {
            AYUAbz aYUAbz = this.f605AcNBzu;
            if (!aYUAbz.A4TApA()) {
                if (aYUAbz.AMqCpz != null) {
                    aYUAbz.ADYaiT(0, 0, false, false);
                }
            }
            azWtSf.f621BniPrB = aYUAbz;
        }
        azWtSf.f622C2rE4F = null;
    }
}
