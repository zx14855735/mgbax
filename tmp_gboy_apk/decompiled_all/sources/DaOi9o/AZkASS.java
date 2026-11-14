package DaOi9o;

import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ View f2222A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2223A4TApA;

    public AZkASS(View view, ArrayList arrayList) {
        this.f2222A2egSU = view;
        this.f2223A4TApA = arrayList;
    }

    @Override // DaOi9o.B7CMnp
    public final void A2egSU(B4ZgIw b4ZgIw) {
        ARc23Z(b4ZgIw);
    }

    @Override // DaOi9o.B7CMnp
    public final void A4TApA() {
    }

    @Override // DaOi9o.B7CMnp
    public final void A5SV6n(B4ZgIw b4ZgIw) {
    }

    @Override // DaOi9o.B7CMnp
    public final void ADYaiT(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
        b4ZgIw.A2egSU(this);
    }

    @Override // DaOi9o.B7CMnp
    public final void AMqCpz() {
    }

    @Override // DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
        this.f2222A2egSU.setVisibility(8);
        ArrayList arrayList = this.f2223A4TApA;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((View) arrayList.get(i)).setVisibility(0);
        }
    }

    @Override // DaOi9o.B7CMnp
    public final void ASJ6gh(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
        b4ZgIw.A2egSU(this);
    }
}
