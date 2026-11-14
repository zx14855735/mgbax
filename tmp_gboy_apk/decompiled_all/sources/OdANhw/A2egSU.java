package OdANhw;

import AaHO0E.GEYgCP;
import CtFAbx.ASJ6gh;
import LqstKO.AMqCpz;
import LqstKO.ARc23Z;
import android.animation.ObjectAnimator;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final GEYgCP f6616AZOQYO = new GEYgCP(Float.class, "animationFraction", 8);

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final O1nrJm.A2egSU f6617AZkASS = new O1nrJm.A2egSU(1);

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f6618A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f6619A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f6620A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ObjectAnimator f6621ADYaiT;
    public ASJ6gh AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AMqCpz f6622ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public A4TApA f6623ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ARc23Z f6624AYUAbz;

    static {
        WjHUZ();
    }

    private static /* synthetic */ void WjHUZ() {
        char[] charArray = "\u009a\u0096\u0094×\u009e\u0098\u0094\u009c×\u009b\u0096\u0080×\u008a\u0091\u009c\u0095\u0095×³\u0097\u0090»\u008b\u0090\u009d\u009e\u009c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 249);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009a\u0095\u0090\u0097\u0090\u008d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 249);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(float f) {
        this.f6620A5SV6n = f;
        ARc23Z aRc23Z = this.f6624AYUAbz;
        aRc23Z.f4939A4TApA = f;
        int i = this.f6618A2egSU - 1;
        int[] iArr = (int[]) this.f6622ARc23Z.f4937B25kr6;
        int length = i % iArr.length;
        int length2 = (length + 1) % iArr.length;
        int i2 = iArr[length];
        int i3 = iArr[length2];
        NdEzCJ.A4TApA a4TApA = NdEzCJ.A4TApA.f6040A2egSU;
        float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB(f - i, 0.0f, 1.0f);
        Integer valueOf = Integer.valueOf(i2);
        Integer valueOf2 = Integer.valueOf(i3);
        a4TApA.getClass();
        aRc23Z.f4938A2egSU = NdEzCJ.A4TApA.A2egSU(B2KMhB2, valueOf, valueOf2).intValue();
        A4TApA a4TApA2 = this.f6623ASJ6gh;
        if (a4TApA2 != null) {
            a4TApA2.invalidateSelf();
        }
    }
}
