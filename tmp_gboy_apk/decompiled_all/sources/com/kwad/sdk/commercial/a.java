package com.kwad.sdk.commercial;

import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends com.kwad.sdk.core.response.a.a {
    public double azF;
    public List<f> azG;
    public String minVersion;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.azF = jSONObject.optDouble("default_ratio", 0.0d);
        this.minVersion = jSONObject.optString("min_version", "");
        List<JSONObject> h = aa.h(jSONObject.optJSONArray("rule_set"));
        if (h != null) {
            this.azG = new ArrayList();
            for (JSONObject jSONObject2 : h) {
                f fVar = new f();
                fVar.parseJson(jSONObject2);
                this.azG.add(fVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "default_ratio", this.azF);
        aa.putValue(jSONObject, "min_version", this.minVersion);
        aa.putValue(jSONObject, "rule_set", this.azG);
        afterToJson(jSONObject);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public final String toString() {
        return "RefineConfRatio{defaultRatio=" + this.azF + ", minVersion='" + this.minVersion + "', ruleSet=" + this.azG + '}';
    }
}
