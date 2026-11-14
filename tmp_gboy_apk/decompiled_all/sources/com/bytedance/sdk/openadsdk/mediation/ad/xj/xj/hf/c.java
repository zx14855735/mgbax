package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener xj;

    public c(MediationShakeViewListener mediationShakeViewListener) {
        this.xj = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj == null || new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0) != 270012) {
            return null;
        }
        this.xj.onDismissed();
        return null;
    }
}
