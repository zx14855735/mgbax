package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private Map<String, Object> c;
    private int d;
    private com.bytedance.sdk.component.p.xj.xj f;
    private ws hf;
    private String kd;
    private boolean u;
    private Context w;
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xj;
    private ne y;

    public f(ne neVar, Context context, boolean z, String str, Map<String, Object> map, com.bytedance.sdk.component.p.xj.xj xjVar, int i) {
        this.y = neVar;
        this.w = context;
        this.u = z;
        this.kd = str;
        this.c = map;
        this.f = xjVar;
        this.d = i;
    }

    public void xj(ws wsVar) {
        this.hf = wsVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(final Map<String, Object> map) {
        boolean xj = !com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj() ? new com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd(this.hf, this.w).xj(this.kd).xj(this.d).hf(this.u).xj(new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.f.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj
            public void hf() {
                if (f.this.xj != null ? f.this.xj.xj(map) : false) {
                    return;
                }
                f.this.f.hf(f.this.c);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj
            public void xj() {
            }
        }) : false;
        com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj(false);
        if (xj) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.xj;
        return xjVar != null && xjVar.xj(map);
    }
}
