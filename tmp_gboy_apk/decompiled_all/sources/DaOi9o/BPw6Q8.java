package DaOi9o;

import ADYaiT.CtFAbx;
import DaOi9o.B4ZgIw;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BPw6Q8 extends B4ZgIw {

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f2277CikNvS;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public ArrayList f2275CcAIMM = new ArrayList();

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public boolean f2276Cd8JRx = true;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public boolean f2278CkXcdM = false;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public int f2279CmUvjW = 0;

    @Override // DaOi9o.B4ZgIw
    public final void A4TApA(View view) {
        for (int i = 0; i < this.f2275CcAIMM.size(); i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).A4TApA(view);
        }
        this.f2243B2KMhB.add(view);
    }

    @Override // DaOi9o.B4ZgIw
    public final void ADYaiT(BmvVmW bmvVmW) {
        if (BChYOn(bmvVmW.f2282A4TApA)) {
            Iterator it = this.f2275CcAIMM.iterator();
            while (it.hasNext()) {
                B4ZgIw b4ZgIw = (B4ZgIw) it.next();
                if (b4ZgIw.BChYOn(bmvVmW.f2282A4TApA)) {
                    b4ZgIw.ADYaiT(bmvVmW);
                    bmvVmW.f2283A5SV6n.add(b4ZgIw);
                }
            }
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void ARc23Z(BmvVmW bmvVmW) {
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).ARc23Z(bmvVmW);
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void ASJ6gh(BmvVmW bmvVmW) {
        if (BChYOn(bmvVmW.f2282A4TApA)) {
            Iterator it = this.f2275CcAIMM.iterator();
            while (it.hasNext()) {
                B4ZgIw b4ZgIw = (B4ZgIw) it.next();
                if (b4ZgIw.BChYOn(bmvVmW.f2282A4TApA)) {
                    b4ZgIw.ASJ6gh(bmvVmW);
                    bmvVmW.f2283A5SV6n.add(b4ZgIw);
                }
            }
        }
    }

    @Override // DaOi9o.B4ZgIw
    /* renamed from: AZkASS, reason: merged with bridge method [inline-methods] */
    public final B4ZgIw clone() {
        BPw6Q8 bPw6Q8 = (BPw6Q8) super.clone();
        bPw6Q8.f2275CcAIMM = new ArrayList();
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            B4ZgIw clone = ((B4ZgIw) this.f2275CcAIMM.get(i)).clone();
            bPw6Q8.f2275CcAIMM.add(clone);
            clone.f2248BChYOn = bPw6Q8;
        }
        return bPw6Q8;
    }

    @Override // DaOi9o.B4ZgIw
    public final void AcNBzu(ViewGroup viewGroup, AZOQYO.ARc23Z aRc23Z, AZOQYO.ARc23Z aRc23Z2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.f2239AlLFFp;
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            B4ZgIw b4ZgIw = (B4ZgIw) this.f2275CcAIMM.get(i);
            if (j > 0 && (this.f2276Cd8JRx || i == 0)) {
                long j2 = b4ZgIw.f2239AlLFFp;
                if (j2 > 0) {
                    b4ZgIw.C4FrIb(j2 + j);
                } else {
                    b4ZgIw.C4FrIb(j);
                }
            }
            b4ZgIw.AcNBzu(viewGroup, aRc23Z, aRc23Z2, arrayList, arrayList2);
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final B4ZgIw AmA8tU(View view) {
        throw null;
    }

    @Override // DaOi9o.B4ZgIw
    public final void AzWtSf() {
        for (int i = 0; i < this.f2275CcAIMM.size(); i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).AzWtSf();
        }
        super.AzWtSf();
    }

    @Override // DaOi9o.B4ZgIw
    public final void BIYEnU(ViewGroup viewGroup) {
        super.BIYEnU(viewGroup);
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).BIYEnU(viewGroup);
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final B4ZgIw BJ7GGh(B7CMnp b7CMnp) {
        super.BJ7GGh(b7CMnp);
        return this;
    }

    @Override // DaOi9o.B4ZgIw
    public final void BNL6CD(View view) {
        for (int i = 0; i < this.f2275CcAIMM.size(); i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).BNL6CD(view);
        }
        this.f2243B2KMhB.remove(view);
    }

    @Override // DaOi9o.B4ZgIw
    public final void BPw6Q8(View view) {
        super.BPw6Q8(view);
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).BPw6Q8(view);
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void BTvldC() {
        if (this.f2275CcAIMM.isEmpty()) {
            CASmeH();
            AlLFFp();
            return;
        }
        BNL6CD bnl6cd = new BNL6CD();
        bnl6cd.f2274A4TApA = this;
        Iterator it = this.f2275CcAIMM.iterator();
        while (it.hasNext()) {
            ((B4ZgIw) it.next()).A2egSU(bnl6cd);
        }
        this.f2277CikNvS = this.f2275CcAIMM.size();
        if (this.f2276Cd8JRx) {
            Iterator it2 = this.f2275CcAIMM.iterator();
            while (it2.hasNext()) {
                ((B4ZgIw) it2.next()).BTvldC();
            }
            return;
        }
        for (int i = 1; i < this.f2275CcAIMM.size(); i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i - 1)).A2egSU(new BNL6CD((B4ZgIw) this.f2275CcAIMM.get(i)));
        }
        B4ZgIw b4ZgIw = (B4ZgIw) this.f2275CcAIMM.get(0);
        if (b4ZgIw != null) {
            b4ZgIw.BTvldC();
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void BmvVmW(B4ZgIw.A2egSU a2egSU) {
        this.f2260CASmeH = a2egSU;
        this.f2279CmUvjW |= 8;
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).BmvVmW(a2egSU);
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void BpkvW3(B2KMhB b2KMhB) {
        super.BpkvW3(b2KMhB);
        this.f2279CmUvjW |= 4;
        if (this.f2275CcAIMM != null) {
            for (int i = 0; i < this.f2275CcAIMM.size(); i++) {
                ((B4ZgIw) this.f2275CcAIMM.get(i)).BpkvW3(b2KMhB);
            }
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void C2rE4F() {
        this.f2279CmUvjW |= 2;
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).C2rE4F();
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void C4FrIb(long j) {
        this.f2239AlLFFp = j;
    }

    @Override // DaOi9o.B4ZgIw
    public final String CNPG0E(String str) {
        String CNPG0E2 = super.CNPG0E(str);
        for (int i = 0; i < this.f2275CcAIMM.size(); i++) {
            StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(CNPG0E2, "\n");
            A5SV6n2.append(((B4ZgIw) this.f2275CcAIMM.get(i)).CNPG0E(str + "  "));
            CNPG0E2 = A5SV6n2.toString();
        }
        return CNPG0E2;
    }

    public final void COJEAR(B4ZgIw b4ZgIw) {
        this.f2275CcAIMM.add(b4ZgIw);
        b4ZgIw.f2248BChYOn = this;
        long j = this.f2240AmA8tU;
        if (j >= 0) {
            b4ZgIw.BV3sI0(j);
        }
        if ((this.f2279CmUvjW & 1) != 0) {
            b4ZgIw.BniPrB(this.f2241AzWtSf);
        }
        if ((this.f2279CmUvjW & 2) != 0) {
            b4ZgIw.C2rE4F();
        }
        if ((this.f2279CmUvjW & 4) != 0) {
            b4ZgIw.BpkvW3(this.f2261CNPG0E);
        }
        if ((this.f2279CmUvjW & 8) != 0) {
            b4ZgIw.BmvVmW(this.f2260CASmeH);
        }
    }

    @Override // DaOi9o.B4ZgIw
    /* renamed from: CQhlFr, reason: merged with bridge method [inline-methods] */
    public final void BV3sI0(long j) {
        ArrayList arrayList;
        this.f2240AmA8tU = j;
        if (j < 0 || (arrayList = this.f2275CcAIMM) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).BV3sI0(j);
        }
    }

    @Override // DaOi9o.B4ZgIw
    /* renamed from: CSDoyG, reason: merged with bridge method [inline-methods] */
    public final void BniPrB(TimeInterpolator timeInterpolator) {
        this.f2279CmUvjW |= 1;
        ArrayList arrayList = this.f2275CcAIMM;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((B4ZgIw) this.f2275CcAIMM.get(i)).BniPrB(timeInterpolator);
            }
        }
        this.f2241AzWtSf = timeInterpolator;
    }

    public final void CTkVKb(int i) {
        if (i == 0) {
            this.f2276Cd8JRx = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException(CtFAbx.ARc23Z(i, "Invalid parameter for TransitionSet ordering: "));
            }
            this.f2276Cd8JRx = false;
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void cancel() {
        super.cancel();
        int size = this.f2275CcAIMM.size();
        for (int i = 0; i < size; i++) {
            ((B4ZgIw) this.f2275CcAIMM.get(i)).cancel();
        }
    }
}
