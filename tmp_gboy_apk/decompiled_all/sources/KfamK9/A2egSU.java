package KfamK9;

import com.fl.saas.common.util.feature.Predicate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Predicate {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4261AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Predicate f4262AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Predicate f4263AmA8tU;

    public /* synthetic */ A2egSU(Predicate predicate, Predicate predicate2, int i) {
        this.f4261AcNBzu = i;
        this.f4262AlLFFp = predicate;
        this.f4263AmA8tU = predicate2;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f4261AcNBzu;
        return A4TApA.A2egSU(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f4261AcNBzu) {
        }
        return A4TApA.A4TApA(this);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f4261AcNBzu;
        return A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public final boolean test(Object obj) {
        switch (this.f4261AcNBzu) {
            case 0:
                return A4TApA.ADYaiT(this.f4262AlLFFp, this.f4263AmA8tU, obj);
            default:
                return A4TApA.ARc23Z(this.f4262AlLFFp, this.f4263AmA8tU, obj);
        }
    }
}
