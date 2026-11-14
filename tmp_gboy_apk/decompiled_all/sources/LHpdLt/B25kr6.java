package LHpdLt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends androidx.recyclerview.widget.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f4518A2egSU;

    public B25kr6(B2KMhB b2KMhB) {
        this.f4518A2egSU = b2KMhB;
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final boolean A2egSU(int i, int i2) {
        B2KMhB b2KMhB = this.f4518A2egSU;
        BJ7GGh bJ7GGh = (BJ7GGh) b2KMhB.f4520AlLFFp.f4592C4FrIb.get(i);
        BJ7GGh bJ7GGh2 = (BJ7GGh) b2KMhB.f4519AcNBzu.get(i2);
        return BTvldC.ASJ6gh(bJ7GGh.f4548A2egSU, bJ7GGh2.f4548A2egSU) && BTvldC.ASJ6gh(bJ7GGh.f4549A4TApA, bJ7GGh2.f4549A4TApA) && BTvldC.ASJ6gh(bJ7GGh.f4550A5SV6n, bJ7GGh2.f4550A5SV6n);
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final boolean A4TApA(int i, int i2) {
        String str;
        B2KMhB b2KMhB = this.f4518A2egSU;
        BJ7GGh bJ7GGh = (BJ7GGh) b2KMhB.f4520AlLFFp.f4592C4FrIb.get(i);
        BJ7GGh bJ7GGh2 = (BJ7GGh) b2KMhB.f4519AcNBzu.get(i2);
        String str2 = bJ7GGh.f4550A5SV6n;
        if (str2 != null && (str = bJ7GGh2.f4550A5SV6n) != null) {
            return str2.equals(str);
        }
        String str3 = bJ7GGh.f4548A2egSU;
        return str3 != null && str3.equals(bJ7GGh2.f4548A2egSU);
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final int ADYaiT() {
        return this.f4518A2egSU.f4519AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.B25kr6
    public final int AMqCpz() {
        return this.f4518A2egSU.f4520AlLFFp.f4592C4FrIb.size();
    }
}
