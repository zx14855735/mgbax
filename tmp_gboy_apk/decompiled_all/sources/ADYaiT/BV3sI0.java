package ADYaiT;

import COJEAR.Dphsd2;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 extends Dphsd2 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f110A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f111A4TApA;

    public /* synthetic */ BV3sI0(int i, Object obj) {
        this.f110A2egSU = i;
        this.f111A4TApA = obj;
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public void A4TApA() {
        Object obj = this.f111A4TApA;
        switch (this.f110A2egSU) {
            case 0:
                ((BNL6CD) obj).f107AlLFFp.f167C2rE4F.setVisibility(0);
                break;
            case 1:
                CkXcdM ckXcdM = (CkXcdM) obj;
                ckXcdM.f167C2rE4F.setVisibility(0);
                if (ckXcdM.f167C2rE4F.getParent() instanceof View) {
                    View view = (View) ckXcdM.f167C2rE4F.getParent();
                    WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                    COJEAR.CikNvS.A5SV6n(view);
                    break;
                }
                break;
        }
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public final void A5SV6n() {
        Object obj = this.f111A4TApA;
        switch (this.f110A2egSU) {
            case 0:
                CkXcdM ckXcdM = ((BNL6CD) obj).f107AlLFFp;
                ckXcdM.f167C2rE4F.setAlpha(1.0f);
                ckXcdM.f170CNPG0E.ADYaiT(null);
                ckXcdM.f170CNPG0E = null;
                break;
            case 1:
                CkXcdM ckXcdM2 = (CkXcdM) obj;
                ckXcdM2.f167C2rE4F.setAlpha(1.0f);
                ckXcdM2.f170CNPG0E.ADYaiT(null);
                ckXcdM2.f170CNPG0E = null;
                break;
            default:
                K1Z3yj.A2egSU a2egSU = (K1Z3yj.A2egSU) obj;
                ((CkXcdM) a2egSU.f4175AmA8tU).f167C2rE4F.setVisibility(8);
                CkXcdM ckXcdM3 = (CkXcdM) a2egSU.f4175AmA8tU;
                PopupWindow popupWindow = ckXcdM3.f168C4FrIb;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (ckXcdM3.f167C2rE4F.getParent() instanceof View) {
                    View view = (View) ckXcdM3.f167C2rE4F.getParent();
                    WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                    COJEAR.CikNvS.A5SV6n(view);
                }
                ckXcdM3.f167C2rE4F.AMqCpz();
                ckXcdM3.f170CNPG0E.ADYaiT(null);
                ckXcdM3.f170CNPG0E = null;
                ViewGroup viewGroup = ckXcdM3.f172CQhlFr;
                WeakHashMap weakHashMap2 = COJEAR.DG07BK.f1680A2egSU;
                COJEAR.CikNvS.A5SV6n(viewGroup);
                break;
        }
    }
}
