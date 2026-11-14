package com.bytedance.msdk.core.tf;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private com.bytedance.msdk.api.u.xj.hf.w.hf u;
    private String w;
    private String xj;

    public xj(String str, String str2, String str3) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = new com.bytedance.msdk.api.u.xj.hf.w.hf();
    }

    public String hf() {
        return this.hf;
    }

    public boolean kd() {
        com.bytedance.msdk.api.u.xj.hf.w.hf hfVar = this.u;
        return hfVar != null && hfVar.u();
    }

    public String toString() {
        return "AdNetworkConfValue{mAdnName='" + this.xj + "'mAppId='" + this.hf + "', mAppKey='" + this.w + "', mGMCustomConfig=" + this.u + '}';
    }

    public com.bytedance.msdk.api.u.xj.hf.w.hf u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        com.bytedance.msdk.api.u.xj.hf.w.hf hfVar = this.u;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }

    public static xj xj(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(PluginConstants.KEY_APP_ID);
        String optString2 = jSONObject.optString("app_key");
        String optString3 = jSONObject.optString("custom_type");
        return !TextUtils.equals(optString3, "1") ? new xj(str, optString, optString2) : new xj(str, optString, optString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), optString3);
    }

    public xj(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = new com.bytedance.msdk.api.u.xj.hf.w.hf(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }
}
