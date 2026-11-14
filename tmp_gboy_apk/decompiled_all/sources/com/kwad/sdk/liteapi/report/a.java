package com.kwad.sdk.liteapi.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.liteapi.InputParamHolder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class a {
    private String appId;
    private String name;
    private String packageName;
    private String version;

    public static a cp(Context context) {
        a aVar = new a();
        SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
        if (sDKConfig != null) {
            aVar.appId = sDKConfig.appId;
            aVar.name = sDKConfig.appName;
        }
        aVar.packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64);
            if (packageInfo != null) {
                aVar.version = packageInfo.versionName;
                return aVar;
            }
        } catch (Exception e) {
            LiteApiLogger.printStackTraceOnly(e);
        }
        return aVar;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MedProConst.AD_APPID, this.appId);
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("packageName", this.packageName);
            jSONObject.putOpt("version", this.version);
            return jSONObject;
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
            return jSONObject;
        }
    }
}
