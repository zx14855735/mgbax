package NRGvz2;

import android.content.ComponentName;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f5918A2egSU = 0;

    static {
        new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
        lEiH();
    }

    private static /* synthetic */ void lEiH() {
        char[] charArray = "üðò±øþòú±ýðæ±ì÷úóó±ÕñöÝíöûøú".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 159);
        }
        String str = new String(charArray);
        char[] charArray2 = "üóöñöë".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 159);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
