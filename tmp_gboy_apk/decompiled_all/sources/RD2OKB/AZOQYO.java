package RD2OKB;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AZOQYO extends AYUAbz {
    public static void A2egSU(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        RXb0Sz.ARc23Z.AMqCpz(iArr, "<this>");
        RXb0Sz.ARc23Z.AMqCpz(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void A4TApA(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
        RXb0Sz.ARc23Z.AMqCpz(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static /* synthetic */ void A5SV6n(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        A4TApA(objArr, objArr2, i, i2, i3);
    }

    public static Object[] ADYaiT(Object[] objArr, int i, int i2) {
        RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
        int length = objArr.length;
        if (i2 <= length) {
            Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i2);
            RXb0Sz.ARc23Z.ADYaiT(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }
}
