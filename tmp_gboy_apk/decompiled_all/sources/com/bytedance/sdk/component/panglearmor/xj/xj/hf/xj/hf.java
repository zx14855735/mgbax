package com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj;

import J3FDQU.A2egSU;
import com.bytedance.sdk.component.panglearmor.xj.xj.xj.hf;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static ByteBuffer hf(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static byte[] w(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new Exception("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        StringBuilder B9tovu2 = A2egSU.B9tovu(i, "Underflow while reading length-prefixed value. Length: ", ", available: ");
        B9tovu2.append(byteBuffer.remaining());
        throw new Exception(B9tovu2.toString());
    }

    public static w xj(com.bytedance.sdk.component.panglearmor.xj.hf.hf hfVar, com.bytedance.sdk.component.panglearmor.xj.xj.w.hf hfVar2, int i) {
        try {
            hf.xj xj = com.bytedance.sdk.component.panglearmor.xj.xj.xj.hf.xj(hfVar, hfVar2);
            long xj2 = xj.xj();
            com.bytedance.sdk.component.panglearmor.xj.hf.hf hf = xj.hf();
            ByteBuffer xj3 = hf.xj(0L, (int) hf.xj());
            xj3.order(ByteOrder.LITTLE_ENDIAN);
            return new w(xj(xj3, i), xj2, hfVar2.xj(), hfVar2.u(), hfVar2.kd());
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static ByteBuffer hf(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return hf(byteBuffer, i);
                }
                StringBuilder B9tovu2 = A2egSU.B9tovu(i, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ");
                B9tovu2.append(byteBuffer.remaining());
                throw new Exception(B9tovu2.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static ByteBuffer xj(ByteBuffer byteBuffer, int i) {
        xj(byteBuffer);
        ByteBuffer xj = xj(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (xj.hasRemaining()) {
            i2++;
            if (xj.remaining() >= 8) {
                long j = xj.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
                int i3 = (int) j;
                int position = xj.position() + i3;
                if (i3 <= xj.remaining()) {
                    if (xj.getInt() == i) {
                        return hf(xj, i3 - 4);
                    }
                    xj.position(position);
                } else {
                    StringBuilder B7CMnp2 = A2egSU.B7CMnp(i2, i3, "APK Signing Block entry #", " size out of range: ", ", available: ");
                    B7CMnp2.append(xj.remaining());
                    throw new Exception(B7CMnp2.toString());
                }
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    public static void xj(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer xj(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, capacity, "end > capacity: ", " > "));
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "end < start: ", " < "));
    }
}
