package com.bytedance.sdk.component.y.hf;

import com.bytedance.sdk.component.y.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements f {
    private long hf;
    private long w;
    private long xj;

    @Override // com.bytedance.sdk.component.y.f
    public long getEndRequestTime() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.f
    public long getFirstFrameTime() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.f
    public long getStartRequestTime() {
        return this.xj;
    }

    public void hf(long j) {
        this.hf = j;
    }

    public void w(long j) {
        this.w = j;
    }

    public void xj(long j) {
        this.xj = j;
    }
}
