package com.bytedance.pangle.f;

import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class c {
    private static final byte[] xj = new byte[8];

    public static class hf implements tf {
        private final ByteBuffer hf;
        private final byte[] kd;
        private final byte[] u;
        private final MessageDigest w;
        private int xj;

        /* JADX INFO: Access modifiers changed from: private */
        public void hf() {
            int position = this.hf.position() % f.a.c;
            if (position == 0) {
                return;
            }
            this.hf.put(ByteBuffer.allocate(4096 - position));
        }

        private hf(byte[] bArr, ByteBuffer byteBuffer) {
            this.u = new byte[32];
            this.kd = bArr;
            this.hf = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            this.w = messageDigest;
            messageDigest.update(bArr);
            this.xj = 0;
        }

        @Override // com.bytedance.pangle.f.tf
        public void xj(ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.xj);
                byteBuffer.limit(byteBuffer.position() + min);
                this.w.update(byteBuffer);
                remaining -= min;
                int i = this.xj + min;
                this.xj = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.w;
                    byte[] bArr = this.u;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.hf.put(this.u);
                    this.w.update(this.kd);
                    this.xj = 0;
                }
            }
        }

        public void xj() {
            if (this.xj == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.xj);
        }
    }

    public static class xj {
        public final byte[] hf;
        public final ByteBuffer xj;

        public xj(ByteBuffer byteBuffer, byte[] bArr) {
            this.xj = byteBuffer;
            this.hf = bArr;
        }
    }

    static {
        OUenq();
    }

    private static /* synthetic */ void OUenq() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static int[] hf(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = xj(j, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) * 32;
            arrayList.add(Long.valueOf(xj(j, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF));
        } while (j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + xj(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    public static xj xj(RandomAccessFile randomAccessFile, g gVar, d dVar) {
        int i = hf(randomAccessFile.length() - (gVar.w - gVar.hf))[r0.length - 1];
        int i2 = i + f.a.c;
        ByteBuffer xj2 = dVar.xj(i2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        xj2.order(byteOrder);
        ByteBuffer xj3 = xj(xj2, 0, i);
        int i3 = i + 64;
        ByteBuffer xj4 = xj(xj2, i, i3);
        ByteBuffer xj5 = xj(xj2, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        xj(randomAccessFile, gVar, xj3, wrap, xj4, xj5);
        xj2.position(xj5.limit() + i3);
        xj2.putInt(xj5.limit() + 68);
        xj2.flip();
        return new xj(xj2, bArr);
    }

    private static void xj(RandomAccessFile randomAccessFile, g gVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) {
        xj(gVar);
        long j = gVar.w - gVar.hf;
        int[] hf2 = hf(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] xj2 = xj(randomAccessFile, gVar, xj, hf2, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(xj2);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            xj(byteBuffer3, randomAccessFile.length(), hf2.length - 1, xj);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            xj(byteBuffer4, gVar.hf, j, gVar.u);
        }
    }

    private static void xj(tf tfVar, p pVar, int i) {
        long xj2 = pVar.xj();
        long j = 0;
        while (xj2 > 0) {
            int min = (int) Math.min(xj2, i);
            pVar.xj(tfVar, j, min);
            long j2 = min;
            j += j2;
            xj2 -= j2;
        }
    }

    private static void xj(RandomAccessFile randomAccessFile, g gVar, byte[] bArr, ByteBuffer byteBuffer) {
        hf hfVar = new hf(bArr, byteBuffer);
        xj(hfVar, new pl(randomAccessFile.getFD(), 0L, gVar.hf), 1048576);
        long j = gVar.u;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = gVar.w;
        xj(hfVar, new pl(fd, j2, (16 + j) - j2), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(xj(gVar.hf));
        order.flip();
        hfVar.xj(order);
        long j3 = j + 20;
        xj(hfVar, new pl(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
        if (length != 0) {
            hfVar.xj(ByteBuffer.allocate(4096 - length));
        }
        hfVar.xj();
        hfVar.hf();
    }

    private static byte[] xj(RandomAccessFile randomAccessFile, g gVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        xj(randomAccessFile, gVar, bArr, xj(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer xj2 = xj(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer xj3 = xj(byteBuffer, iArr[length], iArr[i]);
                f fVar = new f(xj2);
                hf hfVar = new hf(bArr, xj3);
                xj(hfVar, fVar, f.a.c);
                hfVar.xj();
                hfVar.hf();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                hf hfVar2 = new hf(bArr, ByteBuffer.wrap(bArr2));
                hfVar2.xj(xj(byteBuffer, 0, f.a.c));
                hfVar2.xj();
                return bArr2;
            }
        }
    }

    private static ByteBuffer xj(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length == 8) {
            byteBuffer.put("TrueBrew".getBytes());
            byteBuffer.put((byte) 1);
            byteBuffer.put((byte) 0);
            byteBuffer.put((byte) 12);
            byteBuffer.put((byte) 7);
            byteBuffer.putShort((short) 1);
            byteBuffer.putShort((short) 1);
            byteBuffer.putInt(0);
            byteBuffer.putInt(0);
            byteBuffer.putLong(j);
            byteBuffer.put((byte) 2);
            byteBuffer.put((byte) 0);
            byteBuffer.put(bArr);
            xj(byteBuffer, 22);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static ByteBuffer xj(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        xj(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        xj(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(xj(j));
        xj(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void xj(g gVar) {
        long j = gVar.hf;
        if (j % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + gVar.hf);
        }
        if ((gVar.w - j) % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF == 0) {
            return;
        }
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (gVar.w - gVar.hf));
    }

    private static ByteBuffer xj(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    private static void xj(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long xj(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int xj(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
