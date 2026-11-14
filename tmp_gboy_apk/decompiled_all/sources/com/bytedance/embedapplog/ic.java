package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.qi;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ic extends qi.xj {
    private volatile String xj = "";

    public String hf() {
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
        this.xj = bundle.getString("oa_id_flag");
    }
}
