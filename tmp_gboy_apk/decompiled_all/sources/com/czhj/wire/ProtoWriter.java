package com.czhj.wire;

import com.czhj.wire.okio.BufferedSink;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ProtoWriter {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedSink f10672a;

    public ProtoWriter(BufferedSink bufferedSink) {
        this.f10672a = bufferedSink;
    }

    public static int a(int i) {
        return c(a(i, FieldEncoding.VARINT));
    }

    public static int b(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    public static int c(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public void f(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public void writeBytes(ByteString byteString) {
        this.f10672a.write(byteString);
    }

    public void writeFixed32(int i) {
        this.f10672a.writeIntLe(i);
    }

    public void writeFixed64(long j) {
        this.f10672a.writeLongLe(j);
    }

    public void writeString(String str) {
        this.f10672a.writeUtf8(str);
    }

    public void writeTag(int i, FieldEncoding fieldEncoding) {
        writeVarint32(a(i, fieldEncoding));
    }

    public void writeVarint32(int i) {
        while ((i & (-128)) != 0) {
            this.f10672a.writeByte((i & 127) | r.b.d);
            i >>>= 7;
        }
        this.f10672a.writeByte(i);
    }

    public void writeVarint64(long j) {
        while (true) {
            long j2 = (-128) & j;
            BufferedSink bufferedSink = this.f10672a;
            if (j2 == 0) {
                bufferedSink.writeByte((int) j);
                return;
            } else {
                bufferedSink.writeByte((((int) j) & 127) | r.b.d);
                j >>>= 7;
            }
        }
    }

    private static int a(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    public static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }
}
