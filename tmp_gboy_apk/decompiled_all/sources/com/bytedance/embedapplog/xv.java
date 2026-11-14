package com.bytedance.embedapplog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class xv<T> {
    private volatile T xj;

    public final T hf(Object... objArr) {
        if (this.xj == null) {
            synchronized (this) {
                try {
                    if (this.xj == null) {
                        this.xj = xj(objArr);
                    }
                } finally {
                }
            }
        }
        return this.xj;
    }

    public abstract T xj(Object... objArr);
}
