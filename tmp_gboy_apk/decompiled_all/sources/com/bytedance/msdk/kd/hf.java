package com.bytedance.msdk.kd;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile hf xj;
    private List<xj> hf = new CopyOnWriteArrayList();

    public static class xj {
        private JSONObject hf;
        private u xj;

        public xj(u uVar, JSONObject jSONObject) {
            this.xj = uVar;
            this.hf = jSONObject;
        }

        public JSONObject hf() {
            return this.hf;
        }

        public u xj() {
            return this.xj;
        }
    }

    private hf() {
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public List<xj> hf() {
        return this.hf;
    }

    public void w() {
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 清空埋点辅助模块");
        List<xj> list = this.hf;
        if (list != null) {
            list.clear();
        }
    }

    public void xj(u uVar, JSONObject jSONObject) {
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 保存到埋点辅助模块");
        this.hf.add(new xj(uVar, jSONObject));
    }
}
