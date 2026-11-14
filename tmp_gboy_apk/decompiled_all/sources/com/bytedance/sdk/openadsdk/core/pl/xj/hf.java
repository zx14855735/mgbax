package com.bytedance.sdk.openadsdk.core.pl.xj;

import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.ai;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import java.util.function.LongSupplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf extends com.bytedance.sdk.openadsdk.core.wo.u implements IDownloadButtonClickListener, LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null) {
            if (i == 223100) {
                if (!com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w)) {
                    pluginValueSet = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                }
                handleComplianceDialog(new AYUAbz((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).A2egSU().booleanValue(223101, false));
                return null;
            }
            if (i == 223110) {
                handleMarketFailedComplianceDialog();
                return null;
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
