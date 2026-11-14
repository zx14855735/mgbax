package LHpdLt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS implements Mm8v1u.BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4507A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4508A4TApA;

    public /* synthetic */ AZkASS(BTvldC bTvldC, int i) {
        this.f4507A2egSU = i;
        this.f4508A4TApA = bTvldC;
    }

    @Override // Mm8v1u.BJ7GGh
    public void A2egSU(String str) {
        switch (this.f4507A2egSU) {
            case 0:
                try {
                    BTvldC.A4TApA(this.f4508A4TApA, "sync_modes", Integer.parseInt(str));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                try {
                    BTvldC.A4TApA(this.f4508A4TApA, "network_buffer", Integer.parseInt(str));
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }
}
