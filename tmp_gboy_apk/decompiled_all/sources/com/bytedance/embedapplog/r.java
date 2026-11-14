package com.bytedance.embedapplog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class r extends l {
    private boolean kd;
    static final long[] hf = {920000};
    static final long[] w = {920000};
    private static final long[] u = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    public r(a aVar) {
        super(aVar);
        this.kd = true;
    }

    @Override // com.bytedance.embedapplog.l
    public long[] hf() {
        int pl2 = this.xj.kd().pl();
        if (pl2 == 0) {
            return u;
        }
        if (pl2 == 1) {
            return w;
        }
        if (pl2 == 2) {
            return hf;
        }
        cu.hf((Throwable) null);
        return w;
    }

    @Override // com.bytedance.embedapplog.l
    public String u() {
        return com.kuaishou.weapon.p0.t.k;
    }

    @Override // com.bytedance.embedapplog.l
    public boolean w() {
        JSONObject xj;
        JSONObject jSONObject = new JSONObject();
        aq kd = this.xj.kd();
        JSONObject xj2 = kd.xj();
        if (xj2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (kd) {
                xj = no.xj(xj2);
            }
            jSONObject.put("header", xj);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(xj.optString("device_id")) && no.u() && this.kd) {
                this.kd = false;
                return false;
            }
            JSONObject xj3 = this.xj.kd().xj();
            JSONObject xj4 = gj.xj(cy.xj(this.xj.hf(), xj3, this.xj.f().xj(), true, xj.u()), jSONObject);
            if (xj4 != null) {
                String optString = xj4.optString("device_id", "");
                boolean xj5 = this.xj.kd().xj(xj4, optString, xj4.optString("install_id", ""), xj4.optString("ssid", ""));
                v.hf("__kite", "start:" + no.y());
                try {
                    if (no.y()) {
                        new ai(this.xj.hf()).xj(xj3, optString);
                        return xj5;
                    }
                } catch (Throwable th) {
                    v.xj("__kite", "error:" + no.y(), th);
                }
                return xj5;
            }
        } else {
            cu.hf((Throwable) null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.l
    public long xj() {
        return this.xj.kd().g() + (this.xj.c().w() ? 21600000 : 43200000);
    }
}
