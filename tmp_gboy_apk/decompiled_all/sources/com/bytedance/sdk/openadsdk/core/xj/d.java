package com.bytedance.sdk.openadsdk.core.xj;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c implements hf {
    private long xj;

    public d(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
    public void hf(final qt qtVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hf(qtVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.super.hf(qtVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
    public void xj(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(i, str);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.super.xj(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xj.hf
    public long hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
    public void xj(final qt qtVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(qtVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.super.xj(qtVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
    public void xj() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj();
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.super.xj();
                }
            });
        }
    }
}
