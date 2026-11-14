package com.bytedance.sdk.openadsdk.core.xj;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.zg.w.hf.p;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u implements hf {
    private long xj;

    public y(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
    public void hf(final p pVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hf(pVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.y.4
                @Override // java.lang.Runnable
                public void run() {
                    y.super.hf(pVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
    public void xj(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(i, str);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.super.xj(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xj.hf
    public long hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
    public void xj(final p pVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(pVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.y.2
                @Override // java.lang.Runnable
                public void run() {
                    y.super.xj(pVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u
    public void xj() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj();
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.y.3
                @Override // java.lang.Runnable
                public void run() {
                    y.super.xj();
                }
            });
        }
    }
}
