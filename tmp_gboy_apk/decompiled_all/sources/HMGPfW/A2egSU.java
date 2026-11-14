package HMGPfW;

import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f3382A2egSU;

    public A2egSU(AMqCpz aMqCpz) {
        this.f3382A2egSU = aMqCpz;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        synchronized (this.f3382A2egSU) {
            try {
                AMqCpz aMqCpz = this.f3382A2egSU;
                if (aMqCpz.f3401B7CMnp == null) {
                    return null;
                }
                aMqCpz.AzWtSf();
                if (this.f3382A2egSU.ASJ6gh()) {
                    this.f3382A2egSU.AcNBzu();
                    this.f3382A2egSU.f3403BChYOn = 0;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
