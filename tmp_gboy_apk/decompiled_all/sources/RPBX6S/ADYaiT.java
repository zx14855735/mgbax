package RPBX6S;

import ADYaiT.DUi7mC;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final DUi7mC f7876A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static DUi7mC f7877A4TApA;

    static {
        Object obj = null;
        f7876A2egSU = new DUi7mC(23, obj, obj, obj);
        QqcHAGf();
    }

    private static /* synthetic */ void QqcHAGf() {
        char[] charArray = "\u001f\u0013\u0011R\u001b\u001d\u0011\u0019R\u001e\u0013\u0005R\u000f\u0014\u0019\u0010\u0010R6\u0012\u0015>\u000e\u0015\u0018\u001b\u0019".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '|');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001f\u0010\u0015\u0012\u0015\b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '|');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
