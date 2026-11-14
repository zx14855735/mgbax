package androidx.fragment.app;

import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class BmvVmW implements DV2E8K.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f8797A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f8798A4TApA;

    public /* synthetic */ BmvVmW(int i, Object obj) {
        this.f8797A2egSU = i;
        this.f8798A4TApA = obj;
    }

    @Override // DV2E8K.A5SV6n
    public final Bundle saveState() {
        Object obj = this.f8798A4TApA;
        switch (this.f8797A2egSU) {
            case 0:
                String str = FragmentActivity.LIFECYCLE_TAG;
                FragmentActivity fragmentActivity = (FragmentActivity) obj;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_STOP);
                return new Bundle();
            default:
                return ((CtxOCS) obj).CtxOCS();
        }
    }
}
