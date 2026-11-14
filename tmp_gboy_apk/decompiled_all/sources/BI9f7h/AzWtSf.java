package BI9f7h;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static int f1312ARc23Z;

    /* renamed from: A2egSU, reason: collision with root package name */
    public ArrayList f1313A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1314A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1315A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ArrayList f1316ADYaiT;
    public int AMqCpz;

    public final void A2egSU(ArrayList arrayList) {
        int size = this.f1313A2egSU.size();
        if (this.AMqCpz != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                AzWtSf azWtSf = (AzWtSf) arrayList.get(i);
                if (this.AMqCpz == azWtSf.f1314A4TApA) {
                    A5SV6n(this.f1315A5SV6n, azWtSf);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int A4TApA(B4ZgIw.ADYaiT aDYaiT, int i) {
        int AmA8tU2;
        int AmA8tU3;
        ArrayList arrayList = this.f1313A2egSU;
        if (arrayList.size() == 0) {
            return 0;
        }
        BChYOn.ASJ6gh aSJ6gh = (BChYOn.ASJ6gh) ((BChYOn.ARc23Z) arrayList.get(0)).f1175CrfGsy;
        aDYaiT.B7CMnp();
        aSJ6gh.A4TApA(aDYaiT, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((BChYOn.ARc23Z) arrayList.get(i2)).A4TApA(aDYaiT, false);
        }
        if (i == 0 && aSJ6gh.f1204EY4UKY > 0) {
            BChYOn.A4TApA.A2egSU(aSJ6gh, aDYaiT, arrayList, 0);
        }
        if (i == 1 && aSJ6gh.EdQ5bb > 0) {
            BChYOn.A4TApA.A2egSU(aSJ6gh, aDYaiT, arrayList, 1);
        }
        try {
            aDYaiT.B25kr6();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1316ADYaiT = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) arrayList.get(i3);
            BmvVmW bmvVmW = new BmvVmW(3);
            new WeakReference(aRc23Z);
            B4ZgIw.ADYaiT.AmA8tU(aRc23Z.f1164CNPG0E);
            B4ZgIw.ADYaiT.AmA8tU(aRc23Z.f1165COJEAR);
            B4ZgIw.ADYaiT.AmA8tU(aRc23Z.f1166CQhlFr);
            B4ZgIw.ADYaiT.AmA8tU(aRc23Z.f1167CSDoyG);
            B4ZgIw.ADYaiT.AmA8tU(aRc23Z.f1168CTkVKb);
            this.f1316ADYaiT.add(bmvVmW);
        }
        if (i == 0) {
            AmA8tU2 = B4ZgIw.ADYaiT.AmA8tU(aSJ6gh.f1164CNPG0E);
            AmA8tU3 = B4ZgIw.ADYaiT.AmA8tU(aSJ6gh.f1166CQhlFr);
            aDYaiT.B7CMnp();
        } else {
            AmA8tU2 = B4ZgIw.ADYaiT.AmA8tU(aSJ6gh.f1165COJEAR);
            AmA8tU3 = B4ZgIw.ADYaiT.AmA8tU(aSJ6gh.f1167CSDoyG);
            aDYaiT.B7CMnp();
        }
        return AmA8tU3 - AmA8tU2;
    }

    public final void A5SV6n(int i, AzWtSf azWtSf) {
        Iterator it = this.f1313A2egSU.iterator();
        while (it.hasNext()) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) it.next();
            ArrayList arrayList = azWtSf.f1313A2egSU;
            if (!arrayList.contains(aRc23Z)) {
                arrayList.add(aRc23Z);
            }
            int i2 = azWtSf.f1314A4TApA;
            if (i == 0) {
                aRc23Z.f1193De4eam = i2;
            } else {
                aRc23Z.f1194DjONCG = i2;
            }
        }
        this.AMqCpz = azWtSf.f1314A4TApA;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.f1315A5SV6n;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String AZkASS2 = CtFAbx.AZkASS("] <", this.f1314A4TApA, sb);
        Iterator it = this.f1313A2egSU.iterator();
        while (it.hasNext()) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) it.next();
            StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(AZkASS2, " ");
            A5SV6n2.append(aRc23Z.f1189DXnQ0V);
            AZkASS2 = A5SV6n2.toString();
        }
        return CtFAbx.AcNBzu(AZkASS2, " >");
    }
}
