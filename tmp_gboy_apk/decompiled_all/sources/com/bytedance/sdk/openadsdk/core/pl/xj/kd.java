package com.bytedance.sdk.openadsdk.core.pl.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.ai;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class kd extends com.bytedance.sdk.openadsdk.core.wo.u implements OnItemClickListener, LongSupplier {
    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null) {
            if (!com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w)) {
                pluginValueSet = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
            }
            if (i == 223200) {
                ASJ6gh ADYaiT2 = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class));
                onItemClick(AaHO0E.AYUAbz(ADYaiT2.objectValue(223201, AaHO0E.ARc23Z())), AaHO0E.AYUAbz(ADYaiT2.objectValue(223202, AaHO0E.ARc23Z())), AaHO0E.AYUAbz(ADYaiT2.objectValue(223203, AaHO0E.ARc23Z())));
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onItemClick();

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        onItemClick();
    }
}
