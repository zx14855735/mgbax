package com.bytedance.sdk.component.w.xj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class pl {
    static final Logger xj = Logger.getLogger(pl.class.getName());

    static {
        mVSh();
    }

    private pl() {
    }

    public static yo hf(File file) {
        if (file != null) {
            return xj(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    private static /* synthetic */ void mVSh() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static yo w(File file) {
        if (file != null) {
            return xj(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static kd xj(v vVar) {
        return new am(vVar);
    }

    public static u xj(yo yoVar) {
        return new g(yoVar);
    }

    public static v hf(Socket socket) {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                xj w = w(socket);
                return w.xj(xj(socket.getInputStream(), w));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static xj w(final Socket socket) {
        return new xj() { // from class: com.bytedance.sdk.component.w.xj.pl.4
            @Override // com.bytedance.sdk.component.w.xj.xj
            public IOException hf(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.component.w.xj.xj
            public void m_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!pl.xj(e)) {
                        throw e;
                    }
                    pl.xj.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (Exception e2) {
                    pl.xj.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    public static yo xj(OutputStream outputStream) {
        return xj(outputStream, new jk());
    }

    private static yo xj(final OutputStream outputStream, final jk jkVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (jkVar != null) {
            return new yo() { // from class: com.bytedance.sdk.component.w.xj.pl.1
                @Override // com.bytedance.sdk.component.w.xj.yo
                public void a_(w wVar, long j) {
                    try {
                        pz.xj(wVar.hf, 0L, j);
                        long j2 = j;
                        while (j2 > 0) {
                            jk.this.c();
                            qt qtVar = wVar.xj;
                            int min = (int) Math.min(j2, qtVar.w - qtVar.hf);
                            outputStream.write(qtVar.xj, qtVar.hf, min);
                            int i = qtVar.hf + min;
                            qtVar.hf = i;
                            long j3 = min;
                            j2 -= j3;
                            wVar.hf -= j3;
                            if (i == qtVar.w) {
                                wVar.xj = qtVar.hf();
                                zg.xj(qtVar);
                            }
                        }
                    } catch (IOException | Exception unused) {
                    }
                }

                @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    outputStream.close();
                }

                @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
                public void flush() {
                    outputStream.flush();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.bytedance.sdk.component.w.xj.yo
                public jk xj() {
                    return jk.this;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static yo xj(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                xj w = w(socket);
                return w.xj(xj(socket.getOutputStream(), w));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static v xj(InputStream inputStream) {
        return xj(inputStream, new jk());
    }

    private static v xj(final InputStream inputStream, final jk jkVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (jkVar != null) {
            return new v() { // from class: com.bytedance.sdk.component.w.xj.pl.2
                @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }

                @Override // com.bytedance.sdk.component.w.xj.v
                public long xj(w wVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        jk.this.c();
                        qt kd = wVar.kd(1);
                        int read = inputStream.read(kd.xj, kd.w, (int) Math.min(j, 8192 - kd.w));
                        if (read == -1) {
                            return -1L;
                        }
                        kd.w += read;
                        long j2 = read;
                        wVar.hf += j2;
                        return j2;
                    } catch (AssertionError e) {
                        if (pl.xj(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    } catch (Throwable th) {
                        throw new IOException(th.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.w.xj.v
                public jk xj() {
                    return jk.this;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static v xj(File file) {
        if (file != null) {
            return xj(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static yo xj() {
        return new yo() { // from class: com.bytedance.sdk.component.w.xj.pl.3
            @Override // com.bytedance.sdk.component.w.xj.yo
            public void a_(w wVar, long j) {
                wVar.f(j);
            }

            @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
            public void flush() {
            }

            @Override // com.bytedance.sdk.component.w.xj.yo
            public jk xj() {
                return jk.w;
            }
        };
    }

    public static boolean xj(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
