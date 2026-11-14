package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends p.xj {
    private y.xj hf;
    private Handler xj = new Handler(Looper.getMainLooper());

    public xj(y.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void hf() {
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.xj.2
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.hf != null) {
                    xj.this.hf.onDialogBtnNo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void w() {
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.xj.3
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.hf != null) {
                    xj.this.hf.onDialogCancel();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void xj() {
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.xj.1
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.hf != null) {
                    xj.this.hf.onDialogBtnYes();
                }
            }
        });
    }

    private void xj(Runnable runnable) {
        this.xj.post(runnable);
    }
}
