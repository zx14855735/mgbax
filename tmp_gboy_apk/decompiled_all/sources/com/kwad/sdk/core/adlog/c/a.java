package com.kwad.sdk.core.adlog.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String PI;
    public a.C0353a PJ;
    public long Ql;
    public int UO;
    public int aAV;
    public int aCA;
    public String aCB;
    public int aCC;
    public int aCD;
    public String aCF;
    public int aCG;
    public int aCH;
    public String aCI;
    public String aCJ;
    public int aCK;
    public int aCL;
    public long aCM;
    public long aCN;
    public int aCQ;
    public int aCR;
    public String aCT;
    public int aCV;
    public int aCW;
    public int aCX;
    public int aCY;
    public JSONObject aCl;
    public int aCm;
    public int aCn;
    public int aCo;
    public int aCp;
    public String aCq;
    public String aCu;
    public String aCv;
    public String aCw;
    public int aCx;
    public int aCy;
    public String aDa;
    public AdTemplate adTemplate;
    public int adnMaterialType;
    public String adnMaterialUrl;
    public String adnName;
    public int adnType;
    public int downloadSource;
    public int mH;
    public aj.a mJ;
    public double mK;
    public long yY;
    public long aCr = -1;
    public int aCs = -1;
    public long aCt = -1;
    public int aCz = -1;
    public int PK = 0;
    public String aCE = "";
    public int aCO = -1;
    public int aCP = -1;
    public int downloadStatus = 0;
    public int aCS = -1;
    public int PH = -1;
    public int aCU = -1;
    public int adxResult = -1;
    public int PL = -1;
    public int aCZ = 0;

    public static a Gz() {
        return new a();
    }

    public final a.C0353a GA() {
        return this.PJ;
    }

    public final void a(h hVar) {
        if (hVar != null) {
            this.aDa = hVar.Km();
        }
    }

    public final a au(long j) {
        this.yY = j;
        return this;
    }

    public final a av(long j) {
        this.Ql = j;
        return this;
    }

    public final a dE(String str) {
        this.PI = str;
        return this;
    }

    /* renamed from: do, reason: not valid java name */
    public final void m13do(int i) {
        if (i == 0) {
            this.aCW = 1;
        } else if (i == 1) {
            this.aCW = 2;
        } else {
            if (i != 2) {
                return;
            }
            this.aCW = 3;
        }
    }

    public final a dp(int i) {
        this.mH = i;
        return this;
    }

    public final a dq(int i) {
        this.PK = i;
        return this;
    }

    public final a dr(int i) {
        this.PL = i;
        return this;
    }

    public final a ds(int i) {
        this.PH = i;
        return this;
    }

    public final a dt(int i) {
        this.UO = i;
        return this;
    }

    public final a du(int i) {
        this.aCG = i;
        return this;
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0353a c0353a = this.PJ;
        if (c0353a == null) {
            a.C0353a c0353a2 = new a.C0353a();
            this.PJ = c0353a2;
            c0353a2.a(adTemplate, null, null, null);
        } else if (c0353a.aBN == null) {
            c0353a.a(adTemplate, null, null, null);
        }
    }

    public final a a(a.C0353a c0353a) {
        this.PJ = c0353a;
        return this;
    }

    public final a e(aj.a aVar) {
        this.mJ = aVar;
        return this;
    }
}
