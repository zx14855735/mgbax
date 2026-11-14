package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class aoaaaaaa {
    static long aaaaaaa0;
    static aeaaaaaa aaaaaaaa;

    public static aeaaaaaa aaaaaaaa() {
        synchronized (aoaaaaaa.class) {
            try {
                aeaaaaaa aeaaaaaaVar = aaaaaaaa;
                if (aeaaaaaaVar == null) {
                    return new aeaaaaaa();
                }
                aaaaaaaa = aeaaaaaaVar.aaaaaaan;
                aeaaaaaaVar.aaaaaaan = null;
                aaaaaaa0 -= 8192;
                return aeaaaaaaVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void aaaaaaaa(aeaaaaaa aeaaaaaaVar) {
        if (aeaaaaaaVar.aaaaaaan == null && aeaaaaaaVar.aaaaaaae == null) {
            if (aeaaaaaaVar.aaaaaaac) {
                return;
            }
            synchronized (aoaaaaaa.class) {
                try {
                    long j = aaaaaaa0 + 8192;
                    if (j > 65536) {
                        return;
                    }
                    aaaaaaa0 = j;
                    aeaaaaaaVar.aaaaaaan = aaaaaaaa;
                    aeaaaaaaVar.aaaaaaao = 0;
                    aeaaaaaaVar.aaaaaaa0 = 0;
                    aaaaaaaa = aeaaaaaaVar;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
