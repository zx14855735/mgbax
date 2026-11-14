package CSDoyG;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {
    public static Interpolator A2egSU(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    public static Interpolator A4TApA(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }

    public static Interpolator A5SV6n(Path path) {
        return new PathInterpolator(path);
    }
}
