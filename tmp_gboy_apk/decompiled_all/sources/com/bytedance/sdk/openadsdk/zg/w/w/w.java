package com.bytedance.sdk.openadsdk.zg.w.w;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public PluginValueSet xj;

    public static class xj {
        private final com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();

        public xj hf(double d) {
            this.xj.xj(262002, Double.valueOf(d));
            return this;
        }

        public xj xj(double d) {
            this.xj.xj(262001, Double.valueOf(d));
            return this;
        }

        public w xj() {
            return new w(this.xj.hf());
        }
    }

    public w(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.ADYaiT(sparseArray);
    }

    public double hf() {
        return this.xj.doubleValue(262002);
    }

    public double xj() {
        return this.xj.doubleValue(262001);
    }
}
