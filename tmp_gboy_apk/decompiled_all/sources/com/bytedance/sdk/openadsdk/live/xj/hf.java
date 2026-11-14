package com.bytedance.sdk.openadsdk.live.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements ILiveHostActionParam {
    private Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.xj != null) {
            ARc23Z A4TApA2 = ARc23Z.A4TApA();
            A4TApA2.ASJ6gh(0, z);
            SparseArray sparseArray = A4TApA2.f4113A2egSU;
            sparseArray.put(1, str);
            sparseArray.put(2, str2);
            sparseArray.put(3, map);
            A4TApA2.ADYaiT(-99999987, 1);
            this.xj.apply(A4TApA2.A2egSU().sparseArray());
        }
    }
}
