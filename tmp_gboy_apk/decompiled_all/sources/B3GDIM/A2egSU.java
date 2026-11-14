package B3GDIM;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A2egSU f1019A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final A2egSU f1020A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final CancellationException f1021A2egSU;

    static {
        if (ASJ6gh.f1032AzWtSf) {
            f1020A5SV6n = null;
            f1019A4TApA = null;
        } else {
            f1020A5SV6n = new A2egSU(false, null);
            f1019A4TApA = new A2egSU(true, null);
            Mslfltv();
        }
    }

    public A2egSU(boolean z, CancellationException cancellationException) {
        this.f1021A2egSU = cancellationException;
    }

    private static /* synthetic */ void Mslfltv() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
