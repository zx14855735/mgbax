package com.bytedance.sdk.component.panglearmor.xj.xj.hf.hf;

import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.xj.hf.hf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    public static long hf(ByteBuffer byteBuffer) {
        u(byteBuffer);
        return hf(byteBuffer, byteBuffer.position() + 12);
    }

    private static int kd(ByteBuffer byteBuffer) {
        u(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && xj(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static void u(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int w(ByteBuffer byteBuffer) {
        u(byteBuffer);
        return xj(byteBuffer, byteBuffer.position() + 10);
    }

    public static long xj(ByteBuffer byteBuffer) {
        u(byteBuffer);
        return hf(byteBuffer, byteBuffer.position() + 16);
    }

    public static long hf(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    public static Pair<ByteBuffer, Long> xj(hf hfVar) {
        if (hfVar.xj() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> xj = xj(hfVar, 0);
        return xj != null ? xj : xj(hfVar, 65535);
    }

    private static Pair<ByteBuffer, Long> xj(hf hfVar, int i) {
        if (i >= 0 && i <= 65535) {
            long xj = hfVar.xj();
            if (xj < 22) {
                return null;
            }
            int min = ((int) Math.min(i, xj - 22)) + 22;
            long j = xj - min;
            ByteBuffer xj2 = hfVar.xj(j, min);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            xj2.order(byteOrder);
            int kd = kd(xj2);
            if (kd == -1) {
                return null;
            }
            xj2.position(kd);
            ByteBuffer slice = xj2.slice();
            slice.order(byteOrder);
            return new Pair<>(slice, Long.valueOf(j + kd));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    public static int xj(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }
}
