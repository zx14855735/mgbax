package com.bytedance.sdk.openadsdk.live;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Callback<Object> {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.xj != null) {
            ARc23Z A4TApA2 = ARc23Z.A4TApA();
            A4TApA2.f4113A2egSU.put(0, obj);
            A4TApA2.ADYaiT(-99999987, 1);
            this.xj.apply(A4TApA2.A2egSU().sparseArray());
        }
    }
}
