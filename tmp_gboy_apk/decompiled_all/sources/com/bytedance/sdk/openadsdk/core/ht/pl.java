package com.bytedance.sdk.openadsdk.core.ht;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class pl implements com.bytedance.sdk.component.f.xj.xj.y {
    com.bytedance.sdk.component.d.hf.kd xj;

    public pl(com.bytedance.sdk.component.d.hf.kd kdVar) {
        this.xj = kdVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public void hf(String str) {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.w(str);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public void xj(String str) {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.xj(str);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public void xj(String str, byte[] bArr) {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.xj(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public void xj(String str, String str2) {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.hf(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public com.bytedance.sdk.component.f.xj.xj.kd xj() {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar == null) {
            return null;
        }
        return new p(kdVar.xj());
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.y
    public void xj(final com.bytedance.sdk.component.f.xj.xj.w wVar) {
        com.bytedance.sdk.component.d.hf.kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.pl.1
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (wVar != null) {
                        wVar.xj(new y(uVar), new c(hfVar));
                    }
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    if (wVar != null) {
                        wVar.xj(new y(uVar), iOException);
                    }
                }
            });
        }
    }
}
