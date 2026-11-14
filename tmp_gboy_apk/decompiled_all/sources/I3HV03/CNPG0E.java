package I3HV03;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CNPG0E extends MediaDataSource {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f3872AcNBzu;

    public CNPG0E(ByteBuffer byteBuffer) {
        this.f3872AcNBzu = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f3872AcNBzu.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.f3872AcNBzu.limit()) {
            return -1;
        }
        this.f3872AcNBzu.position((int) j);
        int min = Math.min(i2, this.f3872AcNBzu.remaining());
        this.f3872AcNBzu.get(bArr, i, min);
        return min;
    }
}
