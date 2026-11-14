package LCJm5h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f4433A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f4434A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final long f4435A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final long f4436ADYaiT;

    public ASJ6gh(String str, String str2, long j, long j2) {
        this.f4433A2egSU = str;
        this.f4434A4TApA = str2;
        this.f4435A5SV6n = j;
        this.f4436ADYaiT = j2;
    }

    public static ASJ6gh A2egSU(String str) {
        if (str.isEmpty()) {
            return null;
        }
        String[] split = str.split("§", 4);
        if (split.length < 4) {
            return null;
        }
        try {
            return new ASJ6gh(split[0], split[1], Long.parseLong(split[2]), Long.parseLong(split[3]));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String A4TApA() {
        return this.f4433A2egSU + "§" + this.f4434A4TApA + "§" + this.f4435A5SV6n + "§" + this.f4436ADYaiT;
    }
}
