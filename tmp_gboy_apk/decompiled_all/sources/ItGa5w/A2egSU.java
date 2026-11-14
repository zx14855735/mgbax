package ItGa5w;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends InputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ByteBuffer f4070AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4071AlLFFp = -1;

    public A2egSU(ByteBuffer byteBuffer) {
        this.f4070AcNBzu = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f4070AcNBzu.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.f4071AlLFFp = this.f4070AcNBzu.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f4070AcNBzu;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.f4071AlLFFp;
        if (i == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f4070AcNBzu.position(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        ByteBuffer byteBuffer = this.f4070AcNBzu;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.f4070AcNBzu;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, min);
        return min;
    }
}
