package com.bytedance.adsdk.xj.xj.hf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements y {
    private final ByteBuffer xj;

    public w(ByteBuffer byteBuffer) {
        this.xj = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public byte c_() {
        return this.xj.get();
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public void d_() {
        this.xj.position(0);
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public InputStream kd() {
        return new ByteArrayInputStream(this.xj.array());
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public int u() {
        return this.xj.limit() - this.xj.position();
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public int w() {
        return this.xj.position();
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public long xj(long j) {
        this.xj.position((int) (r0.position() + j));
        return j;
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.y
    public int xj(byte[] bArr, int i, int i2) {
        this.xj.get(bArr, i, i2);
        return i2;
    }
}
