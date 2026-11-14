package H0R8Px;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ARc23Z f3152A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f3153A4TApA;

    public ASJ6gh() {
        long maxMemory = Runtime.getRuntime().maxMemory() / 8;
        if (10485760 > maxMemory) {
            this.f3153A4TApA = (int) maxMemory;
        } else {
            this.f3153A4TApA = 10485760;
        }
        this.f3152A2egSU = new ARc23Z(this.f3153A4TApA, 0);
    }
}
