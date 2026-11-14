package com.bytedance.sdk.component.y;

import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class z implements q, Function {
    q hf;
    Function xj;

    public z(q qVar) {
        this.hf = qVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            Object obj2 = sparseArray.get(1);
            Object obj3 = sparseArray.get(2);
            if (obj3 != null) {
                obj3 = new g(AaHO0E.AYUAbz(obj3));
            }
            this.hf.onStepStart((String) obj2, (pl) obj3);
            return null;
        }
        if (intValue != 2) {
            return null;
        }
        Object obj4 = sparseArray.get(1);
        Object obj5 = sparseArray.get(2);
        if (obj5 != null) {
            obj5 = new g(AaHO0E.AYUAbz(obj5));
        }
        this.hf.onStepEnd((String) obj4, (pl) obj5);
        return null;
    }

    @Override // com.bytedance.sdk.component.y.q
    public void onStepEnd(String str, pl plVar) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        if (plVar != null) {
            plVar = new g(plVar);
        }
        sparseArray.put(2, plVar);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.y.q
    public void onStepStart(String str, pl plVar) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        if (plVar != null) {
            plVar = new g(plVar);
        }
        sparseArray.put(2, plVar);
        this.xj.apply(sparseArray);
    }

    public z(Function function) {
        this.xj = function;
    }
}
