package com.kwad.sdk.core.scene;

import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class EntryPackage extends URLPackage {
    private static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString("entryId");
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "entryPageSource", this.entryPageSource);
        aa.putValue(json, "entryId", this.entryId);
        return json;
    }

    public EntryPackage(String str, int i) {
        super(str, i);
        this.entryPageSource = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
    }
}
