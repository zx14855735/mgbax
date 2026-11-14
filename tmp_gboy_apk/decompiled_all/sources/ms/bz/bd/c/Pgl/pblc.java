package ms.bz.bd.c.Pgl;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pblc {

    public static class pblb extends Exception {
    }

    public static final class pgla<A, B> {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final ByteBuffer f14034A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final Long f14035A4TApA;

        public pgla(ByteBuffer byteBuffer, Long l) {
            this.f14034A2egSU = byteBuffer;
            this.f14035A4TApA = l;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || pgla.class != obj.getClass()) {
                return false;
            }
            pgla pglaVar = (pgla) obj;
            if (this.f14034A2egSU.equals(pglaVar.f14034A2egSU)) {
                return this.f14035A4TApA.equals(pglaVar.f14035A4TApA);
            }
            return false;
        }

        public final int hashCode() {
            return this.f14035A4TApA.hashCode() + ((this.f14034A2egSU.hashCode() + 31) * 31);
        }
    }

    public static LinkedHashMap A2egSU(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a9f96c", new byte[]{33}));
        }
        int capacity = byteBuffer.capacity() - 24;
        if (capacity < 8) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41f187", new byte[]{113}));
        }
        byteBuffer.capacity();
        if (capacity > byteBuffer.capacity()) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6d97c", new byte[]{39}));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(capacity);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (slice.hasRemaining()) {
                if (slice.remaining() < 8) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c86e94", new byte[]{36}));
                }
                long j = slice.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bb5779", new byte[]{36}));
                }
                int i = (int) j;
                int position2 = slice.position() + i;
                if (i > slice.remaining()) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8b381f", new byte[]{113}));
                }
                Integer valueOf = Integer.valueOf(slice.getInt());
                int i2 = i - 4;
                if (i2 < 0) {
                    throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5d8fdd", new byte[]{118}));
                }
                int limit2 = slice.limit();
                int position3 = slice.position();
                int i3 = i2 + position3;
                if (i3 < position3 || i3 > limit2) {
                    throw new BufferUnderflowException();
                }
                slice.limit(i3);
                try {
                    ByteBuffer slice2 = slice.slice();
                    slice2.order(slice.order());
                    slice.position(i3);
                    slice.limit(limit2);
                    linkedHashMap.put(valueOf, slice2);
                    slice.position(position2);
                } catch (Throwable th) {
                    slice.limit(limit2);
                    throw th;
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
            throw th2;
        }
    }

    public static pgla A4TApA(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "99b892", new byte[]{121, 106}));
        }
        long j = size - 22;
        long min = Math.min(j, 65535L);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > min) {
                throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "071727", new byte[]{112, 101}));
            }
            long j3 = j - j2;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s = allocate2.getShort(0);
                if (s == i) {
                    ByteBuffer allocate3 = ByteBuffer.allocate(4);
                    allocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - s) - 6);
                    fileChannel.read(allocate3);
                    long j4 = allocate3.getInt(0);
                    if (j4 < 32) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9677d", new byte[]{42}));
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer allocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(allocate4);
                    allocate4.order(byteOrder);
                    if (allocate4.getLong(8) != 2334950737559900225L || allocate4.getLong(16) != 3617552046287187010L) {
                        return null;
                    }
                    long j5 = allocate4.getLong(0);
                    if (j5 < allocate4.capacity() || j5 > 2147483639) {
                        return null;
                    }
                    int i2 = (int) (8 + j5);
                    long j6 = j4 - i2;
                    if (j6 < 0) {
                        return null;
                    }
                    fileChannel.position(j6);
                    ByteBuffer allocate5 = ByteBuffer.allocate(i2);
                    fileChannel.read(allocate5);
                    allocate5.order(byteOrder);
                    if (allocate5.getLong(0) == j5) {
                        return new pgla(allocate5, Long.valueOf(j6));
                    }
                    return null;
                }
            }
            i++;
        }
    }
}
