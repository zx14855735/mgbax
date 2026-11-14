package PCV8se;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B25kr6 extends AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f7082A2egSU = -1.0f;

    @Override // PCV8se.AMqCpz
    public final void A2egSU(BJ7GGh bJ7GGh, float f, float f2) {
        float f3 = f2 * f;
        bJ7GGh.ADYaiT(0.0f, f3, 180.0f, 90.0f);
        float f4 = f3 * 2.0f;
        bJ7GGh.getClass();
        BIYEnU bIYEnU = new BIYEnU(0.0f, 0.0f, f4, f4);
        bIYEnU.f7126ARc23Z = 180.0f;
        bIYEnU.f7127ASJ6gh = 90.0f;
        bJ7GGh.f7133ASJ6gh.add(bIYEnU);
        BChYOn bChYOn = new BChYOn(bIYEnU);
        float f5 = 180.0f + 90.0f;
        boolean z = 90.0f < 0.0f;
        float f6 = z ? (180.0f + 180.0f) % 360.0f : 180.0f;
        float f7 = z ? (180.0f + f5) % 360.0f : f5;
        bJ7GGh.A2egSU(f6);
        bJ7GGh.f7134AYUAbz.add(bChYOn);
        bJ7GGh.AMqCpz = f7;
        double d = f5;
        bJ7GGh.f7130A5SV6n = (((f4 - 0.0f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((0.0f + f4) * 0.5f);
        bJ7GGh.f7131ADYaiT = (((f4 - 0.0f) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((0.0f + f4) * 0.5f);
    }
}
