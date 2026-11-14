package io.dcloud.openapi.poly.api;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Platform {
    private String aaaaaaa0;
    private String aaaaaaaa;
    private String aaaaaaac;
    private JSONObject aaaaaaae;
    private String aaaaaaan;
    private String aaaaaaao;
    private String aaaaaaau;

    public String getAppid() {
        return this.aaaaaaan;
    }

    public String getEc() {
        return this.aaaaaaac;
    }

    public String getEr() {
        return this.aaaaaaao;
    }

    public JSONObject getRewardJson() {
        return this.aaaaaaae;
    }

    public String getSplash() {
        return this.aaaaaaa0;
    }

    public String getTid() {
        return this.aaaaaaau;
    }

    public String getType() {
        return this.aaaaaaaa;
    }

    public void setPlatJson(JSONObject jSONObject) {
        this.aaaaaaao = jSONObject.optString("er");
        this.aaaaaaac = jSONObject.optString("ec");
        JSONObject optJSONObject = jSONObject.optJSONObject(MediationConstant.RIT_TYPE_SPLASH);
        if (optJSONObject != null) {
            this.aaaaaaa0 = optJSONObject.toString();
            this.aaaaaaau = optJSONObject.optString("tid");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(PointCategory.APP);
            if (optJSONObject2 != null) {
                this.aaaaaaan = optJSONObject2.optString(PluginConstants.KEY_APP_ID);
            }
        }
        this.aaaaaaae = jSONObject.optJSONObject("reward");
    }

    public void setType(String str) {
        this.aaaaaaaa = str;
    }
}
