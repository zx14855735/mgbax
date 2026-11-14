package com.bytedance.sdk.component.f.hf.u.hf;

import com.baidu.mobads.sdk.internal.bn;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private int hf;
    private int xj;

    public xj(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.xj = i;
        this.hf = i2;
    }

    public static xj w() {
        return new xj(1, 100, bn.e);
    }

    public int hf() {
        return this.hf;
    }

    public int xj() {
        return this.xj;
    }

    public static xj xj(int i, int i2) {
        return new xj(i, i2, bn.e);
    }

    public static xj xj(int i, int i2, long j) {
        return new xj(i, i2, j);
    }
}
