package androidx.fragment.app;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CqNSpT extends FragmentFactory {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ CtxOCS f8827A4TApA;

    public CqNSpT(CtxOCS ctxOCS) {
        this.f8827A4TApA = ctxOCS;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment A2egSU(ClassLoader classLoader, String str) {
        CQhlFr cQhlFr = this.f8827A4TApA.f8847B7CMnp;
        Context context = cQhlFr.getContext();
        cQhlFr.getClass();
        return Fragment.instantiate(context, str, null);
    }
}
