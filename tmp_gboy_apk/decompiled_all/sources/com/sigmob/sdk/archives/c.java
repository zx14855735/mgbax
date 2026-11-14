package com.sigmob.sdk.archives;

import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class c extends InputStream {
    private static final int b = 255;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f13022a = new byte[1];
    private long c = 0;

    public abstract a a();

    public void a(int i) {
        b(i);
    }

    @Deprecated
    public int b() {
        return (int) this.c;
    }

    public long c() {
        return this.c;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f13022a, 0, 1) == -1) {
            return -1;
        }
        return this.f13022a[0] & 255;
    }

    private void b(long j) {
        if (j != -1) {
            this.c += j;
        }
    }

    public void a(long j) {
        this.c -= j;
    }

    public boolean a(a aVar) {
        return true;
    }
}
