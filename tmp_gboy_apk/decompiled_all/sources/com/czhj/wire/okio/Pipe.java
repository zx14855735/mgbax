package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Pipe {

    /* renamed from: a, reason: collision with root package name */
    final long f10700a;
    boolean c;
    boolean d;
    private Sink g;
    final Buffer b = new Buffer();
    private final Sink e = new PipeSink();
    private final Source f = new PipeSource();

    public final class PipeSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        final PushableTimeout f10701a = new PushableTimeout();

        public PipeSink() {
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Sink sink;
            synchronized (Pipe.this.b) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.c) {
                        return;
                    }
                    if (pipe.g != null) {
                        sink = Pipe.this.g;
                    } else {
                        Pipe pipe2 = Pipe.this;
                        if (pipe2.d && pipe2.b.size() > 0) {
                            throw new IOException("source is closed");
                        }
                        Pipe pipe3 = Pipe.this;
                        pipe3.c = true;
                        pipe3.b.notifyAll();
                        sink = null;
                    }
                    if (sink != null) {
                        this.f10701a.a(sink.timeout());
                        try {
                            sink.close();
                        } finally {
                            this.f10701a.a();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Flushable
        public void flush() {
            Sink sink;
            synchronized (Pipe.this.b) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.c) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.g != null) {
                        sink = Pipe.this.g;
                    } else {
                        Pipe pipe2 = Pipe.this;
                        if (pipe2.d && pipe2.b.size() > 0) {
                            throw new IOException("source is closed");
                        }
                        sink = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (sink != null) {
                this.f10701a.a(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.f10701a.a();
                }
            }
        }

        @Override // com.czhj.wire.okio.Sink
        public Timeout timeout() {
            return this.f10701a;
        }

        @Override // com.czhj.wire.okio.Sink
        public void write(Buffer buffer, long j) {
            Sink sink;
            synchronized (Pipe.this.b) {
                try {
                    if (!Pipe.this.c) {
                        while (true) {
                            if (j <= 0) {
                                sink = null;
                                break;
                            }
                            if (Pipe.this.g != null) {
                                sink = Pipe.this.g;
                                break;
                            }
                            Pipe pipe = Pipe.this;
                            if (pipe.d) {
                                throw new IOException("source is closed");
                            }
                            long size = pipe.f10700a - pipe.b.size();
                            if (size == 0) {
                                this.f10701a.waitUntilNotified(Pipe.this.b);
                            } else {
                                long min = Math.min(size, j);
                                Pipe.this.b.write(buffer, min);
                                j -= min;
                                Pipe.this.b.notifyAll();
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (sink != null) {
                this.f10701a.a(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.f10701a.a();
                }
            }
        }
    }

    public final class PipeSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        final Timeout f10702a = new Timeout();

        public PipeSource() {
        }

        @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Pipe.this.b) {
                Pipe pipe = Pipe.this;
                pipe.d = true;
                pipe.b.notifyAll();
            }
        }

        @Override // com.czhj.wire.okio.Source
        public long read(Buffer buffer, long j) {
            synchronized (Pipe.this.b) {
                try {
                    if (Pipe.this.d) {
                        throw new IllegalStateException("closed");
                    }
                    while (Pipe.this.b.size() == 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.c) {
                            return -1L;
                        }
                        this.f10702a.waitUntilNotified(pipe.b);
                    }
                    long read = Pipe.this.b.read(buffer, j);
                    Pipe.this.b.notifyAll();
                    return read;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.czhj.wire.okio.Source
        public Timeout timeout() {
            return this.f10702a;
        }
    }

    public Pipe(long j) {
        if (j < 1) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("maxBufferSize < 1: ", j));
        }
        this.f10700a = j;
    }

    public void fold(Sink sink) {
        boolean z;
        Buffer buffer;
        while (true) {
            synchronized (this.b) {
                try {
                    if (this.g != null) {
                        throw new IllegalStateException("sink already folded");
                    }
                    if (this.b.exhausted()) {
                        this.d = true;
                        this.g = sink;
                        return;
                    } else {
                        z = this.c;
                        buffer = new Buffer();
                        Buffer buffer2 = this.b;
                        buffer.write(buffer2, buffer2.c);
                        this.b.notifyAll();
                    }
                } finally {
                }
            }
            try {
                sink.write(buffer, buffer.c);
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.b) {
                    this.d = true;
                    this.b.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final Sink sink() {
        return this.e;
    }

    public final Source source() {
        return this.f;
    }
}
