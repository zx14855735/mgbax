package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa;

import android.text.TextUtils;
import com.sigmob.sdk.base.n;
import io.dcloud.openapi.poly.api.Platform;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa {
    private String aaaaaaa0;
    private String aaaaaaaa;
    private JSONArray aaaaaaac = new JSONArray();
    private String aaaaaaae;
    private String aaaaaaan;
    private JSONObject aaaaaaao;
    private Platform aaaaaaau;

    public String aaaaaaa0() {
        return this.aaaaaaa0;
    }

    public String aaaaaaaa() {
        return this.aaaaaaaa;
    }

    public String aaaaaaac() {
        return this.aaaaaaae;
    }

    public boolean aaaaaaae() {
        return !TextUtils.isEmpty(this.aaaaaaae);
    }

    public Platform aaaaaaan() {
        return this.aaaaaaau;
    }

    public void aaaaaaao(String str) {
        this.aaaaaaan = str;
    }

    public JSONObject aaaaaaau() {
        return this.aaaaaaao;
    }

    public void aaaaaaa0(String str) {
        this.aaaaaaa0 = str;
    }

    public void aaaaaaaa(String str) {
        this.aaaaaaaa = str;
    }

    public String aaaaaaao() {
        return this.aaaaaaan;
    }

    public void aaaaaaaa(Platform platform) {
        this.aaaaaaau = platform;
    }

    public boolean aaaaaaaa(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        this.aaaaaaaa = jSONObject.optString("appid");
        this.aaaaaaac = jSONObject.optJSONArray("appidh");
        this.aaaaaaa0 = jSONObject.optString("appkey");
        this.aaaaaaao = jSONObject.optJSONObject(n.m);
        this.aaaaaaae = jSONObject.optString("ada");
        try {
            if (this.aaaaaaao != null) {
                if (aaaaaaae()) {
                    this.aaaaaaao.put("appid", this.aaaaaaaa);
                } else {
                    if (this.aaaaaaau == null) {
                        this.aaaaaaau = new Platform();
                    }
                    this.aaaaaaau.setType(this.aaaaaaan);
                    this.aaaaaaau.setPlatJson(this.aaaaaaao);
                    return true;
                }
            } else {
                if (!aaaaaaae()) {
                    return true;
                }
                JSONObject jSONObject2 = new JSONObject();
                this.aaaaaaao = jSONObject2;
                jSONObject2.put("appid", this.aaaaaaaa);
            }
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }
}
