package ADYaiT;

import COJEAR.Dphsd2;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DV2E8K extends Dphsd2 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f242A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ DXuj49 f243A4TApA;

    public /* synthetic */ DV2E8K(DXuj49 dXuj49, int i) {
        this.f242A2egSU = i;
        this.f243A4TApA = dXuj49;
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public final void A5SV6n() {
        View view;
        DXuj49 dXuj49 = this.f243A4TApA;
        switch (this.f242A2egSU) {
            case 0:
                if (dXuj49.f264AzWtSf && (view = dXuj49.f256ASJ6gh) != null) {
                    view.setTranslationY(0.0f);
                    dXuj49.f254ADYaiT.setTranslationY(0.0f);
                }
                dXuj49.f254ADYaiT.setVisibility(8);
                dXuj49.f254ADYaiT.setTransitioning(false);
                dXuj49.f268B4ZgIw = null;
                K1Z3yj.A2egSU a2egSU = dXuj49.f260AaHO0E;
                if (a2egSU != null) {
                    a2egSU.AYUAbz(dXuj49.f259AZkASS);
                    dXuj49.f259AZkASS = null;
                    dXuj49.f260AaHO0E = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = dXuj49.f253A5SV6n;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                    COJEAR.CikNvS.A5SV6n(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                dXuj49.f268B4ZgIw = null;
                dXuj49.f254ADYaiT.requestLayout();
                break;
        }
    }
}
