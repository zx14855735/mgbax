package com.bytedance.sdk.openadsdk.core.ra;

import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g {
    private String am;
    private int c;
    private String d;
    private String e;
    private long f;
    private long g;
    private String hf;
    private boolean kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10403pl;
    private String qt;
    private long tf;
    private long u;
    private String w;
    private long xj;
    private int y;
    private String yo;
    private String zg;

    public static g xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.xj = jSONObject.optLong("user_id");
        gVar.hf = jSONObject.optString("coupon_meta_id");
        gVar.w = jSONObject.optString("unique_id");
        gVar.u = jSONObject.optLong("device_id");
        gVar.kd = jSONObject.optBoolean("has_coupon");
        gVar.y = jSONObject.optInt("coupon_scene");
        gVar.c = jSONObject.optInt(PointParamKey.TYPE);
        gVar.f = jSONObject.optLong("threshold");
        gVar.d = jSONObject.optString("scene_key");
        gVar.tf = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        gVar.p = jSONObject.optLong("amount");
        gVar.f10403pl = jSONObject.optInt("action");
        gVar.g = jSONObject.optLong("style");
        gVar.am = jSONObject.optString("start_time");
        gVar.qt = jSONObject.optString("expire_time");
        gVar.zg = jSONObject.optString("button_text");
        gVar.e = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
        gVar.yo = jSONObject.optString("toast");
        return gVar;
    }

    public int getType() {
        return this.c;
    }

    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.xj);
            jSONObject.put("coupon_meta_id", this.hf);
            jSONObject.put("unique_id", this.w);
            jSONObject.put("device_id", this.u);
            jSONObject.put(PointParamKey.TYPE, this.c);
            jSONObject.put("scene_key", this.d);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.tf);
            jSONObject.put("value", this.p);
            jSONObject.put("threshold", this.f);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.e);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public String u() {
        return this.yo;
    }

    public int w() {
        return this.y;
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.xj);
            jSONObject.put("coupon_meta_id", this.hf);
            jSONObject.put("unique_id", this.w);
            jSONObject.put("device_id", this.u);
            jSONObject.put("has_coupon", this.kd);
            jSONObject.put("coupon_scene", this.y);
            jSONObject.put(PointParamKey.TYPE, this.c);
            jSONObject.put("threshold", this.f);
            jSONObject.put("scene_key", this.d);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.tf);
            jSONObject.put("amount", this.p);
            jSONObject.put("action", this.f10403pl);
            jSONObject.put("style", this.g);
            jSONObject.put("start_time", this.am);
            jSONObject.put("expire_time", this.qt);
            jSONObject.put("button_text", this.zg);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.e);
            jSONObject.put("toast", this.yo);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public boolean xj(boolean z) {
        int i;
        boolean z2 = this.kd && this.p > 0;
        return z ? z2 && ((i = this.y) == 0 || i == 5) : z2 && this.y == 5;
    }
}
