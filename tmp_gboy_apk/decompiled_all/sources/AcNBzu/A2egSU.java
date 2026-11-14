package AcNBzu;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends ADYaiT {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile A2egSU f936A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A5SV6n f937A2egSU = new A5SV6n();

    public static A2egSU A2egSU() {
        if (f936A4TApA != null) {
            return f936A4TApA;
        }
        synchronized (A2egSU.class) {
            try {
                if (f936A4TApA == null) {
                    f936A4TApA = new A2egSU();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f936A4TApA;
    }
}
