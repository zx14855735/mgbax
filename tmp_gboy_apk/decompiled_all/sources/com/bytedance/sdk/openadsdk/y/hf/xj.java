package com.bytedance.sdk.openadsdk.y.hf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private int hf = 0;
    public Map<Integer, Long> xj = new ConcurrentHashMap();

    public Long hf(int i) {
        try {
            if (xj(i)) {
                return this.xj.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public boolean u(int i) {
        return i == this.hf;
    }

    public void w(int i) {
        if (xj(i)) {
            return;
        }
        this.hf |= i;
        try {
            this.xj.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public void xj() {
        this.hf = 0;
        try {
            this.xj.clear();
        } catch (Exception unused) {
        }
    }

    public boolean xj(int i) {
        return (this.hf & i) == i;
    }
}
