package com.bytedance.sdk.openadsdk.core.x;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends d {
    public kd(SparseArray<Object> sparseArray, int i) {
        super(sparseArray, i);
    }

    public c hf() {
        PluginValueSet u;
        if (w() == null || (u = w().u()) == null) {
            return null;
        }
        return new c((JSONObject) u.objectValue(4, JSONObject.class));
    }

    public boolean xj() {
        if (w() != null) {
            return w().xj();
        }
        return false;
    }
}
