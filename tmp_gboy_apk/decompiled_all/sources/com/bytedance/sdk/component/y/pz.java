package com.bytedance.sdk.component.y;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pz implements jk, Function {
    jk hf;
    Function xj;

    public pz(jk jkVar) {
        this.hf = jkVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        this.hf.onStep(((Integer) obj2).intValue(), sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.y.jk
    public void onStep(int i, Object obj) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(1, sparseArray, 0, i, 1);
        sparseArray.put(2, obj);
        this.xj.apply(sparseArray);
    }

    public pz(Function function) {
        this.xj = function;
    }
}
