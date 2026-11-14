package H0R8Px;

import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f3131A2egSU;

    public A2egSU(AMqCpz aMqCpz) {
        this.f3131A2egSU = aMqCpz;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        synchronized (this.f3131A2egSU) {
            try {
                AMqCpz aMqCpz = this.f3131A2egSU;
                if (aMqCpz.f3145B4ZgIw == null) {
                    return null;
                }
                aMqCpz.B25kr6();
                if (this.f3131A2egSU.AZkASS()) {
                    this.f3131A2egSU.AzWtSf();
                    this.f3131A2egSU.f3147B9tovu = 0;
                }
                return null;
            } finally {
            }
        }
    }
}
