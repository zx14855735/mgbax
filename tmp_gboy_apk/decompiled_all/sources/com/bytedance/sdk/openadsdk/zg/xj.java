package com.bytedance.sdk.openadsdk.zg;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private int hf;
    private PluginValueSet u;
    private String w;
    private boolean xj;

    public xj(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            this.xj = ADYaiT2.booleanValue(-999903, false);
            this.hf = ADYaiT2.intValue(-999900, 0);
            this.w = ADYaiT2.stringValue(-999901, null);
            this.u = A2egSU.ADYaiT((SparseArray) ADYaiT2.objectValue(-999902, SparseArray.class));
        }
    }

    public int hf() {
        return this.hf;
    }

    public PluginValueSet u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public boolean xj() {
        return this.xj;
    }
}
