package com.kwad.sdk.api.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class DelegateFragmentLifecycleCallbacks extends CtxOCS.A2egSU {
    private final KsFragmentManager.FragmentLifecycleCallbacks mBase;
    private final KsFragmentManager mFragmentManager;

    public DelegateFragmentLifecycleCallbacks(KsFragmentManager ksFragmentManager, KsFragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mBase = fragmentLifecycleCallbacks;
        this.mFragmentManager = ksFragmentManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentActivityCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentActivityCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentAttached(CtxOCS ctxOCS, Fragment fragment, Context context) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentDestroyed(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentDetached(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentDetached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentPaused(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPaused(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentPreAttached(CtxOCS ctxOCS, Fragment fragment, Context context) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPreAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentPreCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPreCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentResumed(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentResumed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentSaveInstanceState(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentSaveInstanceState(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentStarted(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentStarted(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentStopped(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentStopped(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentViewCreated(CtxOCS ctxOCS, Fragment fragment, View view, Bundle bundle) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentViewCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), view, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public void onFragmentViewDestroyed(CtxOCS ctxOCS, Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentViewDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }
}
