package IySJvm;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile A2egSU f4097A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f4098A2egSU;

    public A2egSU(int i) {
        this.f4098A2egSU = i;
    }

    public static A2egSU A2egSU() {
        if (f4097A4TApA == null) {
            synchronized (A2egSU.class) {
                try {
                    if (f4097A4TApA == null) {
                        f4097A4TApA = new A2egSU();
                    }
                } finally {
                }
            }
        }
        return f4097A4TApA;
    }

    public A2egSU(Throwable th) {
        this.f4098A2egSU = 207;
        th.getMessage();
    }

    public A2egSU(int i, int i2) {
        this.f4098A2egSU = i;
    }
}
