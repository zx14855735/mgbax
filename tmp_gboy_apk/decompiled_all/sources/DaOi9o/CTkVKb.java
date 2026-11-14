package DaOi9o;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb extends CSDoyG {
    @Override // ADYaiT.BmvVmW
    public final float ADYaiT(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // DaOi9o.CNPG0E, ADYaiT.BmvVmW
    public final void AZOQYO(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // ADYaiT.BmvVmW
    public final void AaHO0E(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // DaOi9o.CSDoyG, ADYaiT.BmvVmW
    public final void AcNBzu(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // ADYaiT.BmvVmW
    public final void AlLFFp(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // ADYaiT.BmvVmW
    public final void AmA8tU(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
