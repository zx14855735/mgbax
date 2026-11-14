package RPBX6S;

import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AMqCpz extends BaseContinuationImpl {
    public AMqCpz(RJJjP9.A2egSU a2egSU) {
        super(a2egSU);
        if (a2egSU != null && a2egSU.getContext() != RJJjP9.AMqCpz.f7864AcNBzu) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, RJJjP9.A2egSU
    public RJJjP9.ADYaiT getContext() {
        return RJJjP9.AMqCpz.f7864AcNBzu;
    }
}
