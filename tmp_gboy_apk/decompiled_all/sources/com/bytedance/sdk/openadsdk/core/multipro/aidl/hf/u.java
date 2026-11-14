package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Bundle;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.qt;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends qt.xj {
    private final com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf xj;

    public u(com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qt
    public Bundle xj(int i) {
        com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar = this.xj;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (hfVar != null) {
            hfVar.xj(i, new com.bytedance.sdk.openadsdk.e.xj.xj.hf.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.u.1
                @Override // com.bytedance.sdk.openadsdk.e.xj.xj.hf.xj.xj
                public void xj(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            return bundle;
        } catch (InterruptedException e) {
            pl.xj(e);
            return bundle;
        }
    }
}
