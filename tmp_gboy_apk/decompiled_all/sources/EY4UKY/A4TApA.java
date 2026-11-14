package EY4UKY;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AtomicInteger f2500A2egSU = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("AsyncTask #");
        AMqCpz.append(this.f2500A2egSU.getAndIncrement());
        return new Thread(runnable, AMqCpz.toString());
    }
}
