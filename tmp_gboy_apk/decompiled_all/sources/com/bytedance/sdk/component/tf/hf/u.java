package com.bytedance.sdk.component.tf.hf;

import com.bytedance.sdk.component.tf.hf.w;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u<T extends w> {
    private BlockingQueue<T> hf = new LinkedBlockingQueue();
    private int xj;

    private u(int i) {
        this.xj = i;
    }

    public static u xj(int i) {
        return new u(i);
    }

    public T xj() {
        return this.hf.poll();
    }

    public boolean xj(T t) {
        if (t == null) {
            return false;
        }
        t.xj();
        if (this.hf.size() >= this.xj) {
            return false;
        }
        return this.hf.offer(t);
    }
}
