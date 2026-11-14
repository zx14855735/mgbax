package D8MqeW;

import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final List f2019A2egSU;

    static {
        Float valueOf = Float.valueOf(0.0f);
        f2019A2egSU = RD2OKB.AaHO0E.AMqCpz(new R8Rbcg.A4TApA(valueOf, valueOf), new R8Rbcg.A4TApA(Float.valueOf(0.5f), Float.valueOf(0.5f)));
        CPyEmj();
    }

    public static final long A2egSU(AYUAbz aYUAbz) {
        RXb0Sz.ARc23Z.AMqCpz(aYUAbz, "feature");
        List list = aYUAbz.f2018A2egSU;
        return B25kr6.ARc23Z.A2egSU((((A4TApA) RD2OKB.B4ZgIw.AcNBzu(list)).A2egSU() + ((A4TApA) RD2OKB.B4ZgIw.AZOQYO(list)).f2011A2egSU[0]) / 2.0f, (((A4TApA) RD2OKB.B4ZgIw.AcNBzu(list)).A4TApA() + ((A4TApA) RD2OKB.B4ZgIw.AZOQYO(list)).f2011A2egSU[1]) / 2.0f);
    }

    private static /* synthetic */ void CPyEmj() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
