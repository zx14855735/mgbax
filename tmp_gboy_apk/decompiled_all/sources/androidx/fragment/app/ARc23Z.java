package androidx.fragment.app;

import android.view.View;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.volley.NetworkResponse;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.network.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ARc23Z implements C2rE4F.ADYaiT, ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8727AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f8728AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f8729AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f8730AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f8731B25kr6;

    public /* synthetic */ ARc23Z(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f8727AcNBzu = i;
        this.f8728AlLFFp = obj;
        this.f8729AmA8tU = obj2;
        this.f8730AzWtSf = obj3;
        this.f8731B25kr6 = obj4;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        switch (this.f8727AcNBzu) {
            case 1:
                ae.a((String) this.f8728AlLFFp, (AdTracker) this.f8729AmA8tU, (NetworkResponse) this.f8730AzWtSf, (ae.a) this.f8731B25kr6, obj);
                break;
            default:
                b.a((String) this.f8728AlLFFp, (String) this.f8729AmA8tU, (String) this.f8730AzWtSf, (NetworkResponse) this.f8731B25kr6, obj);
                break;
        }
    }

    @Override // C2rE4F.ADYaiT
    public void onCancel() {
        AmA8tU amA8tU = (AmA8tU) this.f8729AmA8tU;
        RXb0Sz.ARc23Z.AMqCpz(amA8tU, "this$0");
        AZOQYO azoqyo = (AZOQYO) this.f8730AzWtSf;
        RXb0Sz.ARc23Z.AMqCpz(azoqyo, "$animationInfo");
        DyaChj dyaChj = (DyaChj) this.f8731B25kr6;
        RXb0Sz.ARc23Z.AMqCpz(dyaChj, "$operation");
        View view = (View) this.f8728AlLFFp;
        view.clearAnimation();
        amA8tU.f8753A2egSU.endViewTransition(view);
        azoqyo.A2egSU();
        if (CtxOCS.C4FrIb(2)) {
            dyaChj.toString();
        }
    }
}
