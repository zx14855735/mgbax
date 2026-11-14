package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DuwtYk implements androidx.lifecycle.AZOQYO, DV2E8K.ARc23Z, androidx.lifecycle.D07BeM {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Fragment f8944AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final androidx.lifecycle.CtxOCS f8945AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final B7CMnp f8946AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public androidx.lifecycle.CqNSpT f8947AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public androidx.lifecycle.BI9f7h f8948B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public DV2E8K.AMqCpz f8949B2KMhB = null;

    public DuwtYk(Fragment fragment, androidx.lifecycle.CtxOCS ctxOCS, B7CMnp b7CMnp) {
        this.f8944AcNBzu = fragment;
        this.f8945AlLFFp = ctxOCS;
        this.f8946AmA8tU = b7CMnp;
    }

    public final void A2egSU(androidx.lifecycle.AlLFFp alLFFp) {
        this.f8948B25kr6.ARc23Z(alLFFp);
    }

    public final void A4TApA() {
        if (this.f8948B25kr6 == null) {
            this.f8948B25kr6 = new androidx.lifecycle.BI9f7h(this);
            DV2E8K.AMqCpz aMqCpz = new DV2E8K.AMqCpz(this);
            this.f8949B2KMhB = aMqCpz;
            aMqCpz.A2egSU();
            this.f8946AmA8tU.run();
        }
    }

    @Override // androidx.lifecycle.AZOQYO
    public final D9tr6l.A4TApA getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f8944AcNBzu;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        D9tr6l.ADYaiT aDYaiT = new D9tr6l.ADYaiT();
        LinkedHashMap linkedHashMap = aDYaiT.f2052A2egSU;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.CkXcdM.f9033A2egSU, application);
        }
        linkedHashMap.put(androidx.lifecycle.CQhlFr.f9015A2egSU, fragment);
        linkedHashMap.put(androidx.lifecycle.CQhlFr.f9016A4TApA, this);
        if (fragment.getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.CQhlFr.f9017A5SV6n, fragment.getArguments());
        }
        return aDYaiT;
    }

    @Override // androidx.lifecycle.AZOQYO
    public final androidx.lifecycle.CqNSpT getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f8944AcNBzu;
        androidx.lifecycle.CqNSpT defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f8947AzWtSf = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f8947AzWtSf == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f8947AzWtSf = new androidx.lifecycle.CcAIMM(application, fragment, fragment.getArguments());
        }
        return this.f8947AzWtSf;
    }

    @Override // androidx.lifecycle.B9tovu
    public final androidx.lifecycle.AzWtSf getLifecycle() {
        A4TApA();
        return this.f8948B25kr6;
    }

    @Override // DV2E8K.ARc23Z
    public final DV2E8K.ADYaiT getSavedStateRegistry() {
        A4TApA();
        return this.f8949B2KMhB.f2197A4TApA;
    }

    @Override // androidx.lifecycle.D07BeM
    public final androidx.lifecycle.CtxOCS getViewModelStore() {
        A4TApA();
        return this.f8945AlLFFp;
    }
}
