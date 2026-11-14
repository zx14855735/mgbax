package I3HV03;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B25kr6 f3826A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final B25kr6 f3827A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final B25kr6 f3828A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final B25kr6 f3829ADYaiT;
    public static final B25kr6 AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3830ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final boolean f3831ASJ6gh;

    static {
        new B25kr6(0);
        new B25kr6(1);
        f3826A2egSU = new B25kr6(4);
        f3827A4TApA = new B25kr6(2);
        B25kr6 b25kr6 = new B25kr6(3);
        f3828A5SV6n = b25kr6;
        f3829ADYaiT = new B25kr6(5);
        AMqCpz = b25kr6;
        f3830ARc23Z = HSHyT0.AlLFFp.A2egSU(b25kr6, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f3831ASJ6gh = true;
        hGFLr();
    }

    private static /* synthetic */ void hGFLr() {
        char[] charArray = "ÈÄÆ\u0085ÌÊÆÎ\u0085ÉÄÒ\u0085ØÃÎÇÇ\u0085áÅÂéÙÂÏÌÎ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 171);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÈÇÂÅÂß".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 171);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract int A2egSU(int i, int i2, int i3, int i4);

    public abstract float A4TApA(int i, int i2, int i3, int i4);
}
