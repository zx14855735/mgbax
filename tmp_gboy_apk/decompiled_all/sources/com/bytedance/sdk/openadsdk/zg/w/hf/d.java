package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.graphics.Bitmap;
import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class d extends tf {
    private SparseArray<Object> xj;

    private SparseArray<Object> io() {
        return super.u_();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> io2 = io();
        this.xj = io2;
        return io2;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf, com.bytedance.sdk.openadsdk.zg.w.hf.g, com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return u_();
        }
        if (intValue == 140111) {
            Function AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()));
            xj(ADYaiT2.intValue(1, 0) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd(AYUAbz2) : new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w(AYUAbz2));
            return null;
        }
        switch (intValue) {
            case 170101:
                xj(ADYaiT2.booleanValue(0, false));
                return null;
            case 170102:
                xj((Bitmap) ADYaiT2.objectValue(0, Bitmap.class), ADYaiT2.intValue(1, 0));
                return null;
            case 170103:
                xj(new com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(Bitmap bitmap, int i);

    public abstract void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar);

    public abstract void xj(boolean z);
}
