package com.kwad.sdk.i;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class d implements b {
    public List<e> aXy;
    public long intervalTime;

    public final long OL() {
        long j = this.intervalTime;
        return j > 0 ? j : PushUIConfig.dismissTime;
    }

    public final void parseJson(JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aXy = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i));
                this.aXy.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
