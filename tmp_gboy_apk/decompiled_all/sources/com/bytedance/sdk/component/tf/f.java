package com.bytedance.sdk.component.tf;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {
    private int hf;
    private int xj;

    public f(Callable<V> callable, int i, int i2) {
        super(callable);
        this.xj = i == -1 ? 5 : i;
        this.hf = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        if (xj() < fVar.xj()) {
            return 1;
        }
        return xj() > fVar.xj() ? -1 : 0;
    }

    public int xj() {
        return this.xj;
    }

    public f(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.xj = i == -1 ? 5 : i;
        this.hf = i2;
    }
}
