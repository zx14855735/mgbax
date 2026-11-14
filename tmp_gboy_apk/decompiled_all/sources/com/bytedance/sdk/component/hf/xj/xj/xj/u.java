package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.w.hf.q;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements com.bytedance.sdk.component.hf.xj.hf {
    com.bytedance.sdk.component.w.hf.kd xj;

    public u(com.bytedance.sdk.component.w.hf.kd kdVar) {
        this.xj = kdVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public zg hf() {
        return new d(this.xj.hf());
    }

    /* renamed from: kd, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.hf.xj.hf clone() {
        return new u(this.xj.kd());
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public boolean u() {
        return this.xj.u();
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public void w() {
        this.xj.w();
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public am xj() {
        return new f(this.xj.xj());
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public void xj(final com.bytedance.sdk.component.hf.xj.w wVar) {
        this.xj.xj(new com.bytedance.sdk.component.w.hf.y() { // from class: com.bytedance.sdk.component.hf.xj.xj.xj.u.1
            @Override // com.bytedance.sdk.component.w.hf.y
            public void xj(com.bytedance.sdk.component.w.hf.kd kdVar, IOException iOException) {
                wVar.onFailure(new u(kdVar), iOException);
            }

            @Override // com.bytedance.sdk.component.w.hf.y
            public void xj(com.bytedance.sdk.component.w.hf.kd kdVar, q qVar) {
                wVar.onResponse(new u(kdVar), new d(qVar));
            }
        });
    }
}
