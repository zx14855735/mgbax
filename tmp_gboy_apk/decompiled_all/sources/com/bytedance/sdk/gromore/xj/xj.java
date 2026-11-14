package com.bytedance.sdk.gromore.xj;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.w;
import com.bytedance.sdk.openadsdk.mediation.hf.hf.hf;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private PluginValueSet xj;

    public xj(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.ADYaiT(sparseArray);
        this.hf = new com.bytedance.sdk.openadsdk.mediation.hf.hf.xj(sparseArray);
    }

    public w c() {
        if (y() != null) {
            return y().g();
        }
        return null;
    }

    public int d() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet.intValue(3);
        }
        return 0;
    }

    public Function<SparseArray<Object>, Object> f() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return com.bytedance.sdk.openadsdk.ai.w.xj(pluginValueSet.objectValue(8302, Object.class));
        }
        return null;
    }

    public int hf() {
        return this.hf.c();
    }

    public String kd() {
        return this.hf.u();
    }

    public float u() {
        return this.hf.d();
    }

    public float w() {
        return this.hf.f();
    }

    public int xj() {
        return this.hf.y();
    }

    public hf y() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.ai();
        }
        return null;
    }
}
