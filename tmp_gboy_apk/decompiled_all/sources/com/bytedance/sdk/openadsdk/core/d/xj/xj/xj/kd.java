package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj hf;
    private String kd;
    private Map<String, Object> u;
    private com.bytedance.sdk.component.p.xj.xj w;
    private ws xj;

    public kd(com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar, ws wsVar, com.bytedance.sdk.component.p.xj.xj xjVar2, Map<String, Object> map, String str) {
        this.xj = wsVar;
        this.hf = xjVar;
        this.w = xjVar2;
        this.u = map;
        this.kd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(final Map<String, Object> map) {
        int xj = com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.xj, new com.bytedance.sdk.openadsdk.core.live.xj.w() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.live.xj.w
            public void xj(int i) {
                if (kd.this.hf == null || !kd.this.hf.xj(map)) {
                    kd.this.w.hf(kd.this.u);
                }
            }
        }, this.kd);
        if (xj == 1 || xj == 2) {
            xj();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.hf;
        return xjVar != null && xjVar.xj(map);
    }

    private void xj() {
        Map<String, Object> hashMap;
        Map<String, Object> map = this.u;
        if (map != null) {
            Object obj = map.get("click_chain");
            Object obj2 = this.u.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.hf.xj.w)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.hf.xj.w wVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w) obj;
            com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) wVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
            if (xjVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    hashMap = (Map) obj2;
                } else {
                    hashMap = new HashMap<>();
                }
                xjVar.xj(hashMap, wVar);
            }
        }
    }
}
