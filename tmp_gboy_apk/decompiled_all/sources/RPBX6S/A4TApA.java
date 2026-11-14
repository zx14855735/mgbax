package RPBX6S;

import RXb0Sz.ARc23Z;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A4TApA extends BaseContinuationImpl {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final RJJjP9.ADYaiT f7874AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public transient RJJjP9.A2egSU f7875AlLFFp;

    public A4TApA(RJJjP9.A2egSU a2egSU, RJJjP9.ADYaiT aDYaiT) {
        super(a2egSU);
        this.f7874AcNBzu = aDYaiT;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, RJJjP9.A2egSU
    public RJJjP9.ADYaiT getContext() {
        RJJjP9.ADYaiT aDYaiT = this.f7874AcNBzu;
        ARc23Z.A4TApA(aDYaiT);
        return aDYaiT;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final void releaseIntercepted() {
        RJJjP9.A2egSU a2egSU = this.f7875AlLFFp;
        if (a2egSU != null && a2egSU != this) {
            ARc23Z.A4TApA(getContext().A2egSU(RJJjP9.A4TApA.f7863A2egSU));
        }
        this.f7875AlLFFp = A2egSU.f7873AcNBzu;
    }
}
