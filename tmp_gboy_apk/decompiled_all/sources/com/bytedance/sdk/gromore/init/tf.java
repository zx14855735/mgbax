package com.bytedance.sdk.gromore.init;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements Function<SparseArray<Object>, Object> {
    private u hf = new u();
    private c w;
    private q xj;

    public tf(q qVar) {
        this.xj = qVar;
        this.w = new c(this.xj);
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        if (intValue == -99999986) {
            q qVar = this.xj;
            if (qVar != null) {
                return qVar.xj();
            }
            return null;
        }
        if (intValue == -999800) {
            if (this.xj == null) {
                return null;
            }
            Context context = (Context) ADYaiT2.objectValue(-998000, Context.class);
            return new y(context, this.xj.xj(context));
        }
        if (intValue != 8303 && intValue != 999801) {
            return null;
        }
        if (intValue == 8303) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "initRequestCondition getBridge");
            return this.hf;
        }
        if (this.xj != null) {
            return this.w;
        }
        return null;
    }
}
