package com.bytedance.sdk.component.panglearmor.xj.hf;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements hf {
    private final long hf;
    private final long w;
    private final FileChannel xj;

    public u(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.xj = fileChannel;
        this.hf = j;
        this.w = j2;
    }

    @Override // com.bytedance.sdk.component.panglearmor.xj.hf.hf
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public u xj(long j, long j2) {
        long xj = xj();
        xj(j, j2, xj);
        return (j == 0 && j2 == xj) ? this : new u(this.xj, this.hf + j, j2);
    }

    @Override // com.bytedance.sdk.component.panglearmor.xj.hf.hf
    public long xj() {
        long j = this.w;
        if (j != -1) {
            return j;
        }
        try {
            return this.xj.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public void xj(long j, int i, ByteBuffer byteBuffer) {
        int read;
        xj(j, i, xj());
        if (i == 0) {
            return;
        }
        if (i <= byteBuffer.remaining()) {
            long j2 = this.hf + j;
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.xj) {
                        this.xj.position(j2);
                        read = this.xj.read(byteBuffer);
                    }
                    j2 += read;
                    i -= read;
                }
                return;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.bytedance.sdk.component.panglearmor.xj.hf.hf
    public ByteBuffer xj(long j, int i) {
        if (i >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            xj(j, i, allocate);
            allocate.flip();
            return allocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
    }

    private static void xj(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("offset (", j, ") > source size (");
            B2KMhB2.append(j3);
            B2KMhB2.append(")");
            throw new IndexOutOfBoundsException(B2KMhB2.toString());
        }
        long j4 = j + j2;
        if (j4 < j) {
            StringBuilder B2KMhB3 = CtFAbx.B2KMhB("offset (", j, ") + size (");
            B2KMhB3.append(j2);
            B2KMhB3.append(") overflow");
            throw new IndexOutOfBoundsException(B2KMhB3.toString());
        }
        if (j4 <= j3) {
            return;
        }
        StringBuilder B2KMhB4 = CtFAbx.B2KMhB("offset (", j, ") + size (");
        B2KMhB4.append(j2);
        B2KMhB4.append(") > source size (");
        B2KMhB4.append(j3);
        B2KMhB4.append(")");
        throw new IndexOutOfBoundsException(B2KMhB4.toString());
    }
}
