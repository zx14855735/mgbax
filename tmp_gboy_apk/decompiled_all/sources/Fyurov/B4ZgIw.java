package Fyurov;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f2971A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public B3GDIM f2972A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f2973A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f2974ADYaiT;
    public ScheduledExecutorService AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ScheduledFuture f2975ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f2976ASJ6gh;

    public static B4ZgIw A2egSU(long j, B3GDIM b3gdim) {
        if (j <= 0) {
            return null;
        }
        B4ZgIw b4ZgIw = new B4ZgIw();
        b4ZgIw.f2976ASJ6gh = false;
        b4ZgIw.f2971A2egSU = j;
        b4ZgIw.f2972A4TApA = b3gdim;
        b4ZgIw.AMqCpz = Executors.newSingleThreadScheduledExecutor();
        b4ZgIw.f2973A5SV6n = 0L;
        b4ZgIw.f2974ADYaiT = j;
        return b4ZgIw;
    }

    public final void A4TApA() {
        try {
            if (this.f2976ASJ6gh) {
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                this.f2976ASJ6gh = false;
                ScheduledFuture scheduledFuture = this.f2975ARc23Z;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void A5SV6n() {
        try {
            if (this.f2976ASJ6gh) {
                return;
            }
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            this.f2976ASJ6gh = true;
            this.f2975ARc23Z = this.AMqCpz.scheduleAtFixedRate(new CtFAbx.A2egSU(3, this), 100L, 100L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
    }

    public final void ADYaiT() {
        try {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            ScheduledFuture scheduledFuture = this.f2975ARc23Z;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.f2973A5SV6n = 0L;
            this.f2974ADYaiT = this.f2971A2egSU;
            this.f2976ASJ6gh = false;
        } catch (Exception unused) {
        }
    }
}
