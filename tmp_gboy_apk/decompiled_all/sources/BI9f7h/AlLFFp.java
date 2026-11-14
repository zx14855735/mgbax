package BI9f7h;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public B25kr6 f1308A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ArrayList f1309A4TApA;

    public static long A2egSU(ARc23Z aRc23Z, long j) {
        B25kr6 b25kr6 = aRc23Z.f1297ADYaiT;
        if (b25kr6 instanceof AaHO0E) {
            return j;
        }
        ArrayList arrayList = aRc23Z.f1303AaHO0E;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            ADYaiT aDYaiT = (ADYaiT) arrayList.get(i);
            if (aDYaiT instanceof ARc23Z) {
                ARc23Z aRc23Z2 = (ARc23Z) aDYaiT;
                if (aRc23Z2.f1297ADYaiT != b25kr6) {
                    j2 = Math.min(j2, A2egSU(aRc23Z2, aRc23Z2.f1298ARc23Z + j));
                }
            }
        }
        if (aRc23Z != b25kr6.f1324AZOQYO) {
            return j2;
        }
        long AZOQYO2 = b25kr6.AZOQYO();
        long j3 = j - AZOQYO2;
        return Math.min(Math.min(j2, A2egSU(b25kr6.f1323AYUAbz, j3)), j3 - r9.f1298ARc23Z);
    }

    public static long A4TApA(ARc23Z aRc23Z, long j) {
        B25kr6 b25kr6 = aRc23Z.f1297ADYaiT;
        if (b25kr6 instanceof AaHO0E) {
            return j;
        }
        ArrayList arrayList = aRc23Z.f1303AaHO0E;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            ADYaiT aDYaiT = (ADYaiT) arrayList.get(i);
            if (aDYaiT instanceof ARc23Z) {
                ARc23Z aRc23Z2 = (ARc23Z) aDYaiT;
                if (aRc23Z2.f1297ADYaiT != b25kr6) {
                    j2 = Math.max(j2, A4TApA(aRc23Z2, aRc23Z2.f1298ARc23Z + j));
                }
            }
        }
        if (aRc23Z != b25kr6.f1323AYUAbz) {
            return j2;
        }
        long AZOQYO2 = b25kr6.AZOQYO();
        long j3 = j + AZOQYO2;
        return Math.max(Math.max(j2, A4TApA(b25kr6.f1324AZOQYO, j3)), j3 - r9.f1298ARc23Z);
    }
}
