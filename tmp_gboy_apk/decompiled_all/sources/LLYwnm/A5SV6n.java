package LLYwnm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4611AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Map f4612AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ boolean f4613AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f4614AzWtSf;

    public A5SV6n(AYUAbz aYUAbz, boolean z, Map map) {
        this.f4614AzWtSf = aYUAbz;
        this.f4613AmA8tU = z;
        this.f4612AlLFFp = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4611AcNBzu) {
            case 0:
                Iterator it = this.f4614AzWtSf.AMqCpz.iterator();
                while (it.hasNext()) {
                    AlLFFp alLFFp = (AlLFFp) it.next();
                    Map map = this.f4612AlLFFp;
                    if (this.f4613AmA8tU) {
                        alLFFp.A2egSU(map);
                    } else {
                        AYUAbz.A4TApA(map.get("error"));
                        alLFFp.getClass();
                    }
                }
                break;
            default:
                String A4TApA2 = AYUAbz.A4TApA(this.f4612AlLFFp.get("message"));
                Iterator it2 = this.f4614AzWtSf.f4630ARc23Z.iterator();
                while (it2.hasNext()) {
                    ((AzWtSf) it2.next()).A5SV6n(A4TApA2, this.f4613AmA8tU);
                }
                break;
        }
    }

    public A5SV6n(AYUAbz aYUAbz, Map map, boolean z) {
        this.f4614AzWtSf = aYUAbz;
        this.f4612AlLFFp = map;
        this.f4613AmA8tU = z;
    }
}
