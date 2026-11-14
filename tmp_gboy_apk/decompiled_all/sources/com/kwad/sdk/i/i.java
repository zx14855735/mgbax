package com.kwad.sdk.i;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i implements b {
    public double aAi;
    public String aXV;
    public String aXW;
    public String aXX;
    public long aXY = System.currentTimeMillis();

    public static i Pb() {
        return new i();
    }

    public final i gA(String str) {
        this.aXW = str;
        return this;
    }

    public final i gB(String str) {
        this.aXX = str;
        return this;
    }

    public final i gz(String str) {
        this.aXV = str;
        return this;
    }

    public final i n(double d) {
        this.aAi = d;
        return this;
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, com.sigmob.sdk.base.n.C, Double.valueOf(this.aAi));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.o(this.aAi)));
        c.putValue(jSONObject, "log_build_time_ms", this.aXY);
        c.putValue(jSONObject, "log_level", this.aXV);
        c.putValue(jSONObject, "log_tag", this.aXW);
        c.putValue(jSONObject, "log_content", this.aXX);
        return jSONObject;
    }
}
