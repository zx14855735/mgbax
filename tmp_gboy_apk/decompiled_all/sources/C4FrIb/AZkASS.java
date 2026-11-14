package C4FrIb;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements CNPG0E.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f1562A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f1563A4TApA;

    public /* synthetic */ AZkASS(int i, Object obj) {
        this.f1562A2egSU = i;
        this.f1563A4TApA = obj;
    }

    @Override // CNPG0E.A2egSU
    public final void accept(Object obj) {
        switch (this.f1562A2egSU) {
            case 0:
                AcNBzu acNBzu = (AcNBzu) obj;
                if (acNBzu == null) {
                    acNBzu = new AcNBzu(-3);
                }
                ((K1Z3yj.A2egSU) this.f1563A4TApA).AzWtSf(acNBzu);
                return;
            default:
                AcNBzu acNBzu2 = (AcNBzu) obj;
                synchronized (AlLFFp.f1572A5SV6n) {
                    try {
                        B25kr6.AzWtSf azWtSf = AlLFFp.f1573ADYaiT;
                        ArrayList arrayList = (ArrayList) azWtSf.get((String) this.f1563A4TApA);
                        if (arrayList == null) {
                            return;
                        }
                        azWtSf.remove((String) this.f1563A4TApA);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((CNPG0E.A2egSU) arrayList.get(i)).accept(acNBzu2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
