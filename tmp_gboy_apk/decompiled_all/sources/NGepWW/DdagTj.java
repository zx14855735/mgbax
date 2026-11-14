package NGepWW;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DdagTj implements NUY5pn.AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f5741A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final NSK3xo.AYUAbz f5742A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f5743A5SV6n;

    public DdagTj(DuwtYk duwtYk, NSK3xo.AYUAbz aYUAbz, int i) {
        this.f5741A2egSU = new WeakReference(duwtYk);
        this.f5742A4TApA = aYUAbz;
        this.f5743A5SV6n = i;
    }

    @Override // NUY5pn.AmA8tU
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        DuwtYk duwtYk = (DuwtYk) this.f5741A2egSU.get();
        if (duwtYk == null) {
            return;
        }
        NUY5pn.AYUAbz.AMqCpz(Looper.myLooper() == duwtYk.f5753AcNBzu.f5809ASJ6gh.f5795BNL6CD, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        ReentrantLock reentrantLock = duwtYk.f5754AlLFFp;
        reentrantLock.lock();
        try {
            if (!duwtYk.ARc23Z(0)) {
                reentrantLock.unlock();
                return;
            }
            if (!a2egSU.A5SV6n()) {
                duwtYk.AMqCpz(a2egSU, this.f5742A4TApA, this.f5743A5SV6n);
            }
            if (duwtYk.AYUAbz()) {
                duwtYk.AZOQYO();
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
