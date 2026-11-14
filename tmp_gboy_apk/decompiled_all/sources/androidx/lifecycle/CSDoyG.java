package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CSDoyG implements DV2E8K.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DV2E8K.ADYaiT f9018A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f9019A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Bundle f9020A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final R8Rbcg.ADYaiT f9021ADYaiT;

    public CSDoyG(DV2E8K.ADYaiT aDYaiT, D07BeM d07BeM) {
        RXb0Sz.ARc23Z.AMqCpz(aDYaiT, "savedStateRegistry");
        this.f9018A2egSU = aDYaiT;
        this.f9021ADYaiT = new R8Rbcg.ADYaiT(new androidx.activity.AzWtSf(3, d07BeM));
    }

    public final void A2egSU() {
        if (this.f9019A4TApA) {
            return;
        }
        Bundle A2egSU2 = this.f9018A2egSU.A2egSU("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9020A5SV6n;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (A2egSU2 != null) {
            bundle.putAll(A2egSU2);
        }
        this.f9020A5SV6n = bundle;
        this.f9019A4TApA = true;
    }

    @Override // DV2E8K.A5SV6n
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9020A5SV6n;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((CTkVKb) this.f9021ADYaiT.A2egSU()).f9022ADYaiT.entrySet()) {
            String str = (String) entry.getKey();
            Bundle saveState = ((COJEAR) entry.getValue()).AMqCpz.saveState();
            if (!RXb0Sz.ARc23Z.A2egSU(saveState, Bundle.EMPTY)) {
                bundle.putBundle(str, saveState);
            }
        }
        this.f9019A4TApA = false;
        return bundle;
    }
}
