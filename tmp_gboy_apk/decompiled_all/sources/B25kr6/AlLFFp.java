package B25kr6;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long[] f1004A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object[] f1005A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object[] f1006A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f1007ADYaiT;

    public AlLFFp(int i) {
        int i2;
        long[] jArr = AmA8tU.f1008A2egSU;
        this.f1004A2egSU = jArr;
        Object[] objArr = B2KMhB.A2egSU.f1017A4TApA;
        this.f1005A4TApA = objArr;
        this.f1006A5SV6n = objArr;
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
        this.f1007ADYaiT = i2;
        if (i2 != 0) {
            int i4 = ((i2 + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i4];
            Arrays.fill(jArr2, 0, i4, -9187201950435737472L);
            int i5 = i2 >> 3;
            long j = 255 << ((i2 & 7) << 3);
            jArr2[i5] = (jArr2[i5] & (~j)) | j;
            jArr = jArr2;
        }
        this.f1004A2egSU = jArr;
        this.f1005A4TApA = i2 == 0 ? objArr : new Object[i2];
        this.f1006A5SV6n = i2 != 0 ? new Object[i2] : objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A2egSU(java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = 0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13.f1007ADYaiT
            int r1 = r1 >>> 7
        L17:
            r1 = r1 & r3
            long[] r4 = r13.f1004A2egSU
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L45:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L64
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.f1005A4TApA
            r11 = r11[r10]
            boolean r11 = RXb0Sz.ARc23Z.A2egSU(r11, r14)
            if (r11 == 0) goto L5e
            goto L6e
        L5e:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L45
        L64:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L77
            r10 = -1
        L6e:
            if (r10 < 0) goto L75
            java.lang.Object[] r14 = r13.f1006A5SV6n
            r14 = r14[r10]
            return r14
        L75:
            r14 = 0
            return r14
        L77:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: B25kr6.AlLFFp.A2egSU(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
    
        r26 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dc, code lost:
    
        if (((r2 & ((~r2) << 6)) & r19) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00de, code lost:
    
        r24 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B25kr6.AlLFFp.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Object[] objArr = this.f1005A4TApA;
        Object[] objArr2 = this.f1006A5SV6n;
        long[] jArr = this.f1004A2egSU;
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
                        int i5 = (i << 3) + i4;
                        Object obj = objArr[i5];
                        Object obj2 = objArr2[i5];
                        i2 += (obj2 != null ? obj2.hashCode() : 0) ^ (obj != null ? obj.hashCode() : 0);
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
        return "{}";
    }

    public AlLFFp() {
        this(6);
    }
}
