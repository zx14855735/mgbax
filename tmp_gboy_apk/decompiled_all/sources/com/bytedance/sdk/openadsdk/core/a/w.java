package com.bytedance.sdk.openadsdk.core.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements com.bytedance.sdk.component.u.xj.w {
    public final float hf;
    public final long w;
    public final float xj;

    public w(float f, float f2, long j) {
        this.xj = f;
        this.hf = f2;
        this.w = j;
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public long getLastTime() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public float getLatitude() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.u.xj.w
    public float getLongitude() {
        return this.hf;
    }
}
