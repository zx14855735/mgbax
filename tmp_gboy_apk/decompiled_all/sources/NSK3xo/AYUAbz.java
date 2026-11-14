package NSK3xo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A5SV6n f5929A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ASJ6gh f5930A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f5931A5SV6n;

    public AYUAbz(String str, A5SV6n a5SV6n, ASJ6gh aSJ6gh) {
        this.f5931A5SV6n = str;
        this.f5929A2egSU = a5SV6n;
        this.f5930A4TApA = aSJ6gh;
    }

    public final ASJ6gh A2egSU() {
        ASJ6gh aSJ6gh = this.f5930A4TApA;
        if (aSJ6gh != null) {
            return aSJ6gh;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
