package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ff extends l {
    public ff(a aVar) {
        super(aVar);
    }

    @Override // com.bytedance.embedapplog.l
    public long[] hf() {
        return r.w;
    }

    @Override // com.bytedance.embedapplog.l
    public String u() {
        return "c";
    }

    @Override // com.bytedance.embedapplog.l
    public boolean w() {
        JSONObject xj = this.xj.kd().xj();
        if (this.xj.kd().pl() == 0 || xj == null || this.xj.u().f() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", xj);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject hf = gj.hf(gj.xj(cy.xj(this.xj.hf(), this.xj.kd().xj(), this.xj.f().w(), true, xj.u()), gj.w), jSONObject);
        xj.pl().xj(!no.xj(hf, this.xj.u().c()), hf);
        if (hf == null) {
            return false;
        }
        this.xj.u().xj(hf);
        return true;
    }

    @Override // com.bytedance.embedapplog.l
    public long xj() {
        return this.xj.u().f() + 21600000;
    }
}
