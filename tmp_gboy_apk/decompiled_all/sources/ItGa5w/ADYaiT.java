package ItGa5w;

import ADYaiT.CtFAbx;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends FilterInputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final long f4074AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4075AlLFFp;

    public ADYaiT(InputStream inputStream, long j) {
        super(inputStream);
        this.f4074AcNBzu = j;
    }

    public final void A2egSU(int i) {
        if (i >= 0) {
            this.f4075AlLFFp += i;
            return;
        }
        long j = this.f4075AlLFFp;
        long j2 = this.f4074AcNBzu;
        if (j2 - j <= 0) {
            return;
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("Failed to read all expected data, expected: ", j2, ", but read: ");
        B2KMhB2.append(this.f4075AlLFFp);
        throw new IOException(B2KMhB2.toString());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f4074AcNBzu - this.f4075AlLFFp, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        A2egSU(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        A2egSU(read);
        return read;
    }
}
