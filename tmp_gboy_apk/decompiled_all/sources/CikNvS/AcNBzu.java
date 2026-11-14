package CikNvS;

import android.widget.PopupWindow;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AcNBzu {
    public static boolean A2egSU(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int A4TApA(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void A5SV6n(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    public static void ADYaiT(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }
}
