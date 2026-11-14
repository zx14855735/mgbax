package D8MqeW;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends AYUAbz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f2017A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ARc23Z(List list, boolean z) {
        super(list);
        RXb0Sz.ARc23Z.AMqCpz(list, "cubics");
        this.f2017A4TApA = z;
    }

    @Override // D8MqeW.AYUAbz
    public final AYUAbz A2egSU(K1Z3yj.A2egSU a2egSU) {
        RFbdkT.A5SV6n A4TApA2 = RD2OKB.AZkASS.A4TApA();
        List list = this.f2018A2egSU;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            A4TApA2.add(((A4TApA) list.get(i)).AMqCpz(a2egSU));
        }
        return new ARc23Z(RD2OKB.AZkASS.A2egSU(A4TApA2), this.f2017A4TApA);
    }

    public final String toString() {
        return "Corner: cubics=" + RD2OKB.B4ZgIw.AaHO0E(this.f2018A2egSU, new AMqCpz(), 30) + " convex=" + this.f2017A4TApA;
    }
}
