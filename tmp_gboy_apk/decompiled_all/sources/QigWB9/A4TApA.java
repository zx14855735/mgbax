package QigWB9;

import android.os.Binder;
import android.os.Process;
import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AMqCpz f7707A2egSU;

    public A4TApA(AMqCpz aMqCpz) {
        this.f7707A2egSU = aMqCpz;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        AMqCpz aMqCpz = this.f7707A2egSU;
        aMqCpz.f7718B25kr6.set(true);
        try {
            Process.setThreadPriority(10);
            aMqCpz.A2egSU();
            Binder.flushPendingCommands();
            return null;
        } finally {
        }
    }
}
