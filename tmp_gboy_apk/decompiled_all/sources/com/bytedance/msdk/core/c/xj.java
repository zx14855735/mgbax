package com.bytedance.msdk.core.c;

import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;
    private long hf;
    private final Queue<Long> u = new LinkedList();
    private long w;

    private xj() {
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public boolean hf() {
        synchronized (xj.class) {
            try {
                if (this.hf > 0 && this.w > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.u.size() >= this.hf) {
                        while (this.u.size() > this.hf) {
                            this.u.poll();
                        }
                        if (Math.abs(currentTimeMillis - this.u.peek().longValue()) <= this.w) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } finally {
            }
        }
    }

    public void xj(long j, long j2) {
        synchronized (xj.class) {
            try {
                if (this.hf == j) {
                    if (this.w != j2) {
                    }
                }
                this.hf = j;
                this.w = j2;
                this.u.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
