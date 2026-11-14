package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class o extends s {
    private JSONObject aHb;

    public o(String str) {
        this(str, "{}");
    }

    public final int dN(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.aHb) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private o(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue((o) str);
        try {
            this.aHb = new JSONObject(getValue());
        } catch (NullPointerException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
        }
    }
}
