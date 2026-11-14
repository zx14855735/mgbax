package com.bytedance.sdk.gromore.xj.xj.xj;

import android.app.Activity;
import com.bytedance.msdk.api.u.c;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.w {
    private com.bytedance.msdk.api.u.hf xj;

    public hf(Activity activity, Map<String, Object> map, com.bytedance.msdk.api.u.xj.xj.w wVar) {
        if (wVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.xj = wVar.xj(activity, map);
        } else {
            this.xj = wVar.xj(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.w
    public void xj() {
        com.bytedance.msdk.api.u.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.w
    public void xj(final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.api.u.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(new c() { // from class: com.bytedance.sdk.gromore.xj.xj.xj.hf.1
                @Override // com.bytedance.msdk.api.u.c
                public void hf() {
                    com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.hf();
                    }
                }

                @Override // com.bytedance.msdk.api.u.c
                public void xj(int i, String str) {
                    com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.xj(i, str);
                    }
                }

                @Override // com.bytedance.msdk.api.u.c
                public void xj() {
                    com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.xj();
                    }
                }
            });
        }
    }

    public hf(com.bytedance.msdk.api.u.hf hfVar) {
        this.xj = hfVar;
    }
}
