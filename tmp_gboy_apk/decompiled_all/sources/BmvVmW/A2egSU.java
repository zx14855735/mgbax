package BmvVmW;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {
    public static void A2egSU(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean A4TApA(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter A5SV6n(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void ADYaiT(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void AMqCpz(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void ARc23Z(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void ASJ6gh(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void AYUAbz(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void AZOQYO(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}
