package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaao {
    private String aaaaaaa0;
    private String aaaaaaac;
    private int aaaaaaae;
    private int aaaaaaan;
    private String aaaaaaao;
    private String aaaaaaau;
    private String aaaaaaav;
    private String aaaaaaea;
    private JSONObject aaaaaaeo;
    private int aaaaeaaa;
    private String eaaaaaaa;
    private long aaaaaaaa = 0;
    private boolean aaaeaaaa = true;
    private boolean aaaaaeaa = false;

    public aaaaaaao aaaaaaa0(int i) {
        this.aaaaaaan = i;
        return this;
    }

    public aaaaaaao aaaaaaaa(long j) {
        this.aaaaaaaa = j;
        return this;
    }

    public aaaaaaao aaaaaaac(String str) {
        this.aaaaaaa0 = str;
        return this;
    }

    public JSONObject aaaaaaae() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", this.aaaaaaaa);
            jSONObject.put("ret", this.aaaaaaan);
            if (this.aaaaaaan == 0) {
                jSONObject.put("errMsg", this.aaaaaaeo);
            }
            jSONObject.put("tid", this.aaaaaaau);
            jSONObject.put("mediaId", this.aaaaaaao);
            jSONObject.put("slotId", this.aaaaaaac);
            jSONObject.put("provider", this.aaaaaaa0);
            jSONObject.put("level", this.aaaaeaaa);
            if (this.aaaaaeaa) {
                jSONObject.put("use", 1);
            }
            if (!TextUtils.isEmpty(this.aaaaaaea)) {
                jSONObject.put("cav", this.aaaaaaea);
            }
            if (!TextUtils.isEmpty(this.eaaaaaaa)) {
                jSONObject.put("csv", this.eaaaaaaa);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public aaaaaaao aaaaaaan(String str) {
        this.aaaaaaau = str;
        return this;
    }

    public aaaaaaao aaaaaaao(String str) {
        this.aaaaaaao = str;
        return this;
    }

    public aaaaaaao aaaaaaau(String str) {
        this.aaaaaaac = str;
        return this;
    }

    public String toString() {
        return aaaaaaae().toString();
    }

    public aaaaaaao aaaaaaa0(String str) {
        this.eaaaaaaa = str;
        return this;
    }

    public aaaaaaao aaaaaaaa(int i) {
        this.aaaaeaaa = i;
        return this;
    }

    public int aaaaaaac() {
        return this.aaaaaaan;
    }

    public void aaaaaaan() {
        this.aaaaaeaa = true;
    }

    public String aaaaaaao() {
        return this.aaaaaaac;
    }

    public boolean aaaaaaau() {
        return this.aaaeaaaa;
    }

    public JSONObject aaaaaaa0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(t.b, this.aaaaaaa0);
            jSONObject.put(f.f13353a, this.aaaaaaac);
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, this.aaaaaaae);
            jSONObject.put(br.c, this.aaaaaaav);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public aaaaaaao aaaaaaaa(String str) {
        this.aaaaaaea = str;
        return this;
    }

    public aaaaaaao aaaaaaaa(int i, String str) {
        this.aaaeaaaa = i != -9999;
        this.aaaaaaae = i;
        this.aaaaaaav = str;
        JSONObject jSONObject = new JSONObject();
        this.aaaaaaeo = jSONObject;
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            this.aaaaaaeo.put(br.c, str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public int aaaaaaaa() {
        return this.aaaaaaae;
    }
}
