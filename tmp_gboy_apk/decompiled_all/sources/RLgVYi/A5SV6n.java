package RLgVYi;

import RXb0Sz.ARc23Z;
import RXb0Sz.AaHO0E;
import com.bumptech.glide.AMqCpz;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends RPBX6S.A4TApA {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7870AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Function2 f7871AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ RJJjP9.A2egSU f7872B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5SV6n(RJJjP9.A2egSU a2egSU, RJJjP9.ADYaiT aDYaiT, Function2 function2, RJJjP9.A2egSU a2egSU2) {
        super(a2egSU, aDYaiT);
        this.f7871AzWtSf = function2;
        this.f7872B25kr6 = a2egSU2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.f7870AmA8tU;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f7870AmA8tU = 2;
            AMqCpz.CqNSpT(obj);
            return obj;
        }
        this.f7870AmA8tU = 1;
        AMqCpz.CqNSpT(obj);
        Function2 function2 = this.f7871AzWtSf;
        ARc23Z.A5SV6n(function2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        AaHO0E.A2egSU(function2);
        return function2.invoke(this.f7872B25kr6, this);
    }
}
