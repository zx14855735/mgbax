package androidx.drawerlayout;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class R$styleable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f8613A2egSU = {2130969052};

    static {
        gucC();
    }

    private static /* synthetic */ void gucC() {
        char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\\');
        }
        String str = new String(charArray);
        char[] charArray2 = "?0525(".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\\');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
