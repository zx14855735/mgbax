package com.bytedance.sdk.openadsdk.core.xj;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf implements hf {
    private long xj;

    public u(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xj.hf
    public long hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf
    public void xj(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(i, str);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.super.xj(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf
    public void xj(final List<com.bytedance.sdk.openadsdk.zg.w.hf.d> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(list);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.u.2
                @Override // java.lang.Runnable
                public void run() {
                    u.super.xj(list);
                }
            });
        }
    }
}
