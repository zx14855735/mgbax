package COJEAR;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DcUJf1 extends RPBX6S.AMqCpz implements Function2, RXb0Sz.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f1690AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1691AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public /* synthetic */ Object f1692AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ View f1693AzWtSf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DcUJf1(View view, RJJjP9.A2egSU a2egSU) {
        super(a2egSU);
        this.f1693AzWtSf = view;
        this.f1690AcNBzu = 2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final RJJjP9.A2egSU create(Object obj, RJJjP9.A2egSU a2egSU) {
        DcUJf1 dcUJf1 = new DcUJf1(this.f1693AzWtSf, a2egSU);
        dcUJf1.f1692AmA8tU = obj;
        return dcUJf1;
    }

    @Override // RXb0Sz.AMqCpz
    public final int getArity() {
        return this.f1690AcNBzu;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DcUJf1) create((RicAXQ.A4TApA) obj, (RJJjP9.A2egSU) obj2)).invokeSuspend(R8Rbcg.AMqCpz.f7833A5SV6n);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RLgVYi.A2egSU a2egSU = RLgVYi.A2egSU.f7865AcNBzu;
        int i = this.f1691AlLFFp;
        R8Rbcg.AMqCpz aMqCpz = R8Rbcg.AMqCpz.f7833A5SV6n;
        View view = this.f1693AzWtSf;
        if (i == 0) {
            com.bumptech.glide.AMqCpz.CqNSpT(obj);
            RicAXQ.A4TApA a4TApA = (RicAXQ.A4TApA) this.f1692AmA8tU;
            this.f1692AmA8tU = a4TApA;
            this.f1691AlLFFp = 1;
            a4TApA.A2egSU(view, this);
            return a2egSU;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.AMqCpz.CqNSpT(obj);
            return aMqCpz;
        }
        RicAXQ.A4TApA a4TApA2 = (RicAXQ.A4TApA) this.f1692AmA8tU;
        com.bumptech.glide.AMqCpz.CqNSpT(obj);
        if (view instanceof ViewGroup) {
            this.f1692AmA8tU = null;
            this.f1691AlLFFp = 2;
            a4TApA2.getClass();
            Object A4TApA2 = a4TApA2.A4TApA(new CNPG0E(new DaOi9o(0, (ViewGroup) view)), this);
            if (A4TApA2 != a2egSU) {
                A4TApA2 = aMqCpz;
            }
            if (A4TApA2 == a2egSU) {
                return a2egSU;
            }
        }
        return aMqCpz;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        RXb0Sz.AZOQYO.f7892A2egSU.getClass();
        String A2egSU2 = RXb0Sz.AZkASS.A2egSU(this);
        RXb0Sz.ARc23Z.ADYaiT(A2egSU2, "renderLambdaToString(...)");
        return A2egSU2;
    }
}
