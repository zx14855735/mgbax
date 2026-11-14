package CASmeH;

import ADYaiT.D9tr6l;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final D9tr6l f1606A2egSU = new D9tr6l((AZkASS) null, false);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final D9tr6l f1607A4TApA = new D9tr6l((AZkASS) null, true);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final D9tr6l f1608A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final D9tr6l f1609ADYaiT;

    static {
        AZkASS aZkASS = AZkASS.f1605A2egSU;
        f1608A5SV6n = new D9tr6l(aZkASS, false);
        f1609ADYaiT = new D9tr6l(aZkASS, true);
        eZWhU();
    }

    private static /* synthetic */ void eZWhU() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
