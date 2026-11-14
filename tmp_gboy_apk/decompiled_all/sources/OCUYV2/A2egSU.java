package OCUYV2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f6219A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f6220A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f6221A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6222ADYaiT;
    public final float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f6223ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f6224ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6225AYUAbz;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        if (r6 > r3.f6220A4TApA) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
    
        if (r3.f6223ARc23Z <= r3.f6220A4TApA) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A2egSU(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OCUYV2.A2egSU.<init>(int, float, float, float, int, float, int, float, int, float):void");
    }

    public static A2egSU A2egSU(float f, float f2, float f3, float f4, int[] iArr, float f5, int[] iArr2, float f6, int[] iArr3) {
        A2egSU a2egSU = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3];
                int length2 = iArr.length;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = length;
                    int i7 = i3;
                    int i8 = i;
                    int i9 = length2;
                    int i10 = i5;
                    A2egSU a2egSU2 = new A2egSU(i8, f2, f3, f4, iArr[i5], f5, i4, f6, i2, f);
                    float f7 = a2egSU2.f6225AYUAbz;
                    if (a2egSU == null || f7 < a2egSU.f6225AYUAbz) {
                        if (f7 == 0.0f) {
                            return a2egSU2;
                        }
                        a2egSU = a2egSU2;
                    }
                    int i11 = i8 + 1;
                    i5 = i10 + 1;
                    i3 = i7;
                    i = i11;
                    length = i6;
                    length2 = i9;
                }
                i3++;
                i = i;
                length = length;
            }
        }
        return a2egSU;
    }

    public final String toString() {
        return "Arrangement [priority=" + this.f6219A2egSU + ", smallCount=" + this.f6221A5SV6n + ", smallSize=" + this.f6220A4TApA + ", mediumCount=" + this.f6222ADYaiT + ", mediumSize=" + this.AMqCpz + ", largeCount=" + this.f6224ASJ6gh + ", largeSize=" + this.f6223ARc23Z + ", cost=" + this.f6225AYUAbz + "]";
    }
}
