package H0R8Px;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements Closeable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final InputStream[] f3137AcNBzu;

    public ADYaiT(InputStream[] inputStreamArr) {
        this.f3137AcNBzu = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (InputStream inputStream : this.f3137AcNBzu) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
    }
}
