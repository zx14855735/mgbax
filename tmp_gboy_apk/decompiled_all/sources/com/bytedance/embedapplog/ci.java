package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.qi;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ci extends qi.xj {
    private volatile boolean xj = false;

    public boolean hf() {
        return this.xj;
    }

    @Override // com.bytedance.embedapplog.qi
    public void xj(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.qi
    public void xj(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.xj = bundle.getBoolean("oa_id_limit_state");
    }
}
