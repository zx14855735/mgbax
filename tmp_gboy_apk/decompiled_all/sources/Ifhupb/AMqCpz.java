package Ifhupb;

import ItGa5w.AaHO0E;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AtomicReference f3971A2egSU = new AtomicReference();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B25kr6.ADYaiT f3972A4TApA = new B25kr6.ADYaiT();

    public final void A2egSU(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f3972A4TApA) {
            this.f3972A4TApA.put(new AaHO0E(cls, cls2, cls3), list);
        }
    }
}
