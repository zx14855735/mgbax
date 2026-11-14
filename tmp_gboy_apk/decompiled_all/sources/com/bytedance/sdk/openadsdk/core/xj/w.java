package com.bytedance.sdk.openadsdk.core.xj;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj implements hf {
    private long xj;

    public w(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
    public void hf(final com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hf(hfVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.w.3
                @Override // java.lang.Runnable
                public void run() {
                    w.super.hf(hfVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        if (com.bytedance.sdk.openadsdk.core.component.splash.kd.xj()) {
            super.xj(hfVar);
        } else {
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.super.xj(hfVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xj.hf
    public long hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.hf.xj xjVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(xjVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.super.xj(xjVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, final com.bytedance.sdk.openadsdk.zg.w.hf.xj xjVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xj(hfVar, xjVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.super.xj(hfVar, xjVar);
                }
            });
        }
    }
}
