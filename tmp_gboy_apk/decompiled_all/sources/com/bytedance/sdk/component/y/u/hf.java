package com.bytedance.sdk.component.y.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements d {
    private com.bytedance.sdk.component.y.c hf;
    private byte[] xj;

    public hf(byte[] bArr, com.bytedance.sdk.component.y.c cVar) {
        this.xj = bArr;
        this.hf = cVar;
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        d kdVar;
        int kd = wVar.kd();
        wVar.xj(this.xj.length);
        if (kd == 2) {
            kdVar = com.bytedance.sdk.component.y.w.w.xj.xj(this.xj) ? new kd(this.xj, this.hf) : this.hf == null ? new p() : new f(1001, "not image format", null);
        } else if (kd != 3) {
            boolean hf = com.bytedance.sdk.component.y.w.w.xj.hf(this.xj);
            if (hf) {
                byte[] bArr = this.xj;
                kdVar = new g(bArr, bArr, this.hf, hf);
            } else if (com.bytedance.sdk.component.y.w.w.xj.xj(this.xj)) {
                kdVar = new kd(this.xj, this.hf);
            } else {
                byte[] bArr2 = this.xj;
                kdVar = new g(bArr2, bArr2, this.hf, hf);
            }
        } else {
            byte[] bArr3 = this.xj;
            kdVar = new g(bArr3, bArr3, this.hf, com.bytedance.sdk.component.y.w.w.xj.hf(bArr3));
        }
        wVar.xj(kdVar);
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "image_type";
    }
}
