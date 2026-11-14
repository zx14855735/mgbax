package QgOIY0;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A5SV6n f7498A2egSU;

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            f7498A2egSU = new ADYaiT();
        } else {
            f7498A2egSU = new A5SV6n();
            dAiv();
        }
    }

    private static /* synthetic */ void dAiv() {
        char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 21);
        }
        String str = new String(charArray);
        char[] charArray2 = "vy|{|a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 21);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
