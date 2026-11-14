package CASmeH;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AZkASS f1605A2egSU = new AZkASS();

    static {
        rGWaoDc();
    }

    private static /* synthetic */ void rGWaoDc() {
        char[] charArray = "ÖÚØ\u009bÒÔØÐ\u009b×ÚÌ\u009bÆÝÐÙÙ\u009bÿÛÜ÷ÇÜÑÒÐ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 181);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÖÙÜÛÜÁ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 181);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
