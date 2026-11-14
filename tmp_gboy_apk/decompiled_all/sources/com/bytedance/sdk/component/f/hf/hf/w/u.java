package com.bytedance.sdk.component.f.hf.hf.w;

import android.os.HandlerThread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends HandlerThread {
    private kd xj;

    public u() {
        super("csj_openlog");
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.w();
        }
    }

    public void xj(kd kdVar) {
        this.xj = kdVar;
    }
}
