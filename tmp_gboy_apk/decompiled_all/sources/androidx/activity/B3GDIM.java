package androidx.activity;

import android.window.OnBackInvokedCallback;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B3GDIM f7965A2egSU = new B3GDIM();

    static {
        NeAuHWK();
    }

    private static /* synthetic */ void NeAuHWK() {
        char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '+');
        }
        String str = new String(charArray);
        char[] charArray2 = "HGBEB_".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '+');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final OnBackInvokedCallback A2egSU(Function1<? super A4TApA, R8Rbcg.AMqCpz> function1, Function1<? super A4TApA, R8Rbcg.AMqCpz> function12, Function0<R8Rbcg.AMqCpz> function0, Function0<R8Rbcg.AMqCpz> function02) {
        RXb0Sz.ARc23Z.AMqCpz(function1, "onBackStarted");
        RXb0Sz.ARc23Z.AMqCpz(function12, "onBackProgressed");
        RXb0Sz.ARc23Z.AMqCpz(function0, "onBackInvoked");
        RXb0Sz.ARc23Z.AMqCpz(function02, "onBackCancelled");
        return new B2KMhB(function1, function12, function0, function02);
    }
}
