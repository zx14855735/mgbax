package HXc4pW;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 implements ASJ6gh, com.bumptech.glide.load.data.ADYaiT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AZkASS f3628AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AYUAbz f3629AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3630AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3631AzWtSf = -1;

    /* renamed from: B25kr6, reason: collision with root package name */
    public HSHyT0.AZkASS f3632B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public List f3633B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f3634B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public volatile Hjvs0g.BChYOn f3635B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public File f3636B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public BmvVmW f3637B9tovu;

    public BV3sI0(AYUAbz aYUAbz, AZkASS aZkASS) {
        this.f3629AlLFFp = aYUAbz;
        this.f3628AcNBzu = aZkASS;
    }

    @Override // HXc4pW.ASJ6gh
    public final boolean A2egSU() {
        List list;
        ArrayList A2egSU2 = this.f3629AlLFFp.A2egSU();
        boolean z = false;
        if (!A2egSU2.isEmpty()) {
            AYUAbz aYUAbz = this.f3629AlLFFp;
            com.bumptech.glide.AaHO0E aaHO0E = aYUAbz.f3504A5SV6n.f9920A4TApA;
            Class<?> cls = aYUAbz.f3505ADYaiT.getClass();
            Class cls2 = aYUAbz.f3507ASJ6gh;
            Class cls3 = aYUAbz.f3511AaHO0E;
            Ifhupb.AMqCpz aMqCpz = aaHO0E.f9940AYUAbz;
            ItGa5w.AaHO0E aaHO0E2 = (ItGa5w.AaHO0E) aMqCpz.f3971A2egSU.getAndSet(null);
            if (aaHO0E2 == null) {
                aaHO0E2 = new ItGa5w.AaHO0E(cls, cls2, cls3);
            } else {
                aaHO0E2.f4088A2egSU = cls;
                aaHO0E2.f4089A4TApA = cls2;
                aaHO0E2.f4090A5SV6n = cls3;
            }
            synchronized (aMqCpz.f3972A4TApA) {
                list = (List) aMqCpz.f3972A4TApA.get(aaHO0E2);
            }
            aMqCpz.f3971A2egSU.set(aaHO0E2);
            List list2 = list;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = aaHO0E.f9934A2egSU.A2egSU(cls).iterator();
                while (it.hasNext()) {
                    Iterator it2 = aaHO0E.f9936A5SV6n.A4TApA((Class) it.next(), cls2).iterator();
                    while (it2.hasNext()) {
                        Class cls4 = (Class) it2.next();
                        if (!aaHO0E.f9938ARc23Z.A4TApA(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                            arrayList.add(cls4);
                        }
                    }
                }
                aaHO0E.f9940AYUAbz.A2egSU(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
                list2 = arrayList;
            }
            if (!list2.isEmpty()) {
                while (true) {
                    List list3 = this.f3633B2KMhB;
                    if (list3 != null && this.f3634B3GDIM < list3.size()) {
                        this.f3635B4ZgIw = null;
                        while (!z && this.f3634B3GDIM < this.f3633B2KMhB.size()) {
                            List list4 = this.f3633B2KMhB;
                            int i = this.f3634B3GDIM;
                            this.f3634B3GDIM = i + 1;
                            Hjvs0g.BI9f7h bI9f7h = (Hjvs0g.BI9f7h) list4.get(i);
                            File file = this.f3636B7CMnp;
                            AYUAbz aYUAbz2 = this.f3629AlLFFp;
                            this.f3635B4ZgIw = bI9f7h.A2egSU(file, aYUAbz2.AMqCpz, aYUAbz2.f3506ARc23Z, aYUAbz2.f3509AZOQYO);
                            if (this.f3635B4ZgIw != null && this.f3629AlLFFp.A5SV6n(this.f3635B4ZgIw.f3744A5SV6n.A2egSU()) != null) {
                                this.f3635B4ZgIw.f3744A5SV6n.ARc23Z(this.f3629AlLFFp.f3515AzWtSf, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                    int i2 = this.f3631AzWtSf + 1;
                    this.f3631AzWtSf = i2;
                    if (i2 >= list2.size()) {
                        int i3 = this.f3630AmA8tU + 1;
                        this.f3630AmA8tU = i3;
                        if (i3 >= A2egSU2.size()) {
                            break;
                        }
                        this.f3631AzWtSf = 0;
                    }
                    HSHyT0.AZkASS aZkASS = (HSHyT0.AZkASS) A2egSU2.get(this.f3630AmA8tU);
                    Class cls5 = (Class) list2.get(this.f3631AzWtSf);
                    HSHyT0.B3GDIM AMqCpz = this.f3629AlLFFp.AMqCpz(cls5);
                    AYUAbz aYUAbz3 = this.f3629AlLFFp;
                    this.f3637B9tovu = new BmvVmW(aYUAbz3.f3504A5SV6n.f9919A2egSU, aZkASS, aYUAbz3.f3514AmA8tU, aYUAbz3.AMqCpz, aYUAbz3.f3506ARc23Z, AMqCpz, cls5, aYUAbz3.f3509AZOQYO);
                    File A4TApA2 = aYUAbz3.f3508AYUAbz.A2egSU().A4TApA(this.f3637B9tovu);
                    this.f3636B7CMnp = A4TApA2;
                    if (A4TApA2 != null) {
                        this.f3632B25kr6 = aZkASS;
                        this.f3633B2KMhB = this.f3629AlLFFp.f3504A5SV6n.f9920A4TApA.ASJ6gh(A4TApA2);
                        this.f3634B3GDIM = 0;
                    }
                }
            } else if (!File.class.equals(this.f3629AlLFFp.f3511AaHO0E)) {
                throw new IllegalStateException("Failed to find any load path from " + this.f3629AlLFFp.f3505ADYaiT.getClass() + " to " + this.f3629AlLFFp.f3511AaHO0E);
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void A5SV6n(Exception exc) {
        this.f3628AcNBzu.A4TApA(this.f3637B9tovu, exc, this.f3635B4ZgIw.f3744A5SV6n, 4);
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public final void ASJ6gh(Object obj) {
        this.f3628AcNBzu.A5SV6n(this.f3632B25kr6, obj, this.f3635B4ZgIw.f3744A5SV6n, 4, this.f3637B9tovu);
    }

    @Override // HXc4pW.ASJ6gh
    public final void cancel() {
        Hjvs0g.BChYOn bChYOn = this.f3635B4ZgIw;
        if (bChYOn != null) {
            bChYOn.f3744A5SV6n.cancel();
        }
    }
}
