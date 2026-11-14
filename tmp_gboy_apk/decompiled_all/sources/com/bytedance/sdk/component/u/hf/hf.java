package com.bytedance.sdk.component.u.hf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj, Function {
    xj hf;
    Function xj;

    public hf(xj xjVar) {
        this.hf = xjVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            return this.hf.encrypt((String) sparseArray.get(1));
        }
        if (intValue == 2) {
            return this.hf.decrypt((String) sparseArray.get(1));
        }
        if (intValue != 3) {
            return null;
        }
        return Integer.valueOf(this.hf.type());
    }

    @Override // com.bytedance.sdk.component.u.hf.xj
    public String decrypt(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.xj
    public String encrypt(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.xj
    public int type() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    public hf(Function function) {
        this.xj = function;
    }
}
