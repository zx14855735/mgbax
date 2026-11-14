package RJJjP9;

import RXb0Sz.ARc23Z;
import java.io.Serializable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz implements ADYaiT, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final AMqCpz f7864AcNBzu = new AMqCpz();

    static {
        SzACm();
    }

    private static /* synthetic */ void SzACm() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // RJJjP9.ADYaiT
    public final A5SV6n A2egSU(A4TApA a4TApA) {
        ARc23Z.AMqCpz(a4TApA, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
