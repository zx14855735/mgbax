package ADYaiT;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DG07BK {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static DG07BK f231ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f232A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f233A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f234A5SV6n;

    public final void A2egSU(double d, double d2, long j) {
        double d3 = (0.01720197f * ((j - 946728000000L) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(d3) * 0.03341960161924362d) + d3 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d3) * 0.0053d) + Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d2) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d4 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d4))) / (Math.cos(asin) * Math.cos(d4));
        if (sin3 >= 1.0d) {
            this.f234A5SV6n = 1;
            this.f232A2egSU = -1L;
            this.f233A4TApA = -1L;
        } else {
            if (sin3 <= -1.0d) {
                this.f234A5SV6n = 0;
                this.f232A2egSU = -1L;
                this.f233A4TApA = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f232A2egSU = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f233A4TApA = round;
            if (round >= j || this.f232A2egSU <= j) {
                this.f234A5SV6n = 1;
            } else {
                this.f234A5SV6n = 0;
            }
        }
    }
}
