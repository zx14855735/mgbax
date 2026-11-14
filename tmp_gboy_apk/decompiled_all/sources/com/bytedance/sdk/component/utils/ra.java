package com.bytedance.sdk.component.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ra {
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> xj = new ConcurrentHashMap<>();

    public void hf(int i) {
        this.xj.remove(Integer.valueOf(i));
    }

    public void w(int i) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> remove = this.xj.remove(Integer.valueOf(i));
        if (remove != null) {
            for (Map.Entry<Integer, Runnable> entry : remove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }

    public void xj(int i, int i2, Runnable runnable) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.xj.get(Integer.valueOf(i));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.xj.put(Integer.valueOf(i), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i2), runnable);
    }

    public abstract boolean xj(int i);

    public void xj(int i, int i2) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i <= 0 || i2 <= 0 || (concurrentHashMap = this.xj.get(Integer.valueOf(i))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i2));
    }
}
