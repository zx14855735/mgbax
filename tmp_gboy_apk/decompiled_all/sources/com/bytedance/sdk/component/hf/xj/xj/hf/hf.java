package com.bytedance.sdk.component.hf.xj.xj.hf;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.zg;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements d.xj {
    am hf;
    int w = 0;
    List<d> xj;

    public hf(List<d> list, am amVar) {
        this.xj = list;
        this.hf = amVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.d.xj
    public am xj() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.hf.xj.d.xj
    public zg xj(am amVar) {
        this.hf = amVar;
        int i = this.w + 1;
        this.w = i;
        return this.xj.get(i).xj(this);
    }
}
