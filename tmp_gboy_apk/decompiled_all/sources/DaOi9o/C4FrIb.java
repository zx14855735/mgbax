package DaOi9o;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class C4FrIb {
    public static void A2egSU(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public static void A4TApA(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public static void A5SV6n(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
