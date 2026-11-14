package B25kr6;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long[] f1001A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float[] f1002A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f1003A5SV6n;

    public AcNBzu(int i) {
        int i2;
        long[] jArr = AmA8tU.f1008A2egSU;
        this.f1001A2egSU = jArr;
        this.f1002A4TApA = ASJ6gh.f987A2egSU;
        if (i < 0) {
            B2KMhB.A2egSU.A5SV6n("Capacity must be a positive value.");
            throw null;
        }
        int i3 = i == 7 ? 8 : i + ((i - 1) / 7);
        if (i3 > 0) {
            i2 = Math.max(7, i3 > 0 ? (-1) >>> Integer.numberOfLeadingZeros(i3) : 0);
        } else {
            i2 = 0;
        }
        this.f1003A5SV6n = i2;
        if (i2 != 0) {
            int i4 = ((i2 + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i4];
            Arrays.fill(jArr2, 0, i4, -9187201950435737472L);
            jArr = jArr2;
        }
        this.f1001A2egSU = jArr;
        int i5 = i2 >> 3;
        long j = 255 << ((i2 & 7) << 3);
        jArr[i5] = (jArr[i5] & (~j)) | j;
        this.f1002A4TApA = new float[i2];
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bd, code lost:
    
        r27 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cb, code lost:
    
        if (((r12 & ((~r12) << 6)) & r23) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
    
        r13 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B25kr6.AcNBzu.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        float[] fArr = this.f1002A4TApA;
        long[] jArr = this.f1001A2egSU;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        i2 = Float.floatToIntBits(fArr[(i << 3) + i4]) + i2;
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
            }
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        float[] fArr = this.f1002A4TApA;
        long[] jArr = this.f1001A2egSU;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            sb.append(f);
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append((CharSequence) "]");
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }

    public AcNBzu() {
        this(6);
    }
}
