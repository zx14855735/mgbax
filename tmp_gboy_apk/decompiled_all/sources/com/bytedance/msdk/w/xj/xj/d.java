package com.bytedance.msdk.w.xj.xj;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends w {
    public d(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        super(hfVar, function);
    }

    public void w(Activity activity) {
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = ((w) this).d;
        if (hfVar != null) {
            hfVar.y();
        }
        if (((w) this).tf != null) {
            ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8113).xj(20033, activity).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, Object obj, String str) {
        try {
            w(activity);
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
