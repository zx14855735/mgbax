package FpcJKS;

import B25kr6.AMqCpz;
import H0qugq.ADYaiT;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final FG7pZc.A2egSU f2875A2egSU = new FG7pZc.A2egSU();

    public final void A2egSU(GTPRn3.A2egSU a2egSU, ADYaiT aDYaiT) {
        FG7pZc.A2egSU a2egSU2 = this.f2875A2egSU;
        synchronized (a2egSU2) {
            try {
                Set set = (Set) a2egSU2.f2572A2egSU.get(a2egSU);
                if (set == null) {
                    set = new AMqCpz();
                    a2egSU2.f2572A2egSU.put(a2egSU, set);
                }
                set.add(aDYaiT);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
