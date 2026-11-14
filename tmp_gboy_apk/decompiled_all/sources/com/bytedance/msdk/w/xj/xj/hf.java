package com.bytedance.msdk.w.xj.xj;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.pl;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w {
    public hf(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        super(hfVar, function);
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        return mq();
    }

    public View mq() {
        Object apply;
        try {
            if (((w) this).tf == null) {
                return null;
            }
            apply = ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8113).xj(View.class).hf());
            if (apply instanceof View) {
                return (View) apply;
            }
            return null;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }
}
