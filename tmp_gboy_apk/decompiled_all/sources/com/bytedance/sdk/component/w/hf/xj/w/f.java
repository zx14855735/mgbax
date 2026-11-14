package com.bytedance.sdk.component.w.hf.xj.w;

import com.bytedance.sdk.component.w.hf.pz;
import com.bytedance.sdk.component.w.hf.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f extends z {
    private final long hf;
    private final com.bytedance.sdk.component.w.xj.kd w;
    private final String xj;

    public f(String str, long j, com.bytedance.sdk.component.w.xj.kd kdVar) {
        this.xj = str;
        this.hf = j;
        this.w = kdVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.z
    public long hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.w.hf.z
    public com.bytedance.sdk.component.w.xj.kd w() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.w.hf.z
    public pz xj() {
        String str = this.xj;
        if (str != null) {
            return pz.xj(str);
        }
        return null;
    }
}
