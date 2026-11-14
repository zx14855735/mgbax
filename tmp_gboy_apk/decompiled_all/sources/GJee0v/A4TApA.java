package GJee0v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Bitmap.Config f3029A2egSU = Bitmap.Config.RGB_565;

    static {
        NXuI();
    }

    public static BitmapFactory.Options A2egSU(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inPreferredConfig = f3029A2egSU;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inJustDecodeBounds = false;
        int i = context.getResources().getDisplayMetrics().densityDpi;
        float f = context.getResources().getDisplayMetrics().density;
        if (i > 240 && f > 1.5f) {
            int i2 = (int) (i * 0.75f);
            options.inDensity = i2;
            options.inTargetDensity = i2;
        }
        return options;
    }

    private static /* synthetic */ void NXuI() {
        char[] charArray = "ÔØÚ\u0099ÐÖÚÒ\u0099ÕØÎ\u0099ÄßÒÛÛ\u0099ýÙÞõÅÞÓÐÒ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 183);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÔÛÞÙÞÃ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 183);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
