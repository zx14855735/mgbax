package COJEAR;

import android.content.ClipData;
import android.view.PointerIcon;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CrfGsy {
    public static void A2egSU(View view) {
        view.cancelDragAndDrop();
    }

    public static void A4TApA(View view) {
        view.dispatchFinishTemporaryDetach();
    }

    public static void A5SV6n(View view) {
        view.dispatchStartTemporaryDetach();
    }

    public static void ADYaiT(View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    public static boolean AMqCpz(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
    }

    public static void ARc23Z(View view, View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }
}
