package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A2egSU implements Source {
    boolean cacheRequestClosed;
    final /* synthetic */ A4TApA this$0;
    final /* synthetic */ BufferedSink val$cacheBody;
    final /* synthetic */ A5SV6n val$cacheRequest;
    final /* synthetic */ BufferedSource val$source;

    public A2egSU(A4TApA a4TApA, BufferedSource bufferedSource, A5SV6n a5SV6n, BufferedSink bufferedSink) {
        this.this$0 = a4TApA;
        this.val$source = bufferedSource;
        this.val$cacheRequest = a5SV6n;
        this.val$cacheBody = bufferedSink;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z;
        if (!this.cacheRequestClosed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                z = okhttp3.internal.A5SV6n.B4ZgIw(100, this);
            } catch (IOException unused) {
                z = false;
            }
            if (!z) {
                this.cacheRequestClosed = true;
                this.val$cacheRequest.abort();
            }
        }
        this.val$source.close();
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) {
        try {
            long read = this.val$source.read(buffer, j);
            if (read != -1) {
                buffer.copyTo(this.val$cacheBody.buffer(), buffer.size() - read, read);
                this.val$cacheBody.emitCompleteSegments();
                return read;
            }
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.val$cacheBody.close();
            }
            return -1L;
        } catch (IOException e) {
            if (this.cacheRequestClosed) {
                throw e;
            }
            this.cacheRequestClosed = true;
            this.val$cacheRequest.abort();
            throw e;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.val$source.timeout();
    }
}
