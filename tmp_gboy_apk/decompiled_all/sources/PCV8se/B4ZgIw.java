package PCV8se;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B7CMnp f7105A2egSU = new B7CMnp();

    static {
        eNMpM();
    }

    private static /* synthetic */ void eNMpM() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
