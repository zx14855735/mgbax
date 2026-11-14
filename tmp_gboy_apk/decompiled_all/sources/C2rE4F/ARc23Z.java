package C2rE4F;

import com.sigmob.sdk.archives.d;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Locale[] f1536A2egSU = {new Locale("en", "XA"), new Locale(d.f13023a, "XB")};

    static {
        qewpAC();
    }

    public static Locale A2egSU(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean A4TApA(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (locale.getLanguage().equals(locale2.getLanguage())) {
            Locale[] localeArr = f1536A2egSU;
            for (Locale locale3 : localeArr) {
                if (locale3.equals(locale)) {
                    return false;
                }
            }
            for (Locale locale4 : localeArr) {
                if (locale4.equals(locale2)) {
                    return false;
                }
            }
            String A2egSU2 = CASmeH.ARc23Z.A2egSU(locale);
            if (!A2egSU2.isEmpty()) {
                return A2egSU2.equals(CASmeH.ARc23Z.A2egSU(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ void qewpAC() {
        char[] charArray = "txz9pvzr9uxn9d\u007fr{{9]y~Ue~spr".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 23);
        }
        String str = new String(charArray);
        char[] charArray2 = "t{~y~c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 23);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
