package okhttp3.internal.ws;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz {
    boolean closed;
    final ADYaiT frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final BufferedSource source;
    private final Buffer controlFrameBuffer = new Buffer();
    private final Buffer messageFrameBuffer = new Buffer();

    public AMqCpz(boolean z, BufferedSource bufferedSource, ADYaiT aDYaiT) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (aDYaiT == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.isClient = z;
        this.source = bufferedSource;
        this.frameCallback = aDYaiT;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new Buffer.UnsafeCursor();
    }

    public final void A2egSU() {
        A5SV6n();
        if (this.isControlFrame) {
            A4TApA();
            return;
        }
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException(CtFAbx.AzWtSf(new StringBuilder("Unknown opcode: "), i));
        }
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.readFully(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    A5SV6n.A4TApA(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                if (i == 1) {
                    ADYaiT aDYaiT = this.frameCallback;
                    A2egSU a2egSU = (A2egSU) aDYaiT;
                    a2egSU.listener.onMessage(a2egSU, this.messageFrameBuffer.readUtf8());
                    return;
                }
                ADYaiT aDYaiT2 = this.frameCallback;
                A2egSU a2egSU2 = (A2egSU) aDYaiT2;
                a2egSU2.listener.onMessage(a2egSU2, this.messageFrameBuffer.readByteString());
                return;
            }
            while (!this.closed) {
                A5SV6n();
                if (!this.isControlFrame) {
                    break;
                } else {
                    A4TApA();
                }
            }
            if (this.opcode != 0) {
                throw new ProtocolException(CtFAbx.AzWtSf(new StringBuilder("Expected continuation opcode. Got: "), this.opcode));
            }
        }
        throw new IOException("closed");
    }

    public final void A4TApA() {
        short s;
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.readFully(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                A5SV6n.A4TApA(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.controlFrameBuffer.readShort();
                    str = this.controlFrameBuffer.readUtf8();
                    String A2egSU2 = A5SV6n.A2egSU(s);
                    if (A2egSU2 != null) {
                        throw new ProtocolException(A2egSU2);
                    }
                } else {
                    s = 1005;
                    str = "";
                }
                ((A2egSU) this.frameCallback).ARc23Z(s, str);
                this.closed = true;
                return;
            case 9:
                ((A2egSU) this.frameCallback).ASJ6gh(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                ADYaiT aDYaiT = this.frameCallback;
                this.controlFrameBuffer.readByteString();
                ((A2egSU) aDYaiT).AYUAbz();
                return;
            default:
                throw new ProtocolException(CtFAbx.AzWtSf(new StringBuilder("Unknown control opcode: "), this.opcode));
        }
    }

    public final void A5SV6n() {
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            byte readByte = this.source.readByte();
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.opcode = readByte & 15;
            boolean z = (readByte & 128) != 0;
            this.isFinalFrame = z;
            boolean z2 = (readByte & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (readByte & 64) != 0;
            boolean z4 = (readByte & 32) != 0;
            boolean z5 = (readByte & 16) != 0;
            if (z3 || z4 || z5) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            byte readByte2 = this.source.readByte();
            boolean z6 = (readByte2 & 128) != 0;
            if (z6 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = readByte2 & Byte.MAX_VALUE;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = this.source.readShort() & 65535;
            } else if (j == 127) {
                long readLong = this.source.readLong();
                this.frameLength = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.source.readFully(this.maskKey);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }
}
