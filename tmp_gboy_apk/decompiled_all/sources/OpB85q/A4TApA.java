package OpB85q;

import android.graphics.Color;
import com.sigmob.sdk.base.utils.n;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int f6659A2egSU = Color.alpha(n.f13223a);

    static {
        VxkG();
    }

    private static /* synthetic */ void VxkG() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
