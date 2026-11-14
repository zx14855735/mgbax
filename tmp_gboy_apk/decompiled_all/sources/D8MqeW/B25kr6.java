package D8MqeW;

import android.graphics.Matrix;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 extends A4TApA {
    public B25kr6() {
        super(0);
    }

    public final void ARc23Z(K1Z3yj.A2egSU a2egSU, int i) {
        float[] fArr = this.f2011A2egSU;
        float f = fArr[i];
        int i2 = i + 1;
        float f2 = fArr[i2];
        float[] fArr2 = (float[]) a2egSU.f4174AlLFFp;
        fArr2[0] = f;
        fArr2[1] = f2;
        ((Matrix) a2egSU.f4175AmA8tU).mapPoints(fArr2);
        long A2egSU2 = B25kr6.ARc23Z.A2egSU(fArr2[0], fArr2[1]);
        fArr[i] = Float.intBitsToFloat((int) (A2egSU2 >> 32));
        fArr[i2] = Float.intBitsToFloat((int) (4294967295L & A2egSU2));
    }
}
