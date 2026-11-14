package Oay4Bh;

import COJEAR.FG7pZc;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CASmeH implements COJEAR {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ boolean f6608AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ boolean f6609AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ boolean f6610AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ NGepWW.A2egSU f6611AzWtSf;

    public CASmeH(boolean z, boolean z2, boolean z3, NGepWW.A2egSU a2egSU) {
        this.f6608AcNBzu = z;
        this.f6609AlLFFp = z2;
        this.f6610AmA8tU = z3;
        this.f6611AzWtSf = a2egSU;
    }

    @Override // Oay4Bh.COJEAR
    public final FG7pZc AZOQYO(View view, FG7pZc fG7pZc, CQhlFr cQhlFr) {
        if (this.f6608AcNBzu) {
            cQhlFr.f6615ADYaiT = fG7pZc.A2egSU() + cQhlFr.f6615ADYaiT;
        }
        boolean AlLFFp2 = C4FrIb.AlLFFp(view);
        if (this.f6609AlLFFp) {
            if (AlLFFp2) {
                cQhlFr.f6614A5SV6n = fG7pZc.A4TApA() + cQhlFr.f6614A5SV6n;
            } else {
                cQhlFr.f6612A2egSU = fG7pZc.A4TApA() + cQhlFr.f6612A2egSU;
            }
        }
        if (this.f6610AmA8tU) {
            if (AlLFFp2) {
                cQhlFr.f6612A2egSU = fG7pZc.A5SV6n() + cQhlFr.f6612A2egSU;
            } else {
                cQhlFr.f6614A5SV6n = fG7pZc.A5SV6n() + cQhlFr.f6614A5SV6n;
            }
        }
        view.setPaddingRelative(cQhlFr.f6612A2egSU, cQhlFr.f6613A4TApA, cQhlFr.f6614A5SV6n, cQhlFr.f6615ADYaiT);
        this.f6611AzWtSf.AZOQYO(view, fG7pZc, cQhlFr);
        return fG7pZc;
    }
}
