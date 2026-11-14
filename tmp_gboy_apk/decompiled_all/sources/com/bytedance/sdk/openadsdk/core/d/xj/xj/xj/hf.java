package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.w;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private ws hf;
    private com.bytedance.sdk.component.p.xj.xj kd;
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj u;
    private String w;
    private Context xj;
    private Map<String, Object> y;

    public hf(com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar, Context context, ws wsVar, String str, Map<String, Object> map, com.bytedance.sdk.component.p.xj.xj xjVar2) {
        this.u = xjVar;
        this.xj = context;
        this.hf = wsVar;
        this.w = str;
        this.kd = xjVar2;
        this.y = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj(this.hf, false)) {
            com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.u;
            return xjVar != null && xjVar.xj(map);
        }
        if (tf.kd(this.hf)) {
            com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar2 = this.u;
            return xjVar2 != null && xjVar2.xj(map);
        }
        if (tf.u(this.hf)) {
            com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar3 = this.u;
            return xjVar3 != null && xjVar3.xj(map);
        }
        new com.bytedance.sdk.openadsdk.core.hf.xj.hf.w(this.hf, this.xj).xj(this.w).xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj
            public void xj() {
                if (hf.this.u.xj(map)) {
                    return;
                }
                hf.this.kd.hf(hf.this.y);
            }
        });
        return true;
    }
}
