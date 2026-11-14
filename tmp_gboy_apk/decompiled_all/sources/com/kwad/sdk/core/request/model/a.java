package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aML;
    private String aMM;
    private String appId;
    private String name;
    private String packageName;
    private String version;
    private int versionCode;

    public static JSONObject KA() {
        if (!m(aML)) {
            aML = KB().toJson();
        }
        return aML;
    }

    public static a KB() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.getSDKConfig().appId;
            aVar.name = ServiceProvider.getSDKConfig().appName;
            aVar.packageName = ServiceProvider.Re().getPackageName();
            aVar.version = m.cN(ServiceProvider.Re());
            aVar.versionCode = m.cP(ServiceProvider.Re());
            aVar.aMM = com.kwad.sdk.utils.f.cB(ServiceProvider.Re());
            if (!TextUtils.isEmpty(bs.getAppId())) {
                aVar.appId = bs.getAppId();
            }
            if (!TextUtils.isEmpty(bs.getPackageName())) {
                aVar.packageName = bs.getPackageName();
                return aVar;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(MedProConst.AD_APPID);
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(ServiceProvider.getSDKConfig().appId) && optString2.equals(ServiceProvider.getSDKConfig().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, MedProConst.AD_APPID, this.appId);
        aa.putValue(jSONObject, "name", this.name);
        aa.putValue(jSONObject, "packageName", this.packageName);
        aa.putValue(jSONObject, "version", this.version);
        aa.putValue(jSONObject, "versionCode", this.versionCode);
        aa.putValue(jSONObject, "sha1", this.aMM);
        return jSONObject;
    }
}
