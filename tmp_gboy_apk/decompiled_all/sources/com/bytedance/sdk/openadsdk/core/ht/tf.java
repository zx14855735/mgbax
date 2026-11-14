package com.bytedance.sdk.openadsdk.core.ht;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class tf implements com.bytedance.sdk.component.f.xj.xj.hf {
    com.bytedance.sdk.component.d.hf.w xj;

    public tf(com.bytedance.sdk.component.d.hf.w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.hf
    public void xj(String str) {
        com.bytedance.sdk.component.d.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(str);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.hf
    public void xj(String str, String str2) {
        com.bytedance.sdk.component.d.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.hf(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.hf
    public com.bytedance.sdk.component.f.xj.xj.kd xj() {
        com.bytedance.sdk.component.d.hf.w wVar = this.xj;
        if (wVar == null) {
            return null;
        }
        return new p(wVar.xj());
    }
}
