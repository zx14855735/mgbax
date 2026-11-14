package Hjvs0g;

import ADYaiT.DUi7mC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 implements com.bumptech.glide.load.data.AMqCpz, com.bumptech.glide.load.data.ADYaiT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f3748AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DUi7mC f3749AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3750AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public com.bumptech.glide.AZOQYO f3751AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public com.bumptech.glide.load.data.ADYaiT f3752B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public List f3753B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f3754B3GDIM;

    public BPw6Q8(ArrayList arrayList, DUi7mC dUi7mC) {
        this.f3749AlLFFp = dUi7mC;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f3748AcNBzu = arrayList;
        this.f3750AmA8tU = 0;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        return ((com.bumptech.glide.load.data.AMqCpz) this.f3748AcNBzu.get(0)).A2egSU();
    }

    public final void A4TApA() {
        if (this.f3754B3GDIM) {
            return;
        }
        if (this.f3750AmA8tU < this.f3748AcNBzu.size() - 1) {
            this.f3750AmA8tU++;
            ARc23Z(this.f3751AzWtSf, this.f3752B25kr6);
        } else {
            ItGa5w.ARc23Z.A4TApA(this.f3753B2KMhB);
            this.f3752B25kr6.A5SV6n(new HXc4pW.BI9f7h("Fetch failed", new ArrayList(this.f3753B2KMhB)));
        }
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void A5SV6n(Exception exc) {
        List list = this.f3753B2KMhB;
        ItGa5w.ARc23Z.A5SV6n(list, "Argument must not be null");
        list.add(exc);
        A4TApA();
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        List list = this.f3753B2KMhB;
        if (list != null) {
            this.f3749AlLFFp.B7CMnp(list);
        }
        this.f3753B2KMhB = null;
        Iterator it = this.f3748AcNBzu.iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.load.data.AMqCpz) it.next()).AMqCpz();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, com.bumptech.glide.load.data.ADYaiT aDYaiT) {
        this.f3751AzWtSf = azoqyo;
        this.f3752B25kr6 = aDYaiT;
        this.f3753B2KMhB = (List) this.f3749AlLFFp.AYUAbz();
        ((com.bumptech.glide.load.data.AMqCpz) this.f3748AcNBzu.get(this.f3750AmA8tU)).ARc23Z(azoqyo, this);
        if (this.f3754B3GDIM) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void ASJ6gh(Object obj) {
        if (obj != null) {
            this.f3752B25kr6.ASJ6gh(obj);
        } else {
            A4TApA();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        this.f3754B3GDIM = true;
        Iterator it = this.f3748AcNBzu.iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.load.data.AMqCpz) it.next()).cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        return ((com.bumptech.glide.load.data.AMqCpz) this.f3748AcNBzu.get(0)).getDataSource();
    }
}
