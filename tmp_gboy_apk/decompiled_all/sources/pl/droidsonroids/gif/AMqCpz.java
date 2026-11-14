package pl.droidsonroids.gif;

import java.lang.Thread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f14093AcNBzu;

    public AMqCpz(A5SV6n a5SV6n) {
        this.f14093AcNBzu = a5SV6n;
    }

    public abstract void A2egSU();

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            GifInfoHandle gifInfoHandle = this.f14093AcNBzu.f14081B3GDIM;
            synchronized (gifInfoHandle) {
                z = gifInfoHandle.f14096A2egSU == 0;
            }
            if (z) {
                return;
            }
            A2egSU();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
