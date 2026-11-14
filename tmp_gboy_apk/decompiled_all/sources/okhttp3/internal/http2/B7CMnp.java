package okhttp3.internal.http2;

import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.AMqCpz;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class B7CMnp implements Closeable {
    private static final Logger logger = Logger.getLogger(ARc23Z.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final AMqCpz.A4TApA hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    static {
        LatZ();
    }

    public B7CMnp(BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new AMqCpz.A4TApA(buffer);
        this.maxFrameSize = f.a.d;
    }

    private static /* synthetic */ void LatZ() {
        char[] charArray = "øôöµüúöþµùôâµèóþ÷÷µÑõòÙéòÿüþ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 155);
        }
        String str = new String(charArray);
        char[] charArray2 = "ø÷òõòï".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 155);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void A2egSU(BIYEnU bIYEnU) {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = bIYEnU.AMqCpz(this.maxFrameSize);
            if (bIYEnU.A4TApA() != -1) {
                this.hpackWriter.A5SV6n(bIYEnU.A4TApA());
            }
            ADYaiT(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void A4TApA() {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    String hex = ARc23Z.CONNECTION_PREFACE.hex();
                    byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
                    Locale locale = Locale.US;
                    logger2.fine(">> CONNECTION " + hex);
                }
                this.sink.write(ARc23Z.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void A5SV6n(boolean z, int i, Buffer buffer, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        ADYaiT(i, i2, (byte) 0, z ? (byte) 1 : (byte) 0);
        if (i2 > 0) {
            this.sink.write(buffer, i2);
        }
    }

    public final void ADYaiT(int i, int i2, byte b, byte b2) {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(ARc23Z.A2egSU(false, i, i2, b, b2));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            ARc23Z.A4TApA("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            ARc23Z.A4TApA("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
        BufferedSink bufferedSink = this.sink;
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
        this.sink.writeByte(b & 255);
        this.sink.writeByte(b2 & 255);
        this.sink.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void AMqCpz(int i, A4TApA a4TApA, byte[] bArr) {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (a4TApA.httpCode == -1) {
                ARc23Z.A4TApA("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            ADYaiT(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.writeInt(i);
            this.sink.writeInt(a4TApA.httpCode);
            if (bArr.length > 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void ARc23Z(int i, ArrayList arrayList, boolean z) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.AMqCpz(arrayList);
        long size = this.hpackBuffer.size();
        int min = (int) Math.min(this.maxFrameSize, size);
        long j = min;
        byte b = size == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        ADYaiT(i, min, (byte) 1, b);
        this.sink.write(this.hpackBuffer, j);
        if (size > j) {
            long j2 = size - j;
            while (j2 > 0) {
                int min2 = (int) Math.min(this.maxFrameSize, j2);
                long j3 = min2;
                j2 -= j3;
                ADYaiT(i, min2, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
                this.sink.write(this.hpackBuffer, j3);
            }
        }
    }

    public final int ASJ6gh() {
        return this.maxFrameSize;
    }

    public final synchronized void AYUAbz(int i, int i2, boolean z) {
        if (this.closed) {
            throw new IOException("closed");
        }
        ADYaiT(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void AZOQYO(int i, A4TApA a4TApA) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (a4TApA.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        ADYaiT(i, 4, (byte) 3, (byte) 0);
        this.sink.writeInt(a4TApA.httpCode);
        this.sink.flush();
    }

    public final synchronized void AZkASS(BIYEnU bIYEnU) {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            int i = 0;
            ADYaiT(0, bIYEnU.AZOQYO() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (bIYEnU.ARc23Z(i)) {
                    this.sink.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.sink.writeInt(bIYEnU.A2egSU(i));
                }
                i++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void AaHO0E(int i, ArrayList arrayList, boolean z) {
        if (this.closed) {
            throw new IOException("closed");
        }
        ARc23Z(i, arrayList, z);
    }

    public final synchronized void AcNBzu(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            ARc23Z.A4TApA("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
        ADYaiT(i, 4, (byte) 8, (byte) 0);
        this.sink.writeInt((int) j);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }
}
