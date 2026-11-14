package com.bytedance.sdk.gromore.xj.xj.u;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.gromore.xj.xj.u {
    private com.bytedance.msdk.api.hf xj;

    public xj(com.bytedance.msdk.api.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u
    public String hf() {
        com.bytedance.msdk.api.hf hfVar = this.xj;
        if (hfVar != null) {
            return TextUtils.isEmpty(hfVar.w()) ? this.xj.u() : this.xj.w();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u
    public String kd() {
        com.bytedance.msdk.api.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.y();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u
    public int u() {
        com.bytedance.msdk.api.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.kd();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u
    public String w() {
        com.bytedance.msdk.api.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u
    public String xj() {
        com.bytedance.msdk.api.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }
}
