package com.bytedance.sdk.component.p.xj;

import android.text.TextUtils;
import com.bytedance.sdk.component.p.u.kd;
import com.bytedance.sdk.component.p.u.u;
import com.bytedance.sdk.component.p.u.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements u {
    private JSONObject hf;
    private com.bytedance.sdk.component.p.xj.xj kd;
    private w u;
    private Map<String, Object> w;
    private String xj;
    private int y;

    public static class xj {
        private JSONObject c;
        private String hf;
        private Map<String, Object> kd;
        private JSONObject u;
        private StringBuilder w;
        private int xj = 1;
        private w y;

        public xj(String str) {
            this.hf = str;
        }

        public xj hf(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public xj xj(JSONObject jSONObject) {
            this.u = jSONObject;
            return this;
        }

        public xj xj(Map<String, Object> map) {
            this.kd = map;
            return this;
        }

        public xj xj(w wVar) {
            this.y = wVar;
            return this;
        }

        public hf xj() {
            return new hf(this);
        }
    }

    @Override // com.bytedance.sdk.component.p.u.u
    public kd hf() {
        return new kd() { // from class: com.bytedance.sdk.component.p.xj.hf.1
            @Override // com.bytedance.sdk.component.p.u.kd
            public void hf(com.bytedance.sdk.component.p.xj.xj xjVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.p.w.xj> it = com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(hf.this.xj).hf(xjVar.c(), xjVar.w(), map).iterator();
                while (it.hasNext()) {
                    hf.this.xj(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.p.u.kd
            public void xj(com.bytedance.sdk.component.p.xj.xj xjVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.p.w.xj> it = com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(hf.this.xj).xj(xjVar.c(), xjVar.w(), map).iterator();
                while (it.hasNext()) {
                    hf.this.xj(it.next(), map);
                }
            }
        };
    }

    private hf(xj xjVar) {
        this.y = 1;
        this.y = xjVar.xj;
        if (xjVar.xj == 2) {
            this.kd = new com.bytedance.sdk.component.p.xj.xj(xjVar.w, xjVar.u, (Map<String, Object>) xjVar.kd);
            this.y = 2;
        } else {
            this.xj = xjVar.hf;
            if (xjVar.c != null) {
                com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(xjVar.c);
            }
        }
        this.hf = xjVar.u;
        this.w = xjVar.kd;
        this.u = xjVar.y;
    }

    public void xj() {
        com.bytedance.sdk.component.p.w.w xj2;
        if (this.y == 2) {
            w wVar = this.u;
            if (wVar != null) {
                wVar.xj(this.kd);
            }
            this.kd.y();
            return;
        }
        if (TextUtils.isEmpty(this.xj) || (xj2 = com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(this.xj)) == null) {
            return;
        }
        xj(xj2.xj(), this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.p.w.xj xjVar, Map<String, Object> map) {
        if (xjVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.p.xj.xj xjVar2 = new com.bytedance.sdk.component.p.xj.xj(xjVar, this.hf, map);
        xjVar2.xj(this.xj);
        xjVar2.xj(this);
        w wVar = this.u;
        if (wVar != null) {
            wVar.xj(xjVar2);
        }
        xjVar2.y();
        for (com.bytedance.sdk.component.p.w.xj xjVar3 : com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(this.xj).w(xjVar, xjVar2.w(), map)) {
            if (xjVar3 != null) {
                xj(xjVar3, map);
            }
        }
    }
}
