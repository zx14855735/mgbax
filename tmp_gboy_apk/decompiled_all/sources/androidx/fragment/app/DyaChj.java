package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DyaChj {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f8953A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f8954A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Fragment f8955A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f8956ADYaiT;
    public final LinkedHashSet AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f8957ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f8958ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final DUi7mC f8959AYUAbz;

    public DyaChj(int i, int i2, DUi7mC dUi7mC, C2rE4F.AMqCpz aMqCpz) {
        J3FDQU.A2egSU.BJ7GGh(i, "finalState");
        J3FDQU.A2egSU.BJ7GGh(i2, "lifecycleImpact");
        Fragment fragment = dUi7mC.f8903A5SV6n;
        RXb0Sz.ARc23Z.ADYaiT(fragment, "fragmentStateManager.fragment");
        J3FDQU.A2egSU.BJ7GGh(i, "finalState");
        J3FDQU.A2egSU.BJ7GGh(i2, "lifecycleImpact");
        RXb0Sz.ARc23Z.AMqCpz(fragment, "fragment");
        this.f8953A2egSU = i;
        this.f8954A4TApA = i2;
        this.f8955A5SV6n = fragment;
        this.f8956ADYaiT = new ArrayList();
        this.AMqCpz = new LinkedHashSet();
        aMqCpz.A2egSU(new C2rE4F.ADYaiT() { // from class: androidx.fragment.app.ECyGFg
            @Override // C2rE4F.ADYaiT
            public final void onCancel() {
                DyaChj dyaChj = DyaChj.this;
                RXb0Sz.ARc23Z.AMqCpz(dyaChj, "this$0");
                dyaChj.A2egSU();
            }
        });
        this.f8959AYUAbz = dUi7mC;
    }

    public final void A2egSU() {
        if (this.f8957ARc23Z) {
            return;
        }
        this.f8957ARc23Z = true;
        LinkedHashSet linkedHashSet = this.AMqCpz;
        if (linkedHashSet.isEmpty()) {
            A4TApA();
            return;
        }
        for (C2rE4F.AMqCpz aMqCpz : new LinkedHashSet(linkedHashSet)) {
            synchronized (aMqCpz) {
                try {
                    if (!aMqCpz.f1533A2egSU) {
                        aMqCpz.f1533A2egSU = true;
                        aMqCpz.f1535A5SV6n = true;
                        C2rE4F.ADYaiT aDYaiT = aMqCpz.f1534A4TApA;
                        if (aDYaiT != null) {
                            try {
                                aDYaiT.onCancel();
                            } catch (Throwable th) {
                                synchronized (aMqCpz) {
                                    aMqCpz.f1535A5SV6n = false;
                                    aMqCpz.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (aMqCpz) {
                            aMqCpz.f1535A5SV6n = false;
                            aMqCpz.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void A4TApA() {
        if (!this.f8958ASJ6gh) {
            if (CtxOCS.C4FrIb(2)) {
                toString();
            }
            this.f8958ASJ6gh = true;
            Iterator it = this.f8956ADYaiT.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f8959AYUAbz.AZOQYO();
    }

    public final void A5SV6n(int i, int i2) {
        J3FDQU.A2egSU.BJ7GGh(i, "finalState");
        J3FDQU.A2egSU.BJ7GGh(i2, "lifecycleImpact");
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(i2);
        Fragment fragment = this.f8955A5SV6n;
        if (ADYaiT2 == 0) {
            if (this.f8953A2egSU != 1) {
                if (CtxOCS.C4FrIb(2)) {
                    Objects.toString(fragment);
                    if (i != 1 && i != 2 && i != 3 && i != 4) {
                        throw null;
                    }
                }
                this.f8953A2egSU = i;
                return;
            }
            return;
        }
        if (ADYaiT2 != 1) {
            if (ADYaiT2 != 2) {
                return;
            }
            if (CtxOCS.C4FrIb(2)) {
                Objects.toString(fragment);
            }
            this.f8953A2egSU = 1;
            this.f8954A4TApA = 3;
            return;
        }
        if (this.f8953A2egSU == 1) {
            if (CtxOCS.C4FrIb(2)) {
                Objects.toString(fragment);
            }
            this.f8953A2egSU = 2;
            this.f8954A4TApA = 2;
        }
    }

    public final void ADYaiT() {
        int i = this.f8954A4TApA;
        DUi7mC dUi7mC = this.f8959AYUAbz;
        if (i != 2) {
            if (i == 3) {
                Fragment fragment = dUi7mC.f8903A5SV6n;
                RXb0Sz.ARc23Z.ADYaiT(fragment, "fragmentStateManager.fragment");
                View requireView = fragment.requireView();
                RXb0Sz.ARc23Z.ADYaiT(requireView, "fragment.requireView()");
                if (CtxOCS.C4FrIb(2)) {
                    Objects.toString(requireView.findFocus());
                    requireView.toString();
                    fragment.toString();
                }
                requireView.clearFocus();
                return;
            }
            return;
        }
        Fragment fragment2 = dUi7mC.f8903A5SV6n;
        RXb0Sz.ARc23Z.ADYaiT(fragment2, "fragmentStateManager.fragment");
        View findFocus = fragment2.mView.findFocus();
        if (findFocus != null) {
            fragment2.setFocusedView(findFocus);
            if (CtxOCS.C4FrIb(2)) {
                findFocus.toString();
                fragment2.toString();
            }
        }
        View requireView2 = this.f8955A5SV6n.requireView();
        RXb0Sz.ARc23Z.ADYaiT(requireView2, "this.fragment.requireView()");
        if (requireView2.getParent() == null) {
            dUi7mC.A2egSU();
            requireView2.setAlpha(0.0f);
        }
        if (requireView2.getAlpha() == 0.0f && requireView2.getVisibility() == 0) {
            requireView2.setVisibility(4);
        }
        requireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
    }

    public final String toString() {
        StringBuilder B3GDIM2 = ADYaiT.CtFAbx.B3GDIM("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        int i = this.f8953A2egSU;
        B3GDIM2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED");
        B3GDIM2.append(" lifecycleImpact = ");
        int i2 = this.f8954A4TApA;
        B3GDIM2.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE");
        B3GDIM2.append(" fragment = ");
        B3GDIM2.append(this.f8955A5SV6n);
        B3GDIM2.append('}');
        return B3GDIM2.toString();
    }
}
