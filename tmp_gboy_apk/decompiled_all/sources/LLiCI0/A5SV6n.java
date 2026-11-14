package LLiCI0;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements De4eam.AaHO0E {
    @Override // De4eam.AaHO0E
    public final void transformPage(View view, float f) {
        view.setScaleY(((1.0f - Math.abs(f)) * 0.08f) + 0.92f);
        view.setAlpha(((1.0f - Math.abs(f)) * 0.4f) + 0.6f);
    }
}
