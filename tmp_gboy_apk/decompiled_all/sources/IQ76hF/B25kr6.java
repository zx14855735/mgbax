package IQ76hF;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements AYUAbz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Set f3963AcNBzu = Collections.newSetFromMap(new WeakHashMap());

    @Override // IQ76hF.AYUAbz
    public final void onDestroy() {
        Iterator it = ItGa5w.AlLFFp.ADYaiT(this.f3963AcNBzu).iterator();
        while (it.hasNext()) {
            ((IlwJBd.AYUAbz) it.next()).onDestroy();
        }
    }

    @Override // IQ76hF.AYUAbz
    public final void onStart() {
        Iterator it = ItGa5w.AlLFFp.ADYaiT(this.f3963AcNBzu).iterator();
        while (it.hasNext()) {
            ((IlwJBd.AYUAbz) it.next()).onStart();
        }
    }

    @Override // IQ76hF.AYUAbz
    public final void onStop() {
        Iterator it = ItGa5w.AlLFFp.ADYaiT(this.f3963AcNBzu).iterator();
        while (it.hasNext()) {
            ((IlwJBd.AYUAbz) it.next()).onStop();
        }
    }
}
