package HXc4pW;

import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final IhMMDv.ASJ6gh f3571A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Executor f3572A4TApA;

    public B2KMhB(IhMMDv.ASJ6gh aSJ6gh, Executor executor) {
        this.f3571A2egSU = aSJ6gh;
        this.f3572A4TApA = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof B2KMhB) {
            return this.f3571A2egSU.equals(((B2KMhB) obj).f3571A2egSU);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3571A2egSU.hashCode();
    }
}
