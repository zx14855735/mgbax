package DRlcZ9;

import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements DialogInterface.OnMultiChoiceClickListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2085A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f2086A4TApA;

    public /* synthetic */ AZkASS(int i, Object obj) {
        this.f2085A2egSU = i;
        this.f2086A4TApA = obj;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
        switch (this.f2085A2egSU) {
            case 0:
                AaHO0E aaHO0E = (AaHO0E) this.f2086A4TApA;
                if (!z) {
                    aaHO0E.f2088B9tovu = aaHO0E.f2087B7CMnp.remove(aaHO0E.f2090BI9f7h[i].toString()) | aaHO0E.f2088B9tovu;
                    break;
                } else {
                    aaHO0E.f2088B9tovu = aaHO0E.f2087B7CMnp.add(aaHO0E.f2090BI9f7h[i].toString()) | aaHO0E.f2088B9tovu;
                    break;
                }
            default:
                ((boolean[]) this.f2086A4TApA)[i] = z;
                break;
        }
    }
}
