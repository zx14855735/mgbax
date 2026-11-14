package okhttp3.internal.http2;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface BI9f7h {
    public static final BI9f7h CANCEL = new BChYOn();

    static {
        NOdBBzA();
    }

    private static /* synthetic */ void NOdBBzA() {
        char[] charArray = "\u0015\u0019\u001bX\u0011\u0017\u001b\u0013X\u0014\u0019\u000fX\u0005\u001e\u0013\u001a\u001aX<\u0018\u001f4\u0004\u001f\u0012\u0011\u0013".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'v');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0015\u001a\u001f\u0018\u001f\u0002".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'v');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
