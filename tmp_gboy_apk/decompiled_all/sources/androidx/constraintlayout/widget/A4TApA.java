package androidx.constraintlayout.widget;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int[] f8284A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int[] f8285A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f8286A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int[] f8287ADYaiT;
    public float[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f8288ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int[] f8289ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public String[] f8290AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f8291AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int[] f8292AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean[] f8293AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f8294AcNBzu;

    public final void A2egSU(float f, int i) {
        int i2 = this.f8288ARc23Z;
        int[] iArr = this.f8287ADYaiT;
        if (i2 >= iArr.length) {
            this.f8287ADYaiT = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.AMqCpz;
            this.AMqCpz = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f8287ADYaiT;
        int i3 = this.f8288ARc23Z;
        iArr2[i3] = i;
        float[] fArr2 = this.AMqCpz;
        this.f8288ARc23Z = i3 + 1;
        fArr2[i3] = f;
    }

    public final void A4TApA(int i, int i2) {
        int i3 = this.f8286A5SV6n;
        int[] iArr = this.f8284A2egSU;
        if (i3 >= iArr.length) {
            this.f8284A2egSU = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f8285A4TApA;
            this.f8285A4TApA = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f8284A2egSU;
        int i4 = this.f8286A5SV6n;
        iArr3[i4] = i;
        int[] iArr4 = this.f8285A4TApA;
        this.f8286A5SV6n = i4 + 1;
        iArr4[i4] = i2;
    }

    public final void A5SV6n(int i, String str) {
        int i2 = this.f8291AZOQYO;
        int[] iArr = this.f8289ASJ6gh;
        if (i2 >= iArr.length) {
            this.f8289ASJ6gh = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f8290AYUAbz;
            this.f8290AYUAbz = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f8289ASJ6gh;
        int i3 = this.f8291AZOQYO;
        iArr2[i3] = i;
        String[] strArr2 = this.f8290AYUAbz;
        this.f8291AZOQYO = i3 + 1;
        strArr2[i3] = str;
    }

    public final void ADYaiT(int i, boolean z) {
        int i2 = this.f8294AcNBzu;
        int[] iArr = this.f8292AZkASS;
        if (i2 >= iArr.length) {
            this.f8292AZkASS = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f8293AaHO0E;
            this.f8293AaHO0E = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f8292AZkASS;
        int i3 = this.f8294AcNBzu;
        iArr2[i3] = i;
        boolean[] zArr2 = this.f8293AaHO0E;
        this.f8294AcNBzu = i3 + 1;
        zArr2[i3] = z;
    }
}
