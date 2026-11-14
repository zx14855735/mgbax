package COJEAR;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B4ZgIw {
    public static int A2egSU(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    public static CharSequence A4TApA(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    public static ColorStateList A5SV6n(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    public static PorterDuff.Mode ADYaiT(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    public static int AMqCpz(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    public static CharSequence ARc23Z(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    public static MenuItem ASJ6gh(MenuItem menuItem, char c, int i) {
        return menuItem.setAlphabeticShortcut(c, i);
    }

    public static MenuItem AYUAbz(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    public static MenuItem AZOQYO(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    public static MenuItem AZkASS(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    public static MenuItem AaHO0E(MenuItem menuItem, char c, int i) {
        return menuItem.setNumericShortcut(c, i);
    }

    public static MenuItem AcNBzu(MenuItem menuItem, char c, char c2, int i, int i2) {
        return menuItem.setShortcut(c, c2, i, i2);
    }

    public static MenuItem AlLFFp(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}
