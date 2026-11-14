package QgOIY0;

import android.transition.Transition;
import android.transition.TransitionSet;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class CQhlFr implements Transition.TransitionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Transition f7683A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f7684A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Transition f7685A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f7686ADYaiT;
    public final TransitionSet AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final ArrayList f7687ARc23Z;

    public CQhlFr(Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, TransitionSet transitionSet, ArrayList arrayList3) {
        this.f7683A2egSU = transition;
        this.f7684A4TApA = arrayList;
        this.f7685A5SV6n = transition2;
        this.f7686ADYaiT = arrayList2;
        this.AMqCpz = transitionSet;
        this.f7687ARc23Z = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        Transition transition2 = this.f7683A2egSU;
        if (transition2 != null) {
            AMqCpz.AlLFFp(transition2, this.f7684A4TApA, null);
        }
        Transition transition3 = this.f7685A5SV6n;
        if (transition3 != null) {
            AMqCpz.AlLFFp(transition3, this.f7686ADYaiT, null);
        }
        TransitionSet transitionSet = this.AMqCpz;
        if (transitionSet != null) {
            AMqCpz.AlLFFp(transitionSet, this.f7687ARc23Z, null);
        }
    }
}
