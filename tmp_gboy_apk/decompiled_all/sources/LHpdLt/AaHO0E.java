package LHpdLt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements Mm8v1u.BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4509A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4510A4TApA;

    public /* synthetic */ AaHO0E(BTvldC bTvldC, int i) {
        this.f4509A2egSU = i;
        this.f4510A4TApA = bTvldC;
    }

    @Override // Mm8v1u.BJ7GGh
    public void A2egSU(String str) {
        switch (this.f4509A2egSU) {
            case 0:
                try {
                    BTvldC.A4TApA(this.f4510A4TApA, "is_udp", Integer.parseInt(str));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                try {
                    BTvldC.A4TApA(this.f4510A4TApA, "multi_game", Integer.parseInt(str));
                    break;
                } catch (Exception unused) {
                    return;
                }
        }
    }
}
