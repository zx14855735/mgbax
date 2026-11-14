package BI9f7h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends B25kr6 {
    @Override // BI9f7h.B25kr6
    public final void A5SV6n() {
        BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
        BChYOn.AZkASS aZkASS = (BChYOn.AZkASS) aRc23Z;
        int i = aZkASS.f1257DvK7DB;
        int i2 = aZkASS.f1258DyaChj;
        int i3 = aZkASS.f1260EGM26s;
        ARc23Z aRc23Z2 = this.f1323AYUAbz;
        if (i3 == 1) {
            if (i != -1) {
                aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.f1134ADYaiT.f1323AYUAbz);
                this.f1318A4TApA.f1175CrfGsy.f1134ADYaiT.f1323AYUAbz.f1303AaHO0E.add(aRc23Z2);
                aRc23Z2.f1298ARc23Z = i;
            } else if (i2 != -1) {
                aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.f1134ADYaiT.f1324AZOQYO);
                this.f1318A4TApA.f1175CrfGsy.f1134ADYaiT.f1324AZOQYO.f1303AaHO0E.add(aRc23Z2);
                aRc23Z2.f1298ARc23Z = -i2;
            } else {
                aRc23Z2.f1295A4TApA = true;
                aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.f1134ADYaiT.f1324AZOQYO);
                this.f1318A4TApA.f1175CrfGsy.f1134ADYaiT.f1324AZOQYO.f1303AaHO0E.add(aRc23Z2);
            }
            AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1323AYUAbz);
            AcNBzu(this.f1318A4TApA.f1134ADYaiT.f1324AZOQYO);
            return;
        }
        if (i != -1) {
            aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.AMqCpz.f1323AYUAbz);
            this.f1318A4TApA.f1175CrfGsy.AMqCpz.f1323AYUAbz.f1303AaHO0E.add(aRc23Z2);
            aRc23Z2.f1298ARc23Z = i;
        } else if (i2 != -1) {
            aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.AMqCpz.f1324AZOQYO);
            this.f1318A4TApA.f1175CrfGsy.AMqCpz.f1324AZOQYO.f1303AaHO0E.add(aRc23Z2);
            aRc23Z2.f1298ARc23Z = -i2;
        } else {
            aRc23Z2.f1295A4TApA = true;
            aRc23Z2.f1304AcNBzu.add(aRc23Z.f1175CrfGsy.AMqCpz.f1324AZOQYO);
            this.f1318A4TApA.f1175CrfGsy.AMqCpz.f1324AZOQYO.f1303AaHO0E.add(aRc23Z2);
        }
        AcNBzu(this.f1318A4TApA.AMqCpz.f1323AYUAbz);
        AcNBzu(this.f1318A4TApA.AMqCpz.f1324AZOQYO);
    }

    @Override // BI9f7h.B25kr6
    public final void ADYaiT() {
        BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
        int i = ((BChYOn.AZkASS) aRc23Z).f1260EGM26s;
        ARc23Z aRc23Z2 = this.f1323AYUAbz;
        if (i == 1) {
            aRc23Z.f1180D6yqiO = aRc23Z2.f1299ASJ6gh;
        } else {
            aRc23Z.f1181D8MqeW = aRc23Z2.f1299ASJ6gh;
        }
    }

    @Override // BI9f7h.B25kr6
    public final void AMqCpz() {
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
        ARc23Z aRc23Z = this.f1323AYUAbz;
        if (aRc23Z.f1296A5SV6n && !aRc23Z.f1302AZkASS) {
            aRc23Z.A5SV6n((int) ((((ARc23Z) aRc23Z.f1304AcNBzu.get(0)).f1299ASJ6gh * ((BChYOn.AZkASS) this.f1318A4TApA).f1256DuwtYk) + 0.5f));
        }
    }
}
