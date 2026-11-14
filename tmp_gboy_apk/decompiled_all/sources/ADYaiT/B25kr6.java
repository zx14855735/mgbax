package ADYaiT;

import android.view.LayoutInflater;
import androidx.activity.ComponentActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements A2egSU.A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f86A2egSU;

    public B25kr6(B2KMhB b2KMhB) {
        this.f86A2egSU = b2KMhB;
    }

    @Override // A2egSU.A4TApA
    public final void A2egSU(ComponentActivity componentActivity) {
        B2KMhB b2KMhB = this.f86A2egSU;
        BJ7GGh delegate = b2KMhB.getDelegate();
        CkXcdM ckXcdM = (CkXcdM) delegate;
        LayoutInflater from = LayoutInflater.from(ckXcdM.f157BChYOn);
        if (from.getFactory() == null) {
            from.setFactory2(ckXcdM);
        } else {
            boolean z = from.getFactory2() instanceof CkXcdM;
        }
        b2KMhB.getSavedStateRegistry().A2egSU("androidx:appcompat");
        delegate.A5SV6n();
    }
}
