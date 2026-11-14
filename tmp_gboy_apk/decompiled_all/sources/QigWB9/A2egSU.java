package QigWB9;

import NSK3xo.AcNBzu;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU extends AMqCpz implements Runnable {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final NCeV4Q.A5SV6n f7705B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final CountDownLatch f7706B9tovu = new CountDownLatch(1);

    public A2egSU(NCeV4Q.A5SV6n a5SV6n) {
        this.f7705B7CMnp = a5SV6n;
    }

    @Override // QigWB9.AMqCpz
    public final void A2egSU() {
        NCeV4Q.A5SV6n a5SV6n = this.f7705B7CMnp;
        Iterator it = a5SV6n.f5642AZkASS.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((AcNBzu) it.next()).ADYaiT(a5SV6n)) {
                i++;
            }
        }
        try {
            a5SV6n.f5641AZOQYO.tryAcquire(i, 5L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // QigWB9.AMqCpz
    public final void A4TApA(Object obj) {
        CountDownLatch countDownLatch = this.f7706B9tovu;
        try {
            this.f7705B7CMnp.A4TApA(this, obj);
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // QigWB9.AMqCpz
    public final void A5SV6n(Object obj) {
        CountDownLatch countDownLatch = this.f7706B9tovu;
        try {
            this.f7705B7CMnp.A2egSU(this);
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7705B7CMnp.A5SV6n();
    }
}
