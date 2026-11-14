package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl implements p {
    Function xj;

    public pl(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.component.u.p
    public String get(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.p
    public boolean getBoolean(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(4, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.p
    public int getInt(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.p
    public long getLong(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(3, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.u.p
    public void set(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(5, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        this.xj.apply(sparseArray);
    }
}
