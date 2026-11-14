package NGepWW;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class EY4UKY {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ExecutorService f5818A2egSU = Executors.newFixedThreadPool(2, new B3GDIM());

    static {
        qpiomm();
    }

    private static /* synthetic */ void qpiomm() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
