package ADYaiT;

import COJEAR.De4eam;
import android.view.ViewGroup;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f106AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f107AlLFFp;

    public /* synthetic */ BNL6CD(CkXcdM ckXcdM, int i) {
        this.f106AcNBzu = i;
        this.f107AlLFFp = ckXcdM;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.f106AcNBzu) {
            case 0:
                CkXcdM ckXcdM = this.f107AlLFFp;
                if ((ckXcdM.f196DaOi9o & 1) != 0) {
                    ckXcdM.BI9f7h(0);
                }
                if ((ckXcdM.f196DaOi9o & f.a.c) != 0) {
                    ckXcdM.BI9f7h(108);
                }
                ckXcdM.DXuj49 = false;
                ckXcdM.f196DaOi9o = 0;
                break;
            default:
                CkXcdM ckXcdM2 = this.f107AlLFFp;
                ckXcdM2.f168C4FrIb.showAtLocation(ckXcdM2.f167C2rE4F, 55, 0, 0);
                De4eam de4eam = ckXcdM2.f170CNPG0E;
                if (de4eam != null) {
                    de4eam.A4TApA();
                }
                if (!(ckXcdM2.f171COJEAR && (viewGroup = ckXcdM2.f172CQhlFr) != null && viewGroup.isLaidOut())) {
                    ckXcdM2.f167C2rE4F.setAlpha(1.0f);
                    ckXcdM2.f167C2rE4F.setVisibility(0);
                    break;
                } else {
                    ckXcdM2.f167C2rE4F.setAlpha(0.0f);
                    De4eam A2egSU2 = COJEAR.DG07BK.A2egSU(ckXcdM2.f167C2rE4F);
                    A2egSU2.A2egSU(1.0f);
                    ckXcdM2.f170CNPG0E = A2egSU2;
                    A2egSU2.ADYaiT(new BV3sI0(0, this));
                    break;
                }
        }
    }
}
