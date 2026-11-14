package GJee0v;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.lang.Thread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String str;
        try {
            str = AaHO0E.A2egSU(th);
        } catch (IOException unused) {
            str = "null";
        }
        CtFAbx.B7CMnp("003", "thread: " + thread + ", " + str, null);
        int i = AZOQYO.f3039AcNBzu;
    }
}
