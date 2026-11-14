package IOxIEW;

import HSHyT0.AmA8tU;
import HXc4pW.BTvldC;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z implements A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final ARc23Z f3931AcNBzu = new ARc23Z();

    static {
        kYShR();
    }

    private static /* synthetic */ void kYShR() {
        char[] charArray = "\u001b\u0017\u0015V\u001f\u0019\u0015\u001dV\u001a\u0017\u0001V\u000b\u0010\u001d\u0014\u0014V2\u0016\u0011:\n\u0011\u001c\u001f\u001d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'x');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001b\u0014\u0011\u0016\u0011\f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'x');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // IOxIEW.A5SV6n
    public final BTvldC ARc23Z(BTvldC bTvldC, AmA8tU amA8tU) {
        return bTvldC;
    }
}
