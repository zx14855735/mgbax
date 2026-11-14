package ADYaiT;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements DV2E8K.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f84A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f85A4TApA;

    public AzWtSf(DV2E8K.ADYaiT aDYaiT) {
        RXb0Sz.ARc23Z.AMqCpz(aDYaiT, "registry");
        this.f85A4TApA = new LinkedHashSet();
        aDYaiT.A5SV6n("androidx.savedstate.Restarter", this);
    }

    @Override // DV2E8K.A5SV6n
    public final Bundle saveState() {
        switch (this.f84A2egSU) {
            case 0:
                Bundle bundle = new Bundle();
                ((B2KMhB) this.f85A4TApA).getDelegate().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f85A4TApA));
                return bundle2;
        }
    }

    public AzWtSf(B2KMhB b2KMhB) {
        this.f85A4TApA = b2KMhB;
    }
}
