package D8MqeW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E {
    public final long A2egSU(A4TApA a4TApA, float f) {
        float[] fArr = a4TApA.f2011A2egSU;
        int i = 1;
        long A2egSU2 = B25kr6.ARc23Z.A2egSU(fArr[0], fArr[1]);
        float f2 = 0.0f;
        float f3 = f;
        while (true) {
            float f4 = 3;
            float f5 = i / f4;
            long A5SV6n2 = a4TApA.A5SV6n(f5);
            float C4FrIb2 = JrXYwF.A4TApA.C4FrIb(JrXYwF.A4TApA.CmUvjW(A5SV6n2, A2egSU2));
            if (C4FrIb2 >= f3) {
                return B25kr6.ARc23Z.A2egSU(f5 - ((1.0f - (f3 / C4FrIb2)) / f4), f);
            }
            f3 -= C4FrIb2;
            f2 += C4FrIb2;
            if (i == 3) {
                return B25kr6.ARc23Z.A2egSU(1.0f, f2);
            }
            i++;
            A2egSU2 = A5SV6n2;
        }
    }
}
