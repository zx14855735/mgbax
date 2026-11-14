package HXc4pW;

import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp implements HSHyT0.AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f3596A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f3597A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f3598ADYaiT;
    public final Class AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Class f3599ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final HSHyT0.AZkASS f3600ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ItGa5w.A5SV6n f3601AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final HSHyT0.AmA8tU f3602AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f3603AZkASS;

    public B7CMnp(Object obj, HSHyT0.AZkASS aZkASS, int i, int i2, ItGa5w.A5SV6n a5SV6n, Class cls, Class cls2, HSHyT0.AmA8tU amA8tU) {
        ItGa5w.ARc23Z.A5SV6n(obj, "Argument must not be null");
        this.f3596A4TApA = obj;
        ItGa5w.ARc23Z.A5SV6n(aZkASS, "Signature must not be null");
        this.f3600ASJ6gh = aZkASS;
        this.f3597A5SV6n = i;
        this.f3598ADYaiT = i2;
        ItGa5w.ARc23Z.A5SV6n(a5SV6n, "Argument must not be null");
        this.f3601AYUAbz = a5SV6n;
        ItGa5w.ARc23Z.A5SV6n(cls, "Resource class must not be null");
        this.AMqCpz = cls;
        ItGa5w.ARc23Z.A5SV6n(cls2, "Transcode class must not be null");
        this.f3599ARc23Z = cls2;
        ItGa5w.ARc23Z.A5SV6n(amA8tU, "Argument must not be null");
        this.f3602AZOQYO = amA8tU;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (!(obj instanceof B7CMnp)) {
            return false;
        }
        B7CMnp b7CMnp = (B7CMnp) obj;
        return this.f3596A4TApA.equals(b7CMnp.f3596A4TApA) && this.f3600ASJ6gh.equals(b7CMnp.f3600ASJ6gh) && this.f3598ADYaiT == b7CMnp.f3598ADYaiT && this.f3597A5SV6n == b7CMnp.f3597A5SV6n && this.f3601AYUAbz.equals(b7CMnp.f3601AYUAbz) && this.AMqCpz.equals(b7CMnp.AMqCpz) && this.f3599ARc23Z.equals(b7CMnp.f3599ARc23Z) && this.f3602AZOQYO.equals(b7CMnp.f3602AZOQYO);
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        if (this.f3603AZkASS == 0) {
            int hashCode = this.f3596A4TApA.hashCode();
            this.f3603AZkASS = hashCode;
            int hashCode2 = ((((this.f3600ASJ6gh.hashCode() + (hashCode * 31)) * 31) + this.f3597A5SV6n) * 31) + this.f3598ADYaiT;
            this.f3603AZkASS = hashCode2;
            int hashCode3 = this.f3601AYUAbz.hashCode() + (hashCode2 * 31);
            this.f3603AZkASS = hashCode3;
            int hashCode4 = this.AMqCpz.hashCode() + (hashCode3 * 31);
            this.f3603AZkASS = hashCode4;
            int hashCode5 = this.f3599ARc23Z.hashCode() + (hashCode4 * 31);
            this.f3603AZkASS = hashCode5;
            this.f3603AZkASS = this.f3602AZOQYO.f3470A4TApA.hashCode() + (hashCode5 * 31);
        }
        return this.f3603AZkASS;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f3596A4TApA + ", width=" + this.f3597A5SV6n + ", height=" + this.f3598ADYaiT + ", resourceClass=" + this.AMqCpz + ", transcodeClass=" + this.f3599ARc23Z + ", signature=" + this.f3600ASJ6gh + ", hashCode=" + this.f3603AZkASS + ", transformations=" + this.f3601AYUAbz + ", options=" + this.f3602AZOQYO + '}';
    }
}
