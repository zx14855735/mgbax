package com.bytedance.pangle.f;

import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class f implements p {
    private final ByteBuffer xj;

    public f(ByteBuffer byteBuffer) {
        this.xj = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.f.p
    public long xj() {
        return this.xj.capacity();
    }

    @Override // com.bytedance.pangle.f.p
    public void xj(tf tfVar, long j, int i) {
        ByteBuffer slice;
        synchronized (this.xj) {
            this.xj.position(0);
            int i2 = (int) j;
            this.xj.limit(i + i2);
            this.xj.position(i2);
            slice = this.xj.slice();
        }
        tfVar.xj(slice);
    }
}
