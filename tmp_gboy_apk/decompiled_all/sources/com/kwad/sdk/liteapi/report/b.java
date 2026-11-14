package com.kwad.sdk.liteapi.report;

import android.os.Build;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class b {
    public String Mh;
    public String Mi;
    public String Mj;
    public String aGX;
    public String aMX;
    public int ahe;
    public int ahg;
    public String ahh;

    public static b OK() {
        b bVar = new b();
        try {
            bVar.aGX = LiteOAIDHelper.obtainCurrent();
            bVar.ahg = Build.VERSION.SDK_INT;
            bVar.Mj = Build.VERSION.RELEASE;
            bVar.ahe = 1;
            bVar.ahh = Locale.getDefault().getLanguage();
            bVar.aMX = Build.MANUFACTURER;
            bVar.Mh = Build.MODEL;
            bVar.Mi = Build.BRAND;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", this.aGX);
            return jSONObject;
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
            return jSONObject;
        }
    }
}
