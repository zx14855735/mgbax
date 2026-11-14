package LHpdLt;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4519AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4520AlLFFp;

    public B2KMhB(BTvldC bTvldC, ArrayList arrayList) {
        this.f4520AlLFFp = bTvldC;
        this.f4519AcNBzu = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4520AlLFFp.AMqCpz) {
            return;
        }
        BTvldC bTvldC = this.f4520AlLFFp;
        if (bTvldC.f4591C2rE4F == null) {
            return;
        }
        try {
            if (BTvldC.AMqCpz(bTvldC.f4592C4FrIb, this.f4519AcNBzu)) {
                return;
            }
            androidx.recyclerview.widget.B3GDIM A2egSU2 = androidx.recyclerview.widget.BChYOn.A2egSU(new B25kr6(this));
            this.f4520AlLFFp.f4592C4FrIb.clear();
            this.f4520AlLFFp.f4592C4FrIb.addAll(this.f4519AcNBzu);
            A2egSU2.A2egSU(this.f4520AlLFFp.f4591C2rE4F);
        } catch (Exception unused) {
        }
    }
}
