package okhttp3.internal.http2;

import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.AMqCpz;
import okhttp3.internal.http2.AmA8tU;
import okhttp3.internal.http2.AmA8tU.A5SV6n;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class B3GDIM implements Closeable {
    static final Logger logger = Logger.getLogger(ARc23Z.class.getName());
    private final boolean client;
    private final A2egSU continuation;
    final AMqCpz.A2egSU hpackReader;
    private final BufferedSource source;

    public static final class A2egSU implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public A2egSU(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j) {
            int i;
            int readInt;
            do {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) == 0) {
                        i = this.streamId;
                        int ARc23Z2 = B3GDIM.ARc23Z(this.source);
                        this.left = ARc23Z2;
                        this.length = ARc23Z2;
                        byte readByte = (byte) (this.source.readByte() & 255);
                        this.flags = (byte) (this.source.readByte() & 255);
                        Logger logger = B3GDIM.logger;
                        if (logger.isLoggable(Level.FINE)) {
                            logger.fine(ARc23Z.A2egSU(true, this.streamId, this.length, readByte, this.flags));
                        }
                        readInt = this.source.readInt() & Integer.MAX_VALUE;
                        this.streamId = readInt;
                        if (readByte != 9) {
                            ARc23Z.A5SV6n("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                            throw null;
                        }
                    }
                } else {
                    long read = this.source.read(buffer, Math.min(j, i2));
                    if (read != -1) {
                        this.left = (int) (this.left - read);
                        return read;
                    }
                }
                return -1L;
            } while (readInt == i);
            ARc23Z.A5SV6n("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.timeout();
        }
    }

    static {
        PvYhhU();
    }

    public B3GDIM(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        A2egSU a2egSU = new A2egSU(bufferedSource);
        this.continuation = a2egSU;
        this.hpackReader = new AMqCpz.A2egSU(f.a.c, a2egSU);
    }

    public static int A2egSU(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        ARc23Z.A5SV6n("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    public static int ARc23Z(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private static /* synthetic */ void PvYhhU() {
        char[] charArray = "hdf%ljfn%idr%xcngg%AebIyboln".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 11);
        }
        String str = new String(charArray);
        char[] charArray2 = "hgbeb\u007f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 11);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A4TApA(boolean z, AmA8tU.ADYaiT aDYaiT) {
        A4TApA a4TApA;
        try {
            this.source.require(9L);
            int ARc23Z2 = ARc23Z(this.source);
            if (ARc23Z2 < 0 || ARc23Z2 > 16384) {
                ARc23Z.A5SV6n("FRAME_SIZE_ERROR: %s", Integer.valueOf(ARc23Z2));
                throw null;
            }
            byte readByte = (byte) (this.source.readByte() & 255);
            if (z && readByte != 4) {
                ARc23Z.A5SV6n("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.source.readByte() & 255);
            int readInt = this.source.readInt();
            int i = Integer.MAX_VALUE & readInt;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(ARc23Z.A2egSU(true, i, ARc23Z2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    if (i == 0) {
                        ARc23Z.A5SV6n("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
                        throw null;
                    }
                    boolean z2 = (readByte2 & 1) != 0;
                    if ((readByte2 & 32) != 0) {
                        ARc23Z.A5SV6n("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        throw null;
                    }
                    short readByte3 = (readByte2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                    int A2egSU2 = A2egSU(ARc23Z2, readByte2, readByte3);
                    BufferedSource bufferedSource = this.source;
                    AmA8tU.this.getClass();
                    if (i == 0 || (readInt & 1) != 0) {
                        B4ZgIw ARc23Z3 = AmA8tU.this.ARc23Z(i);
                        if (ARc23Z3 == null) {
                            AmA8tU.this.AzWtSf(i, A4TApA.PROTOCOL_ERROR);
                            long j = A2egSU2;
                            AmA8tU.this.AcNBzu(j);
                            bufferedSource.skip(j);
                        } else {
                            ARc23Z3.AZkASS(bufferedSource, A2egSU2);
                            if (z2) {
                                ARc23Z3.AaHO0E();
                            }
                        }
                    } else {
                        AmA8tU amA8tU = AmA8tU.this;
                        amA8tU.getClass();
                        Buffer buffer = new Buffer();
                        long j2 = A2egSU2;
                        bufferedSource.require(j2);
                        bufferedSource.read(buffer, j2);
                        if (buffer.size() != j2) {
                            throw new IOException(buffer.size() + " != " + A2egSU2);
                        }
                        amA8tU.AYUAbz(new AcNBzu(amA8tU, "OkHttp %s Push Data[%s]", new Object[]{amA8tU.hostname, Integer.valueOf(i)}, i, buffer, A2egSU2, z2));
                    }
                    this.source.skip(readByte3);
                    return true;
                case 1:
                    AMqCpz(aDYaiT, ARc23Z2, readByte2, i);
                    return true;
                case 2:
                    if (ARc23Z2 != 5) {
                        ARc23Z.A5SV6n("TYPE_PRIORITY length: %d != 5", Integer.valueOf(ARc23Z2));
                        throw null;
                    }
                    if (i == 0) {
                        ARc23Z.A5SV6n("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    this.source.readInt();
                    this.source.readByte();
                    return true;
                case 3:
                    if (ARc23Z2 != 4) {
                        ARc23Z.A5SV6n("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(ARc23Z2));
                        throw null;
                    }
                    if (i == 0) {
                        ARc23Z.A5SV6n("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int readInt2 = this.source.readInt();
                    A4TApA[] values = A4TApA.values();
                    int length = values.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            A4TApA a4TApA2 = values[i2];
                            if (a4TApA2.httpCode == readInt2) {
                                a4TApA = a4TApA2;
                            } else {
                                i2++;
                            }
                        } else {
                            a4TApA = null;
                        }
                    }
                    if (a4TApA == null) {
                        ARc23Z.A5SV6n("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
                        throw null;
                    }
                    AmA8tU.this.getClass();
                    if (i != 0 && (readInt & 1) == 0) {
                        AmA8tU amA8tU2 = AmA8tU.this;
                        amA8tU2.AYUAbz(new AlLFFp(amA8tU2, "OkHttp %s Push Reset[%s]", new Object[]{amA8tU2.hostname, Integer.valueOf(i)}, i, a4TApA));
                        return true;
                    }
                    A4TApA a4TApA3 = a4TApA;
                    B4ZgIw AZOQYO2 = AmA8tU.this.AZOQYO(i);
                    if (AZOQYO2 != null) {
                        AZOQYO2.AlLFFp(a4TApA3);
                    }
                    return true;
                case 4:
                    AZOQYO(aDYaiT, ARc23Z2, readByte2, i);
                    return true;
                case 5:
                    AYUAbz(aDYaiT, ARc23Z2, readByte2, i);
                    return true;
                case 6:
                    ASJ6gh(aDYaiT, ARc23Z2, readByte2, i);
                    return true;
                case 7:
                    ADYaiT(aDYaiT, ARc23Z2, i);
                    return true;
                case 8:
                    if (ARc23Z2 != 4) {
                        ARc23Z.A5SV6n("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(ARc23Z2));
                        throw null;
                    }
                    long readInt3 = this.source.readInt() & 2147483647L;
                    if (readInt3 == 0) {
                        ARc23Z.A5SV6n("windowSizeIncrement was 0", Long.valueOf(readInt3));
                        throw null;
                    }
                    if (i == 0) {
                        synchronized (AmA8tU.this) {
                            AmA8tU amA8tU3 = AmA8tU.this;
                            amA8tU3.bytesLeftInWriteWindow += readInt3;
                            amA8tU3.notifyAll();
                        }
                        return true;
                    }
                    B4ZgIw ARc23Z4 = AmA8tU.this.ARc23Z(i);
                    if (ARc23Z4 != null) {
                        synchronized (ARc23Z4) {
                            ARc23Z4.bytesLeftInWriteWindow += readInt3;
                            if (readInt3 > 0) {
                                ARc23Z4.notifyAll();
                            }
                        }
                        return true;
                    }
                    return true;
                default:
                    this.source.skip(ARc23Z2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public final void A5SV6n(AmA8tU.ADYaiT aDYaiT) {
        if (this.client) {
            if (A4TApA(true, aDYaiT)) {
                return;
            }
            ARc23Z.A5SV6n("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = ARc23Z.CONNECTION_PREFACE;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            String hex = readByteString.hex();
            byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
            Locale locale = Locale.US;
            logger2.fine("<< CONNECTION " + hex);
        }
        if (byteString.equals(readByteString)) {
            return;
        }
        ARc23Z.A5SV6n("Expected a connection header but was %s", readByteString.utf8());
        throw null;
    }

    public final void ADYaiT(AmA8tU.ADYaiT aDYaiT, int i, int i2) {
        A4TApA a4TApA;
        B4ZgIw[] b4ZgIwArr;
        if (i < 8) {
            ARc23Z.A5SV6n("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            ARc23Z.A5SV6n("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i3 = i - 8;
        A4TApA[] values = A4TApA.values();
        int length = values.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                a4TApA = null;
                break;
            }
            a4TApA = values[i4];
            if (a4TApA.httpCode == readInt2) {
                break;
            } else {
                i4++;
            }
        }
        if (a4TApA == null) {
            ARc23Z.A5SV6n("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.source.readByteString(i3);
        }
        byteString.size();
        synchronized (AmA8tU.this) {
            b4ZgIwArr = (B4ZgIw[]) AmA8tU.this.streams.values().toArray(new B4ZgIw[AmA8tU.this.streams.size()]);
            AmA8tU.this.shutdown = true;
        }
        for (B4ZgIw b4ZgIw : b4ZgIwArr) {
            if (b4ZgIw.id > readInt && b4ZgIw.AYUAbz()) {
                b4ZgIw.AlLFFp(A4TApA.REFUSED_STREAM);
                AmA8tU.this.AZOQYO(b4ZgIw.id);
            }
        }
    }

    public final void AMqCpz(AmA8tU.ADYaiT aDYaiT, int i, byte b, int i2) {
        ExecutorService executorService;
        if (i2 == 0) {
            ARc23Z.A5SV6n("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        short readByte = (b & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            this.source.readInt();
            this.source.readByte();
            i -= 5;
        }
        int A2egSU2 = A2egSU(i, b, readByte);
        A2egSU a2egSU = this.continuation;
        a2egSU.left = A2egSU2;
        a2egSU.length = A2egSU2;
        a2egSU.padding = readByte;
        a2egSU.flags = b;
        a2egSU.streamId = i2;
        this.hpackReader.ARc23Z();
        ArrayList A4TApA2 = this.hpackReader.A4TApA();
        AmA8tU.this.getClass();
        if (i2 != 0 && (i2 & 1) == 0) {
            AmA8tU amA8tU = AmA8tU.this;
            amA8tU.getClass();
            try {
                amA8tU.AYUAbz(new AaHO0E(amA8tU, "OkHttp %s Push Headers[%s]", new Object[]{amA8tU.hostname, Integer.valueOf(i2)}, i2, A4TApA2, z));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (AmA8tU.this) {
            try {
                B4ZgIw ARc23Z2 = AmA8tU.this.ARc23Z(i2);
                if (ARc23Z2 != null) {
                    ARc23Z2.AcNBzu(A4TApA2);
                    if (z) {
                        ARc23Z2.AaHO0E();
                        return;
                    }
                    return;
                }
                AmA8tU amA8tU2 = AmA8tU.this;
                if (amA8tU2.shutdown) {
                    return;
                }
                if (i2 <= amA8tU2.lastGoodStreamId) {
                    return;
                }
                if (i2 % 2 == amA8tU2.nextStreamId % 2) {
                    return;
                }
                B4ZgIw b4ZgIw = new B4ZgIw(i2, AmA8tU.this, false, z, okhttp3.internal.A5SV6n.BChYOn(A4TApA2));
                AmA8tU amA8tU3 = AmA8tU.this;
                amA8tU3.lastGoodStreamId = i2;
                amA8tU3.streams.put(Integer.valueOf(i2), b4ZgIw);
                executorService = AmA8tU.listenerExecutor;
                executorService.execute(new AzWtSf(aDYaiT, "OkHttp %s stream %d", new Object[]{AmA8tU.this.hostname, Integer.valueOf(i2)}, b4ZgIw));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ASJ6gh(AmA8tU.ADYaiT aDYaiT, int i, byte b, int i2) {
        ScheduledExecutorService scheduledExecutorService;
        if (i != 8) {
            ARc23Z.A5SV6n("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            ARc23Z.A5SV6n("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        if ((b & 1) == 0) {
            try {
                scheduledExecutorService = AmA8tU.this.writerExecutor;
                scheduledExecutorService.execute(AmA8tU.this.new A5SV6n(true, readInt, readInt2));
            } catch (RejectedExecutionException unused) {
            }
        } else {
            synchronized (AmA8tU.this) {
                AmA8tU.this.awaitingPong = false;
                AmA8tU.this.notifyAll();
            }
        }
    }

    public final void AYUAbz(AmA8tU.ADYaiT aDYaiT, int i, byte b, int i2) {
        if (i2 == 0) {
            ARc23Z.A5SV6n("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        int readInt = this.source.readInt() & Integer.MAX_VALUE;
        int A2egSU2 = A2egSU(i - 4, b, readByte);
        A2egSU a2egSU = this.continuation;
        a2egSU.left = A2egSU2;
        a2egSU.length = A2egSU2;
        a2egSU.padding = readByte;
        a2egSU.flags = b;
        a2egSU.streamId = i2;
        this.hpackReader.ARc23Z();
        ArrayList A4TApA2 = this.hpackReader.A4TApA();
        AmA8tU amA8tU = AmA8tU.this;
        synchronized (amA8tU) {
            try {
                if (amA8tU.currentPushRequests.contains(Integer.valueOf(readInt))) {
                    amA8tU.AzWtSf(readInt, A4TApA.PROTOCOL_ERROR);
                    return;
                }
                amA8tU.currentPushRequests.add(Integer.valueOf(readInt));
                try {
                    amA8tU.AYUAbz(new AZkASS(amA8tU, "OkHttp %s Push Request[%s]", new Object[]{amA8tU.hostname, Integer.valueOf(readInt)}, readInt, A4TApA2));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AZOQYO(AmA8tU.ADYaiT aDYaiT, int i, byte b, int i2) {
        long j;
        ExecutorService executorService;
        ScheduledExecutorService scheduledExecutorService;
        B4ZgIw[] b4ZgIwArr = null;
        if (i2 != 0) {
            ARc23Z.A5SV6n("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b & 1) != 0) {
            if (i == 0) {
                return;
            }
            ARc23Z.A5SV6n("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        }
        if (i % 6 != 0) {
            ARc23Z.A5SV6n("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        BIYEnU bIYEnU = new BIYEnU();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.source.readShort() & 65535;
            int readInt = this.source.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        ARc23Z.A5SV6n("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    ARc23Z.A5SV6n("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    throw null;
                }
            } else if (readInt != 0 && readInt != 1) {
                ARc23Z.A5SV6n("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                throw null;
            }
            bIYEnU.AYUAbz(readShort, readInt);
        }
        synchronized (AmA8tU.this) {
            try {
                int A5SV6n2 = AmA8tU.this.peerSettings.A5SV6n();
                AmA8tU.this.peerSettings.ASJ6gh(bIYEnU);
                try {
                    scheduledExecutorService = AmA8tU.this.writerExecutor;
                    scheduledExecutorService.execute(new B2KMhB(aDYaiT, "OkHttp %s ACK Settings", new Object[]{AmA8tU.this.hostname}, bIYEnU));
                } catch (RejectedExecutionException unused) {
                }
                int A5SV6n3 = AmA8tU.this.peerSettings.A5SV6n();
                if (A5SV6n3 == -1 || A5SV6n3 == A5SV6n2) {
                    j = 0;
                } else {
                    j = A5SV6n3 - A5SV6n2;
                    AmA8tU amA8tU = AmA8tU.this;
                    if (!amA8tU.receivedInitialPeerSettings) {
                        amA8tU.receivedInitialPeerSettings = true;
                    }
                    if (!amA8tU.streams.isEmpty()) {
                        b4ZgIwArr = (B4ZgIw[]) AmA8tU.this.streams.values().toArray(new B4ZgIw[AmA8tU.this.streams.size()]);
                    }
                }
                executorService = AmA8tU.listenerExecutor;
                executorService.execute(new B25kr6(aDYaiT, "OkHttp %s settings", AmA8tU.this.hostname));
            } finally {
            }
        }
        if (b4ZgIwArr == null || j == 0) {
            return;
        }
        for (B4ZgIw b4ZgIw : b4ZgIwArr) {
            synchronized (b4ZgIw) {
                b4ZgIw.bytesLeftInWriteWindow += j;
                if (j > 0) {
                    b4ZgIw.notifyAll();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.source.close();
    }
}
