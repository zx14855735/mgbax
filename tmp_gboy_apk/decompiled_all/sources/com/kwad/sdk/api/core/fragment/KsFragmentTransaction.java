package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import android.view.View;
import androidx.fragment.app.DXnQ0V;
import androidx.fragment.app.DXuj49;
import androidx.fragment.app.DaOi9o;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import java.util.ArrayList;
import java.util.WeakHashMap;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsFragmentTransaction {
    private final DXuj49 mBase;

    public KsFragmentTransaction(DXuj49 dXuj49) {
        this.mBase = dXuj49;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction add(KsFragment ksFragment, String str) {
        this.mBase.AZOQYO(0, ksFragment.getBase(), str, 1);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction addSharedElement(View view, String str) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.getClass();
        if (DaOi9o.f8933A2egSU == null && DaOi9o.f8934A4TApA == null) {
            return this;
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        String AaHO0E2 = CmUvjW.AaHO0E(view);
        if (AaHO0E2 == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        if (dXuj49.f8929AmA8tU == null) {
            dXuj49.f8929AmA8tU = new ArrayList();
            dXuj49.f8930AzWtSf = new ArrayList();
        } else {
            if (dXuj49.f8930AzWtSf.contains(str)) {
                throw new IllegalArgumentException(CtFAbx.BI9f7h("A shared element with the target name '", str, "' has already been added to the transaction."));
            }
            if (dXuj49.f8929AmA8tU.contains(AaHO0E2)) {
                throw new IllegalArgumentException(CtFAbx.BI9f7h("A shared element with the source name '", AaHO0E2, "' has already been added to the transaction."));
            }
        }
        dXuj49.f8929AmA8tU.add(AaHO0E2);
        dXuj49.f8930AzWtSf.add(str);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction addToBackStack(String str) {
        DXuj49 dXuj49 = this.mBase;
        if (!dXuj49.f8923AYUAbz) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        dXuj49.f8922ASJ6gh = true;
        dXuj49.f8924AZOQYO = str;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction attach(KsFragment ksFragment) {
        DXuj49 dXuj49 = this.mBase;
        Fragment base = ksFragment.getBase();
        dXuj49.getClass();
        dXuj49.A4TApA(new DXnQ0V(base, 7));
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int commit() {
        return this.mBase.A5SV6n();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int commitAllowingStateLoss() {
        return this.mBase.ADYaiT();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void commitNow() {
        this.mBase.AMqCpz();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void commitNowAllowingStateLoss() {
        this.mBase.ARc23Z();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction detach(KsFragment ksFragment) {
        this.mBase.ASJ6gh(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction disallowAddToBackStack() {
        this.mBase.AYUAbz();
        return this;
    }

    public DXuj49 getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction hide(KsFragment ksFragment) {
        this.mBase.AZkASS(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isAddToBackStackAllowed() {
        return this.mBase.f8923AYUAbz;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isEmpty() {
        return this.mBase.AaHO0E();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction remove(KsFragment ksFragment) {
        this.mBase.AcNBzu(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction replace(int i, KsFragment ksFragment) {
        this.mBase.AlLFFp(i, ksFragment.getBase(), null);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction runOnCommit(Runnable runnable) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.AYUAbz();
        if (dXuj49.f8932B2KMhB == null) {
            dXuj49.f8932B2KMhB = new ArrayList();
        }
        dXuj49.f8932B2KMhB.add(runnable);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public KsFragmentTransaction setAllowOptimization(boolean z) {
        this.mBase.f8931B25kr6 = z;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setBreadCrumbShortTitle(int i) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8927AcNBzu = i;
        dXuj49.f8928AlLFFp = null;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setBreadCrumbTitle(int i) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8925AZkASS = i;
        dXuj49.f8926AaHO0E = null;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setCustomAnimations(int i, int i2) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8918A4TApA = i;
        dXuj49.f8919A5SV6n = i2;
        dXuj49.f8920ADYaiT = 0;
        dXuj49.AMqCpz = 0;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setPrimaryNavigationFragment(KsFragment ksFragment) {
        this.mBase.AmA8tU(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setReorderingAllowed(boolean z) {
        this.mBase.f8931B25kr6 = z;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setTransition(int i) {
        this.mBase.f8921ARc23Z = i;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setTransitionStyle(int i) {
        this.mBase.getClass();
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction show(KsFragment ksFragment) {
        this.mBase.AzWtSf(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction add(int i, KsFragment ksFragment) {
        this.mBase.AZOQYO(i, ksFragment.getBase(), null, 1);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction replace(int i, KsFragment ksFragment, String str) {
        this.mBase.AlLFFp(i, ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8927AcNBzu = 0;
        dXuj49.f8928AlLFFp = charSequence;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8925AZkASS = 0;
        dXuj49.f8926AaHO0E = charSequence;
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction add(int i, KsFragment ksFragment, String str) {
        this.mBase.AZOQYO(i, ksFragment.getBase(), str, 1);
        return this;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        DXuj49 dXuj49 = this.mBase;
        dXuj49.f8918A4TApA = i;
        dXuj49.f8919A5SV6n = i2;
        dXuj49.f8920ADYaiT = i3;
        dXuj49.AMqCpz = i4;
        return this;
    }
}
