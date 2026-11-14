package HwAeAU;

import HSHyT0.B3GDIM;
import HXc4pW.BTvldC;
import android.content.Context;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements B3GDIM {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ADYaiT f3802A4TApA = new ADYaiT();

    static {
        lwEUZ();
    }

    private static /* synthetic */ void lwEUZ() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
    }

    @Override // HSHyT0.B3GDIM
    public final BTvldC A4TApA(Context context, BTvldC bTvldC, int i, int i2) {
        return bTvldC;
    }
}
