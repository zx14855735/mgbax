package PCV8se;

import android.view.View;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BniPrB extends BTvldC {
    public BniPrB(FrameLayout frameLayout) {
        ADYaiT(frameLayout);
    }

    private void ADYaiT(View view) {
        view.setOutlineProvider(new OLvDpK.A5SV6n(2, this));
    }

    @Override // PCV8se.BTvldC
    public final void A2egSU(FrameLayout frameLayout) {
        frameLayout.setClipToOutline(!this.f7140A2egSU);
        if (this.f7140A2egSU) {
            frameLayout.invalidate();
        } else {
            frameLayout.invalidateOutline();
        }
    }

    @Override // PCV8se.BTvldC
    public final boolean A4TApA() {
        return this.f7140A2egSU;
    }
}
