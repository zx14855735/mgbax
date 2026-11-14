package D8MqeW;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends AYUAbz {
    @Override // D8MqeW.AYUAbz
    public final AYUAbz A2egSU(K1Z3yj.A2egSU a2egSU) {
        RFbdkT.A5SV6n A4TApA2 = RD2OKB.AZkASS.A4TApA();
        List list = this.f2018A2egSU;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            A4TApA2.add(((A4TApA) list.get(i)).AMqCpz(a2egSU));
        }
        RFbdkT.A5SV6n A2egSU2 = RD2OKB.AZkASS.A2egSU(A4TApA2);
        RXb0Sz.ARc23Z.AMqCpz(A2egSU2, "cubics");
        return new ASJ6gh(A2egSU2);
    }

    public final String toString() {
        return "Edge";
    }
}
