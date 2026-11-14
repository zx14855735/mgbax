package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.CcAIMM;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.D6yqiO;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsFragmentManager {

    @A2egSU
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private final CtxOCS mBase;

    @KsAdSdkDynamicApi
    @A2egSU
    public static abstract class FragmentLifecycleCallbacks {
        private CtxOCS.A2egSU mBase;

        @A2egSU
        public FragmentLifecycleCallbacks() {
        }

        @A2egSU
        public CtxOCS.A2egSU getBase() {
            return this.mBase;
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentActivityCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentDetached(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentPaused(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentPreAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentPreCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentResumed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentSaveInstanceState(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentStarted(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentStopped(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentViewCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, View view, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @A2egSU
        public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @A2egSU
        public void setBase(CtxOCS.A2egSU a2egSU) {
            this.mBase = a2egSU;
        }
    }

    @A2egSU
    public KsFragmentManager(CtxOCS ctxOCS) {
        this.mBase = ctxOCS;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public static void enableDebugLogging(boolean z) {
        while (true) {
        }
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentTransaction beginTransaction() {
        CtxOCS ctxOCS = this.mBase;
        ctxOCS.getClass();
        return new KsFragmentTransaction(new androidx.fragment.app.A2egSU(ctxOCS));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mBase.B9tovu(str, fileDescriptor, printWriter, strArr);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean executePendingTransactions() {
        CtxOCS ctxOCS = this.mBase;
        boolean BIYEnU2 = ctxOCS.BIYEnU(true);
        ctxOCS.BV3sI0();
        return BIYEnU2;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragment findFragmentById(int i) {
        Object BPw6Q82 = this.mBase.BPw6Q8(i);
        if (BPw6Q82 instanceof IDelegateFragment) {
            return ((IDelegateFragment) BPw6Q82).getBase();
        }
        if (BPw6Q82 == null) {
            return null;
        }
        throw new RuntimeException(BPw6Q82 + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragment findFragmentByTag(String str) {
        Object BTvldC2 = this.mBase.BTvldC(str);
        if (BTvldC2 instanceof IDelegateFragment) {
            return ((IDelegateFragment) BTvldC2).getBase();
        }
        if (BTvldC2 == null) {
            return null;
        }
        throw new RuntimeException(BTvldC2 + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int getBackStackEntryCount() {
        ArrayList arrayList = this.mBase.f8832ADYaiT;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @A2egSU
    public CtxOCS getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragment getFragment(Bundle bundle, String str) {
        Object BmvVmW2 = this.mBase.BmvVmW(bundle, str);
        if (BmvVmW2 instanceof IDelegateFragment) {
            return ((IDelegateFragment) BmvVmW2).getBase();
        }
        if (BmvVmW2 == null) {
            return null;
        }
        throw new RuntimeException(BmvVmW2 + " is not a DelegateFragment or DelegateDialogFragment");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public List<KsFragment> getFragments() {
        List<Object> ARc23Z2 = this.mBase.f8831A5SV6n.ARc23Z();
        ArrayList arrayList = new ArrayList(ARc23Z2.size());
        for (Object obj : ARc23Z2) {
            if (!(obj instanceof IDelegateFragment)) {
                throw new RuntimeException(obj + " is not a DelegateFragment");
            }
            arrayList.add(((IDelegateFragment) obj).getBase());
        }
        return arrayList;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isDestroyed() {
        return this.mBase.f8859C2rE4F;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isStateSaved() {
        return this.mBase.CQhlFr();
    }

    @KsAdSdkDynamicApi
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    @A2egSU
    public KsFragmentTransaction openTransaction() {
        CtxOCS ctxOCS = this.mBase;
        ctxOCS.getClass();
        return new KsFragmentTransaction(new androidx.fragment.app.A2egSU(ctxOCS));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void popBackStack() {
        CtxOCS ctxOCS = this.mBase;
        ctxOCS.getClass();
        ctxOCS.BChYOn(new D6yqiO(ctxOCS, null, -1, 0), false);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean popBackStackImmediate() {
        return this.mBase.Cd8JRx();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void putFragment(Bundle bundle, String str, KsFragment ksFragment) {
        this.mBase.CmUvjW(bundle, str, ksFragment.getBase());
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        fragmentLifecycleCallbacks.setBase(new DelegateFragmentLifecycleCallbacks(this, fragmentLifecycleCallbacks));
        this.mBase.f8839AcNBzu.f8820A2egSU.add(new CcAIMM(fragmentLifecycleCallbacks.getBase(), z));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsSavedState saveFragmentInstanceState(KsFragment ksFragment) {
        return new KsSavedState(this.mBase.D07BeM(ksFragment.getBase()));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mBase.DG07BK(fragmentLifecycleCallbacks.getBase());
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean popBackStackImmediate(String str, int i) {
        return this.mBase.CikNvS(-1, i, str);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void popBackStack(String str, int i) {
        CtxOCS ctxOCS = this.mBase;
        ctxOCS.getClass();
        ctxOCS.BChYOn(new D6yqiO(ctxOCS, str, -1, i), false);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean popBackStackImmediate(int i, int i2) {
        CtxOCS ctxOCS = this.mBase;
        if (i >= 0) {
            return ctxOCS.CikNvS(i, i2, null);
        }
        ctxOCS.getClass();
        throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Bad id: "));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void popBackStack(int i, int i2) {
        this.mBase.CcAIMM(i, i2, false);
    }
}
