package AZOQYO;

import AaHO0E.H6qKiO;
import COJEAR.Dphsd2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends Dphsd2 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f407A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f408A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f409A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ Object f410ADYaiT;

    public AaHO0E(AcNBzu acNBzu) {
        this.f407A2egSU = 0;
        this.f410ADYaiT = acNBzu;
        this.f408A4TApA = false;
        this.f409A5SV6n = 0;
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public void A2egSU() {
        switch (this.f407A2egSU) {
            case 1:
                this.f408A4TApA = true;
                break;
        }
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public final void A4TApA() {
        switch (this.f407A2egSU) {
            case 0:
                if (!this.f408A4TApA) {
                    this.f408A4TApA = true;
                    Dphsd2 dphsd2 = ((AcNBzu) this.f410ADYaiT).f414ADYaiT;
                    if (dphsd2 != null) {
                        dphsd2.A4TApA();
                        break;
                    }
                }
                break;
            default:
                ((H6qKiO) this.f410ADYaiT).f898A2egSU.setVisibility(0);
                break;
        }
    }

    @Override // COJEAR.Dphsd2, COJEAR.DjONCG
    public final void A5SV6n() {
        switch (this.f407A2egSU) {
            case 0:
                int i = this.f409A5SV6n + 1;
                this.f409A5SV6n = i;
                AcNBzu acNBzu = (AcNBzu) this.f410ADYaiT;
                if (i == acNBzu.f411A2egSU.size()) {
                    Dphsd2 dphsd2 = acNBzu.f414ADYaiT;
                    if (dphsd2 != null) {
                        dphsd2.A5SV6n();
                    }
                    this.f409A5SV6n = 0;
                    this.f408A4TApA = false;
                    acNBzu.AMqCpz = false;
                    break;
                }
                break;
            default:
                if (!this.f408A4TApA) {
                    ((H6qKiO) this.f410ADYaiT).f898A2egSU.setVisibility(this.f409A5SV6n);
                    break;
                }
                break;
        }
    }

    public AaHO0E(H6qKiO h6qKiO, int i) {
        this.f407A2egSU = 1;
        this.f410ADYaiT = h6qKiO;
        this.f409A5SV6n = i;
        this.f408A4TApA = false;
    }
}
