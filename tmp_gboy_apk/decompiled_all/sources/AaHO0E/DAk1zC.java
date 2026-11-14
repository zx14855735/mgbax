package AaHO0E;

import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DAk1zC {
    public static int A2egSU(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    public static void A4TApA(TextView textView, int i, int i2, int i3, int i4) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    public static void A5SV6n(TextView textView, int[] iArr, int i) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    public static boolean ADYaiT(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
