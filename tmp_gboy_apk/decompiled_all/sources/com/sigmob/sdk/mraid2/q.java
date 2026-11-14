package com.sigmob.sdk.mraid2;

import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final String f13560a;
    private final int b;
    private final boolean c;
    private final d d;
    private Timer e = null;
    private TimerTask f = null;

    /* renamed from: com.sigmob.sdk.mraid2.q$1, reason: invalid class name */
    public class AnonymousClass1 extends TimerTask {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            q.this.d.e(q.this.f13560a);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (q.this.d == null) {
                return;
            }
            q.this.d.a().post(new AaHO0E(0, this));
        }
    }

    public q(d dVar, JSONObject jSONObject) {
        this.d = dVar;
        this.b = jSONObject.optInt("interval");
        this.c = jSONObject.optBoolean("repeats");
        this.f13560a = jSONObject.optString("uniqueId");
    }

    private void d() {
        this.e = new Timer();
        this.f = new AnonymousClass1();
    }

    public void c() {
        TimerTask timerTask = this.f;
        if (timerTask != null) {
            timerTask.cancel();
            this.f = null;
        }
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
            this.e.purge();
            this.e = null;
        }
    }

    public void a() {
        c();
    }

    public void b() {
        try {
            c();
            d();
            int i = this.b;
            if (i > 0) {
                if (this.c) {
                    this.e.schedule(this.f, i, i);
                } else {
                    this.e.schedule(this.f, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
