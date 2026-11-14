package com.bytedance.msdk.w.u;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.core.kd.hf.u;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends hf implements com.bytedance.msdk.core.kd.hf.hf {
    public w(Context context) {
        super(context);
    }

    @Override // com.bytedance.msdk.core.kd.hf.hf
    public int e_() {
        com.bytedance.msdk.w.y.xj.hf hfVar = this.w;
        if (hfVar != null) {
            return hfVar.io();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.core.kd.hf.hf
    public com.bytedance.msdk.w.y.xj.hf u() {
        return this.w;
    }

    @Override // com.bytedance.msdk.core.kd.hf.hf
    public ConcurrentHashMap<String, com.bytedance.msdk.api.hf> w() {
        com.bytedance.msdk.w.y.xj.hf hfVar = this.w;
        if (hfVar != null) {
            return hfVar.dk();
        }
        return null;
    }

    @Override // com.bytedance.msdk.core.kd.hf.hf
    public void xj(Context context, com.bytedance.msdk.api.xj.hf hfVar, u.w wVar) {
        xj(hfVar);
        this.w.hf(true);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.w.xj(currentThreadTimeMillis);
        this.w.xj(wVar);
        com.bytedance.msdk.core.kd.hf.u.xj().xj(this.kd, currentThreadTimeMillis);
        d();
    }
}
