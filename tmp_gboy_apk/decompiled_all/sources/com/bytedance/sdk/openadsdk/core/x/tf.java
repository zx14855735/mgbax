package com.bytedance.sdk.openadsdk.core.x;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class tf {
    public abstract JSONObject hf(Context context);

    public abstract void xj(int i, d dVar);

    public void xj(Context context) {
        w wVar;
        if (xj() && (wVar = (w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya")) != null && wVar.isPitayaEnvAvailable()) {
            final JSONObject hf = hf(context);
            wVar.runTask("common", hf, new com.bytedance.sdk.openadsdk.core.wo.u() { // from class: com.bytedance.sdk.openadsdk.core.x.tf.1
                @Override // com.bytedance.sdk.openadsdk.core.wo.u
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
                    com.bytedance.sdk.openadsdk.core.ht.am.xj();
                    com.bytedance.sdk.openadsdk.core.ht.am.xj((SparseArray<Object>) sparseArray, hf);
                    tf.this.xj(i, new d(sparseArray, i));
                    return null;
                }
            });
        }
    }

    public abstract boolean xj();
}
