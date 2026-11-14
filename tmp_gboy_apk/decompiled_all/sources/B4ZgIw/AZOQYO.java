package B4ZgIw;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Comparable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f1079AcNBzu;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f1083B25kr6;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f1090BI9f7h;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1080AlLFFp = -1;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1081AmA8tU = -1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1082AzWtSf = 0;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f1084B2KMhB = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final float[] f1085B3GDIM = new float[9];

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final float[] f1086B4ZgIw = new float[9];

    /* renamed from: B7CMnp, reason: collision with root package name */
    public A4TApA[] f1087B7CMnp = new A4TApA[16];

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f1088B9tovu = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f1089BChYOn = 0;

    public AZOQYO(int i) {
        this.f1090BI9f7h = i;
    }

    public final void A2egSU(A4TApA a4TApA) {
        int i = 0;
        while (true) {
            int i2 = this.f1088B9tovu;
            if (i >= i2) {
                A4TApA[] a4TApAArr = this.f1087B7CMnp;
                if (i2 >= a4TApAArr.length) {
                    this.f1087B7CMnp = (A4TApA[]) Arrays.copyOf(a4TApAArr, a4TApAArr.length * 2);
                }
                A4TApA[] a4TApAArr2 = this.f1087B7CMnp;
                int i3 = this.f1088B9tovu;
                a4TApAArr2[i3] = a4TApA;
                this.f1088B9tovu = i3 + 1;
                return;
            }
            if (this.f1087B7CMnp[i] == a4TApA) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void A4TApA(A4TApA a4TApA) {
        int i = this.f1088B9tovu;
        int i2 = 0;
        while (i2 < i) {
            if (this.f1087B7CMnp[i2] == a4TApA) {
                while (i2 < i - 1) {
                    A4TApA[] a4TApAArr = this.f1087B7CMnp;
                    int i3 = i2 + 1;
                    a4TApAArr[i2] = a4TApAArr[i3];
                    i2 = i3;
                }
                this.f1088B9tovu--;
                return;
            }
            i2++;
        }
    }

    public final void A5SV6n() {
        this.f1090BI9f7h = 5;
        this.f1082AzWtSf = 0;
        this.f1080AlLFFp = -1;
        this.f1081AmA8tU = -1;
        this.f1083B25kr6 = 0.0f;
        this.f1084B2KMhB = false;
        int i = this.f1088B9tovu;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1087B7CMnp[i2] = null;
        }
        this.f1088B9tovu = 0;
        this.f1089BChYOn = 0;
        this.f1079AcNBzu = false;
        Arrays.fill(this.f1086B4ZgIw, 0.0f);
    }

    public final void ADYaiT(ADYaiT aDYaiT, float f) {
        this.f1083B25kr6 = f;
        this.f1084B2KMhB = true;
        int i = this.f1088B9tovu;
        this.f1081AmA8tU = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1087B7CMnp[i2].AYUAbz(aDYaiT, this, false);
        }
        this.f1088B9tovu = 0;
    }

    public final void AMqCpz(ADYaiT aDYaiT, A4TApA a4TApA) {
        int i = this.f1088B9tovu;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1087B7CMnp[i2].AZOQYO(aDYaiT, a4TApA, false);
        }
        this.f1088B9tovu = 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1080AlLFFp - ((AZOQYO) obj).f1080AlLFFp;
    }

    public final String toString() {
        return "" + this.f1080AlLFFp;
    }
}
