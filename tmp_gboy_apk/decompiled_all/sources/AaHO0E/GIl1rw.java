package AaHO0E;

import android.content.Context;
import android.content.ContextWrapper;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class GIl1rw extends ContextWrapper {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Object f878A2egSU = null;

    static {
        ndMk();
    }

    public static void A2egSU(Context context) {
        if (context.getResources() instanceof GL2Jh7) {
            return;
        }
        context.getResources();
        int i = HIguqb.f932A2egSU;
    }

    private static /* synthetic */ void ndMk() {
        char[] charArray = "7;9z3591z6;-z'<188z\u001e:=\u0016&=031".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'T');
        }
        String str = new String(charArray);
        char[] charArray2 = "78=:= ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'T');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
