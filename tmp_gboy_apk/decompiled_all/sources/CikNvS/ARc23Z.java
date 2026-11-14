package CikNvS;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {
    public static ColorStateList A2egSU(ImageView imageView) {
        return imageView.getImageTintList();
    }

    public static PorterDuff.Mode A4TApA(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    public static void A5SV6n(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }

    public static void ADYaiT(ImageView imageView, PorterDuff.Mode mode) {
        imageView.setImageTintMode(mode);
    }
}
