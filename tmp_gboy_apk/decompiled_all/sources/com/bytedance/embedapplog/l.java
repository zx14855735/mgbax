package com.bytedance.embedapplog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class l {
    private int hf = 0;
    private volatile boolean u;
    private boolean w;
    final a xj;

    public l(a aVar) {
        this.xj = aVar;
    }

    public final long c() {
        boolean z;
        long j;
        long xj = xj();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.u) {
            this.u = false;
            xj = 0;
        }
        if (xj > 1000 + currentTimeMillis) {
            return xj - currentTimeMillis;
        }
        try {
            z = w();
        } catch (Exception e) {
            cu.hf(e);
            z = false;
        }
        if (z) {
            this.hf = 0;
            j = xj() - System.currentTimeMillis();
        } else {
            long[] hf = hf();
            int i = this.hf;
            this.hf = i + 1;
            j = hf[i % hf.length];
        }
        cu.u(u() + " worked:" + z + " " + j, null);
        return j;
    }

    public void f() {
        cu.xj("setImmediately, " + u());
        this.u = true;
    }

    public abstract long[] hf();

    public void kd() {
        this.w = true;
    }

    public abstract String u();

    public abstract boolean w();

    public abstract long xj();

    public boolean y() {
        return this.w;
    }
}
