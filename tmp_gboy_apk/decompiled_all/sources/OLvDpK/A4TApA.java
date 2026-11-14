package OLvDpK;

import Oay4Bh.BmvVmW;
import Oay4Bh.BniPrB;
import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends P3rngT.ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6272A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f6273A4TApA;

    public /* synthetic */ A4TApA(int i, Object obj) {
        this.f6272A2egSU = i;
        this.f6273A4TApA = obj;
    }

    private final void A5SV6n(int i) {
    }

    @Override // P3rngT.ARc23Z
    public final void A2egSU(int i) {
        switch (this.f6272A2egSU) {
            case 0:
                break;
            default:
                BniPrB bniPrB = (BniPrB) this.f6273A4TApA;
                bniPrB.AMqCpz = true;
                BmvVmW bmvVmW = (BmvVmW) bniPrB.f6603ARc23Z.get();
                if (bmvVmW != null) {
                    bmvVmW.A2egSU();
                    break;
                }
                break;
        }
    }

    @Override // P3rngT.ARc23Z
    public final void A4TApA(Typeface typeface, boolean z) {
        switch (this.f6272A2egSU) {
            case 0:
                Chip chip = (Chip) this.f6273A4TApA;
                ARc23Z aRc23Z = chip.f11549B25kr6;
                chip.setText(aRc23Z.f6333Fyurov ? aRc23Z.f6286D6yqiO : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    BniPrB bniPrB = (BniPrB) this.f6273A4TApA;
                    bniPrB.AMqCpz = true;
                    BmvVmW bmvVmW = (BmvVmW) bniPrB.f6603ARc23Z.get();
                    if (bmvVmW != null) {
                        bmvVmW.A2egSU();
                        break;
                    }
                }
                break;
        }
    }
}
