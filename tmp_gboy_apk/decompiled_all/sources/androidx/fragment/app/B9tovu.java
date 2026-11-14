package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu extends androidx.activity.result.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8765A2egSU;

    public B9tovu(AtomicReference atomicReference) {
        this.f8765A2egSU = atomicReference;
    }

    @Override // androidx.activity.result.A5SV6n
    public final void A2egSU(Object obj) {
        androidx.activity.result.A5SV6n a5SV6n = (androidx.activity.result.A5SV6n) this.f8765A2egSU.get();
        if (a5SV6n == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        a5SV6n.A2egSU(obj);
    }
}
