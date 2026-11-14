package com.bytedance.adsdk.ugeno.xj.xj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    protected com.bytedance.adsdk.ugeno.hf.w hf;
    private String w;
    protected JSONObject xj;

    /* renamed from: com.bytedance.adsdk.ugeno.xj.xj.xj$xj, reason: collision with other inner class name */
    public static class C0034xj {
        public static xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
            if (wVar == null || jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString(PointParamKey.TYPE);
            optString.getClass();
            switch (optString) {
                case "stretch":
                    return new kd(wVar, jSONObject);
                case "ripple":
                    return new hf(wVar, jSONObject);
                case "rub_in":
                    return new w(wVar, jSONObject);
                case "shine":
                    return new u(wVar, jSONObject);
                default:
                    return null;
            }
        }
    }

    public xj(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        this.xj = jSONObject;
        this.hf = wVar;
        xj();
    }

    public abstract void hf();

    public String u() {
        return this.w;
    }

    public abstract List<PropertyValuesHolder> w();

    public void xj() {
        this.w = this.xj.optString(PointParamKey.TYPE);
        hf();
    }

    public abstract void xj(int i, int i2);

    public abstract void xj(Canvas canvas);
}
