package ms.bz.bd.c.Pgl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class p1 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile p1 f14033A2egSU;

    private p1() {
    }

    public static p1 A2egSU() {
        if (f14033A2egSU == null) {
            synchronized (p1.class) {
                try {
                    if (f14033A2egSU == null) {
                        f14033A2egSU = new p1();
                    }
                } finally {
                }
            }
        }
        return f14033A2egSU;
    }
}
