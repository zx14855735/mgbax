package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AZOQYO extends ForwardingSink {
    private boolean hasErrors;

    public AZOQYO(Sink sink) {
        super(sink);
    }

    public void A2egSU() {
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException unused) {
            this.hasErrors = true;
            A2egSU();
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException unused) {
            this.hasErrors = true;
            A2egSU();
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer buffer, long j) {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException unused) {
            this.hasErrors = true;
            A2egSU();
        }
    }
}
