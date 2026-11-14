package com.bytedance.adsdk.xj.xj.hf;

import com.sigmob.sdk.archives.tar.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements c {
    protected ByteBuffer xj;

    public u() {
        w(d.b);
    }

    public byte[] hf() {
        return this.xj.array();
    }

    public void u(int i) {
        this.xj.position(xj() + i);
    }

    public void w(int i) {
        ByteBuffer byteBuffer = this.xj;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            this.xj = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.xj.clear();
    }

    public void xj(byte b) {
        this.xj.put(b);
    }

    public void xj(byte[] bArr) {
        this.xj.put(bArr);
    }

    public int xj() {
        return this.xj.position();
    }
}
