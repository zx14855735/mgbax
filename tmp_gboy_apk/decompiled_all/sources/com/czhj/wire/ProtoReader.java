package com.czhj.wire;

import ADYaiT.CtFAbx;
import com.czhj.wire.okio.Buffer;
import com.czhj.wire.okio.BufferedSource;
import com.czhj.wire.okio.ByteString;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ProtoReader {

    /* renamed from: a, reason: collision with root package name */
    static final int f10671a = 3;
    private static final int b = 65;
    private static final int c = 7;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private static final int i = 5;
    private static final int j = 6;
    private static final int k = 7;
    private final BufferedSource l;
    private int o;
    private FieldEncoding s;
    private long m = 0;
    private long n = Long.MAX_VALUE;
    private int p = 2;
    private int q = -1;
    private long r = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        this.l = bufferedSource;
    }

    private int a() {
        int i2;
        this.l.require(1L);
        this.m++;
        byte readByte = this.l.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i3 = readByte & Byte.MAX_VALUE;
        this.l.require(1L);
        this.m++;
        byte readByte2 = this.l.readByte();
        if (readByte2 >= 0) {
            i2 = readByte2 << 7;
        } else {
            i3 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.l.require(1L);
            this.m++;
            byte readByte3 = this.l.readByte();
            if (readByte3 >= 0) {
                i2 = readByte3 << 14;
            } else {
                i3 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.l.require(1L);
                this.m++;
                byte readByte4 = this.l.readByte();
                if (readByte4 < 0) {
                    int i4 = i3 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.l.require(1L);
                    this.m++;
                    byte readByte5 = this.l.readByte();
                    int i5 = i4 | (readByte5 << 28);
                    if (readByte5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            this.l.require(1L);
                            this.m++;
                            if (this.l.readByte() < 0) {
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i5;
                }
                i2 = readByte4 << 21;
            }
        }
        return i3 | i2;
    }

    private long b() {
        if (this.p != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.p);
        }
        long j2 = this.n - this.m;
        this.l.require(j2);
        this.p = 6;
        this.m = this.n;
        this.n = this.r;
        this.r = -1L;
        return j2;
    }

    public long beginMessage() {
        if (this.p != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j2 = this.r;
        this.r = -1L;
        this.p = 6;
        return j2;
    }

    public void endMessage(long j2) {
        if (this.p != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 < 0 || this.r != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.m == this.n || i2 == 0) {
            this.n = j2;
            return;
        }
        throw new IOException("Expected to end at " + this.n + " but was " + this.m);
    }

    public ByteString forEachTag(TagHandler tagHandler) {
        long beginMessage = beginMessage();
        Buffer buffer = null;
        ProtoWriter protoWriter = null;
        while (true) {
            int nextTag = nextTag();
            if (nextTag == -1) {
                break;
            }
            if (tagHandler.decodeMessage(nextTag) == TagHandler.UNKNOWN_TAG) {
                if (buffer == null) {
                    buffer = new Buffer();
                    protoWriter = new ProtoWriter(buffer);
                }
                a(protoWriter, nextTag);
            }
        }
        endMessage(beginMessage);
        return buffer != null ? buffer.readByteString() : ByteString.EMPTY;
    }

    public int nextTag() {
        int i2 = this.p;
        if (i2 == 7) {
            this.p = 2;
            return this.q;
        }
        if (i2 != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.m < this.n && !this.l.exhausted()) {
            int a2 = a();
            if (a2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = a2 >> 3;
            this.q = i3;
            int i4 = a2 & 7;
            if (i4 == 0) {
                this.s = FieldEncoding.VARINT;
                this.p = 0;
                return i3;
            }
            if (i4 == 1) {
                this.s = FieldEncoding.FIXED64;
                this.p = 1;
                return i3;
            }
            if (i4 == 2) {
                this.s = FieldEncoding.LENGTH_DELIMITED;
                this.p = 2;
                int a3 = a();
                if (a3 < 0) {
                    throw new ProtocolException(CtFAbx.ARc23Z(a3, "Negative length: "));
                }
                if (this.r != -1) {
                    throw new IllegalStateException();
                }
                long j2 = this.n;
                this.r = j2;
                long j3 = this.m + a3;
                this.n = j3;
                if (j3 <= j2) {
                    return this.q;
                }
                throw new EOFException();
            }
            if (i4 != 3) {
                if (i4 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i4 != 5) {
                    throw new ProtocolException(CtFAbx.ARc23Z(i4, "Unexpected field encoding: "));
                }
                this.s = FieldEncoding.FIXED32;
                this.p = 5;
                return i3;
            }
            a(i3);
        }
        return -1;
    }

    public FieldEncoding peekFieldEncoding() {
        return this.s;
    }

    public ByteString readBytes() {
        long b2 = b();
        this.l.require(b2);
        return this.l.readByteString(b2);
    }

    public int readFixed32() {
        int i2 = this.p;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.p);
        }
        this.l.require(4L);
        this.m += 4;
        int readIntLe = this.l.readIntLe();
        b(5);
        return readIntLe;
    }

    public long readFixed64() {
        int i2 = this.p;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.p);
        }
        this.l.require(8L);
        this.m += 8;
        long readLongLe = this.l.readLongLe();
        b(1);
        return readLongLe;
    }

    public String readString() {
        long b2 = b();
        this.l.require(b2);
        return this.l.readUtf8(b2);
    }

    public int readVarint32() {
        int i2 = this.p;
        if (i2 == 0 || i2 == 2) {
            int a2 = a();
            b(0);
            return a2;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.p);
    }

    public long readVarint64() {
        int i2 = this.p;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.p);
        }
        long j2 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.l.require(1L);
            this.m++;
            j2 |= (r4 & Byte.MAX_VALUE) << i3;
            if ((this.l.readByte() & 128) == 0) {
                b(0);
                return j2;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public void skip() {
        int i2 = this.p;
        if (i2 == 0) {
            readVarint64();
            return;
        }
        if (i2 == 1) {
            readFixed64();
            return;
        }
        if (i2 == 2) {
            this.l.skip(b());
        } else {
            if (i2 != 5) {
                throw new IllegalStateException("Unexpected call to skip()");
            }
            readFixed32();
        }
    }

    private void a(int i2) {
        while (this.m < this.n && !this.l.exhausted()) {
            int a2 = a();
            if (a2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = a2 >> 3;
            int i4 = a2 & 7;
            if (i4 == 0) {
                this.p = 0;
                readVarint64();
            } else if (i4 == 1) {
                this.p = 1;
                readFixed64();
            } else if (i4 == 2) {
                long a3 = a();
                this.m += a3;
                this.l.skip(a3);
            } else if (i4 == 3) {
                a(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i4 != 5) {
                    throw new ProtocolException(CtFAbx.ARc23Z(i4, "Unexpected field encoding: "));
                }
                this.p = 5;
                readFixed32();
            }
        }
        throw new EOFException();
    }

    private void b(int i2) {
        if (this.p == i2) {
            this.p = 6;
            return;
        }
        long j2 = this.m;
        long j3 = this.n;
        if (j2 > j3) {
            throw new IOException("Expected to end at " + this.n + " but was " + this.m);
        }
        if (j2 != j3) {
            this.p = 7;
            return;
        }
        this.n = this.r;
        this.r = -1L;
        this.p = 6;
    }

    private void a(ProtoWriter protoWriter, int i2) {
        ProtoAdapter<?> rawProtoAdapter = peekFieldEncoding().rawProtoAdapter();
        try {
            rawProtoAdapter.encodeWithTag(protoWriter, i2, rawProtoAdapter.decode(this));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
