package MOpbMP;

import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu implements com.google.android.material.tabs.A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5040A2egSU;

    public B9tovu(BpkvW3 bpkvW3) {
        this.f5040A2egSU = bpkvW3;
    }

    @Override // com.google.android.material.tabs.A2egSU
    public final void A2egSU(TabLayout.A2egSU a2egSU) {
        int i;
        if (a2egSU != null && (i = a2egSU.f11893ADYaiT) >= 0) {
            BpkvW3 bpkvW3 = this.f5040A2egSU;
            if (i >= bpkvW3.f5076BJ7GGh.size()) {
                return;
            }
            BniPrB bniPrB = (BniPrB) bpkvW3.f5076BJ7GGh.get(i);
            int i2 = bniPrB.f5060A2egSU;
            if (i2 == 0) {
                bpkvW3.f5078BPw6Q8 = null;
                bpkvW3.f5079BTvldC = false;
            } else if (i2 == 1) {
                bpkvW3.f5078BPw6Q8 = null;
                bpkvW3.f5079BTvldC = true;
            } else {
                bpkvW3.f5078BPw6Q8 = bniPrB.f5061A4TApA;
                bpkvW3.f5079BTvldC = false;
            }
            bpkvW3.AlLFFp();
        }
    }
}
