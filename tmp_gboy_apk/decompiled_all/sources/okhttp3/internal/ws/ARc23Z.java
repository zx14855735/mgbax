package okhttp3.internal.ws;

import com.sigmob.sdk.base.views.r;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final A2egSU frameSink = new A2egSU();
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    public final class A2egSU implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        public A2egSU() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                throw new IOException("closed");
            }
            ARc23Z aRc23Z = ARc23Z.this;
            aRc23Z.A4TApA(aRc23Z.buffer.size(), this.formatOpcode, this.isFirstFrame, true);
            this.closed = true;
            ARc23Z.this.activeWriter = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            if (this.closed) {
                throw new IOException("closed");
            }
            ARc23Z aRc23Z = ARc23Z.this;
            aRc23Z.A4TApA(aRc23Z.buffer.size(), this.formatOpcode, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return ARc23Z.this.sink.timeout();
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) {
            if (this.closed) {
                throw new IOException("closed");
            }
            ARc23Z.this.buffer.write(buffer, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && ARc23Z.this.buffer.size() > this.contentLength - 8192;
            long completeSegmentByteCount = ARc23Z.this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount <= 0 || z) {
                return;
            }
            ARc23Z.this.A4TApA(completeSegmentByteCount, this.formatOpcode, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    public ARc23Z(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.isClient = z;
        this.sink = bufferedSink;
        this.sinkBuffer = bufferedSink.buffer();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
    }

    public final void A2egSU(int i, ByteString byteString) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i | r.b.d);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | r.b.d);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                A5SV6n.A4TApA(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    public final void A4TApA(long j, int i, boolean z, boolean z2) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= r.b.d;
        }
        this.sinkBuffer.writeByte(i);
        int i2 = this.isClient ? r.b.d : 0;
        if (j <= 125) {
            this.sinkBuffer.writeByte(((int) j) | i2);
        } else if (j <= 65535) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) j);
        } else {
            this.sinkBuffer.writeByte(i2 | 127);
            this.sinkBuffer.writeLong(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                A5SV6n.A4TApA(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.emit();
    }
}
