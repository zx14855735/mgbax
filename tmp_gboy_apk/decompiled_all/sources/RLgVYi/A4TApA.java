package RLgVYi;

import RPBX6S.AMqCpz;
import RXb0Sz.ARc23Z;
import RXb0Sz.AaHO0E;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA extends AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7867AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Function2 f7868AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ RJJjP9.A2egSU f7869AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4TApA(RJJjP9.A2egSU a2egSU, Function2 function2, RJJjP9.A2egSU a2egSU2) {
        super(a2egSU);
        this.f7868AlLFFp = function2;
        this.f7869AmA8tU = a2egSU2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.f7867AcNBzu;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f7867AcNBzu = 2;
            com.bumptech.glide.AMqCpz.CqNSpT(obj);
            return obj;
        }
        this.f7867AcNBzu = 1;
        com.bumptech.glide.AMqCpz.CqNSpT(obj);
        Function2 function2 = this.f7868AlLFFp;
        ARc23Z.A5SV6n(function2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        AaHO0E.A2egSU(function2);
        return function2.invoke(this.f7869AmA8tU, this);
    }
}
