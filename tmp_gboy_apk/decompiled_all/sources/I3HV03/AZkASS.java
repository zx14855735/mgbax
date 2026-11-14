package I3HV03;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZkASS extends ASJ6gh {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final byte[] f3820A4TApA = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(HSHyT0.AZkASS.f3465A2egSU);

    static {
        jEkh();
    }

    private static /* synthetic */ void jEkh() {
        char[] charArray = "\".,o& ,$o#.8o2)$--o\u000b/(\u00033(%&$".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'A');
        }
        String str = new String(charArray);
        char[] charArray2 = "\"-(/(5".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'A');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        messageDigest.update(f3820A4TApA);
    }

    @Override // I3HV03.ASJ6gh
    public final Bitmap A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        Paint paint = BmvVmW.f3866A2egSU;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        Bitmap A5SV6n2 = aDYaiT.A5SV6n(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        A5SV6n2.setHasAlpha(bitmap.hasAlpha());
        BmvVmW.A2egSU(bitmap, A5SV6n2, matrix);
        return A5SV6n2;
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        return obj instanceof AZkASS;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return -599754482;
    }
}
