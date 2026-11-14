package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DjONCG extends Dphsd2 {
    public static boolean B4ZgIw(Transition transition) {
        return (Dphsd2.AYUAbz(transition.getTargetIds()) && Dphsd2.AYUAbz(transition.getTargetNames()) && Dphsd2.AYUAbz(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void A2egSU(View view, Object obj) {
        ((Transition) obj).addTarget(view);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void A4TApA(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                A4TApA(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (B4ZgIw(transition) || !Dphsd2.AYUAbz(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget((View) arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void A5SV6n(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final boolean AMqCpz(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object ARc23Z(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object AZOQYO(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object AZkASS(Object obj, Object obj2) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        transitionSet.addTransition((Transition) obj2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AaHO0E(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new DdagTj(view, arrayList));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AcNBzu(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((Transition) obj).addListener(new Ddcejp(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AlLFFp(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            Dphsd2.ASJ6gh(rect, view);
            ((Transition) obj).setEpicenterCallback(new DcUJf1(0, rect));
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AmA8tU(Object obj, Rect rect) {
        ((Transition) obj).setEpicenterCallback(new DcUJf1(1, rect));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AzWtSf(Object obj, C2rE4F.AMqCpz aMqCpz, AYUAbz aYUAbz) {
        ((Transition) obj).addListener(new De4eam(aYUAbz));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void B25kr6(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Dphsd2.ADYaiT(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        A4TApA(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void B2KMhB(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            B7CMnp(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object B3GDIM(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public final void B7CMnp(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                B7CMnp(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (B4ZgIw(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }
}
