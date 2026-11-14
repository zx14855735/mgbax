package androidx.fragment;

import android.R;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class R$styleable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f8700A2egSU = {R.attr.name, R.attr.id, R.attr.tag};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f8701A4TApA = {R.attr.name, R.attr.tag};

    static {
        tEpGeI();
    }

    private static /* synthetic */ void tEpGeI() {
        char[] charArray = "çëéªãåéáªæëýª÷ìáèèªÎêíÆöíàãá".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 132);
        }
        String str = new String(charArray);
        char[] charArray2 = "çèíêíð".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 132);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
