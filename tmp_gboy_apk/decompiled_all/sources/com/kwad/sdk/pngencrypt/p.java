package com.kwad.sdk.pngencrypt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class p {
    public final e aYY;
    int aZE;
    int aZH;
    int aZI;
    int aZJ;
    int aZK;
    public final k aZU;
    int baA;
    int baB;
    int baC;
    int baD;
    public final boolean baw;
    int bax;
    int bay;
    int baz;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.aZU = kVar;
        this.aYY = eVar;
        this.baw = eVar != null;
    }

    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.baD = i;
    }

    public final void update(int i) {
        this.bax = i;
        if (!this.baw) {
            this.aZE = 1;
            this.aZH = 1;
            this.aZI = 1;
            this.aZJ = 0;
            this.aZK = 0;
            this.baz = i;
            this.bay = i;
            k kVar = this.aZU;
            this.baA = kVar.aZF;
            this.baB = kVar.aZG;
            this.baC = kVar.bag;
            return;
        }
        this.aZE = this.aYY.PZ();
        e eVar = this.aYY;
        this.aZI = eVar.aZI;
        this.aZH = eVar.aZH;
        this.aZK = eVar.aZK;
        this.aZJ = eVar.aZJ;
        this.bay = eVar.PY();
        this.baz = this.aYY.PX();
        this.baA = this.aYY.Qa();
        int Qb = this.aYY.Qb();
        this.baB = Qb;
        this.baC = ((this.aZU.bae * Qb) + 7) / 8;
    }
}
