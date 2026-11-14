package D6DOie;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends MediaDataSource {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public long f1941AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ A4TApA f1942AlLFFp;

    public A2egSU(A4TApA a4TApA) {
        this.f1942AlLFFp = a4TApA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.f1941AcNBzu;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + this.f1942AlLFFp.f1945AcNBzu.available()) {
                    return -1;
                }
                this.f1942AlLFFp.seek(j);
                this.f1941AcNBzu = j;
            }
            if (i2 > this.f1942AlLFFp.f1945AcNBzu.available()) {
                i2 = this.f1942AlLFFp.f1945AcNBzu.available();
            }
            int read = this.f1942AlLFFp.read(bArr, i, i2);
            if (read >= 0) {
                this.f1941AcNBzu += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f1941AcNBzu = -1L;
        return -1;
    }
}
