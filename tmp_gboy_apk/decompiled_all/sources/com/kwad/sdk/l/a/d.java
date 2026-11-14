package com.kwad.sdk.l.a;

import android.content.Context;
import android.provider.Settings;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int bbG = 0;
    public int bbH = 0;
    public int bbI = 0;
    public int bbJ = 0;
    public int bbK = 0;
    public int bbL = 0;
    public int bbM = 0;

    public d(Context context) {
        if (context != null) {
            try {
                ca(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bbG = jSONObject.optInt("isRoot");
        dVar.bbH = jSONObject.optInt("isXPosed");
        dVar.bbI = jSONObject.optInt("isFrameworkHooked");
        dVar.bbJ = jSONObject.optInt("isVirtual");
        dVar.bbK = jSONObject.optInt("isAdbEnabled");
        dVar.bbL = jSONObject.optInt("isEmulator");
        dVar.bbM = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "isRoot", dVar.bbG);
        aa.putValue(jSONObject, "isXPosed", dVar.bbH);
        aa.putValue(jSONObject, "isFrameworkHooked", dVar.bbI);
        aa.putValue(jSONObject, "isVirtual", dVar.bbJ);
        aa.putValue(jSONObject, "isAdbEnabled", dVar.bbK);
        aa.putValue(jSONObject, "isEmulator", dVar.bbL);
        aa.putValue(jSONObject, "isGroupControl", dVar.bbM);
        return jSONObject;
    }

    private void ca(boolean z) {
        this.bbK = cd(z);
    }

    private static int cd(boolean z) {
        return z ? 1 : 2;
    }

    public final void bX(boolean z) {
        this.bbG = cd(z);
    }

    public final void bY(boolean z) {
        this.bbH = cd(z);
    }

    public final void bZ(boolean z) {
        this.bbI = cd(z);
    }

    public final void cb(boolean z) {
        this.bbL = cd(z);
    }

    public final void cc(boolean z) {
        this.bbM = cd(z);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
