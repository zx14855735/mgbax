package L5dZB6;

import ADYaiT.D8MqeW;
import IQ76hF.AmA8tU;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends ThreadPoolExecutor {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AmA8tU f4404AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AtomicInteger f4405AlLFFp;

    public A5SV6n(LinkedBlockingQueue linkedBlockingQueue, AcNBzu.A4TApA a4TApA, AmA8tU amA8tU) {
        super(3, 3, 60L, TimeUnit.SECONDS, linkedBlockingQueue, a4TApA);
        this.f4405AlLFFp = new AtomicInteger(0);
        this.f4404AcNBzu = amA8tU;
    }

    public final void A4TApA() {
        if (this.f4404AcNBzu != null && this.f4405AlLFFp.get() == 0 && getQueue().isEmpty()) {
            new Handler(Looper.getMainLooper()).post(new D8MqeW(25, this));
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f4405AlLFFp.incrementAndGet();
        super.execute(new C4FrIb.A2egSU(this, runnable, 12, false));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
        A4TApA();
    }
}
