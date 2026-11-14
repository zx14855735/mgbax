package OO3awZ;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO {
    public static A5SV6n A5SV6n(AZkASS aZkASS) {
        return aZkASS.f6410A5SV6n ? new A5SV6n("surface_bright", new AMqCpz(29), new ASJ6gh(0), true, null, null, null) : new A5SV6n("surface_dim", new AMqCpz(5), new AMqCpz(6), true, null, null, null);
    }

    public static A5SV6n ADYaiT() {
        return new A5SV6n("inverse_surface", new AYUAbz(14), new AYUAbz(15), false, null, null, null);
    }

    public static boolean AMqCpz(AZkASS aZkASS) {
        int i = aZkASS.f6409A4TApA;
        return i == 6 || i == 7;
    }

    public static boolean ARc23Z(AZkASS aZkASS) {
        return aZkASS.f6409A4TApA == 1;
    }

    public final A5SV6n A2egSU() {
        return new A5SV6n("error", new AYUAbz(5), new AYUAbz(6), true, new ARc23Z(3, this), new A4TApA(3.0d, 4.5d, 7.0d, 7.0d), new ARc23Z(20, this));
    }

    public final A5SV6n A4TApA() {
        return new A5SV6n("error_container", new AYUAbz(20), new AYUAbz(21), true, new ARc23Z(3, this), new A4TApA(1.0d, 1.0d, 3.0d, 4.5d), new ARc23Z(22, this));
    }

    public final A5SV6n ASJ6gh() {
        return new A5SV6n("primary", new AMqCpz(1), new AMqCpz(2), true, new ARc23Z(3, this), new A4TApA(3.0d, 4.5d, 7.0d, 7.0d), new ARc23Z(0, this));
    }

    public final A5SV6n AYUAbz() {
        return new A5SV6n("primary_container", new AMqCpz(18), new ARc23Z(5, this), true, new ARc23Z(3, this), new A4TApA(1.0d, 1.0d, 3.0d, 4.5d), new ARc23Z(6, this));
    }

    public final A5SV6n AZOQYO() {
        return new A5SV6n("secondary", new ASJ6gh(23), new ASJ6gh(24), true, new ARc23Z(3, this), new A4TApA(3.0d, 4.5d, 7.0d, 7.0d), new ARc23Z(14, this));
    }

    public final A5SV6n AZkASS() {
        return new A5SV6n("secondary_container", new AMqCpz(13), new ARc23Z(2, this), true, new ARc23Z(3, this), new A4TApA(1.0d, 1.0d, 3.0d, 4.5d), new ARc23Z(4, this));
    }

    public final A5SV6n AaHO0E() {
        return new A5SV6n("tertiary", new AMqCpz(3), new AMqCpz(4), true, new ARc23Z(3, this), new A4TApA(3.0d, 4.5d, 7.0d, 7.0d), new ARc23Z(1, this));
    }

    public final A5SV6n AcNBzu() {
        return new A5SV6n("tertiary_container", new ASJ6gh(19), new ARc23Z(11, this), true, new ARc23Z(3, this), new A4TApA(1.0d, 1.0d, 3.0d, 4.5d), new ARc23Z(12, this));
    }
}
