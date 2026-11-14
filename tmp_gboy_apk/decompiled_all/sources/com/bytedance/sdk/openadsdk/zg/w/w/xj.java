package com.bytedance.sdk.openadsdk.zg.w.w;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public final PluginValueSet xj;

    public xj(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.ADYaiT(sparseArray);
    }

    public int am() {
        return this.xj.intValue(261015);
    }

    public boolean c() {
        return this.xj.booleanValue(261007);
    }

    public int[] d() {
        return (int[]) this.xj.objectValue(261009, int[].class);
    }

    public Map<String, Object> e() {
        return (Map) this.xj.objectValue(261018, Map.class);
    }

    public boolean f() {
        return this.xj.booleanValue(261008);
    }

    public int g() {
        return this.xj.intValue(261014);
    }

    public String hf() {
        return (String) this.xj.objectValue(261002, String.class);
    }

    public String kd() {
        return (String) this.xj.objectValue(261005, String.class);
    }

    public u p() {
        SparseArray sparseArray = (SparseArray) this.xj.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new u(sparseArray);
        }
        return null;
    }

    public int pl() {
        return this.xj.intValue(261013);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj qt() {
        SparseArray sparseArray = (SparseArray) this.xj.objectValue(261016, SparseArray.class);
        if (sparseArray != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj(sparseArray);
        }
        return null;
    }

    public boolean tf() {
        return this.xj.booleanValue(261011);
    }

    public String u() {
        return (String) this.xj.objectValue(261004, String.class);
    }

    public boolean w() {
        return this.xj.booleanValue(261003);
    }

    public String xj() {
        return (String) this.xj.objectValue(261001, String.class);
    }

    public int y() {
        return this.xj.intValue(261006);
    }

    public boolean zg() {
        return this.xj.booleanValue(261017);
    }
}
