package com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> xj;

    private SparseArray<Object> xj() {
        return com.bytedance.sdk.openadsdk.zg.u.xj().hf();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return values();
        }
        switch (intValue) {
            case 270001:
                return Boolean.class.cast(Boolean.valueOf(isReady()));
            case 270002:
                return getAdLoadInfo();
            case 270003:
                return getMultiBiddingEcpm();
            case 270004:
                return getBestEcpm();
            case 270005:
                return getCacheList();
            case 270006:
                return getShowEcpm();
            default:
                return null;
        }
    }

    public abstract List<hf> getAdLoadInfo();

    public abstract xj getBestEcpm();

    public abstract List<xj> getCacheList();

    public abstract List<xj> getMultiBiddingEcpm();

    public abstract xj getShowEcpm();

    public abstract boolean isReady();

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> xj = xj();
        this.xj = xj;
        return xj;
    }
}
