package Oay4Bh;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f6535ADYaiT;
    public final /* synthetic */ boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f6536ARc23Z;

    public AmA8tU(AzWtSf azWtSf, int i, boolean z) {
        this.f6536ARc23Z = azWtSf;
        this.f6535ADYaiT = i;
        this.AMqCpz = z;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
        int i = this.f6535ADYaiT;
        int i2 = 0;
        int i3 = i;
        while (true) {
            AzWtSf azWtSf = this.f6536ARc23Z;
            if (i2 >= i) {
                azWtSf.getClass();
                aYUAbz.AaHO0E(CQhlFr.ASJ6gh.A2egSU(i3, 1, 1, 1, this.AMqCpz, view.isSelected()));
                return;
            } else {
                BI9f7h bI9f7h = azWtSf.f6540AzWtSf;
                if (bI9f7h.f6550B25kr6.getItemViewType(i2) == 2 || bI9f7h.f6550B25kr6.getItemViewType(i2) == 3) {
                    i3--;
                }
                i2++;
            }
        }
    }
}
