package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends pl.xj {
    private c.xj hf;
    private Handler xj = new Handler(Looper.getMainLooper());

    public hf(c.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl
    public void xj() {
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.hf.1
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.hf != null) {
                    hf.this.hf.onGranted();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl
    public void xj(final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.hf.2
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.hf != null) {
                    hf.this.hf.onDenied(str);
                }
            }
        });
    }

    private void xj(Runnable runnable) {
        if (this.xj == null) {
            this.xj = new Handler(Looper.getMainLooper());
        }
        this.xj.post(runnable);
    }
}
