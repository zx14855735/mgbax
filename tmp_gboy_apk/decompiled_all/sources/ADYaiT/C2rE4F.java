package ADYaiT;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class C2rE4F {
    public static void A2egSU(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales;
        LocaleList locales2;
        boolean equals;
        locales = configuration.getLocales();
        locales2 = configuration2.getLocales();
        equals = locales.equals(locales2);
        if (equals) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static C2rE4F.AYUAbz A4TApA(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return C2rE4F.AYUAbz.A4TApA(languageTags);
    }

    public static void A5SV6n(C2rE4F.AYUAbz aYUAbz) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(aYUAbz.f1538A2egSU.A2egSU());
        LocaleList.setDefault(forLanguageTags);
    }

    public static void ADYaiT(Configuration configuration, C2rE4F.AYUAbz aYUAbz) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(aYUAbz.f1538A2egSU.A2egSU());
        configuration.setLocales(forLanguageTags);
    }
}
