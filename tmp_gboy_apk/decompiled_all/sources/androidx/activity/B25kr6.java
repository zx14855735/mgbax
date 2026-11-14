package androidx.activity;

import ADYaiT.CNPG0E;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B25kr6 f7960A2egSU = new B25kr6();

    static {
        kNoMNI();
    }

    private static /* synthetic */ void kNoMNI() {
        char[] charArray = "IEG\u0004MKGO\u0004HES\u0004YBOFF\u0004`DChXCNMO".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '*');
        }
        String str = new String(charArray);
        char[] charArray2 = "IFCDC^".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '*');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final OnBackInvokedCallback A2egSU(Function0<R8Rbcg.AMqCpz> function0) {
        RXb0Sz.ARc23Z.AMqCpz(function0, "onBackInvoked");
        return new CNPG0E(3, function0);
    }

    public final void A4TApA(Object obj, int i, Object obj2) {
        RXb0Sz.ARc23Z.AMqCpz(obj, "dispatcher");
        RXb0Sz.ARc23Z.AMqCpz(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
    }

    public final void A5SV6n(Object obj, Object obj2) {
        RXb0Sz.ARc23Z.AMqCpz(obj, "dispatcher");
        RXb0Sz.ARc23Z.AMqCpz(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
