package COJEAR;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class De4eam {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f1696A2egSU;

    public De4eam(View view) {
        this.f1696A2egSU = new WeakReference(view);
    }

    public final void A2egSU(float f) {
        View view = (View) this.f1696A2egSU.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void A4TApA() {
        View view = (View) this.f1696A2egSU.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void A5SV6n(long j) {
        View view = (View) this.f1696A2egSU.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void ADYaiT(DjONCG djONCG) {
        View view = (View) this.f1696A2egSU.get();
        if (view != null) {
            if (djONCG != null) {
                view.animate().setListener(new AaHO0E.A5SV6n(djONCG, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void AMqCpz(float f) {
        View view = (View) this.f1696A2egSU.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
