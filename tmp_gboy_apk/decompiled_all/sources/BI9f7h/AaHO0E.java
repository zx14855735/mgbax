package BI9f7h;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends B25kr6 {
    @Override // BI9f7h.B25kr6
    public final void A5SV6n() {
        BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
        if (aRc23Z instanceof BChYOn.A2egSU) {
            ARc23Z aRc23Z2 = this.f1323AYUAbz;
            aRc23Z2.f1295A4TApA = true;
            BChYOn.A2egSU a2egSU = (BChYOn.A2egSU) aRc23Z;
            int i = a2egSU.f1094DyaChj;
            boolean z = a2egSU.f1095ECyGFg;
            int i2 = 0;
            if (i == 0) {
                aRc23Z2.AMqCpz = 4;
                while (i2 < a2egSU.f1263DvK7DB) {
                    BChYOn.ARc23Z aRc23Z3 = a2egSU.f1262DuwtYk[i2];
                    if (z || aRc23Z3.f1188DV2E8K != 8) {
                        ARc23Z aRc23Z4 = aRc23Z3.f1134ADYaiT.f1323AYUAbz;
                        aRc23Z4.f1303AaHO0E.add(aRc23Z2);
                        aRc23Z2.f1304AcNBzu.add(aRc23Z4);
                    }
                    i2++;
                }
                AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1323AYUAbz);
                AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1324AZOQYO);
                return;
            }
            if (i == 1) {
                aRc23Z2.AMqCpz = 5;
                while (i2 < a2egSU.f1263DvK7DB) {
                    BChYOn.ARc23Z aRc23Z5 = a2egSU.f1262DuwtYk[i2];
                    if (z || aRc23Z5.f1188DV2E8K != 8) {
                        ARc23Z aRc23Z6 = aRc23Z5.f1134ADYaiT.f1324AZOQYO;
                        aRc23Z6.f1303AaHO0E.add(aRc23Z2);
                        aRc23Z2.f1304AcNBzu.add(aRc23Z6);
                    }
                    i2++;
                }
                AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1323AYUAbz);
                AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1324AZOQYO);
                return;
            }
            if (i == 2) {
                aRc23Z2.AMqCpz = 6;
                while (i2 < a2egSU.f1263DvK7DB) {
                    BChYOn.ARc23Z aRc23Z7 = a2egSU.f1262DuwtYk[i2];
                    if (z || aRc23Z7.f1188DV2E8K != 8) {
                        ARc23Z aRc23Z8 = aRc23Z7.AMqCpz.f1323AYUAbz;
                        aRc23Z8.f1303AaHO0E.add(aRc23Z2);
                        aRc23Z2.f1304AcNBzu.add(aRc23Z8);
                    }
                    i2++;
                }
                AcNBzu(this.f1318A4TApA.AMqCpz.f1323AYUAbz);
                AcNBzu(this.f1318A4TApA.AMqCpz.f1324AZOQYO);
                return;
            }
            if (i != 3) {
                return;
            }
            aRc23Z2.AMqCpz = 7;
            while (i2 < a2egSU.f1263DvK7DB) {
                BChYOn.ARc23Z aRc23Z9 = a2egSU.f1262DuwtYk[i2];
                if (z || aRc23Z9.f1188DV2E8K != 8) {
                    ARc23Z aRc23Z10 = aRc23Z9.AMqCpz.f1324AZOQYO;
                    aRc23Z10.f1303AaHO0E.add(aRc23Z2);
                    aRc23Z2.f1304AcNBzu.add(aRc23Z10);
                }
                i2++;
            }
            AcNBzu(this.f1318A4TApA.AMqCpz.f1323AYUAbz);
            AcNBzu(this.f1318A4TApA.AMqCpz.f1324AZOQYO);
        }
    }

    @Override // BI9f7h.B25kr6
    public final void ADYaiT() {
        BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
        if (aRc23Z instanceof BChYOn.A2egSU) {
            int i = ((BChYOn.A2egSU) aRc23Z).f1094DyaChj;
            ARc23Z aRc23Z2 = this.f1323AYUAbz;
            if (i == 0 || i == 1) {
                aRc23Z.f1180D6yqiO = aRc23Z2.f1299ASJ6gh;
            } else {
                aRc23Z.f1181D8MqeW = aRc23Z2.f1299ASJ6gh;
            }
        }
    }

    @Override // BI9f7h.B25kr6
    public final void AMqCpz() {
        this.f1319A5SV6n = null;
        this.f1323AYUAbz.A4TApA();
    }

    @Override // BI9f7h.B25kr6
    public final boolean AZkASS() {
        return false;
    }

    public final void AcNBzu(ARc23Z aRc23Z) {
        ARc23Z aRc23Z2 = this.f1323AYUAbz;
        aRc23Z2.f1303AaHO0E.add(aRc23Z);
        aRc23Z.f1304AcNBzu.add(aRc23Z2);
    }

    @Override // BI9f7h.B25kr6, BI9f7h.ADYaiT
    public void update(ADYaiT aDYaiT) {
        BChYOn.A2egSU a2egSU = (BChYOn.A2egSU) this.f1318A4TApA;
        int i = a2egSU.f1094DyaChj;
        ARc23Z aRc23Z = this.f1323AYUAbz;
        Iterator it = aRc23Z.f1304AcNBzu.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = ((ARc23Z) it.next()).f1299ASJ6gh;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            aRc23Z.A5SV6n(i3 + a2egSU.f1096EGM26s);
        } else {
            aRc23Z.A5SV6n(i2 + a2egSU.f1096EGM26s);
        }
    }
}
