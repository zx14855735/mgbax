package PVQ0dw;

import HXc4pW.BniPrB;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.LinearInterpolator;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f7279A2egSU = 0;

    static {
        LinearInterpolator linearInterpolator = NdEzCJ.A2egSU.f6036A2egSU;
        new Handler(Looper.getMainLooper(), new BniPrB(1));
        MpjrpLD();
    }

    private static /* synthetic */ void MpjrpLD() {
        char[] charArray = "0<>}42>6}1<*} ;6??}\u0019=:\u0011!:746".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'S');
        }
        String str = new String(charArray);
        char[] charArray2 = "0?:=:'".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'S');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
