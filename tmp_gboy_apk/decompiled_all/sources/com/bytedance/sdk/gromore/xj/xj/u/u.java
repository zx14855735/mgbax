package com.bytedance.sdk.gromore.xj.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.sdk.openadsdk.zg.w.hf.kd {
    private com.bytedance.msdk.hf.w xj;

    public u(com.bytedance.msdk.hf.w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.kd
    public void hf() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.kd
    public void xj() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            if (wVar.u() == 3) {
                this.xj.hf();
            } else if (this.xj.u() == 2) {
                this.xj.xj();
            }
        }
    }
}
