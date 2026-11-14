package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements d {
    Function xj;

    public tf(Function function) {
        this.xj = function;
    }

    public void clear() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.xj.apply(sparseArray);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.u.d
    public com.bytedance.sdk.component.u.hf.w get(String str) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        com.bytedance.sdk.component.u.hf.u uVar = apply;
        if (apply != 0) {
            uVar = new com.bytedance.sdk.component.u.hf.u((Function) apply);
        }
        return uVar;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.u.d
    public com.bytedance.sdk.component.u.hf.xj getEncrypt(int i) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(3, sparseArray, 0, i, 1);
        apply = this.xj.apply(sparseArray);
        com.bytedance.sdk.component.u.hf.hf hfVar = apply;
        if (apply != 0) {
            hfVar = new com.bytedance.sdk.component.u.hf.hf((Function) apply);
        }
        return hfVar;
    }

    @Override // com.bytedance.sdk.component.u.d
    public void store() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.xj.apply(sparseArray);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    public com.bytedance.sdk.component.u.hf.w get(String str, int i) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        sparseArray.put(2, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        com.bytedance.sdk.component.u.hf.u uVar = apply;
        if (apply != 0) {
            uVar = new com.bytedance.sdk.component.u.hf.u((Function) apply);
        }
        return uVar;
    }
}
