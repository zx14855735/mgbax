package COJEAR;

import android.os.Build;
import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EUIRHA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public EQurEW f1716A2egSU;

    public EUIRHA(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f1716A2egSU = new EPdU4G(C2rE4F.AZkASS(i, interpolator, j));
        } else {
            this.f1716A2egSU = new EGM26s(i, interpolator, j);
        }
    }
}
