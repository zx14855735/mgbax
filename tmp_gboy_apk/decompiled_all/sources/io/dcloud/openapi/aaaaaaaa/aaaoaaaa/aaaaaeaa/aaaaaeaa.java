package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaeaa {
    static final Logger aaaaaaaa = Logger.getLogger(aaaaaeaa.class.getName());

    public class aaaaaaa0 implements aaaaoaaa {
        final /* synthetic */ InputStream aaaaaaa0;
        final /* synthetic */ aaaaaoaa aaaaaaaa;

        public aaaaaaa0(aaaaaoaa aaaaaoaaVar, InputStream inputStream) {
            this.aaaaaaaa = aaaaaoaaVar;
            this.aaaaaaa0 = inputStream;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.aaaaaaaa.aaaaaaau();
                aeaaaaaa aaaaaaa0 = aaaaaaaoVar.aaaaaaa0(1);
                int read = this.aaaaaaa0.read(aaaaaaa0.aaaaaaaa, aaaaaaa0.aaaaaaao, (int) Math.min(j, 8192 - aaaaaaa0.aaaaaaao));
                if (read != -1) {
                    aaaaaaa0.aaaaaaao += read;
                    long j2 = read;
                    aaaaaaaoVar.aaaaaaa0 += j2;
                    return j2;
                }
                if (aaaaaaa0.aaaaaaa0 != aaaaaaa0.aaaaaaao) {
                    return -1L;
                }
                aaaaaaaoVar.aaaaaaaa = aaaaaaa0.aaaaaaa0();
                aoaaaaaa.aaaaaaaa(aaaaaaa0);
                return -1L;
            } catch (AssertionError e) {
                if (aaaaaeaa.aaaaaaaa(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.aaaaaaa0.close();
        }

        public String toString() {
            return "source(" + this.aaaaaaa0 + ")";
        }
    }

    public class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa {
        final /* synthetic */ Socket aaaaeaaa;

        public aaaaaaao(Socket socket) {
            this.aaaaeaaa = socket;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa
        public IOException aaaaaaa0(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa
        public void aaaeaaaa() {
            try {
                this.aaaaeaaa.close();
            } catch (AssertionError e) {
                if (!aaaaaeaa.aaaaaaaa(e)) {
                    throw e;
                }
                aaaaaeaa.aaaaaaaa.log(Level.WARNING, "Failed to close timed out socket " + this.aaaaeaaa, (Throwable) e);
            } catch (Exception e2) {
                aaaaaeaa.aaaaaaaa.log(Level.WARNING, "Failed to close timed out socket " + this.aaaaeaaa, (Throwable) e2);
            }
        }
    }

    static {
        gwtzDs();
    }

    public static aaaaoaaa aaaaaaa0(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa aaaaaaao2 = aaaaaaao(socket);
        return aaaaaaao2.aaaaaaaa(aaaaaaaa(socket.getInputStream(), aaaaaaao2));
    }

    public static aaaaaaau aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        return new eaaaaaaa(aaaaoaaaVar);
    }

    private static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa aaaaaaao(Socket socket) {
        return new aaaaaaao(socket);
    }

    private static /* synthetic */ void gwtzDs() {
        char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 222);
        }
        String str = new String(charArray);
        char[] charArray2 = "½²·°·ª".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 222);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static aaaaaaac aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
        return new aaaaaaea(aaaoaaaaVar);
    }

    private static aaaoaaaa aaaaaaaa(OutputStream outputStream, aaaaaoaa aaaaaoaaVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (aaaaaoaaVar != null) {
            return new aaaaaaaa(aaaaaoaaVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static aaaoaaaa aaaaaaaa(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa aaaaaaao2 = aaaaaaao(socket);
                return aaaaaaao2.aaaaaaaa(aaaaaaaa(socket.getOutputStream(), aaaaaaao2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public class aaaaaaaa implements aaaoaaaa {
        final /* synthetic */ OutputStream aaaaaaa0;
        final /* synthetic */ aaaaaoaa aaaaaaaa;

        public aaaaaaaa(aaaaaoaa aaaaaoaaVar, OutputStream outputStream) {
            this.aaaaaaaa = aaaaaoaaVar;
            this.aaaaaaa0 = outputStream;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            aaaaaaoa.aaaaaaaa(aaaaaaaoVar.aaaaaaa0, 0L, j);
            while (j > 0) {
                this.aaaaaaaa.aaaaaaau();
                aeaaaaaa aeaaaaaaVar = aaaaaaaoVar.aaaaaaaa;
                int min = (int) Math.min(j, aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0);
                this.aaaaaaa0.write(aeaaaaaaVar.aaaaaaaa, aeaaaaaaVar.aaaaaaa0, min);
                int i = aeaaaaaaVar.aaaaaaa0 + min;
                aeaaaaaaVar.aaaaaaa0 = i;
                long j2 = min;
                j -= j2;
                aaaaaaaoVar.aaaaaaa0 -= j2;
                if (i == aeaaaaaaVar.aaaaaaao) {
                    aaaaaaaoVar.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
                    aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.aaaaaaa0.close();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
        public void flush() {
            this.aaaaaaa0.flush();
        }

        public String toString() {
            return "sink(" + this.aaaaaaa0 + ")";
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa;
        }
    }

    public static aaaaoaaa aaaaaaaa(InputStream inputStream) {
        return aaaaaaaa(inputStream, new aaaaaoaa());
    }

    private static aaaaoaaa aaaaaaaa(InputStream inputStream, aaaaaoaa aaaaaoaaVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (aaaaaoaaVar != null) {
            return new aaaaaaa0(aaaaaoaaVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static boolean aaaaaaaa(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
