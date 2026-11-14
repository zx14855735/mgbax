package I3HV03;

import android.graphics.Bitmap;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BIYEnU extends ASJ6gh {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final byte[] f3846A4TApA = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(HSHyT0.AZkASS.f3465A2egSU);

    static {
        TsPoEB();
    }

    private static /* synthetic */ void TsPoEB() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        messageDigest.update(f3846A4TApA);
    }

    @Override // I3HV03.ASJ6gh
    public final Bitmap A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap, int i, int i2) {
        return BmvVmW.A4TApA(aDYaiT, bitmap, i, i2);
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        return obj instanceof BIYEnU;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return 1572326941;
    }
}
