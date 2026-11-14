package com.bytedance.msdk.w.c.hf;

import android.os.Handler;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj {
    private hf hf;
    private Handler xj;

    @Override // com.bytedance.msdk.w.c.hf.xj
    public void xj(Handler handler, com.bytedance.msdk.core.tf.hf hfVar, hf hfVar2) {
        this.xj = handler;
        this.hf = hfVar2;
        if (handler == null || hfVar2 == null || hfVar == null) {
            return;
        }
        hfVar.y().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(hfVar2, hfVar.f());
    }

    @Override // com.bytedance.msdk.w.c.hf.xj
    public void xj() {
        hf hfVar;
        if (this.xj == null || (hfVar = this.hf) == null || hfVar.xj()) {
            return;
        }
        this.xj.removeCallbacks(this.hf);
        this.hf.run();
    }
}
