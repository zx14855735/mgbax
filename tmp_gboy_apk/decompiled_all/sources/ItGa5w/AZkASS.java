package ItGa5w;

import java.io.FilterInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends FilterInputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f4087AcNBzu;

    public AZkASS(AMqCpz aMqCpz) {
        super(aMqCpz);
        this.f4087AcNBzu = Integer.MIN_VALUE;
    }

    public final long A2egSU(long j) {
        int i = this.f4087AcNBzu;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    public final void A4TApA(long j) {
        int i = this.f4087AcNBzu;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f4087AcNBzu = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i = this.f4087AcNBzu;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        super.mark(i);
        this.f4087AcNBzu = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (A2egSU(1L) == -1) {
            return -1;
        }
        int read = super.read();
        A4TApA(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f4087AcNBzu = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        long A2egSU2 = A2egSU(j);
        if (A2egSU2 == -1) {
            return 0L;
        }
        long skip = super.skip(A2egSU2);
        A4TApA(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int A2egSU2 = (int) A2egSU(i2);
        if (A2egSU2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, A2egSU2);
        A4TApA(read);
        return read;
    }
}
