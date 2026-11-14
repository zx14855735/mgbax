package COJEAR;

import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Runnable f1641A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final CopyOnWriteArrayList f1642A4TApA = new CopyOnWriteArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f1643A5SV6n = new HashMap();

    public B3GDIM(Runnable runnable) {
        this.f1641A2egSU = runnable;
    }

    public final boolean A2egSU(MenuItem menuItem) {
        Iterator it = this.f1642A4TApA.iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.CmUvjW) ((B7CMnp) it.next())).f8826A2egSU.AzWtSf(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void A4TApA(B7CMnp b7CMnp) {
        this.f1642A4TApA.remove(b7CMnp);
        B2KMhB b2KMhB = (B2KMhB) this.f1643A5SV6n.remove(b7CMnp);
        if (b2KMhB != null) {
            b2KMhB.f1639A2egSU.A5SV6n(b2KMhB.f1640A4TApA);
            b2KMhB.f1640A4TApA = null;
        }
        this.f1641A2egSU.run();
    }
}
