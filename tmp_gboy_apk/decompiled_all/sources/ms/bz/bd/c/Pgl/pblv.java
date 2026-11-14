package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pblv {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final pblv f14062A4TApA = new pblv();

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f14063A2egSU;

    static {
        HQmLw();
    }

    private static /* synthetic */ void HQmLw() {
        char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 240);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 240);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
