package com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class kd extends w {
    private SparseArray<Object> xj;

    private SparseArray<Object> xj() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj(super.values());
        xj.xj(270008, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(kd.this.hasDislike());
            }
        }));
        xj.xj(270011, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(kd.this.isExpress());
            }
        }));
        return xj.hf();
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
        switch (intValue) {
            case -99999986:
                SparseArray<Object> sparseArray2 = this.xj;
                if (sparseArray2 != null) {
                    return sparseArray2;
                }
                SparseArray<Object> xj = xj();
                this.xj = xj;
                return xj;
            case 270009:
                setUseCustomVideo(ADYaiT2.booleanValue(0, false));
                return null;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.y(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 271048:
                onResume();
                return null;
            case 271049:
                onPause();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.y yVar);

    public abstract void setUseCustomVideo(boolean z);
}
