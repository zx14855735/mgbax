package com.bytedance.sdk.component.y;

import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class et implements dk, Function {
    dk hf;
    Function xj;

    public et(dk dkVar) {
        this.hf = dkVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            Object obj2 = sparseArray.get(1);
            if (obj2 != null) {
                obj2 = new e(AaHO0E.AYUAbz(obj2));
            }
            this.hf.onSuccess((zg) obj2);
            return null;
        }
        if (intValue != 2) {
            return null;
        }
        this.hf.onFailed(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
        return null;
    }

    @Override // com.bytedance.sdk.component.y.dk
    public void onFailed(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(2, sparseArray, 0, i, 1);
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.y.dk
    public void onSuccess(zg zgVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (zgVar != null) {
            zgVar = new e(zgVar);
        }
        sparseArray.put(1, zgVar);
        this.xj.apply(sparseArray);
    }

    public et(Function function) {
        this.xj = function;
    }
}
