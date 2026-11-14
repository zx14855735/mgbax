package PWr3nF;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements View.OnFocusChangeListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7290A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f7291A4TApA;

    public /* synthetic */ A2egSU(AzWtSf azWtSf, int i) {
        this.f7290A2egSU = i;
        this.f7291A4TApA = azWtSf;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f7290A2egSU) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f7291A4TApA;
                aDYaiT.B7CMnp(aDYaiT.B9tovu());
                break;
            default:
                AZkASS aZkASS = (AZkASS) this.f7291A4TApA;
                aZkASS.f7315AcNBzu = z;
                aZkASS.B2KMhB();
                if (!z) {
                    aZkASS.B7CMnp(false);
                    aZkASS.f7316AlLFFp = false;
                    break;
                }
                break;
        }
    }
}
