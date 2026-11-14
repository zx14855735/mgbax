package BmvVmW;

import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ADYaiT {
    public static Drawable A2egSU(Drawable drawable, Drawable drawable2) {
        return new AdaptiveIconDrawable(drawable, drawable2);
    }

    public static Icon A4TApA(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }
}
