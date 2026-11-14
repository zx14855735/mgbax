package com.sigmob.sdk.base.utils;

import android.os.CountDownTimer;
import com.czhj.sdk.logger.SigmobLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13221a = "l";
    private CountDownTimer b;
    private long c;
    private final long d;
    private final long e;
    private boolean f = false;
    private a g;

    public interface a {
        void onTimerFinished();
    }

    public l(long j, long j2) {
        this.d = j;
        this.e = j2;
        this.c = j;
    }

    public void b() {
        SigmobLogger.d(f13221a, "stop", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.c = this.d;
        this.f = false;
    }

    public void c() {
        SigmobLogger.d(f13221a, com.sigmob.sdk.base.common.a.j, new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer == null || this.f) {
            return;
        }
        countDownTimer.cancel();
        this.f = true;
    }

    public void d() {
        SigmobLogger.d(f13221a, "resume", new Object[0]);
        if (this.f) {
            a();
        }
    }

    public void e() {
        SigmobLogger.d(f13221a, "destroy", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.b = null;
        }
        this.g = null;
    }

    public long f() {
        return this.c;
    }

    public void a() {
        SigmobLogger.d(f13221a, "start", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.b = new CountDownTimer(this.c, this.e) { // from class: com.sigmob.sdk.base.utils.l.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                SigmobLogger.d(l.f13221a, "start#onFinish", new Object[0]);
                l.this.c = 0L;
                if (l.this.g == null) {
                    return;
                }
                l.this.g.onTimerFinished();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                SigmobLogger.d(l.f13221a, "start#onTick: remainingTime = " + Math.round(j / 1000.0f), new Object[0]);
                l.this.c = j;
            }
        }.start();
        this.f = false;
    }

    public void a(a aVar) {
        this.g = aVar;
    }
}
