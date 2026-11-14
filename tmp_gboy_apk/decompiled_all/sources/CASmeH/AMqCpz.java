package CASmeH;

import android.icu.util.ULocale;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AMqCpz {
    public static ULocale A2egSU(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    public static ULocale A4TApA(Locale locale) {
        return ULocale.forLocale(locale);
    }

    public static String A5SV6n(Object obj) {
        return ((ULocale) obj).getScript();
    }
}
