package HZUvgL;

import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import Hjvs0g.BmvVmW;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n implements BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f3654AcNBzu;

    public A5SV6n(String str, Object obj) {
        this.f3654AcNBzu = obj;
    }

    public abstract Object A2egSU();

    public void A4TApA(AlLFFp alLFFp) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f3654AcNBzu;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(alLFFp);
        }
    }

    @Override // Hjvs0g.BIYEnU
    public BI9f7h AYUAbz(BmvVmW bmvVmW) {
        return new Hjvs0g.AMqCpz(2, (Hdahpu.AZOQYO) this.f3654AcNBzu);
    }

    public A5SV6n() {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        this.f3654AcNBzu = new ArrayDeque(20);
    }

    public A5SV6n(Hdahpu.AZOQYO azoqyo) {
        this.f3654AcNBzu = azoqyo;
    }
}
