package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.w.hf.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements d.xj {
    jk.xj xj;

    public kd(jk.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.d.xj
    public am xj() {
        return new f(this.xj.xj());
    }

    @Override // com.bytedance.sdk.component.hf.xj.d.xj
    public zg xj(am amVar) {
        return new d(this.xj.xj(this.xj.xj().y().xj(amVar.hf().xj()).xj()));
    }
}
