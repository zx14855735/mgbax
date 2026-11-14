package com.bytedance.sdk.component.y;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements tf, Function {
    tf hf;
    Function xj;

    public p(tf tfVar) {
        this.hf = tfVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return this.hf.coverterTo((Bitmap) sparseArray.get(1));
    }

    @Override // com.bytedance.sdk.component.y.tf
    public Bitmap coverterTo(Bitmap bitmap) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bitmap);
        apply = this.xj.apply(sparseArray);
        return (Bitmap) apply;
    }

    public p(Function function) {
        this.xj = function;
    }
}
