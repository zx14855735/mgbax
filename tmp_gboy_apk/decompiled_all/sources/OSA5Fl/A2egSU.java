package OSA5Fl;

import OLy1FW.AYUAbz;
import P3rngT.A4TApA;
import android.content.Context;
import android.graphics.Color;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final int f6445ARc23Z = (int) Math.round(5.1000000000000005d);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f6446A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6447A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6448A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6449ADYaiT;
    public final float AMqCpz;

    static {
        stBYmG();
    }

    public A2egSU(Context context) {
        boolean A4TApA2 = A4TApA.A4TApA(context, 2130969055, false);
        int AYUAbz2 = AYUAbz.AYUAbz(context, 2130969054, 0);
        int AYUAbz3 = AYUAbz.AYUAbz(context, 2130969053, 0);
        int AYUAbz4 = AYUAbz.AYUAbz(context, 2130968895, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.f6446A2egSU = A4TApA2;
        this.f6447A4TApA = AYUAbz2;
        this.f6448A5SV6n = AYUAbz3;
        this.f6449ADYaiT = AYUAbz4;
        this.AMqCpz = f;
    }

    private static /* synthetic */ void stBYmG() {
        char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 240);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 240);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU(float f, int i) {
        int i2;
        if (!this.f6446A2egSU || BV3sI0.A2egSU.AMqCpz(i, 255) != this.f6449ADYaiT) {
            return i;
        }
        float min = (this.AMqCpz <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int alpha = Color.alpha(i);
        int AaHO0E2 = AYUAbz.AaHO0E(min, BV3sI0.A2egSU.AMqCpz(i, 255), this.f6447A4TApA);
        if (min > 0.0f && (i2 = this.f6448A5SV6n) != 0) {
            AaHO0E2 = BV3sI0.A2egSU.A5SV6n(BV3sI0.A2egSU.AMqCpz(i2, f6445ARc23Z), AaHO0E2);
        }
        return BV3sI0.A2egSU.AMqCpz(AaHO0E2, alpha);
    }
}
