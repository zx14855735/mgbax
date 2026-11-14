package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.aj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private final a aDb = new a();

    public final a GB() {
        return this.aDb;
    }

    public final b aw(long j) {
        this.aDb.yY = j;
        return this;
    }

    public final b b(a.C0353a c0353a) {
        this.aDb.PJ = c0353a;
        return this;
    }

    public final b dA(int i) {
        this.aDb.aCK = i;
        return this;
    }

    public final b dB(int i) {
        this.aDb.aCL = i;
        return this;
    }

    public final b dC(int i) {
        this.aDb.aCz = i;
        return this;
    }

    public final b dD(int i) {
        this.aDb.aCR = i;
        return this;
    }

    public final b dE(int i) {
        this.aDb.aCV = i;
        return this;
    }

    public final b dF(String str) {
        this.aDb.PI = str;
        return this;
    }

    public final b dG(String str) {
        this.aDb.aCI = str;
        return this;
    }

    public final b dH(String str) {
        this.aDb.aCJ = str;
        return this;
    }

    public final b dI(String str) {
        this.aDb.aCT = str;
        return this;
    }

    public final b dJ(int i) {
        this.aDb.PK = i;
        return this;
    }

    public final b dv(int i) {
        this.aDb.mH = i;
        return this;
    }

    public final b dw(int i) {
        this.aDb.aCo = i;
        return this;
    }

    public final b dx(int i) {
        this.aDb.aCp = i;
        return this;
    }

    public final b dy(int i) {
        this.aDb.downloadSource = i;
        return this;
    }

    public final b dz(int i) {
        this.aDb.aCH = i;
        return this;
    }

    public final b f(aj.a aVar) {
        this.aDb.mJ = aVar;
        return this;
    }

    public final b l(double d) {
        this.aDb.mK = d;
        return this;
    }

    public final b x(int i, int i2) {
        this.aDb.aCq = i + "," + i2;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        a aVar2 = this.aDb;
        if (aVar2.PJ == null) {
            aVar2.PJ = new a.C0353a();
        }
        this.aDb.PJ.a(adTemplate, str, str2, aVar);
        return this;
    }

    public final b dF(int i) {
        this.aDb.m13do(i);
        return this;
    }

    public final b dG(int i) {
        this.aDb.aCX = i;
        return this;
    }

    public final b dH(int i) {
        this.aDb.PL = i;
        return this;
    }

    public final b dI(int i) {
        this.aDb.aCZ = i;
        return this;
    }
}
