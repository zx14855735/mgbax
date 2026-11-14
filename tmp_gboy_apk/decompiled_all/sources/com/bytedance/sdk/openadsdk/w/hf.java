package com.bytedance.sdk.openadsdk.w;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.w.xj;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements xj.InterfaceC0209xj {
    private Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.openadsdk.w.xj.InterfaceC0209xj
    public void hf() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.xj;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.w.xj.InterfaceC0209xj
    public void xj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.xj;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
