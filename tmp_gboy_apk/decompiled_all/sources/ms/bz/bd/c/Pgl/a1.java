package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a1 {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static String f14005A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static volatile a1 f14006A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public String f14007A2egSU;

    final class pgla implements pblk.pblb {
    }

    public static a1 A2egSU() {
        if (f14006A5SV6n == null) {
            synchronized (a1.class) {
                try {
                    if (f14006A5SV6n == null) {
                        a1 a1Var = new a1();
                        a1Var.f14007A2egSU = null;
                        f14006A5SV6n = a1Var;
                    }
                } finally {
                }
            }
        }
        return f14006A5SV6n;
    }
}
