package com.octopus.ad.a;

import com.octopus.ad.utils.ThreadUtils;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Timer f12342a;
    private long b;
    private long c;
    private long d;
    private b e;
    private c f = c.FINISH;

    public a(long j, long j2) {
        a(j);
        b(j2);
    }

    private void h() {
        Timer timer = this.f12342a;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.f12342a;
        if (timer2 != null) {
            timer2.purge();
        }
        this.f12342a = null;
    }

    public void d() {
        a(true);
    }

    public void e() {
        if (this.f12342a != null) {
            h();
        }
        this.d = this.b;
        this.f = c.FINISH;
    }

    public boolean f() {
        return this.f == c.START;
    }

    public TimerTask g() {
        return new TimerTask() { // from class: com.octopus.ad.a.a.2
            private long b = -1;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (this.b < 0) {
                    this.b = scheduledExecutionTime() - (a.this.b - a.this.d);
                    ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.a.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.e != null) {
                                a.this.e.a(a.this.d);
                            }
                        }
                    });
                    return;
                }
                a aVar = a.this;
                aVar.d = aVar.b - (scheduledExecutionTime() - this.b);
                ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.a.a.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.e != null) {
                            a.this.e.a(a.this.d);
                        }
                    }
                });
                if (a.this.d <= 0) {
                    a.this.a(false);
                }
            }
        };
    }

    public void b() {
        if (this.f12342a == null || this.f != c.START) {
            return;
        }
        h();
        this.f = c.PAUSE;
    }

    public void c() {
        if (this.f == c.PAUSE) {
            a();
        }
    }

    public void a() {
        if (this.f12342a == null) {
            c cVar = this.f;
            c cVar2 = c.START;
            if (cVar != cVar2) {
                Timer timer = new Timer();
                this.f12342a = timer;
                timer.schedule(g(), 0L, this.c);
                this.f = cVar2;
            }
        }
    }

    private void b(long j) {
        this.c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        if (this.f12342a != null) {
            h();
            this.f = c.FINISH;
            ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        if (z) {
                            a.this.e.b();
                        } else {
                            a.this.e.a();
                        }
                    }
                }
            });
        }
    }

    private void a(long j) {
        this.b = j;
        this.d = j;
    }

    public void a(b bVar) {
        this.e = bVar;
    }
}
