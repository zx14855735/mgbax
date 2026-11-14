package QmCR4D;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AYUAbz f7759A2egSU;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            f7759A2egSU = new A5SV6n();
        } else if (i >= 23) {
            f7759A2egSU = new AZOQYO();
        } else {
            f7759A2egSU = new AYUAbz();
            ZISGp();
        }
    }

    private static /* synthetic */ void ZISGp() {
        char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 232);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 232);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
