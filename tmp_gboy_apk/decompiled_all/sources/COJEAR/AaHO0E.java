package COJEAR;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AaHO0E {
    public static DisplayCutout A2egSU(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    public static List<Rect> A4TApA(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    public static int A5SV6n(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int ADYaiT(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int AMqCpz(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int ARc23Z(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
