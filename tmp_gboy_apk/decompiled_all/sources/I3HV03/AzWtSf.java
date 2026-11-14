package I3HV03;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements HSHyT0.ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final byte[] f3823A2egSU = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f3824A4TApA = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int A4TApA(AZkASS.ARc23Z aRc23Z, byte[] bArr, int i) {
        ByteOrder byteOrder;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = ((InputStream) aRc23Z.f451AlLFFp).read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new AlLFFp();
        }
        if (i2 != i) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr2 = f3823A2egSU;
        boolean z = bArr != null && i > bArr2.length;
        if (z) {
            int i4 = 0;
            while (true) {
                if (i4 >= bArr2.length) {
                    break;
                }
                if (bArr[i4] != bArr2[i4]) {
                    z = false;
                    break;
                }
                i4++;
            }
        }
        if (!z) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        short s = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
        if (s == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (s != 19789) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        byteBuffer.order(byteOrder);
        int i5 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
        int i6 = i5 + 6;
        short s2 = byteBuffer.remaining() - i6 >= 2 ? byteBuffer.getShort(i6) : (short) -1;
        for (int i7 = 0; i7 < s2; i7++) {
            int i8 = (i7 * 12) + i5 + 8;
            if ((byteBuffer.remaining() - i8 >= 2 ? byteBuffer.getShort(i8) : (short) -1) == 274) {
                int i9 = i8 + 2;
                short s3 = byteBuffer.remaining() - i9 >= 2 ? byteBuffer.getShort(i9) : (short) -1;
                if (s3 < 1 || s3 > 12) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                } else {
                    int i10 = i8 + 4;
                    int i11 = byteBuffer.remaining() - i10 >= 4 ? byteBuffer.getInt(i10) : -1;
                    if (i11 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        int i12 = i11 + f3824A4TApA[s3];
                        if (i12 > 4) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                        } else {
                            int i13 = i8 + 8;
                            if (i13 < 0 || i13 > byteBuffer.remaining()) {
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            } else {
                                if (i12 >= 0 && i12 + i13 <= byteBuffer.remaining()) {
                                    if (byteBuffer.remaining() - i13 >= 2) {
                                        return byteBuffer.getShort(i13);
                                    }
                                    return -1;
                                }
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override // HSHyT0.ADYaiT
    public final int A2egSU(InputStream inputStream, HZUvgL.AaHO0E aaHO0E) {
        int i;
        AZkASS.ARc23Z aRc23Z = new AZkASS.ARc23Z(17, inputStream);
        ItGa5w.ARc23Z.A5SV6n(aaHO0E, "Argument must not be null");
        try {
            int ASJ6gh2 = aRc23Z.ASJ6gh();
            if (!((ASJ6gh2 & 65496) == 65496 || ASJ6gh2 == 19789 || ASJ6gh2 == 18761)) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (aRc23Z.AcNBzu() == 255) {
                    short AcNBzu2 = aRc23Z.AcNBzu();
                    if (AcNBzu2 == 218) {
                        break;
                    }
                    if (AcNBzu2 != 217) {
                        i = aRc23Z.ASJ6gh() - 2;
                        if (AcNBzu2 == 225) {
                            break;
                        }
                        long j = i;
                        if (aRc23Z.skip(j) != j) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            break;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    break;
                }
            }
            i = -1;
            if (i == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            byte[] bArr = (byte[]) aaHO0E.ADYaiT(i, byte[].class);
            try {
                return A4TApA(aRc23Z, bArr, i);
            } finally {
                aaHO0E.AYUAbz(bArr);
            }
        } catch (AlLFFp unused) {
            return -1;
        }
    }

    @Override // HSHyT0.ADYaiT
    public ImageHeaderParser$ImageType getType(InputStream inputStream) {
        ItGa5w.ARc23Z.A5SV6n(inputStream, "Argument must not be null");
        return getType(new AZkASS.ARc23Z(17, inputStream));
    }

    @Override // HSHyT0.ADYaiT
    public ImageHeaderParser$ImageType getType(ByteBuffer byteBuffer) {
        ItGa5w.ARc23Z.A5SV6n(byteBuffer, "Argument must not be null");
        return getType(new AcNBzu(byteBuffer, 0));
    }

    private ImageHeaderParser$ImageType getType(AmA8tU amA8tU) {
        try {
            int ASJ6gh2 = amA8tU.ASJ6gh();
            if (ASJ6gh2 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int AcNBzu2 = (ASJ6gh2 << 8) | amA8tU.AcNBzu();
            if (AcNBzu2 == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int AcNBzu3 = (AcNBzu2 << 8) | amA8tU.AcNBzu();
            if (AcNBzu3 == -1991225785) {
                amA8tU.skip(21L);
                try {
                    return amA8tU.AcNBzu() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (AlLFFp unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (AcNBzu3 != 1380533830) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            amA8tU.skip(4L);
            if (((amA8tU.ASJ6gh() << 16) | amA8tU.ASJ6gh()) != 1464156752) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int ASJ6gh3 = (amA8tU.ASJ6gh() << 16) | amA8tU.ASJ6gh();
            if ((ASJ6gh3 & (-256)) != 1448097792) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int i = ASJ6gh3 & 255;
            if (i == 88) {
                amA8tU.skip(4L);
                return (amA8tU.AcNBzu() & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (i == 76) {
                amA8tU.skip(4L);
                return (amA8tU.AcNBzu() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            return ImageHeaderParser$ImageType.WEBP;
        } catch (AlLFFp unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }
}
