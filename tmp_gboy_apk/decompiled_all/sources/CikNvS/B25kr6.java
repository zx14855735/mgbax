package CikNvS;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B25kr6 {
    public static CharSequence A2egSU(PrecomputedText precomputedText) {
        return precomputedText;
    }

    public static String[] A4TApA(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params A5SV6n(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void ADYaiT(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }
}
