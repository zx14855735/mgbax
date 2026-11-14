package com.bytedance.sdk.openadsdk.core.ugeno;

import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.p.xj.hf;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends com.bytedance.adsdk.ugeno.w.xj.hf {
    private volatile xj y;

    public class xj implements com.bytedance.sdk.component.p.u.hf {
        private yo.hf u;
        private zg w;
        yo.xj xj;

        public xj() {
        }

        public void xj(zg zgVar) {
            this.w = zgVar;
        }

        public void xj(yo.hf hfVar) {
            this.u = hfVar;
        }

        public void xj(yo.xj xjVar) {
            this.xj = xjVar;
        }

        @Override // com.bytedance.sdk.component.p.u.hf
        public void xj() {
            d.this.hf(this.w, this.u, this.xj);
        }
    }

    public d(yo yoVar) {
        super(yoVar);
    }

    private xj hf() {
        if (this.y != null) {
            return this.y;
        }
        synchronized (xj.class) {
            try {
                if (this.y != null) {
                    return this.y;
                }
                this.y = new xj();
                return this.y;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.xj.hf
    public void w(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        if (this.y == null) {
            this.y = hf();
        }
        this.y.xj(zgVar);
        this.y.xj(hfVar);
        this.y.xj(xjVar);
        JSONObject w = zgVar.w();
        if (w == null) {
            return;
        }
        new hf.xj(w.optString(PointParamKey.TYPE)).hf(this.u).xj(new com.bytedance.sdk.component.p.u.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.1
            @Override // com.bytedance.sdk.component.p.u.w
            public void xj(com.bytedance.sdk.component.p.xj.xj xjVar2) {
                d.this.xj(xjVar2);
            }
        }).xj().xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (this.kd) {
            return;
        }
        xj hf = hf();
        hf.xj(xj(hf.w, xjVar));
        xjVar.xj(hf);
    }

    public zg xj(zg zgVar, com.bytedance.sdk.component.p.xj.xj xjVar) {
        com.bytedance.sdk.component.p.w.xj xjVar2;
        if (zgVar == null || xjVar == null) {
            return zgVar;
        }
        zg zgVar2 = new zg();
        com.bytedance.adsdk.ugeno.hf.w xj2 = zgVar.xj();
        if (xj2 == null) {
            return zgVar;
        }
        zgVar2.xj(zgVar.hf());
        com.bytedance.sdk.component.p.w.xj c = xjVar.c();
        JSONObject xj3 = xj(xj2, zgVar2, c);
        com.bytedance.sdk.component.p.w.w xj4 = com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(xjVar.u());
        List<com.bytedance.sdk.component.p.w.xj> xj5 = xj4.xj(c, xj2.tf(), new HashMap());
        zgVar2.xj(xj3);
        if (!xj5.isEmpty()) {
            com.bytedance.sdk.component.p.w.xj xjVar3 = xj5.get(0);
            if (xjVar3 != null) {
                zg zgVar3 = new zg();
                zgVar3.xj(xj(xj2, zgVar3, xjVar3));
                zgVar3.xj(xj2);
                zgVar2.xj(zgVar3);
            }
            return zgVar2;
        }
        List<com.bytedance.sdk.component.p.w.xj> hf = xj4.hf(c, xj2.tf(), new HashMap());
        if (!hf.isEmpty() && (xjVar2 = hf.get(0)) != null) {
            zg zgVar4 = new zg();
            zgVar4.xj(xj(xj2, zgVar4, xjVar2));
            zgVar4.xj(xj2);
            zgVar2.hf(zgVar4);
        }
        return zgVar2;
    }

    private JSONObject xj(com.bytedance.adsdk.ugeno.hf.w wVar, zg zgVar, com.bytedance.sdk.component.p.w.xj xjVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (xjVar != null) {
                Map<String, String> w = xjVar.w();
                String xj2 = xjVar.xj();
                zgVar.xj(wVar);
                jSONObject.put(PointParamKey.TYPE, xj2);
                if (w != null && !w.isEmpty()) {
                    for (Map.Entry<String, String> entry : w.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
