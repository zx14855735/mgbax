package com.bytedance.sdk.component.w.hf.xj.hf;

import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.w.hf.ai;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements jk {
    public final ra xj;

    public xj(ra raVar) {
        this.xj = raVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk
    public q xj(jk.xj xjVar) {
        ai aiVar;
        com.bytedance.sdk.component.w.hf.xj.w.c cVar = (com.bytedance.sdk.component.w.hf.xj.w.c) xjVar;
        io xj = cVar.xj();
        if (xj != null && (aiVar = xj.y) != null) {
            aiVar.hf();
        }
        c y = cVar.y();
        com.bytedance.sdk.component.w.hf.xj.w.w xj2 = y.xj(this.xj, xjVar, !xj.hf().equals(an.c));
        w hf = y.hf();
        ai aiVar2 = xj.y;
        if (aiVar2 != null) {
            aiVar2.w();
        }
        return cVar.xj(xj, y, xj2, hf);
    }
}
