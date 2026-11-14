package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void A2egSU(Route route) {
        this.failedRoutes.remove(route);
    }

    public final synchronized void A4TApA(Route route) {
        this.failedRoutes.add(route);
    }

    public final synchronized boolean A5SV6n(Route route) {
        return this.failedRoutes.contains(route);
    }
}
