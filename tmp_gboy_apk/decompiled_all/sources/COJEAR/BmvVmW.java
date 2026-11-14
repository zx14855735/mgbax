package COJEAR;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BmvVmW {
    public static PointerIcon A2egSU(Bitmap bitmap, float f, float f2) {
        return PointerIcon.create(bitmap, f, f2);
    }

    public static PointerIcon A4TApA(Context context, int i) {
        return PointerIcon.getSystemIcon(context, i);
    }

    public static PointerIcon A5SV6n(Resources resources, int i) {
        return PointerIcon.load(resources, i);
    }
}
