package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DdagTj implements Transition.TransitionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ View f8937A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8938A4TApA;

    public DdagTj(View view, ArrayList arrayList) {
        this.f8937A2egSU = view;
        this.f8938A4TApA = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f8937A2egSU.setVisibility(8);
        ArrayList arrayList = this.f8938A4TApA;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((View) arrayList.get(i)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        transition.removeListener(this);
        transition.addListener(this);
    }
}
