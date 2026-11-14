package com.bytedance.msdk.y.hf;

import com.bytedance.msdk.api.u.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile hf w;
    private final Map<String, com.bytedance.msdk.xj.xj.u> hf = new ConcurrentHashMap();
    public p xj;

    private hf() {
    }

    public static hf xj() {
        if (w == null) {
            synchronized (hf.class) {
                try {
                    if (w == null) {
                        w = new hf();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public synchronized Map<String, com.bytedance.msdk.xj.xj.u> hf() {
        return this.hf;
    }

    public Collection<com.bytedance.msdk.xj.xj.u> w() {
        return this.hf.values();
    }

    private com.bytedance.msdk.xj.xj.u hf(String str) {
        if (str == null) {
            return null;
        }
        return this.hf.get(str);
    }

    private com.bytedance.msdk.xj.xj.u w(String str) {
        return MediationConstant.ADN_PANGLE.equalsIgnoreCase(str) ? new com.bytedance.msdk.xj.w.xj() : new u();
    }

    public com.bytedance.msdk.xj.xj.u xj(String str, p pVar) {
        this.xj = pVar;
        return xj(str);
    }

    public synchronized com.bytedance.msdk.xj.xj.u xj(String str) {
        com.bytedance.msdk.xj.xj.u hf;
        p pVar;
        try {
            hf = hf(str);
            if (hf == null) {
                com.bytedance.msdk.core.tf.xj xj = com.bytedance.msdk.core.hf.hf().xj(str);
                if (xj == null && (pVar = this.xj) != null) {
                    xj = new com.bytedance.msdk.core.tf.xj(pVar.kd(), this.xj.w(), this.xj.u());
                    this.xj = null;
                }
                if (xj != null && !xj.kd()) {
                    hf = w(str);
                }
                if (hf != null) {
                    xj(str, hf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return hf;
    }

    private void xj(String str, com.bytedance.msdk.xj.xj.u uVar) {
        if (str == null) {
            return;
        }
        this.hf.put(str, uVar);
    }
}
