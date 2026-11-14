package com.kwad.sdk.commercial;

import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    public com.kwai.adclient.kscommerciallogger.model.d aAe;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;
    public double azZ = 0.01d;
    public double aAa = 1.0d;
    public double aAb = 0.001d;
    public BusinessType aAc = BusinessType.OTHER;
    public SubBusinessType aAd = SubBusinessType.OTHER;

    private d() {
    }

    public static d FH() {
        return new d();
    }

    public final d O(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final d a(SubBusinessType subBusinessType) {
        this.aAd = subBusinessType;
        return this;
    }

    public final d b(BusinessType businessType) {
        this.aAc = businessType;
        return this;
    }

    public final d cR(String str) {
        this.category = str;
        return this;
    }

    public final d cS(String str) {
        this.tag = str;
        return this;
    }

    public final d i(double d) {
        this.azZ = d;
        return this;
    }

    public final d j(double d) {
        this.aAa = d;
        return this;
    }

    public final d k(double d) {
        this.aAb = 0.001d;
        return this;
    }

    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.aAc + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    public final d z(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final d a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.aAe = dVar;
        return this;
    }

    @Deprecated
    public final d i(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }
}
