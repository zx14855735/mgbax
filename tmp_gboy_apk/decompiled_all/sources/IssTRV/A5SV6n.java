package IssTRV;

import HSHyT0.AZkASS;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A5SV6n f4068A4TApA = new A5SV6n();

    static {
        ciMqbmH();
    }

    private static /* synthetic */ void ciMqbmH() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
    }

    public final String toString() {
        return "EmptySignature";
    }
}
