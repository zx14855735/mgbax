package com.kwad.components.offline.api.core.model;

import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BaseOfflineCompoJsonParse<T extends IOfflineCompoJsonParse> implements IOfflineCompoJsonParse {
    public abstract void parseJson(T t, JSONObject jSONObject);

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public void parseJson(JSONObject jSONObject) {
        parseJson(this, jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public JSONObject toJson() {
        return toJson(this);
    }

    public abstract JSONObject toJson(T t);

    public abstract JSONObject toJson(T t, JSONObject jSONObject);
}
