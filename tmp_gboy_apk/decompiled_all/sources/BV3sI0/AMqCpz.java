package BV3sI0;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadLocal f1486A2egSU = new ThreadLocal();

    static {
        fKwBG();
    }

    private static /* synthetic */ void fKwBG() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
