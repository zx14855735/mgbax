package com.kwad.sdk.l.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int bbD;
    public int bbE;
    public int bbF;

    public b(int i, int i2, int i3) {
        this.bbD = i;
        this.bbE = i2;
        this.bbF = i3;
    }

    public static synchronized b QD() {
        synchronized (b.class) {
            if (!((h) ServiceProvider.get(h.class)).Dg()) {
                return null;
            }
            return bh.QD();
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bbD = jSONObject.optInt("cellId", -1);
        bVar.bbE = jSONObject.optInt("lac", -1);
        bVar.bbF = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "cellId", bVar.bbD);
        aa.putValue(jSONObject, "lac", bVar.bbE);
        aa.putValue(jSONObject, "bsss", bVar.bbF);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
