package AaHO0E;

import android.content.Context;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends AZkASS.BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f602AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f603AlLFFp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AYUAbz(AzWtSf azWtSf, Context context, AZkASS.AmA8tU amA8tU, View view) {
        super(2130968611, amA8tU, context, view, true);
        this.f603AlLFFp = azWtSf;
        this.f565ARc23Z = 8388613;
        AZkASS.ARc23Z aRc23Z = azWtSf.f624CASmeH;
        this.f567AYUAbz = aRc23Z;
        AZkASS.BChYOn bChYOn = this.f568AZOQYO;
        if (bChYOn != null) {
            bChYOn.AaHO0E(aRc23Z);
        }
    }

    @Override // AZkASS.BIYEnU
    public final void A5SV6n() {
        switch (this.f602AcNBzu) {
            case 0:
                AzWtSf azWtSf = this.f603AlLFFp;
                azWtSf.BpkvW3 = null;
                azWtSf.f625CNPG0E = 0;
                super.A5SV6n();
                break;
            default:
                AzWtSf azWtSf2 = this.f603AlLFFp;
                AZkASS.AmA8tU amA8tU = azWtSf2.f434AmA8tU;
                if (amA8tU != null) {
                    amA8tU.A5SV6n(true);
                }
                azWtSf2.f621BniPrB = null;
                super.A5SV6n();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AYUAbz(AzWtSf azWtSf, Context context, AZkASS.BpkvW3 bpkvW3, View view) {
        super(2130968611, bpkvW3, context, view, false);
        this.f603AlLFFp = azWtSf;
        if ((bpkvW3.f592CSDoyG.f542CASmeH & 32) != 32) {
            View view2 = azWtSf.f611B9tovu;
            this.AMqCpz = view2 == null ? (View) azWtSf.f439B4ZgIw : view2;
        }
        AZkASS.ARc23Z aRc23Z = azWtSf.f624CASmeH;
        this.f567AYUAbz = aRc23Z;
        AZkASS.BChYOn bChYOn = this.f568AZOQYO;
        if (bChYOn != null) {
            bChYOn.AaHO0E(aRc23Z);
        }
    }
}
