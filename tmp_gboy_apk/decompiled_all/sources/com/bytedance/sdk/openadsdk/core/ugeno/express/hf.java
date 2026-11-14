package com.bytedance.sdk.openadsdk.core.ugeno.express;

import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.sdk.component.adexpress.hf.g;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends g {
    private ht hf;
    private boolean kd;
    private float u;
    private float w;
    private JSONObject xj;

    public static class xj extends g.xj {
        private ht hf;
        private boolean kd;
        private float u;
        private float w;
        private JSONObject xj;

        public xj hf(float f) {
            this.u = f;
            return this;
        }

        public xj kd(JSONObject jSONObject) {
            this.xj = jSONObject;
            return this;
        }

        public xj u(boolean z) {
            this.kd = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.hf.g.xj
        /* renamed from: hf, reason: merged with bridge method [inline-methods] */
        public hf xj() {
            return new hf(this);
        }

        public xj xj(ht htVar) {
            this.hf = htVar;
            return this;
        }

        public xj xj(float f) {
            this.w = f;
            return this;
        }
    }

    public hf(xj xjVar) {
        super(xjVar);
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
    }

    public JSONObject en() {
        return this.xj;
    }

    public boolean ff() {
        return this.kd;
    }

    public float j() {
        return this.u;
    }

    public ht l() {
        return this.hf;
    }

    public float z() {
        return this.w;
    }
}
