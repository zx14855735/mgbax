package com.bytedance.sdk.openadsdk.mediation.hf.hf;

import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.zg.w.w.hf {
    private final PluginValueSet hf;

    public xj(SparseArray<Object> sparseArray) {
        super(sparseArray);
        this.hf = A2egSU.ADYaiT(sparseArray);
    }

    private static Function<SparseArray<Object>, Object> xj(PluginValueSet pluginValueSet) {
        Object obj;
        if (pluginValueSet != null) {
            obj = pluginValueSet.objectValue(8260028, Object.class);
            if (obj == null) {
                try {
                    obj = pluginValueSet.objectValue(260026, AaHO0E.ARc23Z());
                } catch (Throwable unused) {
                }
            }
        } else {
            obj = null;
        }
        return com.bytedance.sdk.openadsdk.ai.w.xj(obj);
    }

    public hf ai() {
        Function<SparseArray<Object>, Object> xj = xj(this.hf);
        if (xj != null) {
            return new hf(xj);
        }
        return null;
    }

    public String q() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet == null) {
            return null;
        }
        return (String) pluginValueSet.objectValue(8260029, String.class);
    }

    public boolean x() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet == null) {
            return false;
        }
        return pluginValueSet.booleanValue(8260030);
    }

    public PluginValueSet z() {
        return this.hf;
    }

    public static final PluginValueSet xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return xj(hfVar, null, false);
    }

    public static final PluginValueSet xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z) {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        if (hfVar == null) {
            return A4TApA2.A2egSU();
        }
        A4TApA2.ASJ6gh(260001, hfVar.xj());
        A4TApA2.ASJ6gh(260002, hfVar.hf());
        A4TApA2.ASJ6gh(260003, hfVar.w());
        A4TApA2.ASJ6gh(260004, hfVar.u());
        A4TApA2.AYUAbz(260005, hfVar.kd());
        A4TApA2.AMqCpz(260006, hfVar.y());
        A4TApA2.AMqCpz(260007, hfVar.c());
        A4TApA2.AMqCpz(7, hfVar.y());
        A4TApA2.AMqCpz(8, hfVar.c());
        A4TApA2.ADYaiT(hfVar.f(), 260008);
        A4TApA2.ADYaiT(hfVar.d(), 260009);
        A4TApA2.ADYaiT(hfVar.f(), 10);
        A4TApA2.ADYaiT(hfVar.d(), 9);
        A4TApA2.AYUAbz(260010, hfVar.tf());
        A4TApA2.AYUAbz(260011, hfVar.p());
        A4TApA2.AMqCpz(2600012, hfVar.pl());
        A4TApA2.ASJ6gh(260013, hfVar.g());
        A4TApA2.ASJ6gh(260014, hfVar.am());
        A4TApA2.AMqCpz(260015, hfVar.qt());
        A4TApA2.AMqCpz(260016, hfVar.zg());
        A4TApA2.ARc23Z(260017, hfVar.e());
        A4TApA2.AMqCpz(260018, hfVar.yo());
        A4TApA2.ASJ6gh(260019, hfVar.v());
        A4TApA2.AMqCpz(260020, hfVar.jk());
        A4TApA2.ASJ6gh(260021, hfVar.pz());
        A4TApA2.ASJ6gh(260022, hfVar.ht());
        A4TApA2.ARc23Z(260023, hfVar.ra());
        PluginValueSet pluginValueSet = null;
        try {
            for (Field field : hfVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(hfVar) instanceof PluginValueSet) {
                    pluginValueSet = (PluginValueSet) field.get(hfVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (pluginValueSet != null) {
            A4TApA2.ARc23Z(8260028, xj(pluginValueSet));
            A4TApA2.ARc23Z(260027, pluginValueSet.objectValue(260027, IMediationAdSlot.class));
        }
        A4TApA2.ASJ6gh(260024, hfVar.dk());
        A4TApA2.AMqCpz(260025, hfVar.et());
        A4TApA2.ADYaiT(hfVar.f(), 260008);
        if (!TextUtils.isEmpty(str)) {
            A4TApA2.ASJ6gh(8260029, str);
            A4TApA2.AYUAbz(8260030, z);
        }
        return A4TApA2.A2egSU();
    }

    public static PluginValueSet xj(PluginValueSet pluginValueSet, String str) {
        AYUAbz A5SV6n2 = AYUAbz.A5SV6n(pluginValueSet);
        A5SV6n2.ASJ6gh(260022, str);
        return A5SV6n2.A2egSU();
    }
}
