package B25kr6;

import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Object f992A2egSU = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Object f993A4TApA = new Object();

    public static final void A2egSU(B25kr6 b25kr6) {
        int i = b25kr6.f1015AzWtSf;
        int[] iArr = b25kr6.f1013AlLFFp;
        Object[] objArr = b25kr6.f1014AmA8tU;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f993A4TApA) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        b25kr6.f1012AcNBzu = false;
        b25kr6.f1015AzWtSf = i2;
    }

    public static final void A4TApA(AMqCpz aMqCpz, int i) {
        RXb0Sz.ARc23Z.AMqCpz(aMqCpz, "<this>");
        aMqCpz.f983AcNBzu = new int[i];
        aMqCpz.f984AlLFFp = new Object[i];
    }

    public static final int A5SV6n(AMqCpz aMqCpz, Object obj, int i) {
        RXb0Sz.ARc23Z.AMqCpz(aMqCpz, "<this>");
        int i2 = aMqCpz.f985AmA8tU;
        if (i2 == 0) {
            return -1;
        }
        try {
            int A2egSU2 = B2KMhB.A2egSU.A2egSU(aMqCpz.f985AmA8tU, i, aMqCpz.f983AcNBzu);
            if (A2egSU2 < 0 || RXb0Sz.ARc23Z.A2egSU(obj, aMqCpz.f984AlLFFp[A2egSU2])) {
                return A2egSU2;
            }
            int i3 = A2egSU2 + 1;
            while (i3 < i2 && aMqCpz.f983AcNBzu[i3] == i) {
                if (RXb0Sz.ARc23Z.A2egSU(obj, aMqCpz.f984AlLFFp[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = A2egSU2 - 1; i4 >= 0 && aMqCpz.f983AcNBzu[i4] == i; i4--) {
                if (RXb0Sz.ARc23Z.A2egSU(obj, aMqCpz.f984AlLFFp[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void NIexfUU() {
        char[] charArray = "¨¤¦å¬ª¦®å©¤²å¸£®§§å\u0081¥¢\u0089¹¢¯¬®".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 203);
        }
        String str = new String(charArray);
        char[] charArray2 = "¨§¢¥¢¿".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 203);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
