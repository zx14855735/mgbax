package com.bytedance.pangle.f;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class y {
    static final HashMap<String, SparseArray<g>> xj = new HashMap<>();

    public static class xj implements tf {
        private final MessageDigest[] xj;

        public xj(MessageDigest[] messageDigestArr) {
            this.xj = messageDigestArr;
        }

        @Override // com.bytedance.pangle.f.tf
        public void xj(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.xj) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    static {
        YAbrO();
    }

    private static /* synthetic */ void YAbrO() {
        char[] charArray = "ÂÎÌ\u008fÆÀÌÄ\u008fÃÎØ\u008fÒÉÄÍÍ\u008fëÏÈãÓÈÅÆÄ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 161);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÂÍÈÏÈÕ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 161);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static int hf(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    private static int kd(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> u(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    public static String w(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return "RSA";
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
        }
    }

    public static void xj(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, g gVar) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                xj(arrayMap, randomAccessFile.getFD(), gVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            xj(map.get(3), randomAccessFile, gVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void w(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static String hf(int i) {
        if (i == 1) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (i == 2) {
            return MessageDigestAlgorithms.SHA_512;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
        }
        return MessageDigestAlgorithms.SHA_256;
    }

    public static byte[] hf(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            StringBuilder B9tovu2 = A2egSU.B9tovu(i, "Underflow while reading length-prefixed value. Length: ", ", available: ");
            B9tovu2.append(byteBuffer.remaining());
            throw new IOException(B9tovu2.toString());
        }
        throw new IOException("Negative length");
    }

    private static void xj(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, g gVar) {
        pl plVar = new pl(fileDescriptor, 0L, gVar.hf);
        long j = gVar.w;
        pl plVar2 = new pl(fileDescriptor, j, gVar.u - j);
        ByteBuffer duplicate = gVar.kd.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        v.xj(duplicate, gVar.hf);
        f fVar = new f(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] xj2 = xj(iArr, new p[]{plVar, plVar2, fVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), xj2[i2])) {
                    throw new SecurityException(CtFAbx.B25kr6(new StringBuilder(), hf(i3), " digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] xj(int[] iArr, p[] pVarArr) {
        p[] pVarArr2 = pVarArr;
        long j = 0;
        for (p pVar : pVarArr2) {
            j += xj(pVar.xj());
        }
        if (j < 2097151) {
            int i = (int) j;
            byte[][] bArr = new byte[iArr.length][];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                byte[] bArr2 = new byte[(kd(iArr[i2]) * i) + 5];
                bArr2[0] = 90;
                xj(i, bArr2, 1);
                bArr[i2] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                String hf = hf(iArr[i3]);
                try {
                    messageDigestArr[i3] = MessageDigest.getInstance(hf);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(CtFAbx.AcNBzu(hf, " digest not supported"), e);
                }
            }
            xj xjVar = new xj(messageDigestArr);
            int length2 = pVarArr2.length;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length2) {
                p pVar2 = pVarArr2[i4];
                byte[][] bArr4 = bArr;
                long xj2 = pVar2.xj();
                int i7 = i6;
                long j2 = 0;
                while (xj2 > 0) {
                    int min = (int) Math.min(xj2, BaseConstants.MB_VALUE);
                    xj(min, bArr3, 1);
                    for (int i8 = 0; i8 < length; i8++) {
                        messageDigestArr[i8].update(bArr3);
                    }
                    byte[] bArr5 = bArr3;
                    long j3 = j2;
                    try {
                        pVar2.xj(xjVar, j3, min);
                        int i9 = 0;
                        while (i9 < iArr.length) {
                            int i10 = iArr[i9];
                            byte[] bArr6 = bArr4[i9];
                            int kd = kd(i10);
                            p pVar3 = pVar2;
                            MessageDigest messageDigest = messageDigestArr[i9];
                            long j4 = xj2;
                            int digest = messageDigest.digest(bArr6, (i7 * kd) + 5, kd);
                            if (digest != kd) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i9++;
                            pVar2 = pVar3;
                            xj2 = j4;
                        }
                        long j5 = min;
                        j2 = j3 + j5;
                        xj2 -= j5;
                        i7++;
                        bArr3 = bArr5;
                    } catch (IOException e2) {
                        throw new DigestException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i7, i5, "Failed to digest chunk #", " of section #"), e2);
                    }
                }
                i5++;
                i4++;
                pVarArr2 = pVarArr;
                i6 = i7;
                bArr = bArr4;
            }
            byte[][] bArr7 = bArr;
            byte[][] bArr8 = new byte[iArr.length][];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                int i12 = iArr[i11];
                byte[] bArr9 = bArr7[i11];
                String hf2 = hf(i12);
                try {
                    bArr8[i11] = MessageDigest.getInstance(hf2).digest(bArr9);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(CtFAbx.AcNBzu(hf2, " digest not supported"), e3);
                }
            }
            return bArr8;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(j)));
    }

    public static byte[] xj(byte[] bArr, long j, g gVar) {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j - (gVar.w - gVar.hf)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    private static void xj(byte[] bArr, RandomAccessFile randomAccessFile, g gVar) {
        try {
            if (Arrays.equals(xj(bArr, randomAccessFile.length(), gVar), c.xj(randomAccessFile, gVar, new d() { // from class: com.bytedance.pangle.f.y.1
                @Override // com.bytedance.pangle.f.d
                public ByteBuffer xj(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).hf)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    public static Pair<ByteBuffer, Long> xj(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> xj2 = v.xj(randomAccessFile);
        if (xj2 != null) {
            return xj2;
        }
        throw new am("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static long xj(ByteBuffer byteBuffer, long j) {
        long xj2 = v.xj(byteBuffer);
        if (xj2 <= j) {
            if (v.hf(byteBuffer) + xj2 == j) {
                return xj2;
            }
            throw new am("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("ZIP Central Directory offset out of range: ", xj2, ". ZIP End of Central Directory offset: ");
        B2KMhB2.append(j);
        throw new am(B2KMhB2.toString());
    }

    private static long xj(long j) {
        return (j + 1048575) / BaseConstants.MB_VALUE;
    }

    public static int xj(int i, int i2) {
        return hf(xj(i), xj(i2));
    }

    public static int xj(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
        }
    }

    public static ByteBuffer xj(ByteBuffer byteBuffer, int i, int i2) {
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

    public static ByteBuffer xj(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 >= position && i2 <= limit) {
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
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
    }

    public static ByteBuffer xj(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return xj(byteBuffer, i);
                }
                StringBuilder B9tovu2 = A2egSU.B9tovu(i, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ");
                B9tovu2.append(byteBuffer.remaining());
                throw new IOException(B9tovu2.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static void xj(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static Pair<ByteBuffer, Long> xj(RandomAccessFile randomAccessFile, long j) {
        if (j >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
                return null;
            }
            long j2 = allocate.getLong(0);
            if (j2 < allocate.capacity() || j2 > 2147483639) {
                throw new am("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
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
                throw new am(B2KMhB2.toString());
            }
            throw new am("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        throw new am("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
    }

    public static void xj(String str, RandomAccessFile randomAccessFile, int... iArr) {
        xj.put(str, new SparseArray<>());
        Pair<ByteBuffer, Long> xj2 = xj(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) xj2.first;
        long longValue = ((Long) xj2.second).longValue();
        if (!v.xj(randomAccessFile, longValue)) {
            long xj3 = xj(byteBuffer, longValue);
            Pair<ByteBuffer, Long> xj4 = xj(randomAccessFile, xj3);
            if (xj4 == null) {
                return;
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) xj4.first;
            long longValue2 = ((Long) xj4.second).longValue();
            w(byteBuffer2);
            ByteBuffer xj5 = xj(byteBuffer2, 8, byteBuffer2.capacity() - 24);
            HashSet hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
            while (xj5.hasRemaining() && xj5.remaining() >= 8) {
                long j = xj5.getLong();
                if (j < 4 || j > 2147483647L) {
                    return;
                }
                int i2 = (int) j;
                int position = xj5.position() + i2;
                if (i2 > xj5.remaining()) {
                    return;
                }
                int i3 = xj5.getInt();
                if (hashSet.contains(Integer.valueOf(i3))) {
                    xj.get(str).put(i3, new g(xj(xj5, i2 - 4), longValue2, xj3, longValue, byteBuffer));
                }
                xj5.position(position);
            }
            return;
        }
        throw new am("ZIP64 APK not supported");
    }
}
