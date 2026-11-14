package HXc4pW;

import java.io.File;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements ASJ6gh, com.bumptech.glide.load.data.ADYaiT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final List f3491AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AYUAbz f3492AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ARc23Z f3493AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3494AzWtSf = -1;

    /* renamed from: B25kr6, reason: collision with root package name */
    public HSHyT0.AZkASS f3495B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public List f3496B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f3497B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public volatile Hjvs0g.BChYOn f3498B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public File f3499B7CMnp;

    public ADYaiT(List list, AYUAbz aYUAbz, ARc23Z aRc23Z) {
        this.f3491AcNBzu = list;
        this.f3492AlLFFp = aYUAbz;
        this.f3493AmA8tU = aRc23Z;
    }

    @Override // HXc4pW.ASJ6gh
    public final boolean A2egSU() {
        while (true) {
            List list = this.f3496B2KMhB;
            boolean z = false;
            if (list != null && this.f3497B3GDIM < list.size()) {
                this.f3498B4ZgIw = null;
                while (!z && this.f3497B3GDIM < this.f3496B2KMhB.size()) {
                    List list2 = this.f3496B2KMhB;
                    int i = this.f3497B3GDIM;
                    this.f3497B3GDIM = i + 1;
                    Hjvs0g.BI9f7h bI9f7h = (Hjvs0g.BI9f7h) list2.get(i);
                    File file = this.f3499B7CMnp;
                    AYUAbz aYUAbz = this.f3492AlLFFp;
                    this.f3498B4ZgIw = bI9f7h.A2egSU(file, aYUAbz.AMqCpz, aYUAbz.f3506ARc23Z, aYUAbz.f3509AZOQYO);
                    if (this.f3498B4ZgIw != null && this.f3492AlLFFp.A5SV6n(this.f3498B4ZgIw.f3744A5SV6n.A2egSU()) != null) {
                        this.f3498B4ZgIw.f3744A5SV6n.ARc23Z(this.f3492AlLFFp.f3515AzWtSf, this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f3494AzWtSf + 1;
            this.f3494AzWtSf = i2;
            if (i2 >= this.f3491AcNBzu.size()) {
                return false;
            }
            HSHyT0.AZkASS aZkASS = (HSHyT0.AZkASS) this.f3491AcNBzu.get(this.f3494AzWtSf);
            AYUAbz aYUAbz2 = this.f3492AlLFFp;
            File A4TApA2 = aYUAbz2.f3508AYUAbz.A2egSU().A4TApA(new AMqCpz(aZkASS, aYUAbz2.f3514AmA8tU));
            this.f3499B7CMnp = A4TApA2;
            if (A4TApA2 != null) {
                this.f3495B25kr6 = aZkASS;
                this.f3496B2KMhB = this.f3492AlLFFp.f3504A5SV6n.f9920A4TApA.ASJ6gh(A4TApA2);
                this.f3497B3GDIM = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void A5SV6n(Exception exc) {
        this.f3493AmA8tU.A4TApA(this.f3495B25kr6, exc, this.f3498B4ZgIw.f3744A5SV6n, 3);
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void ASJ6gh(Object obj) {
        this.f3493AmA8tU.A5SV6n(this.f3495B25kr6, obj, this.f3498B4ZgIw.f3744A5SV6n, 3, this.f3495B25kr6);
    }

    @Override // HXc4pW.ASJ6gh
    public final void cancel() {
        Hjvs0g.BChYOn bChYOn = this.f3498B4ZgIw;
        if (bChYOn != null) {
            bChYOn.f3744A5SV6n.cancel();
        }
    }
}
