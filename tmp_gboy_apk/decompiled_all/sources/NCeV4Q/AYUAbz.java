package NCeV4Q;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final BTvldC.ADYaiT f5648A2egSU = new BTvldC.ADYaiT(new String[0]);

    static {
        IzFruHh();
    }

    private static /* synthetic */ void IzFruHh() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
