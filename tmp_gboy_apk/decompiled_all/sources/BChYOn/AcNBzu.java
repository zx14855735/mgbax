package BChYOn;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final boolean[] f1264A2egSU = new boolean[3];

    static {
        Ebrf();
    }

    public static void A2egSU(ASJ6gh aSJ6gh, B4ZgIw.ADYaiT aDYaiT, ARc23Z aRc23Z) {
        aRc23Z.f1145B25kr6 = -1;
        aRc23Z.f1146B2KMhB = -1;
        int i = aSJ6gh.f1195Dphsd2[0];
        int[] iArr = aRc23Z.f1195Dphsd2;
        if (i != 2 && iArr[0] == 4) {
            AMqCpz aMqCpz = aRc23Z.f1164CNPG0E;
            int i2 = aMqCpz.f1128ASJ6gh;
            int B2KMhB2 = aSJ6gh.B2KMhB();
            AMqCpz aMqCpz2 = aRc23Z.f1166CQhlFr;
            int i3 = B2KMhB2 - aMqCpz2.f1128ASJ6gh;
            aMqCpz.f1130AZOQYO = aDYaiT.AaHO0E(aMqCpz);
            aMqCpz2.f1130AZOQYO = aDYaiT.AaHO0E(aMqCpz2);
            aDYaiT.ADYaiT(aMqCpz.f1130AZOQYO, i2);
            aDYaiT.ADYaiT(aMqCpz2.f1130AZOQYO, i3);
            aRc23Z.f1145B25kr6 = 2;
            aRc23Z.f1180D6yqiO = i2;
            int i4 = i3 - i2;
            aRc23Z.f1176CtFAbx = i4;
            int i5 = aRc23Z.f1183D9tr6l;
            if (i4 < i5) {
                aRc23Z.f1176CtFAbx = i5;
            }
        }
        if (aSJ6gh.f1195Dphsd2[1] == 2 || iArr[1] != 4) {
            return;
        }
        AMqCpz aMqCpz3 = aRc23Z.f1165COJEAR;
        int i6 = aMqCpz3.f1128ASJ6gh;
        int AaHO0E2 = aSJ6gh.AaHO0E();
        AMqCpz aMqCpz4 = aRc23Z.f1167CSDoyG;
        int i7 = AaHO0E2 - aMqCpz4.f1128ASJ6gh;
        aMqCpz3.f1130AZOQYO = aDYaiT.AaHO0E(aMqCpz3);
        aMqCpz4.f1130AZOQYO = aDYaiT.AaHO0E(aMqCpz4);
        aDYaiT.ADYaiT(aMqCpz3.f1130AZOQYO, i6);
        aDYaiT.ADYaiT(aMqCpz4.f1130AZOQYO, i7);
        if (aRc23Z.f1182D8cQ8b > 0 || aRc23Z.f1188DV2E8K == 8) {
            AMqCpz aMqCpz5 = aRc23Z.f1168CTkVKb;
            B4ZgIw.AZOQYO AaHO0E3 = aDYaiT.AaHO0E(aMqCpz5);
            aMqCpz5.f1130AZOQYO = AaHO0E3;
            aDYaiT.ADYaiT(AaHO0E3, aRc23Z.f1182D8cQ8b + i6);
        }
        aRc23Z.f1146B2KMhB = 2;
        aRc23Z.f1181D8MqeW = i6;
        int i8 = i7 - i6;
        aRc23Z.f1177CtxOCS = i8;
        int i9 = aRc23Z.f1184DAk1zC;
        if (i8 < i9) {
            aRc23Z.f1177CtxOCS = i9;
        }
    }

    public static final boolean A4TApA(int i, int i2) {
        return (i & i2) == i2;
    }

    private static /* synthetic */ void Ebrf() {
        char[] charArray = "VZX\u001bRTXP\u001bWZL\u001bF]PYY\u001b\u007f[\\wG\\QRP".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '5');
        }
        String str = new String(charArray);
        char[] charArray2 = "VY\\[\\A".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '5');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
