package com.bytedance.sdk.component.y;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements f, Function {
    f hf;
    Function xj;

    public d(f fVar) {
        this.hf = fVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int intValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (intValue == 1) {
            return Long.valueOf(this.hf.getStartRequestTime());
        }
        if (intValue == 2) {
            return Long.valueOf(this.hf.getFirstFrameTime());
        }
        if (intValue != 3) {
            return null;
        }
        return Long.valueOf(this.hf.getEndRequestTime());
    }

    @Override // com.bytedance.sdk.component.y.f
    public long getEndRequestTime() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.y.f
    public long getFirstFrameTime() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.y.f
    public long getStartRequestTime() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    public d(Function function) {
        this.xj = function;
    }
}
