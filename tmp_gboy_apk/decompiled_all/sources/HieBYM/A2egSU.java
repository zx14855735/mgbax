package HieBYM;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ A4TApA f3704AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2egSU(A4TApA a4TApA, Runnable runnable, String str) {
        super(runnable, str);
        this.f3704AcNBzu = a4TApA;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(9);
        if (this.f3704AcNBzu.f3706A4TApA) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable unused) {
            Log.isLoggable("GlideExecutor", 6);
        }
    }
}
