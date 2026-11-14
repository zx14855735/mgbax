package ADYaiT;

import android.app.LocaleManager;
import android.os.LocaleList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B9tovu {
    public static LocaleList A2egSU(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static void A4TApA(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
