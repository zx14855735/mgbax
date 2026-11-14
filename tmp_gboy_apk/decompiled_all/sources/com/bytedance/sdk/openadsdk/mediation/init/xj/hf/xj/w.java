package com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public final PluginValueSet xj;

    public w(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.ADYaiT(sparseArray);
    }

    public String c() {
        return (String) this.xj.objectValue(265006, String.class);
    }

    public String hf() {
        return (String) this.xj.objectValue(265001, String.class);
    }

    public int kd() {
        return this.xj.intValue(265004);
    }

    public String u() {
        return (String) this.xj.objectValue(265003, String.class);
    }

    public String w() {
        return (String) this.xj.objectValue(265002, String.class);
    }

    public Map<String, String> xj() {
        return (Map) this.xj.objectValue(265007, Map.class);
    }

    public String y() {
        return (String) this.xj.objectValue(265005, String.class);
    }
}
