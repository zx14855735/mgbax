package DaOi9o;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final COJEAR.AZOQYO f2262A2egSU = new COJEAR.AZOQYO(2);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final COJEAR.AZOQYO f2263A4TApA = new COJEAR.AZOQYO(3);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final COJEAR.AZOQYO f2264A5SV6n = new COJEAR.AZOQYO(4);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final COJEAR.AZOQYO f2265ADYaiT = new COJEAR.AZOQYO(5);
    public static final COJEAR.AZOQYO AMqCpz = new COJEAR.AZOQYO(6);

    static {
        ZDXarwJ();
    }

    private static /* synthetic */ void ZDXarwJ() {
        char[] charArray = "ÜÐÒ\u0091ØÞÒÚ\u0091ÝÐÆ\u0091Ì×ÚÓÓ\u0091õÑÖýÍÖÛØÚ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 191);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÜÓÖÑÖË".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 191);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    void A2egSU(B7CMnp b7CMnp, B4ZgIw b4ZgIw);
}
