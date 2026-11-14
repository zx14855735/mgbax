package ADYaiT;

import AaHO0E.Dphsd2;
import android.view.Window;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BTvldC implements Dphsd2, AZkASS.BJ7GGh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f109AcNBzu;

    public /* synthetic */ BTvldC(CkXcdM ckXcdM) {
        this.f109AcNBzu = ckXcdM;
    }

    @Override // AZkASS.BJ7GGh
    public void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
        CikNvS cikNvS;
        AZkASS.AmA8tU AaHO0E2 = amA8tU.AaHO0E();
        int i = 0;
        boolean z2 = AaHO0E2 != amA8tU;
        if (z2) {
            amA8tU = AaHO0E2;
        }
        CkXcdM ckXcdM = this.f109AcNBzu;
        CikNvS[] cikNvSArr = ckXcdM.f183CtxOCS;
        int length = cikNvSArr != null ? cikNvSArr.length : 0;
        while (true) {
            if (i < length) {
                cikNvS = cikNvSArr[i];
                if (cikNvS != null && cikNvS.f144AYUAbz == amA8tU) {
                    break;
                } else {
                    i++;
                }
            } else {
                cikNvS = null;
                break;
            }
        }
        if (cikNvS != null) {
            if (!z2) {
                ckXcdM.B7CMnp(cikNvS, z);
            } else {
                ckXcdM.B3GDIM(cikNvS.f138A2egSU, cikNvS, AaHO0E2);
                ckXcdM.B7CMnp(cikNvS, true);
            }
        }
    }

    @Override // AZkASS.BJ7GGh
    public boolean AMqCpz(AZkASS.AmA8tU amA8tU) {
        Window.Callback callback;
        if (amA8tU != amA8tU.AaHO0E()) {
            return true;
        }
        CkXcdM ckXcdM = this.f109AcNBzu;
        if (!ckXcdM.f177CikNvS || (callback = ckXcdM.f158BI9f7h.getCallback()) == null || ckXcdM.f188D8cQ8b) {
            return true;
        }
        callback.onMenuOpened(108, amA8tU);
        return true;
    }
}
