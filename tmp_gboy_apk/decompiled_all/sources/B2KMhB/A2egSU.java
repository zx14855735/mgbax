package B2KMhB;

import RXb0Sz.ARc23Z;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f1016A2egSU = new int[0];

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Object[] f1017A4TApA = new Object[0];

    static {
        VROpRU();
    }

    public static final int A2egSU(int i, int i2, int[] iArr) {
        ARc23Z.AMqCpz(iArr, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final int A4TApA(long[] jArr, int i, long j) {
        ARc23Z.AMqCpz(jArr, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static final void A5SV6n(String str) {
        ARc23Z.AMqCpz(str, "message");
        throw new IllegalArgumentException(str);
    }

    private static /* synthetic */ void VROpRU() {
        char[] charArray = "nb`#jl`h#obt#~ehaa#GcdO\u007fdijh".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\r');
        }
        String str = new String(charArray);
        char[] charArray2 = "nadcdy".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
