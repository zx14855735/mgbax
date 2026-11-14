package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.hf.xj.xj.hf;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationManagerVisitor {
    private static volatile Object hf;
    private static volatile MediationManagerVisitor xj;
    private hf w;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (xj == null) {
            synchronized (MediationManagerVisitor.class) {
                try {
                    if (xj == null) {
                        xj = new MediationManagerVisitor();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public synchronized IMediationManager getMediationManager() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            Object obj = hf;
            if (adManager != null) {
                hf = adManager.getExtra(null, bundle);
            }
            if (hf == null) {
                return null;
            }
            if (this.w == null) {
                this.w = new hf(qt.xj(hf));
            } else if (obj != hf) {
                this.w.xj(qt.xj(hf));
            }
            return this.w;
        } catch (Throwable th) {
            throw th;
        }
    }
}
