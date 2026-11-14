package com.kwad.components.core.p;

import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c extends InputStream {
    private InputStream abE;
    private int abF;
    private volatile float abH;
    private volatile long abI;
    private int abB = -1;
    private int abC = 10000;
    private long abD = -1;
    private long abG = -1;
    private int abJ = 20480;

    public c(InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.abE = inputStream;
        this.abH = i / 1000.0f;
    }

    private static void N(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private void tY() {
        this.abB = 0;
        this.abD = System.currentTimeMillis();
    }

    private void tZ() {
        if (this.abB < this.abC) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.abD;
        float f = this.abB / this.abH;
        this.abI = g(this.abF, currentTimeMillis - this.abG);
        float f2 = j;
        if (f > f2) {
            N((long) (f - f2));
        }
        tY();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.abE.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.abE.close();
        b.a(this);
        this.abG = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.abE.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.abE.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.abG <= 0) {
            this.abG = System.currentTimeMillis();
        }
        this.abF++;
        if (!b.abz || !b.aby) {
            return this.abE.read();
        }
        if (this.abB < 0) {
            tY();
        }
        int read = this.abE.read();
        this.abB++;
        tZ();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.abE.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.abE.skip(j);
    }

    public final long tX() {
        return this.abI;
    }
}
