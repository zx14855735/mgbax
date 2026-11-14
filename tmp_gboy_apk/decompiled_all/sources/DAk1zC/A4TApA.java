package DAk1zC;

import ADYaiT.BmvVmW;
import B25kr6.B25kr6;
import androidx.lifecycle.CikNvS;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA extends CikNvS {
    public static final BmvVmW AMqCpz = new BmvVmW(8);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final B25kr6 f2055ADYaiT = new B25kr6();

    static {
        Tgftx();
    }

    private static /* synthetic */ void Tgftx() {
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

    @Override // androidx.lifecycle.CikNvS
    public final void A4TApA() {
        B25kr6 b25kr6 = this.f2055ADYaiT;
        if (b25kr6.AMqCpz() > 0) {
            b25kr6.ARc23Z(0).getClass();
            throw new ClassCastException();
        }
        int i = b25kr6.f1015AzWtSf;
        Object[] objArr = b25kr6.f1014AmA8tU;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        b25kr6.f1015AzWtSf = 0;
        b25kr6.f1012AcNBzu = false;
    }
}
