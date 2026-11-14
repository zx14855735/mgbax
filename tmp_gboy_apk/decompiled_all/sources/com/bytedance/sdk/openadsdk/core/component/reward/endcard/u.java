package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.pz.u {
    private final WeakReference<com.bytedance.sdk.openadsdk.core.jk.u> xj;

    public u(com.bytedance.sdk.openadsdk.core.jk.u uVar) {
        this.xj = new WeakReference<>(uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.am.xj
    public void xj() {
        if (this.xj.get() != null) {
            this.xj.get().xj(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.am.xj
    public void xj(int i, String str) {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.u> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get();
    }
}
