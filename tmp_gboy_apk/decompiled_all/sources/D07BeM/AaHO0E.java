package D07BeM;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements TransformationMethod {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TransformationMethod f1940A2egSU;

    public AaHO0E(TransformationMethod transformationMethod) {
        this.f1940A2egSU = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f1940A2egSU;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || AmA8tU.A2egSU().A4TApA() != 1) {
            return charSequence;
        }
        AmA8tU A2egSU2 = AmA8tU.A2egSU();
        A2egSU2.getClass();
        return A2egSU2.AMqCpz(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        TransformationMethod transformationMethod = this.f1940A2egSU;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i, rect);
        }
    }
}
