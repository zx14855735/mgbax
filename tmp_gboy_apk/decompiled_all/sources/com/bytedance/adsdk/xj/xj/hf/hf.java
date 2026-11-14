package com.bytedance.adsdk.xj.xj.hf;

import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends u {
    public void hf(int i) {
        xj((byte) ((i >> 24) & 255));
        xj((byte) ((i >> 16) & 255));
        xj((byte) ((i >> 8) & 255));
        xj((byte) (i & 255));
    }

    @Override // com.bytedance.adsdk.xj.xj.hf.u
    public void w(int i) {
        super.w(i);
        this.xj.order(ByteOrder.BIG_ENDIAN);
    }

    public void xj(int i) {
        xj((byte) (i & 255));
        xj((byte) ((i >> 8) & 255));
        xj((byte) ((i >> 16) & 255));
        xj((byte) ((i >> 24) & 255));
    }
}
