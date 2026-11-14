package androidx.fragment.app;

import android.transition.Transition;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class De4eam implements Transition.TransitionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f8943A2egSU;

    public De4eam(AYUAbz aYUAbz) {
        this.f8943A2egSU = aYUAbz;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        this.f8943A2egSU.run();
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
    }
}
