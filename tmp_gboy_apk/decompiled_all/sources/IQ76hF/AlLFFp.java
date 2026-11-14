package IQ76hF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Set f3952A2egSU = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f3953A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f3954A5SV6n;

    public final boolean A2egSU(IhMMDv.A5SV6n a5SV6n) {
        boolean z = true;
        if (a5SV6n == null) {
            return true;
        }
        boolean remove = this.f3952A2egSU.remove(a5SV6n);
        if (!this.f3953A4TApA.remove(a5SV6n) && !remove) {
            z = false;
        }
        if (z) {
            a5SV6n.clear();
        }
        return z;
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f3952A2egSU.size() + ", isPaused=" + this.f3954A5SV6n + "}";
    }
}
