package NdEzCJ;

import B25kr6.AzWtSf;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AzWtSf f6041A2egSU = new AzWtSf();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AzWtSf f6042A4TApA = new AzWtSf();

    public static A5SV6n A2egSU(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return A4TApA(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return A4TApA(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i);
            return null;
        }
    }

    public static A5SV6n A4TApA(ArrayList arrayList) {
        A5SV6n a5SV6n = new A5SV6n();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            a5SV6n.f6042A4TApA.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            ADYaiT aDYaiT = new ADYaiT();
            aDYaiT.f6046ADYaiT = 0;
            aDYaiT.AMqCpz = 1;
            aDYaiT.f6043A2egSU = startDelay;
            aDYaiT.f6044A4TApA = duration;
            aDYaiT.f6045A5SV6n = interpolator;
            aDYaiT.f6046ADYaiT = objectAnimator.getRepeatCount();
            aDYaiT.AMqCpz = objectAnimator.getRepeatMode();
            a5SV6n.f6041A2egSU.put(propertyName, aDYaiT);
        }
        return a5SV6n;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof A5SV6n) {
            return this.f6041A2egSU.equals(((A5SV6n) obj).f6041A2egSU);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6041A2egSU.hashCode();
    }

    public final String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f6041A2egSU + "}\n";
    }
}
