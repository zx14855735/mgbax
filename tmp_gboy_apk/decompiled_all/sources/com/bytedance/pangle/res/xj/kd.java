package com.bytedance.pangle.res.xj;

import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends tf {
    private long xj;

    public kd(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized long hf() {
        return this.xj;
    }

    @Override // com.bytedance.pangle.res.xj.tf, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        long skip;
        skip = super.skip(j);
        this.xj += skip;
        return skip;
    }

    @Override // com.bytedance.pangle.res.xj.tf
    public synchronized void xj(int i) {
        if (i != -1) {
            this.xj += i;
        }
    }

    public int xj() {
        long hf = hf();
        if (hf <= 2147483647L) {
            return (int) hf;
        }
        throw new ArithmeticException("The byte count " + hf + " is too large to be converted to an int");
    }
}
