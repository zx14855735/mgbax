package com.kwad.components.ad.adbit;

import com.kwad.sdk.utils.aa;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public JSONObject bB;
    public Map<String, String> bC;

    public a(JSONObject jSONObject, Map<String, String> map) {
        this.bB = jSONObject;
        this.bC = map;
    }

    public final String O() {
        for (String str : this.bC.keySet()) {
            aa.putValue(this.bB, str, this.bC.get(str));
        }
        return this.bB.toString();
    }
}
