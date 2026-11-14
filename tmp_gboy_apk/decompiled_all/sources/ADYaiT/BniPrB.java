package ADYaiT;

import android.os.PowerManager;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BniPrB {
    public static boolean A2egSU(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }

    public static String A4TApA(Locale locale) {
        return locale.toLanguageTag();
    }
}
