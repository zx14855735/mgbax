package Ifhupb;

import HXc4pW.AaHO0E;
import HXc4pW.BNL6CD;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ADYaiT {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final BNL6CD f3968A5SV6n = new BNL6CD(Object.class, Object.class, Object.class, Collections.singletonList(new AaHO0E(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new IOxIEW.ARc23Z(), null)), null);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B25kr6.ADYaiT f3969A2egSU = new B25kr6.ADYaiT();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicReference f3970A4TApA = new AtomicReference();

    static {
        yPjXdiR();
    }

    private static /* synthetic */ void yPjXdiR() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(Class cls, Class cls2, Class cls3, BNL6CD bnl6cd) {
        synchronized (this.f3969A2egSU) {
            B25kr6.ADYaiT aDYaiT = this.f3969A2egSU;
            ItGa5w.AaHO0E aaHO0E = new ItGa5w.AaHO0E(cls, cls2, cls3);
            if (bnl6cd == null) {
                bnl6cd = f3968A5SV6n;
            }
            aDYaiT.put(aaHO0E, bnl6cd);
        }
    }
}
