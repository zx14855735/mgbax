package H0R8Px;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends FilterOutputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ G58fqA.A2egSU f3132AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4TApA(G58fqA.A2egSU a2egSU, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.f3132AcNBzu = a2egSU;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException unused) {
            this.f3132AcNBzu.f2977A2egSU = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException unused) {
            this.f3132AcNBzu.f2977A2egSU = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        try {
            ((FilterOutputStream) this).out.write(i);
        } catch (IOException unused) {
            this.f3132AcNBzu.f2977A2egSU = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        try {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
        } catch (IOException unused) {
            this.f3132AcNBzu.f2977A2egSU = true;
        }
    }
}
