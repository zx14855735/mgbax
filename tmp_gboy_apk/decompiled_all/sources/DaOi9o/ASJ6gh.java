package DaOi9o;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh extends CkXcdM {
    public ASJ6gh(int i) {
        this.f2303CcAIMM = i;
    }

    public static float Cd8JRx(BmvVmW bmvVmW, float f) {
        Float f2;
        return (bmvVmW == null || (f2 = (Float) bmvVmW.f2281A2egSU.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // DaOi9o.CkXcdM, DaOi9o.B4ZgIw
    public final void ASJ6gh(BmvVmW bmvVmW) {
        CkXcdM.COJEAR(bmvVmW);
        View view = bmvVmW.f2282A4TApA;
        Float f = (Float) view.getTag(2131298124);
        if (f == null) {
            f = view.getVisibility() == 0 ? Float.valueOf(BpkvW3.f2284A2egSU.ADYaiT(view)) : Float.valueOf(0.0f);
        }
        bmvVmW.f2281A2egSU.put("android:fade:transitionAlpha", f);
    }

    @Override // DaOi9o.CkXcdM
    public final Animator CSDoyG(View view, BmvVmW bmvVmW) {
        BpkvW3.f2284A2egSU.getClass();
        return CcAIMM(view, Cd8JRx(bmvVmW, 0.0f), 1.0f);
    }

    @Override // DaOi9o.CkXcdM
    public final Animator CTkVKb(View view, BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        ADYaiT.BmvVmW bmvVmW3 = BpkvW3.f2284A2egSU;
        bmvVmW3.getClass();
        ObjectAnimator CcAIMM2 = CcAIMM(view, Cd8JRx(bmvVmW, 1.0f), 0.0f);
        if (CcAIMM2 == null) {
            bmvVmW3.AaHO0E(view, Cd8JRx(bmvVmW2, 1.0f));
        }
        return CcAIMM2;
    }

    public final ObjectAnimator CcAIMM(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        BpkvW3.f2284A2egSU.AaHO0E(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BpkvW3.f2285A4TApA, f2);
        ARc23Z aRc23Z = new ARc23Z(view);
        ofFloat.addListener(aRc23Z);
        B2KMhB().A2egSU(aRc23Z);
        return ofFloat;
    }

    public ASJ6gh() {
    }
}
