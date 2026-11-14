package com.kwad.components.core.h;

import android.os.Handler;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a implements Runnable {
    private InterfaceC0292a Rf;
    private volatile Handler iK;
    private long Rc = 1000;
    private boolean Rd = true;
    private long Re = 0;
    private float mSpeed = 1.0f;

    /* renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0292a {
        void D(long j);
    }

    public a(Handler handler) {
        this.iK = handler;
    }

    public final void a(InterfaceC0292a interfaceC0292a) {
        this.Rf = interfaceC0292a;
    }

    public final void destroy() {
        stop();
        this.iK = null;
    }

    public final void pause() {
        this.Rd = true;
    }

    public final void resume() {
        this.Rd = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0292a interfaceC0292a;
        try {
            if (this.iK != null) {
                if (!this.Rd && (interfaceC0292a = this.Rf) != null) {
                    interfaceC0292a.D(this.Re);
                    this.Re += this.Rc;
                }
                if (this.iK != null) {
                    this.iK.postDelayed(this, (long) (this.Rc / this.mSpeed));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    public final void start() {
        this.Rd = false;
        if (this.iK != null) {
            this.iK.post(this);
        }
    }

    public final void stop() {
        if (this.iK != null) {
            this.iK.removeCallbacks(this);
        }
    }
}
