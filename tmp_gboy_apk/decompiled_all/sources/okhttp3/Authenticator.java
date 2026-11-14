package okhttp3;

import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator.1
        @Override // okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    };

    static {
        wDTPg();
    }

    private static /* synthetic */ void wDTPg() {
        char[] charArray = "W[Y\u001aSUYQ\u001aV[M\u001aG\\QXX\u001a~Z]vF]PSQ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '4');
        }
        String str = new String(charArray);
        char[] charArray2 = "WX]Z]@".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '4');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Nullable
    Request authenticate(@Nullable Route route, Response response);
}
