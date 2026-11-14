package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends g.xj {
    private Handler hf = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xj;

    public w(com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar) {
        this.xj = xjVar;
    }

    private Handler d() {
        Handler handler = this.hf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hf = handler2;
        return handler2;
    }

    private void f() {
        this.xj = null;
        this.hf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void hf() {
        d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = w.this.xj;
                if (xjVar != null) {
                    xjVar.xj();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void kd() {
        d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = w.this.xj;
                if (xjVar != null) {
                    xjVar.u();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void u() {
        d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = w.this.xj;
                if (xjVar != null) {
                    xjVar.w();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void w() {
        d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = w.this.xj;
                if (xjVar != null) {
                    xjVar.hf();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void y() {
        d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = w.this.xj;
                if (xjVar != null) {
                    xjVar.kd();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public void xj() {
        f();
    }
}
