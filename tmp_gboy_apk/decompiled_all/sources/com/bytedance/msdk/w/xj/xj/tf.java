package com.bytedance.msdk.w.xj.xj;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.pl;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends w {
    public tf(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        super(hfVar, function);
    }

    public void hf(ViewGroup viewGroup) {
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = ((w) this).d;
        if (hfVar != null) {
            hfVar.y();
        }
        if (((w) this).tf != null) {
            ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6152).xj(20060, viewGroup).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(ViewGroup viewGroup) {
        try {
            hf(viewGroup);
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
