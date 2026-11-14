package com.bytedance.msdk.y.hf;

import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private final PluginValueSet xj;

    private w(PluginValueSet pluginValueSet) {
        this.xj = pluginValueSet;
    }

    private boolean hf() {
        PluginValueSet pluginValueSet = this.xj;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public static w xj(PluginValueSet pluginValueSet) {
        return new w(pluginValueSet);
    }

    public Function<SparseArray<Object>, Object> xj() {
        if (hf()) {
            return AaHO0E.AYUAbz(this.xj.objectValue(8301, AaHO0E.ARc23Z()));
        }
        return null;
    }
}
