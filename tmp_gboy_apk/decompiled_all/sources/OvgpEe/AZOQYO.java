package OvgpEe;

import android.graphics.Matrix;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float[] f6869A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float[] f6870A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Matrix f6871A5SV6n;

    public AZOQYO() {
        this.f6869A2egSU = new float[2];
        this.f6870A4TApA = new float[]{1.0f, 0.0f};
        this.f6871A5SV6n = new Matrix();
    }

    public final void A2egSU() {
        Arrays.fill(this.f6869A2egSU, 0.0f);
        float[] fArr = this.f6870A4TApA;
        Arrays.fill(fArr, 0.0f);
        fArr[0] = 1.0f;
        this.f6871A5SV6n.reset();
    }

    public final void A4TApA(float f) {
        float[] fArr = this.f6869A2egSU;
        fArr[0] = fArr[0] * 1.0f;
        fArr[1] = fArr[1] * f;
        float[] fArr2 = this.f6870A4TApA;
        fArr2[0] = fArr2[0] * 1.0f;
        fArr2[1] = fArr2[1] * f;
    }

    public final void A5SV6n(float f) {
        float[] fArr = this.f6869A2egSU;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + 0.0f;
    }

    public AZOQYO(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[2];
        this.f6869A2egSU = fArr3;
        float[] fArr4 = new float[2];
        this.f6870A4TApA = fArr4;
        System.arraycopy(fArr, 0, fArr3, 0, 2);
        System.arraycopy(fArr2, 0, fArr4, 0, 2);
        this.f6871A5SV6n = new Matrix();
    }
}
