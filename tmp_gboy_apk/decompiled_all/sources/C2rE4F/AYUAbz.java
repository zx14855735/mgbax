package C2rE4F;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AYUAbz f1537A4TApA = A2egSU(new Locale[0]);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS f1538A2egSU;

    static {
        nRaYGPg();
    }

    public AYUAbz(AZkASS aZkASS) {
        this.f1538A2egSU = aZkASS;
    }

    public static AYUAbz A2egSU(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new AYUAbz(new AaHO0E(ASJ6gh.A2egSU(localeArr))) : new AYUAbz(new AZOQYO(localeArr));
    }

    public static AYUAbz A4TApA(String str) {
        if (str == null || str.isEmpty()) {
            return f1537A4TApA;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = ARc23Z.A2egSU(split[i]);
        }
        return A2egSU(localeArr);
    }

    private static /* synthetic */ void nRaYGPg() {
        char[] charArray = "S_]\u001eWQ]U\u001eR_I\u001eCXU\\\\\u001ez^YrBYTWU".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '0');
        }
        String str = new String(charArray);
        char[] charArray2 = "S\\Y^YD".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '0');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AYUAbz) {
            return this.f1538A2egSU.equals(((AYUAbz) obj).f1538A2egSU);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1538A2egSU.hashCode();
    }

    public final String toString() {
        return this.f1538A2egSU.toString();
    }
}
