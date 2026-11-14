package com.bytedance.sdk.openadsdk.core.x;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.yo;
import io.dcloud.openapi.core.util.Const;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class f extends com.bytedance.sdk.openadsdk.core.wo.u implements LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        xj(i, (SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class));
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public PluginValueSet hf(int i, SparseArray<Object> sparseArray) {
        return null;
    }

    public PluginValueSet w(int i, SparseArray<Object> sparseArray) {
        JSONObject ss = pz.hf().ss();
        if (ss == null) {
            return null;
        }
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.f4119A2egSU.put(33, ss);
        return A4TApA2.A2egSU();
    }

    public PluginValueSet xj(int i, d dVar) {
        return null;
    }

    public PluginValueSet hf(int i) {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.f4119A2egSU.put(32, String.valueOf(wo.kd()));
        return A4TApA2.A2egSU();
    }

    public PluginValueSet xj(int i, kd kdVar) {
        return null;
    }

    public PluginValueSet xj(int i, SparseArray<Object> sparseArray) {
        if (i == 1) {
            return xj(i);
        }
        if (i == 6) {
            return xj(i, new kd(sparseArray, i));
        }
        if (i == 3) {
            return w(i, sparseArray);
        }
        if (i != 4) {
            switch (i) {
                case 8:
                    return xj(i, new d(sparseArray, i));
                case 9:
                    return hf(i, sparseArray);
                case 10:
                    xj(sparseArray);
                    return null;
                default:
                    return null;
            }
        }
        return hf(i);
    }

    private void xj(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            try {
                PluginValueSet u = new com.bytedance.sdk.openadsdk.zg.xj(sparseArray).u();
                if (u != null) {
                    String stringValue = u.stringValue(6);
                    JSONObject jSONObject = (JSONObject) u.objectValue(7, JSONObject.class);
                    jSONObject.put("label", stringValue);
                    com.bytedance.sdk.component.f.hf.u.xj.xj xjVar = new com.bytedance.sdk.component.f.hf.u.xj.xj(UUID.randomUUID().toString(), jSONObject);
                    xjVar.xj((byte) 0);
                    xjVar.hf((byte) 2);
                    com.bytedance.sdk.component.f.hf.xj.xj(xjVar, Const.TYPE_CSJ);
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    public PluginValueSet xj(int i) {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.f4119A2egSU.put(31, yo.w());
        return A4TApA2.A2egSU();
    }
}
