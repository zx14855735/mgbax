package QgOIY0;

import android.R;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f7495A2egSU = {R.attr.name, R.attr.id, R.attr.tag};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f7496A4TApA = {0, 3, 0, 1, 5, 4, 7, 6};

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
    
        if (r1 == r2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.transition.Transition A2egSU(QgOIY0.B2KMhB r1, boolean r2) {
        /*
            r0 = 0
            if (r1 != 0) goto L4
            return r0
        L4:
            if (r2 == 0) goto L11
            QgOIY0.B25kr6 r1 = r1.f7570BmvVmW
            if (r1 != 0) goto Lb
            goto L11
        Lb:
            java.lang.Object r2 = QgOIY0.B2KMhB.f7551CtxOCS
            java.lang.Object r1 = r1.AMqCpz
            if (r1 != r2) goto L12
        L11:
            r1 = r0
        L12:
            if (r1 == 0) goto L1b
            android.transition.Transition r1 = (android.transition.Transition) r1
            android.transition.Transition r1 = r1.clone()
            return r1
        L1b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.AMqCpz.A2egSU(QgOIY0.B2KMhB, boolean):android.transition.Transition");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (r1 == r2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.transition.TransitionSet A4TApA(QgOIY0.B2KMhB r1, QgOIY0.B2KMhB r2, boolean r3) {
        /*
            r0 = 0
            if (r1 == 0) goto L2a
            if (r2 != 0) goto L6
            goto L2a
        L6:
            if (r3 == 0) goto L13
            QgOIY0.B25kr6 r1 = r2.f7570BmvVmW
            if (r1 != 0) goto Ld
            goto L13
        Ld:
            java.lang.Object r2 = QgOIY0.B2KMhB.f7551CtxOCS
            java.lang.Object r1 = r1.f7549ARc23Z
            if (r1 != r2) goto L14
        L13:
            r1 = r0
        L14:
            if (r1 == 0) goto L1d
            android.transition.Transition r1 = (android.transition.Transition) r1
            android.transition.Transition r1 = r1.clone()
            goto L1e
        L1d:
            r1 = r0
        L1e:
            if (r1 != 0) goto L21
            goto L2a
        L21:
            android.transition.TransitionSet r2 = new android.transition.TransitionSet
            r2.<init>()
            r2.addTransition(r1)
            return r2
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.AMqCpz.A4TApA(QgOIY0.B2KMhB, QgOIY0.B2KMhB, boolean):android.transition.TransitionSet");
    }

    public static TransitionSet A5SV6n(Transition transition, Transition transition2, TransitionSet transitionSet, B2KMhB b2KMhB) {
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition2 != null) {
            transitionSet2.addTransition(transition2);
        }
        if (transition != null) {
            transitionSet2.addTransition(transition);
        }
        if (transitionSet != null) {
            transitionSet2.addTransition(transitionSet);
        }
        return transitionSet2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0036, code lost:
    
        if (r1.f7580CcAIMM != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0038, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0069, code lost:
    
        if (r1.f7559B4ZgIw != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0075, code lost:
    
        if (r1.f7559B4ZgIw != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void ADYaiT(QgOIY0.AaHO0E r11, QgOIY0.AZkASS r12, android.util.SparseArray r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.AMqCpz.ADYaiT(QgOIY0.AaHO0E, QgOIY0.AZkASS, android.util.SparseArray, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0223 A[LOOP:7: B:85:0x0221->B:86:0x0223, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void AMqCpz(QgOIY0.BNL6CD r31, java.util.ArrayList r32, java.util.ArrayList r33, int r34, int r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.AMqCpz.AMqCpz(QgOIY0.BNL6CD, java.util.ArrayList, java.util.ArrayList, int, int, boolean):void");
    }

    public static void ARc23Z(QkAq4X.A4TApA a4TApA, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                a4TApA.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ARc23Z(a4TApA, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void ASJ6gh(Rect rect, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        rect.set(i, iArr[1], view.getWidth() + i, view.getHeight() + iArr[1]);
    }

    public static void AYUAbz(Transition transition, ArrayList arrayList) {
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                AYUAbz(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (AZOQYO(transition)) {
            return;
        }
        List<View> targets = transition.getTargets();
        if (targets == null || targets.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget((View) arrayList.get(i));
                i++;
            }
        }
    }

    public static boolean AZOQYO(Transition transition) {
        List<Integer> targetIds = transition.getTargetIds();
        if (targetIds != null && !targetIds.isEmpty()) {
            return true;
        }
        List<String> targetNames = transition.getTargetNames();
        if (targetNames != null && !targetNames.isEmpty()) {
            return true;
        }
        List<Class> targetTypes = transition.getTargetTypes();
        return (targetTypes == null || targetTypes.isEmpty()) ? false : true;
    }

    public static QkAq4X.A4TApA AZkASS(QkAq4X.A4TApA a4TApA, TransitionSet transitionSet, C4FrIb c4FrIb) {
        if (a4TApA.isEmpty() || transitionSet == null) {
            a4TApA.clear();
            return null;
        }
        B2KMhB b2KMhB = c4FrIb.f7673ADYaiT;
        QkAq4X.A4TApA a4TApA2 = new QkAq4X.A4TApA();
        b2KMhB.getClass();
        ARc23Z(a4TApA2, null);
        throw null;
    }

    public static Transition AaHO0E(B2KMhB b2KMhB, boolean z) {
        Object obj;
        B25kr6 b25kr6;
        if (b2KMhB == null) {
            return null;
        }
        if (!z || (b25kr6 = b2KMhB.f7570BmvVmW) == null || (obj = b25kr6.f7548ADYaiT) == B2KMhB.f7551CtxOCS) {
            obj = null;
        }
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public static ArrayList AcNBzu(Transition transition, B2KMhB b2KMhB, ArrayList arrayList, View view) {
        if (transition == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        b2KMhB.getClass();
        arrayList2.removeAll(arrayList);
        if (!arrayList2.isEmpty()) {
            arrayList2.add(view);
            AYUAbz(transition, arrayList2);
        }
        return arrayList2;
    }

    public static void AlLFFp(Transition transition, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                AlLFFp(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (AZOQYO(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
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

    public static void AmA8tU(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    public static QkAq4X.A4TApA AzWtSf(QkAq4X.A4TApA a4TApA, TransitionSet transitionSet, C4FrIb c4FrIb) {
        c4FrIb.f7670A2egSU.getClass();
        a4TApA.clear();
        return null;
    }
}
