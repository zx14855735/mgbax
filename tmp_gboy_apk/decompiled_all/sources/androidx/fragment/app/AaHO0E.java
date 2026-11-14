package androidx.fragment.app;

import android.transition.Transition;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends AZkASS {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f8743A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f8744ADYaiT;
    public final Object AMqCpz;

    public AaHO0E(DyaChj dyaChj, C2rE4F.AMqCpz aMqCpz, boolean z, boolean z2) {
        super(dyaChj, aMqCpz);
        int i = dyaChj.f8953A2egSU;
        Fragment fragment = dyaChj.f8955A5SV6n;
        this.f8743A5SV6n = i == 2 ? z ? fragment.getReenterTransition() : fragment.getEnterTransition() : z ? fragment.getReturnTransition() : fragment.getExitTransition();
        this.f8744ADYaiT = dyaChj.f8953A2egSU == 2 ? z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() : true;
        this.AMqCpz = z2 ? z ? fragment.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition() : null;
    }

    public final Dphsd2 A5SV6n() {
        Object obj = this.f8743A5SV6n;
        Dphsd2 ADYaiT2 = ADYaiT(obj);
        Object obj2 = this.AMqCpz;
        Dphsd2 ADYaiT3 = ADYaiT(obj2);
        if (ADYaiT2 == null || ADYaiT3 == null || ADYaiT2 == ADYaiT3) {
            return ADYaiT2 == null ? ADYaiT3 : ADYaiT2;
        }
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.f8741A2egSU.f8955A5SV6n + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
    }

    public final Dphsd2 ADYaiT(Object obj) {
        if (obj == null) {
            return null;
        }
        DjONCG djONCG = DaOi9o.f8933A2egSU;
        if (djONCG != null && (obj instanceof Transition)) {
            return djONCG;
        }
        Dphsd2 dphsd2 = DaOi9o.f8934A4TApA;
        if (dphsd2 != null && dphsd2.AMqCpz(obj)) {
            return dphsd2;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f8741A2egSU.f8955A5SV6n + " is not a valid framework Transition or AndroidX Transition");
    }
}
