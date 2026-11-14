package LLiCI0;

import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends androidx.recyclerview.widget.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f4707A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f4708A4TApA;

    public B25kr6(ArrayList arrayList, ArrayList arrayList2) {
        this.f4707A2egSU = arrayList;
        this.f4708A4TApA = arrayList2;
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final boolean A2egSU(int i, int i2) {
        L5dZB6.A4TApA a4TApA = (L5dZB6.A4TApA) this.f4707A2egSU.get(i);
        L5dZB6.A4TApA a4TApA2 = (L5dZB6.A4TApA) this.f4708A4TApA.get(i2);
        return a4TApA.f4399B4ZgIw == a4TApA2.f4399B4ZgIw && a4TApA.f4400B7CMnp == a4TApA2.f4400B7CMnp && a4TApA.f4395AzWtSf.equals(a4TApA2.f4395AzWtSf);
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final boolean A4TApA(int i, int i2) {
        return ((L5dZB6.A4TApA) this.f4707A2egSU.get(i)).f4392AcNBzu.equals(((L5dZB6.A4TApA) this.f4708A4TApA.get(i2)).f4392AcNBzu);
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final Object A5SV6n(int i, int i2) {
        L5dZB6.A4TApA a4TApA = (L5dZB6.A4TApA) this.f4707A2egSU.get(i);
        L5dZB6.A4TApA a4TApA2 = (L5dZB6.A4TApA) this.f4708A4TApA.get(i2);
        ArrayList arrayList = new ArrayList();
        if (a4TApA.f4399B4ZgIw != a4TApA2.f4399B4ZgIw) {
            arrayList.add(PointCategory.PROGRESS);
        }
        if (a4TApA.f4400B7CMnp != a4TApA2.f4400B7CMnp) {
            arrayList.add("status");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final int ADYaiT() {
        return this.f4708A4TApA.size();
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final int AMqCpz() {
        return this.f4707A2egSU.size();
    }
}
