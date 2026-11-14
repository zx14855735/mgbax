package OvgpEe;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f6908A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f6909A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f6910A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f6911ADYaiT;
    public int[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6912ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f6913ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f6914AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f6915AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f6916AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f6917AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6918AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f6919AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f6920AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f6921AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f6922B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f6923B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6924B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Integer f6925B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f6926B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public float f6927B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f6928BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f6929BI9f7h;

    public final int A2egSU() {
        return this.f6911ADYaiT ? (int) (this.f6908A2egSU * this.f6910A5SV6n) : this.f6909A4TApA;
    }

    public final int A4TApA() {
        return !this.f6929BI9f7h ? A2egSU() : this.f6928BChYOn ? (int) (this.f6908A2egSU * this.f6927B9tovu) : this.f6926B7CMnp;
    }

    public final boolean A5SV6n(boolean z) {
        if (this.f6918AcNBzu <= 0) {
            return false;
        }
        if (z || this.f6917AaHO0E <= 0) {
            return z && this.f6916AZkASS > 0;
        }
        return true;
    }

    public final void ADYaiT() {
        if (this.f6915AZOQYO < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
        if (this.f6924B3GDIM < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.f6921AzWtSf == 0) {
            if ((A2egSU() > 0 || (this.f6929BI9f7h && A4TApA() > 0)) && this.f6915AZOQYO == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.AMqCpz.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}
