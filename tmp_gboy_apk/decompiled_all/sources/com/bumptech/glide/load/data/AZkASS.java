package com.bumptech.glide.load.data;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.archives.tar.e;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends FilterInputStream {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final byte[] f9985AmA8tU = {-1, -31, 0, 28, 69, e.R, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final int f9986AzWtSf = 31;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final byte f9987AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f9988AlLFFp;

    public AZkASS(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Cannot add invalid orientation: "));
        }
        this.f9987AcNBzu = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i;
        int i2 = this.f9988AlLFFp;
        int read = (i2 < 2 || i2 > (i = f9986AzWtSf)) ? super.read() : i2 == i ? this.f9987AcNBzu : f9985AmA8tU[i2 - 2] & 255;
        if (read != -1) {
            this.f9988AlLFFp++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f9988AlLFFp = (int) (this.f9988AlLFFp + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f9988AlLFFp;
        int i5 = f9986AzWtSf;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f9987AcNBzu;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f9985AmA8tU, this.f9988AlLFFp - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f9988AlLFFp += i3;
        }
        return i3;
    }
}
