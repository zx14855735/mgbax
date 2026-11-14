package NUY5pn;

import android.net.Uri;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BpkvW3 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f6032A2egSU = 0;

    static {
        Uri.parse("http://plus.google.com/").buildUpon().appendPath("circles").appendPath("find").build();
        mUVAPh();
    }

    private static /* synthetic */ void mUVAPh() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
