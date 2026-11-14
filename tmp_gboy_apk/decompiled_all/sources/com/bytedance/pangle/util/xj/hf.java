package com.bytedance.pangle.util.xj;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.util.Pair;
import com.bytedance.pangle.util.y;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static String xj = "";

    private static ByteBuffer hf(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> xj2 = xj(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) xj2.first;
            long longValue = ((Long) xj2.second).longValue();
            if (w.xj(randomAccessFile, longValue)) {
                throw new Exception("ZIP64 APK not supported");
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) xj(randomAccessFile, xj(byteBuffer, longValue)).first;
            randomAccessFile.close();
            return byteBuffer2;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String[] xj(File file) {
        String str;
        String str2 = "";
        try {
            ByteBuffer hf = hf(file);
            if (xj(hf)) {
                str2 = y.xj(hf.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = str2;
        }
        return new String[]{str2, xj, str};
    }

    private static Pair<ByteBuffer, Long> xj(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> xj2 = w.xj(randomAccessFile);
        if (xj2 != null) {
            return xj2;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long xj(ByteBuffer byteBuffer, long j) {
        long xj2 = w.xj(byteBuffer);
        if (xj2 <= j) {
            if (w.hf(byteBuffer) + xj2 == j) {
                return xj2;
            }
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("ZIP Central Directory offset out of range: ", xj2, ". ZIP End of Central Directory offset: ");
        B2KMhB2.append(j);
        throw new Exception(B2KMhB2.toString());
    }

    private static void hf(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static Pair<ByteBuffer, Long> xj(RandomAccessFile randomAccessFile, long j) {
        if (j >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j2 = allocate.getLong(0);
                if (j2 < allocate.capacity() || j2 > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                }
                int i = (int) (8 + j2);
                long j3 = j - i;
                if (j3 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j4 = allocate2.getLong(0);
                    if (j4 == j2) {
                        return Pair.create(allocate2, Long.valueOf(j3));
                    }
                    StringBuilder B2KMhB2 = CtFAbx.B2KMhB("APK Signing Block sizes in header and footer do not match: ", j4, " vs ");
                    B2KMhB2.append(j2);
                    throw new Exception(B2KMhB2.toString());
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
    }

    private static boolean xj(ByteBuffer byteBuffer) {
        hf(byteBuffer);
        ByteBuffer xj2 = xj(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (xj2.hasRemaining()) {
            i++;
            if (xj2.remaining() >= 8) {
                long j = xj2.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                }
                int i2 = (int) j;
                int position = xj2.position() + i2;
                if (i2 <= xj2.remaining()) {
                    int i3 = xj2.getInt();
                    if (i3 == -262969152) {
                        xj = "V3";
                        return true;
                    }
                    if (i3 == 1896449818) {
                        xj = "V2";
                        return true;
                    }
                    xj2.position(position);
                } else {
                    StringBuilder B7CMnp2 = A2egSU.B7CMnp(i, i2, "APK Signing Block entry #", " size out of range: ", ", available: ");
                    B7CMnp2.append(xj2.remaining());
                    throw new Exception(B7CMnp2.toString());
                }
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
        }
        return false;
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
