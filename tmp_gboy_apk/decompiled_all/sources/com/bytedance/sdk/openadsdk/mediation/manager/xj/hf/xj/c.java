package com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class c extends w {
    private SparseArray<Object> xj;

    private SparseArray<Object> xj() {
        return com.bytedance.sdk.openadsdk.zg.u.xj(super.values()).hf();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w, java.util.function.Function
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
        if (intValue != 270007) {
            return super.apply(sparseArray);
        }
        destroy();
        return null;
    }

    public abstract void destroy();

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
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
