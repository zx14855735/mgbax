package com.bytedance.sdk.openadsdk.core.wo;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.ai;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private hf hf;
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    public void xj(hf hfVar) {
        this.hf = hfVar;
    }

    public void xj(int i, SparseArray<Object> sparseArray) {
        hf hfVar;
        if (new AYUAbz(sparseArray).A2egSU().booleanValue(-999903, false) && i == 8001 && (hfVar = this.hf) != null) {
            hfVar.xj(true);
        } else if (this.xj != null) {
            this.xj.apply(com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w) ? com.bytedance.sdk.openadsdk.zg.u.xj(sparseArray).xj(i).xj(Void.class).hf() : com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(Void.class).xj(-99999979, sparseArray).hf());
        }
    }
}
