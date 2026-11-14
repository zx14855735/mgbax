package AaHO0E;

import android.os.LocaleList;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class D9tr6l {
    public static LocaleList A2egSU(String str) {
        return LocaleList.forLanguageTags(str);
    }

    public static void A4TApA(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
