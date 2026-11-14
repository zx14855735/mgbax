package K7mCWO;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile HandlerThread f4178A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile Handler f4179A4TApA;

    public static Handler A2egSU() {
        if (f4179A4TApA == null) {
            A4TApA();
        }
        return f4179A4TApA;
    }

    public static HandlerThread A4TApA() {
        if (f4178A2egSU == null) {
            synchronized (A2egSU.class) {
                try {
                    if (f4178A2egSU == null) {
                        HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                        f4178A2egSU = handlerThread;
                        handlerThread.start();
                        f4179A4TApA = new Handler(f4178A2egSU.getLooper());
                    }
                } finally {
                }
            }
        }
        return f4178A2egSU;
    }
}
