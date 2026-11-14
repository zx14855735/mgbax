package com.bytedance.sdk.openadsdk.core.ht;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class c implements com.bytedance.sdk.component.f.xj.xj.kd {
    private com.bytedance.sdk.component.d.hf xj;

    public c(com.bytedance.sdk.component.d.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.kd
    public String hf() {
        com.bytedance.sdk.component.d.hf hfVar = this.xj;
        return hfVar != null ? hfVar.u() : "";
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.kd
    public Map<String, String> kd() {
        com.bytedance.sdk.component.d.hf hfVar = this.xj;
        return hfVar != null ? hfVar.w() : new HashMap();
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.kd
    public String u() {
        com.bytedance.sdk.component.d.hf hfVar = this.xj;
        return hfVar != null ? hfVar.hf() : "";
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.kd
    public int w() {
        com.bytedance.sdk.component.d.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.kd
    public boolean xj() {
        com.bytedance.sdk.component.d.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.f();
        }
        return false;
    }
}
