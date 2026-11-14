package com.czhj.wire.okio;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class PushableTimeout extends Timeout {

    /* renamed from: a, reason: collision with root package name */
    private Timeout f10703a;
    private boolean b;
    private long c;
    private long d;

    public void a() {
        this.f10703a.timeout(this.d, TimeUnit.NANOSECONDS);
        if (this.b) {
            this.f10703a.deadlineNanoTime(this.c);
        } else {
            this.f10703a.clearDeadline();
        }
    }

    public void a(Timeout timeout) {
        long deadlineNanoTime;
        this.f10703a = timeout;
        boolean hasDeadline = timeout.hasDeadline();
        this.b = hasDeadline;
        this.c = hasDeadline ? timeout.deadlineNanoTime() : -1L;
        long timeoutNanos = timeout.timeoutNanos();
        this.d = timeoutNanos;
        timeout.timeout(Timeout.a(timeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.b && hasDeadline()) {
            deadlineNanoTime = Math.min(deadlineNanoTime(), this.c);
        } else if (!hasDeadline()) {
            return;
        } else {
            deadlineNanoTime = deadlineNanoTime();
        }
        timeout.deadlineNanoTime(deadlineNanoTime);
    }
}
