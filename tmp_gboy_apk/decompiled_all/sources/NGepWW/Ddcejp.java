package NGepWW;

import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Ddcejp extends EQurEW {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f5744A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f5745A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f5746ADYaiT;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ddcejp(De4eam de4eam, EPdU4G ePdU4G, NOd7IU.A2egSU a2egSU) {
        super(ePdU4G);
        this.f5746ADYaiT = de4eam;
        this.f5745A5SV6n = a2egSU;
    }

    @Override // NGepWW.EQurEW
    public final void A2egSU() {
        switch (this.f5744A4TApA) {
            case 0:
                ((De4eam) this.f5746ADYaiT).f5749AmA8tU.ASJ6gh((NOd7IU.A2egSU) this.f5745A5SV6n);
                break;
            default:
                DuwtYk duwtYk = (DuwtYk) this.f5745A5SV6n;
                if (duwtYk.ARc23Z(0)) {
                    CASmeH cASmeH = (CASmeH) this.f5746ADYaiT;
                    NOd7IU.A2egSU a2egSU = cASmeH.f5710AlLFFp;
                    if (a2egSU.A5SV6n()) {
                        NUY5pn.AaHO0E aaHO0E = cASmeH.f5711AmA8tU;
                        a2egSU = aaHO0E.f5956AmA8tU;
                        if (!a2egSU.A5SV6n()) {
                            String valueOf = String.valueOf(a2egSU);
                            Log.wtf("GoogleApiClientConnecting", ADYaiT.CtFAbx.B25kr6(new StringBuilder(valueOf.length() + 48), "Sign-in succeeded with resolve account failure: ", valueOf), new Exception());
                            duwtYk.ASJ6gh(a2egSU);
                            break;
                        } else {
                            duwtYk.f5766BJ7GGh = true;
                            duwtYk.f5767BNL6CD = NUY5pn.A2egSU.A2egSU(aaHO0E.f5955AlLFFp);
                            duwtYk.f5768BPw6Q8 = aaHO0E.f5957AzWtSf;
                            duwtYk.f5769BTvldC = aaHO0E.f5958B25kr6;
                            duwtYk.AZOQYO();
                            break;
                        }
                    } else {
                        int i = duwtYk.f5764BI9f7h;
                        if (i == 2 || (i == 1 && !a2egSU.A4TApA())) {
                            duwtYk.AaHO0E();
                            duwtYk.AZOQYO();
                        }
                        duwtYk.ASJ6gh(a2egSU);
                    }
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ddcejp(DuwtYk duwtYk, DuwtYk duwtYk2, CASmeH cASmeH) {
        super(duwtYk);
        this.f5745A5SV6n = duwtYk2;
        this.f5746ADYaiT = cASmeH;
    }
}
