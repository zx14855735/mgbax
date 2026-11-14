package BI9f7h;

import ADYaiT.CtFAbx;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends B25kr6 {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final ArrayList f1285AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1286AcNBzu;

    public A5SV6n(BChYOn.ARc23Z aRc23Z, int i) {
        super(aRc23Z);
        BChYOn.ARc23Z aRc23Z2;
        this.f1285AaHO0E = new ArrayList();
        this.f1321ARc23Z = i;
        BChYOn.ARc23Z aRc23Z3 = this.f1318A4TApA;
        BChYOn.ARc23Z AlLFFp2 = aRc23Z3.AlLFFp(i);
        while (true) {
            BChYOn.ARc23Z aRc23Z4 = AlLFFp2;
            aRc23Z2 = aRc23Z3;
            aRc23Z3 = aRc23Z4;
            if (aRc23Z3 == null) {
                break;
            } else {
                AlLFFp2 = aRc23Z3.AlLFFp(this.f1321ARc23Z);
            }
        }
        this.f1318A4TApA = aRc23Z2;
        int i2 = this.f1321ARc23Z;
        ADYaiT aDYaiT = i2 == 0 ? aRc23Z2.f1134ADYaiT : i2 == 1 ? aRc23Z2.AMqCpz : null;
        ArrayList arrayList = this.f1285AaHO0E;
        arrayList.add(aDYaiT);
        BChYOn.ARc23Z AcNBzu2 = aRc23Z2.AcNBzu(this.f1321ARc23Z);
        while (AcNBzu2 != null) {
            int i3 = this.f1321ARc23Z;
            arrayList.add(i3 == 0 ? AcNBzu2.f1134ADYaiT : i3 == 1 ? AcNBzu2.AMqCpz : null);
            AcNBzu2 = AcNBzu2.AcNBzu(this.f1321ARc23Z);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            B25kr6 b25kr6 = (B25kr6) it.next();
            int i4 = this.f1321ARc23Z;
            if (i4 == 0) {
                b25kr6.f1318A4TApA.f1132A4TApA = this;
            } else if (i4 == 1) {
                b25kr6.f1318A4TApA.f1133A5SV6n = this;
            }
        }
        if (this.f1321ARc23Z == 0 && ((BChYOn.ASJ6gh) this.f1318A4TApA.f1175CrfGsy).f1200EH1KK8 && arrayList.size() > 1) {
            this.f1318A4TApA = ((B25kr6) CtFAbx.ADYaiT(arrayList, 1)).f1318A4TApA;
        }
        this.f1286AcNBzu = this.f1321ARc23Z == 0 ? this.f1318A4TApA.DXuj49 : this.f1318A4TApA.f1190DaOi9o;
    }

    @Override // BI9f7h.B25kr6
    public final void A5SV6n() {
        ArrayList arrayList = this.f1285AaHO0E;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((B25kr6) it.next()).A5SV6n();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        BChYOn.ARc23Z aRc23Z = ((B25kr6) arrayList.get(0)).f1318A4TApA;
        BChYOn.ARc23Z aRc23Z2 = ((B25kr6) arrayList.get(size - 1)).f1318A4TApA;
        int i = this.f1321ARc23Z;
        ARc23Z aRc23Z3 = this.f1324AZOQYO;
        ARc23Z aRc23Z4 = this.f1323AYUAbz;
        if (i == 0) {
            BChYOn.AMqCpz aMqCpz = aRc23Z.f1164CNPG0E;
            BChYOn.AMqCpz aMqCpz2 = aRc23Z2.f1166CQhlFr;
            ARc23Z AYUAbz2 = B25kr6.AYUAbz(aMqCpz, 0);
            int AMqCpz = aMqCpz.AMqCpz();
            BChYOn.ARc23Z AcNBzu2 = AcNBzu();
            if (AcNBzu2 != null) {
                AMqCpz = AcNBzu2.f1164CNPG0E.AMqCpz();
            }
            if (AYUAbz2 != null) {
                B25kr6.A2egSU(aRc23Z4, AYUAbz2, AMqCpz);
            }
            ARc23Z AYUAbz3 = B25kr6.AYUAbz(aMqCpz2, 0);
            int AMqCpz2 = aMqCpz2.AMqCpz();
            BChYOn.ARc23Z AlLFFp2 = AlLFFp();
            if (AlLFFp2 != null) {
                AMqCpz2 = AlLFFp2.f1166CQhlFr.AMqCpz();
            }
            if (AYUAbz3 != null) {
                B25kr6.A2egSU(aRc23Z3, AYUAbz3, -AMqCpz2);
            }
        } else {
            BChYOn.AMqCpz aMqCpz3 = aRc23Z.f1165COJEAR;
            BChYOn.AMqCpz aMqCpz4 = aRc23Z2.f1167CSDoyG;
            ARc23Z AYUAbz4 = B25kr6.AYUAbz(aMqCpz3, 1);
            int AMqCpz3 = aMqCpz3.AMqCpz();
            BChYOn.ARc23Z AcNBzu3 = AcNBzu();
            if (AcNBzu3 != null) {
                AMqCpz3 = AcNBzu3.f1165COJEAR.AMqCpz();
            }
            if (AYUAbz4 != null) {
                B25kr6.A2egSU(aRc23Z4, AYUAbz4, AMqCpz3);
            }
            ARc23Z AYUAbz5 = B25kr6.AYUAbz(aMqCpz4, 1);
            int AMqCpz4 = aMqCpz4.AMqCpz();
            BChYOn.ARc23Z AlLFFp3 = AlLFFp();
            if (AlLFFp3 != null) {
                AMqCpz4 = AlLFFp3.f1167CSDoyG.AMqCpz();
            }
            if (AYUAbz5 != null) {
                B25kr6.A2egSU(aRc23Z3, AYUAbz5, -AMqCpz4);
            }
        }
        aRc23Z4.f1294A2egSU = this;
        aRc23Z3.f1294A2egSU = this;
    }

    @Override // BI9f7h.B25kr6
    public final void ADYaiT() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1285AaHO0E;
            if (i >= arrayList.size()) {
                return;
            }
            ((B25kr6) arrayList.get(i)).ADYaiT();
            i++;
        }
    }

    @Override // BI9f7h.B25kr6
    public final void AMqCpz() {
        this.f1319A5SV6n = null;
        Iterator it = this.f1285AaHO0E.iterator();
        while (it.hasNext()) {
            ((B25kr6) it.next()).AMqCpz();
        }
    }

    @Override // BI9f7h.B25kr6
    public final long AZOQYO() {
        ArrayList arrayList = this.f1285AaHO0E;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = r5.f1324AZOQYO.f1298ARc23Z + ((B25kr6) arrayList.get(i)).AZOQYO() + j + r5.f1323AYUAbz.f1298ARc23Z;
        }
        return j;
    }

    @Override // BI9f7h.B25kr6
    public final boolean AZkASS() {
        ArrayList arrayList = this.f1285AaHO0E;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((B25kr6) arrayList.get(i)).AZkASS()) {
                return false;
            }
        }
        return true;
    }

    public final BChYOn.ARc23Z AcNBzu() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1285AaHO0E;
            if (i >= arrayList.size()) {
                return null;
            }
            BChYOn.ARc23Z aRc23Z = ((B25kr6) arrayList.get(i)).f1318A4TApA;
            if (aRc23Z.f1188DV2E8K != 8) {
                return aRc23Z;
            }
            i++;
        }
    }

    public final BChYOn.ARc23Z AlLFFp() {
        ArrayList arrayList = this.f1285AaHO0E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            BChYOn.ARc23Z aRc23Z = ((B25kr6) arrayList.get(size)).f1318A4TApA;
            if (aRc23Z.f1188DV2E8K != 8) {
                return aRc23Z;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f1321ARc23Z == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f1285AaHO0E.iterator();
        while (it.hasNext()) {
            B25kr6 b25kr6 = (B25kr6) it.next();
            sb.append("<");
            sb.append(b25kr6);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:288:0x0398, code lost:
    
        r2 = r2 - r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // BI9f7h.B25kr6, BI9f7h.ADYaiT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(BI9f7h.ADYaiT r28) {
        /*
            Method dump skipped, instructions count: 951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BI9f7h.A5SV6n.update(BI9f7h.ADYaiT):void");
    }
}
