package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Ddcejp implements Transition.TransitionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Object f8939A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8940A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f8941A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8942ADYaiT;
    public final /* synthetic */ DjONCG AMqCpz;

    public Ddcejp(DjONCG djONCG, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.AMqCpz = djONCG;
        this.f8939A2egSU = obj;
        this.f8940A4TApA = arrayList;
        this.f8941A5SV6n = obj2;
        this.f8942ADYaiT = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        DjONCG djONCG = this.AMqCpz;
        Object obj = this.f8939A2egSU;
        if (obj != null) {
            djONCG.B7CMnp(obj, this.f8940A4TApA, null);
        }
        Object obj2 = this.f8941A5SV6n;
        if (obj2 != null) {
            djONCG.B7CMnp(obj2, this.f8942ADYaiT, null);
        }
    }
}
