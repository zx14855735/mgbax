package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements kd {
    Function xj;

    public y(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.component.u.kd
    public byte[] encrypt(byte[] bArr, int i) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        return (byte[]) apply;
    }

    public String getDid() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    public String getOAID() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }
}
