package com.bytedance.adsdk.ugeno.w.xj;

import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf implements yo {
    protected String hf;
    protected JSONObject u;
    protected yo xj;
    protected boolean w = true;
    protected boolean kd = false;

    public hf(yo yoVar) {
        this.xj = yoVar;
    }

    public void hf(boolean z) {
        this.kd = z;
    }

    public abstract void w(zg zgVar, yo.hf hfVar, yo.xj xjVar);

    public void xj(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public void hf(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        yo yoVar = this.xj;
        if (yoVar == null) {
            return;
        }
        yoVar.xj(zgVar, hfVar, xjVar);
    }

    public void xj(String str) {
        this.hf = str;
    }

    public void xj(boolean z) {
        this.w = z;
    }

    public boolean xj() {
        String str;
        return this.w && (str = this.hf) != null && "3".compareTo(str) <= 0 && this.u != null;
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        if (xj()) {
            w(zgVar, hfVar, xjVar);
        } else {
            hf(zgVar, hfVar, xjVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(w wVar, String str, y.xj xjVar) {
        yo yoVar = this.xj;
        if (yoVar == null) {
            return;
        }
        yoVar.xj(wVar, str, xjVar);
    }
}
