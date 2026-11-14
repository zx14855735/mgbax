package PCV8se;

import PCV8se.BJ7GGh;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BIYEnU extends BJ7GGh.A4TApA {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final RectF f7122AYUAbz = new RectF();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f7123A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f7124A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f7125ADYaiT;
    public final float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f7126ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f7127ASJ6gh;

    static {
        hBqr();
    }

    public BIYEnU(float f, float f2, float f3, float f4) {
        this.f7123A4TApA = f;
        this.f7124A5SV6n = f2;
        this.f7125ADYaiT = f3;
        this.AMqCpz = f4;
    }

    private static /* synthetic */ void hBqr() {
        char[] charArray = "ËÇÅ\u0086ÏÉÅÍ\u0086ÊÇÑ\u0086ÛÀÍÄÄ\u0086âÆÁêÚÁÌÏÍ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 168);
        }
        String str = new String(charArray);
        char[] charArray2 = "ËÄÁÆÁÜ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 168);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // PCV8se.BJ7GGh.A4TApA
    public final void A2egSU(Matrix matrix, Path path) {
        Matrix matrix2 = this.f7137A2egSU;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f7122AYUAbz;
        rectF.set(this.f7123A4TApA, this.f7124A5SV6n, this.f7125ADYaiT, this.AMqCpz);
        path.arcTo(rectF, this.f7126ARc23Z, this.f7127ASJ6gh, false);
        path.transform(matrix);
    }
}
