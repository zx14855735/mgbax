package com.bytedance.sdk.component.u.xj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements w, Function {
    w hf;
    Function xj;

    public u(w wVar) {
        this.hf = wVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int intValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (intValue == 1) {
            return Float.valueOf(this.hf.getLatitude());
        }
        if (intValue == 2) {
            return Float.valueOf(this.hf.getLongitude());
        }
        if (intValue != 3) {
            return null;
        }
        return Long.valueOf(this.hf.getLastTime());
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public long getLastTime() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public float getLatitude() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return ((Float) apply).floatValue();
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public float getLongitude() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return ((Float) apply).floatValue();
    }

    public u(Function function) {
        this.xj = function;
    }
}
