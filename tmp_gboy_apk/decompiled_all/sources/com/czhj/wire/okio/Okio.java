package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Okio {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f10695a = Logger.getLogger(Okio.class.getName());

    static {
        djCT();
    }

    private Okio() {
    }

    private static AsyncTimeout a(final Socket socket) {
        return new AsyncTimeout() { // from class: com.czhj.wire.okio.Okio.4
            @Override // com.czhj.wire.okio.AsyncTimeout
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.czhj.wire.okio.AsyncTimeout
            public void timedOut() {
                Level level;
                StringBuilder sb;
                Logger logger;
                Exception exc;
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!Okio.a(e)) {
                        throw e;
                    }
                    Logger logger2 = Okio.f10695a;
                    level = Level.WARNING;
                    sb = new StringBuilder("Failed to close timed out socket ");
                    exc = e;
                    logger = logger2;
                    sb.append(socket);
                    logger.log(level, sb.toString(), (Throwable) exc);
                } catch (Exception e2) {
                    Logger logger3 = Okio.f10695a;
                    level = Level.WARNING;
                    sb = new StringBuilder("Failed to close timed out socket ");
                    exc = e2;
                    logger = logger3;
                    sb.append(socket);
                    logger.log(level, sb.toString(), (Throwable) exc);
                }
            }
        };
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.czhj.wire.okio.Okio.3
            @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Flushable
            public void flush() {
            }

            @Override // com.czhj.wire.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.czhj.wire.okio.Sink
            public void write(Buffer buffer, long j) {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    private static /* synthetic */ void djCT() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(File file) {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    private static Sink a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: com.czhj.wire.okio.Okio.1
                @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    outputStream.close();
                }

                @Override // com.czhj.wire.okio.Sink, java.io.Flushable
                public void flush() {
                    outputStream.flush();
                }

                @Override // com.czhj.wire.okio.Sink
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.czhj.wire.okio.Sink
                public void write(Buffer buffer, long j) {
                    Util.checkOffsetAndCount(buffer.c, 0L, j);
                    while (j > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.b;
                        int min = (int) Math.min(j, segment.e - segment.d);
                        outputStream.write(segment.c, segment.d, min);
                        int i = segment.d + min;
                        segment.d = i;
                        long j2 = min;
                        j -= j2;
                        buffer.c -= j2;
                        if (i == segment.e) {
                            buffer.b = segment.pop();
                            SegmentPool.a(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static Sink sink(OutputStream outputStream) {
        return a(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return a(inputStream, new Timeout());
    }

    private static Source a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: com.czhj.wire.okio.Okio.2
                @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    inputStream.close();
                }

                @Override // com.czhj.wire.okio.Source
                public long read(Buffer buffer, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        Timeout.this.throwIfReached();
                        Segment a2 = buffer.a(1);
                        int read = inputStream.read(a2.c, a2.e, (int) Math.min(j, 8192 - a2.e));
                        if (read != -1) {
                            a2.e += read;
                            long j2 = read;
                            buffer.c += j2;
                            return j2;
                        }
                        if (a2.d != a2.e) {
                            return -1L;
                        }
                        buffer.b = a2.pop();
                        SegmentPool.a(a2);
                        return -1L;
                    } catch (AssertionError e) {
                        if (Okio.a(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    }
                }

                @Override // com.czhj.wire.okio.Source
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout a2 = a(socket);
        return a2.sink(a(socket.getOutputStream(), a2));
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout a2 = a(socket);
        return a2.source(a(socket.getInputStream(), a2));
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) {
        OutputStream newOutputStream;
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                throw new IOException("no support os version");
            }
            newOutputStream = Files.newOutputStream(path, openOptionArr);
            return sink(newOutputStream);
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    public static Source source(Path path, OpenOption... openOptionArr) {
        InputStream newInputStream;
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                throw new IOException("no support os version");
            }
            newInputStream = Files.newInputStream(path, openOptionArr);
            return source(newInputStream);
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }
}
