package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.openadsdk.core.a.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile xj xj;
    private Map<String, hf> hf = new HashMap();

    private xj() {
        xj(com.bytedance.sdk.openadsdk.core.x.w.xj.w());
        xj(com.bytedance.sdk.openadsdk.core.x.xj.xj.xj());
        xj(com.bytedance.sdk.openadsdk.core.x.u.xj.w());
        xj(com.bytedance.sdk.openadsdk.core.x.kd.xj.xj());
        xj(com.bytedance.sdk.openadsdk.core.am.hf.xj());
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void xj(hf hfVar) {
        this.hf.put(hfVar.hf(), hfVar);
    }

    public String xj(String str, String str2) {
        if (this.hf.containsKey(str)) {
            return this.hf.get(str).xj(str2);
        }
        return j.xj(str).get(str2, "");
    }

    public void xj(String str, String str2, String str3) {
        if (this.hf.containsKey(str)) {
            this.hf.get(str).xj(str2, str3);
        } else {
            j.xj(str).put(str2, str3);
        }
    }
}
