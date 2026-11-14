package IJPJ4E;

import HSHyT0.AlLFFp;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AlLFFp f3920A2egSU = AlLFFp.A2egSU(HSHyT0.A2egSU.f3459AmA8tU, "com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat");

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AlLFFp f3921A4TApA = AlLFFp.A2egSU(Boolean.FALSE, "com.bumptech.glide.load.resource.gif.GifOptions.DisableAnimation");

    static {
        NJPh();
    }

    private static /* synthetic */ void NJPh() {
        char[] charArray = "ÔØÚ\u0099ÐÖÚÒ\u0099ÕØÎ\u0099ÄßÒÛÛ\u0099ýÙÞõÅÞÓÐÒ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 183);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÔÛÞÙÞÃ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 183);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
