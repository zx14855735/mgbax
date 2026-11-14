package com.google.gson.internal;

import java.io.Writer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends Writer {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Appendable f12062AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AzWtSf f12063AlLFFp = new AzWtSf();

    public B25kr6(Appendable appendable) {
        this.f12062AcNBzu = appendable;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        AzWtSf azWtSf = this.f12063AlLFFp;
        azWtSf.f12061AcNBzu = cArr;
        this.f12062AcNBzu.append(azWtSf, i, i2 + i);
    }

    @Override // java.io.Writer
    public final void write(int i) {
        this.f12062AcNBzu.append((char) i);
    }
}
