package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 {
    private int aaaaaaa0;
    private String aaaaaaaa;
    private int aaaaaaac;
    private int aaaaaaao;
    private List aaaaaaau;
    private int aaaaaaan = 0;
    private boolean aaaaaaae = false;
    private int aaaaaaav = 1;
    private final List aaaaaaeo = new ArrayList();

    public int aaaaaaa0() {
        return this.aaaaaaan;
    }

    public aaaaaaa0 aaaaaaaa(JSONObject jSONObject, int i) {
        this.aaaaaaaa = jSONObject.optString("adpid");
        this.aaaaaaa0 = jSONObject.optInt(PointParamKey.TYPE, -1);
        int optInt = jSONObject.optInt("tto", 18000);
        this.aaaaaaao = optInt;
        if (optInt < 1000) {
            this.aaaaaaao = 18000;
        }
        int optInt2 = jSONObject.optInt("dsto", 5000);
        this.aaaaaaac = optInt2;
        if (optInt2 < 1000) {
            this.aaaaaaac = 5000;
        }
        this.aaaaaaan = jSONObject.optInt("sr", 0);
        this.aaaaaaae = jSONObject.optInt("ord", 0) == 1;
        int optInt3 = jSONObject.optInt("ft", 1);
        this.aaaaaaav = jSONObject.optInt("mt", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("cfgs");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            if (this.aaaaaaau == null) {
                this.aaaaaaau = new ArrayList();
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    int optInt4 = optJSONObject.has("sto") ? optJSONObject.optInt("sto", 5000) : this.aaaaaaac;
                    if (optInt4 < 1000) {
                        optInt4 = 5000;
                    }
                    aaaaaaac aaaaaaaa = new aaaaaaac.aaaaaaa0().aaaaaaac(optJSONObject.optString("sid")).aaaaaaao(optJSONObject.optInt("cpm", -1)).aaaaaaao(optJSONObject.optInt("bdt", 0) == 1).aaaaaaan(optJSONObject.optInt("level", -1)).aaaaaaae(optJSONObject.optInt(t.m, -1)).aaaaaaao(optJSONObject.optString(t.b)).aaaaaaeo(optJSONObject.optInt("ss", -1)).aaaeaaaa(optInt4).aaaaeaaa(optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH, -1)).aaaaaaac(optInt3).aaaaaaa0(this.aaaaaaa0).aaaaaaaa(optJSONObject.optString("mrt")).aaaaaaa0(optJSONObject.optString("path")).aaaaaaav(optJSONObject.optInt("mt", -1)).aaaaaaaa(optJSONObject.optInt(PointCategory.END, 0) == 1).aaaaaaaa(optJSONObject.optJSONObject("params")).aaaaaaaa(optJSONObject.optInt("acpt", 0)).aaaaaaau(this.aaaaaaav).aaaaaaa0(this.aaaaaaa0 != 5).aaaaaaaa();
                    if (!aaaaaaaa.aaaaaeaa().equals(Const.TYPE_HW) || i != 3) {
                        this.aaaaaaeo.add(aaaaaaaa.aaaaaeaa());
                        this.aaaaaaau.add(aaaaaaaa);
                    }
                }
            }
        }
        return this;
    }

    public int aaaaaaac() {
        return this.aaaaaaao;
    }

    public boolean aaaaaaan() {
        return this.aaaaaaae;
    }

    public List aaaaaaao() {
        return this.aaaaaaau;
    }

    public int aaaaaaau() {
        return this.aaaaaaa0;
    }

    public String aaaaaaaa() {
        return this.aaaaaaaa;
    }
}
