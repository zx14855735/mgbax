package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends zg.xj {
    private Handler hf = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xj;

    public kd(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        this.xj = xjVar;
    }

    private void d() {
        this.xj = null;
        this.hf = null;
    }

    private Handler tf() {
        Handler handler = this.hf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hf = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void c() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.y();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void hf() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.xj();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void kd() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.u();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void u() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.w();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void w() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.hf();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void y() {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.kd();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void xj() {
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void xj(final boolean z, final int i, final String str, final int i2, final String str2) {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar != null) {
                    xjVar.xj(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zg
    public void xj(final boolean z, final int i, final Bundle bundle) {
        tf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = kd.this.xj;
                if (xjVar == null || ai.w < 4400) {
                    return;
                }
                try {
                    xjVar.xj(z, i, bundle);
                } catch (AbstractMethodError unused) {
                    pl.u("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}
