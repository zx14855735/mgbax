package com.bytedance.embedapplog;

import com.sigmob.sdk.nativead.ab;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class en extends l {
    private long hf;

    public en(a aVar) {
        super(aVar);
    }

    @Override // com.bytedance.embedapplog.l
    public long[] hf() {
        return r.w;
    }

    @Override // com.bytedance.embedapplog.l
    public String u() {
        return ab.f13593a;
    }

    @Override // com.bytedance.embedapplog.l
    public boolean w() {
        JSONObject xj = this.xj.kd().xj();
        if (this.xj.kd().pl() == 0 || xj == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.xj.kd().xj());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject w = gj.w(gj.xj(cy.xj(this.xj.hf(), this.xj.kd().xj(), this.xj.f().u(), true, xj.u()), gj.w), jSONObject);
        if (w == null) {
            return false;
        }
        xj.pl().hf(!no.xj(xj.y(), w), w);
        if (cu.hf) {
            cu.xj("getAbConfig ".concat(String.valueOf(w)), null);
        }
        this.xj.kd().xj(w);
        this.hf = currentTimeMillis;
        return true;
    }

    @Override // com.bytedance.embedapplog.l
    public long xj() {
        long v = this.xj.u().v();
        if (v < 600000) {
            v = 600000;
        }
        return this.hf + v;
    }
}
