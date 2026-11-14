package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    public static void xj(final String str, final String str2, final ws wsVar) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.f.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(f.xj(str)).w(str2).y(wo.g(wsVar)).xj("dynamic_backup_render_new");
                xj.xj(currentTimeMillis);
                return xj;
            }
        }, "dynamic_backup_render_new");
    }

    public static void xj(final int i, final String str, final String str2, final ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().kd(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.f.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(f.xj(str)).w(str2).y(wo.g(wsVar)).hf(i).c(com.bytedance.sdk.openadsdk.core.c.xj(i));
            }
        });
    }

    public static int xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.getClass();
        switch (str) {
        }
        return 5;
    }
}
