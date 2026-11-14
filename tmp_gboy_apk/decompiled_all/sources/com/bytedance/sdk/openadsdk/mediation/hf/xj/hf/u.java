package com.bytedance.sdk.openadsdk.mediation.hf.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo xj;

    public u(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.xj = iMediationPreloadRequestInfo;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        switch (new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.xj.getAdType()));
            case 271045:
                SparseArray<Object> xj = com.bytedance.sdk.openadsdk.zg.xj.w.hf.xj(this.xj.getAdSlot());
                return xj != null ? xj : new SparseArray();
            case 271046:
                return this.xj.getPrimeRitList();
            default:
                apply = ARc23Z.f4112ADYaiT.apply(sparseArray);
                return apply;
        }
    }
}
