package AaHO0E;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class G16Pvp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f862A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f863A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f864A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f865ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f866ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f867ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f868AYUAbz;

    public final void A2egSU(int i, int i2) {
        this.f864A5SV6n = i;
        this.f865ADYaiT = i2;
        this.f868AYUAbz = true;
        if (this.f867ASJ6gh) {
            if (i2 != Integer.MIN_VALUE) {
                this.f862A2egSU = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f863A4TApA = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f862A2egSU = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f863A4TApA = i2;
        }
    }
}
