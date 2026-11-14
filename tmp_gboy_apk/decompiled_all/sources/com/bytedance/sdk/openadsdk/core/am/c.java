package com.bytedance.sdk.openadsdk.core.am;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.am.f;
import com.bytedance.sdk.openadsdk.core.ff;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private static volatile c xj;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(ws wsVar, String str) {
        if (wsVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        xj2.put("save_jump_success_time", System.currentTimeMillis());
        JSONObject ac = wsVar.ac();
        if (ac == null) {
            return;
        }
        xj2.put("save_dpl_success_materialmeta", ac.toString());
        xj2.put("save_jump_success_ad_tag", str);
    }

    public static c xj() {
        if (xj == null) {
            synchronized (c.class) {
                try {
                    if (xj == null) {
                        xj = new c();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(final ws wsVar, final String str, final boolean z) {
        if (wsVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        new f().xj(new f.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.c.1
            private boolean y = false;

            private void hf(String str2) {
                ws wsVar2 = wsVar;
                if (wsVar2 == null || this.y) {
                    return;
                }
                boolean xe = wsVar2.xe();
                zg yt = wsVar.yt();
                if (yt == null || yt.xj()) {
                    return;
                }
                int w = yt.w();
                if (xe) {
                    return;
                }
                if (w == 1 || w == 2) {
                    ff.xj(wsVar, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
            public void xj() {
                xj(false, "resume");
                if (!z) {
                    hf(str);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj().put("dpl_reject_by_dialog", true);
                u.xj(wsVar, str, "dpl_popup", System.currentTimeMillis() - currentTimeMillis);
            }

            @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
            public void xj(String str2) {
                xj(false, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.am.f.xj
            public void xj(boolean z2) {
                this.y = z2;
                xj(z2, "stop");
                if (!this.y && !z) {
                    hf(str);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj().put("dpl_reject_by_dialog", false);
            }

            private void xj(final boolean z2, final String str2) {
                com.bytedance.sdk.component.tf.c.xj(new com.bytedance.sdk.component.tf.d("EventData") { // from class: com.bytedance.sdk.openadsdk.core.am.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (z) {
                            u.w(wsVar, str, z2 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z2 ? "dpl_success" : "dpl_failed";
                        HashMap hashMap = new HashMap();
                        boolean xj2 = com.bytedance.sdk.openadsdk.core.f.zg().xj();
                        hashMap.put("has_focus", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.f.zg().xj(true)));
                        hashMap.put("is_background", Boolean.valueOf(xj2));
                        hashMap.put("life", str2);
                        hashMap.put("total_duration", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        u.f(wsVar, str, str3, hashMap);
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        ws wsVar2 = wsVar;
                        if (wsVar2 != null) {
                            c.hf(wsVar2, str);
                        }
                    }
                }, 5);
            }
        });
    }
}
