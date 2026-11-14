package ADYaiT;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h implements Executor {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f92AcNBzu = new Object();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayDeque f93AlLFFp = new ArrayDeque();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BIYEnU f94AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Runnable f95AzWtSf;

    public BI9f7h(BIYEnU bIYEnU) {
        this.f94AmA8tU = bIYEnU;
    }

    public final void A4TApA() {
        synchronized (this.f92AcNBzu) {
            try {
                Runnable runnable = (Runnable) this.f93AlLFFp.poll();
                this.f95AzWtSf = runnable;
                if (runnable != null) {
                    this.f94AmA8tU.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f92AcNBzu) {
            try {
                this.f93AlLFFp.add(new BChYOn(this, 0, runnable));
                if (this.f95AzWtSf == null) {
                    A4TApA();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
