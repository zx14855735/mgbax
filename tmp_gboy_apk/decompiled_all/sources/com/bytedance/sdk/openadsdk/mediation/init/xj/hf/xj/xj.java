package com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public final PluginValueSet xj;

    public xj(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.ADYaiT(sparseArray);
    }

    public String c() {
        return (String) this.xj.objectValue(264107, String.class);
    }

    public boolean d() {
        return this.xj.booleanValue(264109);
    }

    public boolean f() {
        return this.xj.booleanValue(264108);
    }

    public boolean hf() {
        return this.xj.booleanValue(264102);
    }

    public boolean kd() {
        return this.xj.booleanValue(264105);
    }

    public String p() {
        return (String) this.xj.objectValue(264111, String.class);
    }

    public boolean tf() {
        return this.xj.booleanValue(264110);
    }

    public Map<String, Object> u() {
        return (Map) this.xj.objectValue(264104, Map.class);
    }

    public w w() {
        SparseArray sparseArray = (SparseArray) this.xj.objectValue(264103, SparseArray.class);
        if (sparseArray == null) {
            return null;
        }
        return new w(sparseArray);
    }

    public String xj() {
        return (String) this.xj.objectValue(264101, String.class);
    }

    public JSONObject y() {
        return (JSONObject) this.xj.objectValue(264106, JSONObject.class);
    }
}
