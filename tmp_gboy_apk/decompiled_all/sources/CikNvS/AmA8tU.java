package CikNvS;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AmA8tU {
    public static int A2egSU(TextView textView) {
        return textView.getBreakStrategy();
    }

    public static ColorStateList A4TApA(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    public static PorterDuff.Mode A5SV6n(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    public static int ADYaiT(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    public static void AMqCpz(TextView textView, int i) {
        textView.setBreakStrategy(i);
    }

    public static void ARc23Z(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    public static void ASJ6gh(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    public static void AYUAbz(TextView textView, int i) {
        textView.setHyphenationFrequency(i);
    }
}
